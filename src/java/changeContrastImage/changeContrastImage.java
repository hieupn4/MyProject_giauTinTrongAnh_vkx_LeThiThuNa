//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package changeContrastImage;
import controller.processByteBinary;
import controller.processFile;
import java.io.IOException;

/**
 * lớp này được xây dựng để tăng độ tương phản của ảnh
 * giải thuật thay đổi độ tương phản thì có nhiều ,chúng ta có thể phân chúng làm 2 loại là 
 * hàm tuyến tính và hàm phi tuyến
 * ở đây chúng ta dùng dùng hàm Piecewise Linear Stretching (một phần tuyến tính) , nghĩa là chúng 
 * ta có các độ dốc của đồ thị khác nhau là anpha và beta
 * @author Administrator
 */
public class changeContrastImage {
    /**
     * phương thức để tăng dộ tương phản của anh
     * @param url1 : location của ảnh bitmap 24 bit ban đầu 
     * @param url2 : location của ảnh bitmap 24 bit sau khi tăng độ tương phản
     * @param anpha
     * @param beta
     * @param lamda
     * @param Va
     * @param Vb
     * @throws IOException 
     */
    public static void conver(String url1,String url2,int a_para,int b_para,int Va,int Vb,int Vc) throws IOException
    {
        /* mình đang thử trong trường hợp file ảnh có chiều ngang với số byte chia hết cho 4 */
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
        int[] a = new int[them.length()/8];
       // System.out.println(them.length()%8);
        //đưa độ xám của mỗi màu vào mảng kiểu int
       // System.out.println(them);
        for(int i=0;i<a.length;i++)
        {
            String x1 ="";
            for(int j=i*8;j<i*8+8;j++)
            {
                x1=x1+them.charAt(j);
            }
          //  System.out.print(x1);
            a[i] = processByteBinary.converToInt255(x1);
            
        }        
        // biến 24 bit thành 24 bit của ảnh đã tăng tương phản
        int[] b = new int[a.length];
        converInts24ToInts24(a,b,a_para,b_para,Va,Vb,Vc);
        //chuỗi data bitmap mới được tạo thành như sau : 24 bit đầu được thay bằng 24 bit mới
        String tg2 ="";
        for(int i=0;i<b.length;i++)
            tg2 = tg2+processByteBinary.converTo8Bit255(b[i]);
        //ghep phan header va phan data bitmap
        String bm = header + tg2;
        byte[] file = new byte[bm.length()/8];
        file = obPro.converBinaryToByteAarray(bm);
        obPro.createFileFromByteArray(file,url2);
    }
    
    /**
     * phương thức này từ 24 bit của ảnh màu ta chuyển thành 24 bit của ảnh sau khi
     * đã thay đổi độ tương phản
     * @param nInts24bit
     * @param n2Ints24bit 
     */
    public static void converInts24ToInts24(int[] nInts24bit,int[] n2Ints24bit,int a_para,int b_para,int Va,int Vb,int Vc)
    {
        for(int i=0;i<(nInts24bit.length);i++)
            n2Ints24bit[i] = change_Contrast(nInts24bit[i],a_para,b_para,Va,Vb,Vc);
    }
    /**
     * 
     * @param x
     * @param anpha
     * @param beta
     * @param lamda
     * @param a_para
     * @param b_para
     * @param Va
     * @param Vb
     * @return 
     */
    public static int change_Contrast(int x,int a_para,int b_para,int Va,int Vb,int Vc)
    {
        int store =0;
        float anpha = 0.0f;
        float beta = 0.0f;
        float lamda = 0.0f;
     if(x<=a_para)
     {
        anpha = (float)Va/(float)a_para;
        store = (int) (x*anpha);  
        if(store>=255)
        store = 255;
     }
     if((x>=a_para)&&(x<=b_para))
     {
         beta = (float)(Vb-Va)/(float)(b_para-a_para);
         store = (int) (beta*(x-a_para)+Va); 
         if(store>=255)
         store = 255;
     }
     if(x>=b_para)
     {
         lamda = (float)(Vc-Vb)/(float)(255-b_para);
         store =(int) (lamda*(x-b_para)+Vb);
         if(store>=255)
         store = 255;
     }
     return store;
    }
    
}
