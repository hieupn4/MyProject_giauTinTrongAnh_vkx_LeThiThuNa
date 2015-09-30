//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package convertToWhiteAndBackImage;

import controller.processByteBinary;
import controller.processFile;
import static converColorImage24bitToGrayImage.converColorImage24bitToGrayImage.converInts24ToInts24;
import java.io.IOException;

/**
 * lớp này có chức năng chuyển ảnh màu bitmap 24bit thành ảnh đen trắng
 * phương pháp dùng trong trường hợp này tách ngưỡng không nền
 * chúng ta phải chọn một giá trị anpha làm giá trị ngưỡng , trên mỗi pixel chúng ta lấy trung bình cộng 
 * của mức xám của ba kênh màu.Nếu giá trị trung bình này > anpha thì pixel đó có màu trắng 255 255 255
 * còn không thì màu đen 0 0 0
 * @author Administrator
 */
public class toWhiteAndBlackImage {
    public static void conver(int anpha,String url1,String url2) throws IOException
    {
        /* mình đang thử trong trường hợp file ảnh có chiều ngang với số byte chia hết cho 4 */
        //chuyển thanh luồng byte
        String anhcu = "";
        processFile obPro = new processFile();
        String x = processFile.converFileToBinaryString(url1);
        //lấy phần header và phần infomation của ảnh
        String header = x.substring(0,54*8);
        anhcu = anhcu + header;
        StringBuffer y =new StringBuffer(x);
        // tách trích phần data bitmap ra
        String them = y.substring(54*8);
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
        
        // biến 24 bit thành 24 bit của ảnh nhị phân
        int[] b = new int[a.length];
        converInts24ToInts24(anpha,a,b);
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
    public static int conver3IntsTo3Ints(int[] threeInts)
    {
        int oneInt = (int) ((threeInts[0] + threeInts[1] + threeInts[2])/3); 
        return oneInt;
    }
    /**
     * phương thức này từ 24 bit của ảnh màu ta chuyển thành 24 bit của ảnh nhị phân 
     * @param nInts24bit
     * @param n2Ints24bit 
     */
    public static void converInts24ToInts24(int anpha,int[] nInts24bit,int[] n2Ints24bit)
    {
        for(int i=0;i<(nInts24bit.length/3);i++)
        {
            int store = 0;
            for(int j=0;j<3;j++)
            {
                store = store + nInts24bit[i*3+j];
            }
            store = (store/3);
            if(store >= anpha)
            for(int j=0;j<3;j++)
                n2Ints24bit[i*3+j] = 255;
            else
            for(int j=0;j<3;j++)
                n2Ints24bit[i*3+j] = 0;
        }
    }
}
