//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package HistogramEqualation;

import controller.processByteBinary;
import controller.processFile;
import histogram.histogram;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class HistogramEqualation {
    public static float[] R = new float[256];
    public static float[] G = new float[256];
    public static float[] B = new float[256];
    public static void conver(String url1,String url2,int a1,int b1,int a,int b) throws IOException
    {
        /* mình đang thử trong trường hợp file ảnh có chiều ngang với số byte chia hết cho 4 */
        //đầu tiên tính histogram cái đã
        histogram.getInfomationHistogram(url1, R, G, B);
        //chuyển thanh luồng byte
        String anhcu = "";
        processFile obPro = new processFile();
        String x = processFile.converFileToBinaryString(url1);
        //lấy phần header và phần infomation của ảnh
        String header = x.substring(0,53*8);
        anhcu = anhcu + header;
        StringBuffer y =new StringBuffer(x);
        // tách trích phần data bitmap ra
        String them = y.substring(53*8);
        anhcu = anhcu + them;
        int[] a2 = new int[them.length()/8];
       // System.out.println(them.length()%8);
       // đưa độ xám của mỗi màu vào mảng kiểu int
       // System.out.println(them);
        for(int i=0;i<a2.length;i++)
        {
            String x1 ="";
            for(int j=i*8;j<i*8+8;j++)
            {
                x1=x1+them.charAt(j);
            }
          //  System.out.print(x1);
            a2[i] = processByteBinary.converToInt255(x1);
            
        }        
        // biến 24 bit thành 24 bit của ảnh đã tăng tương phản
        int[] b2 = new int[a2.length];
        converInts24ToInts24(a2,b2,a1,b1,a,b);
        //chuỗi data bitmap mới được tạo thành như sau : 24 bit đầu được thay bằng 24 bit mới
        String tg2 ="";
        for(int i=0;i<b2.length;i++)
            tg2 = tg2+processByteBinary.converTo8Bit255(b2[i]);
        //ghep phan header va phan data bitmap
        String bm = header + tg2;
        byte[] file = new byte[bm.length()/8];
        file = obPro.converBinaryToByteAarray(bm);
        obPro.createFileFromByteArray(file,url2);
    }
    /**
     * 
     * @param nInts24bit
     * @param n2Ints24bit
     * @param a1
     * @param b1
     * @param a
     * @param b 
     */
    public static void converInts24ToInts24(int[] nInts24bit,int[] n2Ints24bit,int a1,int b1,int a,int b)
    {
        System.out.println(nInts24bit.length);
        System.out.println(n2Ints24bit.length);
        for(int i=0;i<(nInts24bit.length);i=i+3)
        {
            n2Ints24bit[i] = change_Histogram(nInts24bit[i],a1,b1,a,b,R);
        //    n2Ints24bit[i++] = change_Histogram(nInts24bit[i+1],a1,b1,a,b,G);
        //    n2Ints24bit[i++] = change_Histogram(nInts24bit[i+2],a1,b1,a,b,B);
        }
        for(int i=1;i<(nInts24bit.length);i=i+3)
        {
        //    n2Ints24bit[i] = change_Histogram(nInts24bit[i],a1,b1,a,b,R);
            n2Ints24bit[i++] = change_Histogram(nInts24bit[i+1],a1,b1,a,b,G);
        //    n2Ints24bit[i++] = change_Histogram(nInts24bit[i+2],a1,b1,a,b,B);
        }
        for(int i=2;i<(nInts24bit.length);i=i+3)
        {
        //    n2Ints24bit[i] = change_Histogram(nInts24bit[i],a1,b1,a,b,R);
        //    n2Ints24bit[i++] = change_Histogram(nInts24bit[i+1],a1,b1,a,b,G);
            n2Ints24bit[i++] = change_Histogram(nInts24bit[i+2],a1,b1,a,b,B);
        }
        
    }
    /**
     * 
     * @param x
     * @param a1
     * @param b1
     * @param a
     * @param b
     * @param H
     * @return : có thể sai chỗ này
     */
    public static int change_Histogram(int x,int a1,int b1,int a,int b,float[] H)
    {
       int store = 0;
       if(x<a) store = a1;
       if(x==a) store = (int) ((float)(b1-a1)*H[a]+(float)a1);
       if(x>a)
       {
           float tg =0;
           for(int i=a;i<=x;i++)
               tg = tg+H[i];
           store = (int) ((float)(b1-a1)*tg + (float)a1);
       }
       return store;
    }
    
}
