//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package rorateImage;
import controller.processByteBinary;
import controller.processFile;
import controller.processImage;
import java.awt.Dimension;
import java.io.IOException;

/**
 * lớp này được viết được dùng để quay ngược ảnh 
 * @author Pham Ngoc Hieu
 */
public class rorateImage {
    public static int width;
    //hàm lấy chiều rộng ảnh
    public static int getWidthImage(String url)
    {
        Dimension para = processImage.getImageDim(url);
        int width = para.width;
        return width;
    }
    public static void conver(String url1,String url2) throws IOException
    {
        /* mình đang thử trong trường hợp file ảnh có chiều ngang với số byte chia hết cho 4 */
        width = getWidthImage(url1);
        //chuyển thanh luồng byte
        String anhcu = "";
        processFile obPro = new processFile();
        String x = processFile.converFileToBinaryString(url1);
        //lấy phần header và phần infomation của ảnh
        String header = x.substring(0,54*8); // chỗ này mấy Class trước mình lại ghi là 53*8
        anhcu = anhcu + header;
        StringBuffer y =new StringBuffer(x); 
        // tách trích phần data bitmap ra
        String them = y.substring(54*8); // chỗ này mấy Class trước mình lại ghi là 53*8
        anhcu = anhcu + them;
        int[] a = new int[them.length()/8];
        //System.out.println(them.length()%8);
        //đưa độ xám của mỗi màu vào mảng kiểu int
        //System.out.println(them);
        for(int i=0;i<a.length;i++)
        {
            String x1 ="";
            for(int j=i*8;j<i*8+8;j++)
            {
                x1=x1+them.charAt(j);
            }
        //    System.out.print(x1);
            a[i] = processByteBinary.converToInt255(x1);
            
        }
        
        // biến 24 bit thành 24 bit của ảnh khi đã được quay ngược
        int[] b = new int[a.length];
        converInts24ToInts24(a,b);
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
    //giải thuật quay ngược ảnh
    public static void converInts24ToInts24(int[] nInts24bit,int[] n2Ints24bit)
    {
        int countRow = (nInts24bit.length)/(3*width);//3
        int countColum = width*3; //2
        int k=0;
        for(int i=countRow-1;i>=0;i--) // i :3-0
            for(int j=0;j<countColum;j++)// j :0-1
             n2Ints24bit[k++] = nInts24bit[i*countColum + j];
      /*  int countRow = 3;
        int countColum =2;
        int k=0;
        for(int i=countRow-1;i>=0;i--) // i :3-0
            for(int j=0;j<countColum;j++)// j :0-1
             n2Ints24bit[k++] = nInts24bit[i*countColum + j]; */
        
    }
}
