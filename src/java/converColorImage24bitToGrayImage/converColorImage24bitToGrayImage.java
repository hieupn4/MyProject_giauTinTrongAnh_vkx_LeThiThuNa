/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package converColorImage24bitToGrayImage;

import controller.processByteBinary;
import controller.processFile;
import java.io.IOException;

/**
 * lớp này dùng để chuyển một ảnh bitmap 24 bit màu thành 1 ảnh xám đa cấp 8 bit
 * @author Administrator
 */
public class converColorImage24bitToGrayImage {
    /**
     * phương thức chuyển này đầu tiên sẽ kiểm tra xem ảnh đi vào có phải
     * là ảnh bitmap 24bti màu hay không
     * @param url1 : vị trí của ảnh bimap 24 màu
     * @param url2 : vị trí mà chúng ta lưu ảnh đa cấp xám ra
     */
    public static void conver(String url1,String url2) throws IOException
    {
        /* mình đang thử trong trường hợp file ảnh có chiều ngang với số byte chia hết cho 4 */
        //chuyển thanh luồng byte
        processFile obPro = new processFile();
        String x = processFile.converFileToBinaryString(url1);
        //lấy phần header và phần infomation của ảnh
        String header = x.substring(0,53*8);
        StringBuffer y =new StringBuffer(x);
        // tách trích phần data bitmap ra
        y.substring(53*8);
        int[] a = new int[y.length()/8];
        System.out.println(y.length()%8);
        //đưa độ xám của mỗi màu vào mảng kiểu int
        for(int i=0;i<a.length;i++)
        {
            String x1 ="";
            for(int j=i*8;j<i*8+8;j++)
            {
                x1=x1+y.charAt(i);
            }
            a[i] = processByteBinary.converToInt255(x1);
        }
        // biến 24 bit thành 8 bit
        int[] b = new int[a.length/3];
        System.out.println(a.length%3);
        converIntsToInt(a,b);
        //chuỗi data bitmap mới được tạo thành như sau : 24 bit đầu được thay bằng 8 bit mới
        String tg2 ="";
        for(int i=0;i<b.length;i++)
            tg2 = tg2+processByteBinary.converTo8Bit255(b[i]);
        //bây giờ chúng ta phải tính lại các thông số cho ảnh
     
        //ghep phan header va phan data bitmap
        String bm = header + tg2;
        byte[] file = new byte[bm.length()/8];
        file = obPro.converBinaryToByteAarray(bm);
        obPro.createFileFromByteArray(file,"C:\\Users\\Administrator\\Desktop\\thu3.bmp");
    }
    /**
     * phương thức này chuyển 24 bit của một pixel màu về thành 8 bit / 1 pixel
     * của ảnh xám
     * @param threeBytes
     * @param oneByte 
     */
    public static int conver3IntsTo1Int(int[] threeInts)
    {
        int oneInt = (int) (0.11*threeInts[0] + 0.59*threeInts[1] + 0.3*threeInts[2]); 
        return oneInt;
    }
    /**
     * phương thức nay dùng để chuyển một mảng byte của file ảnh bit 24 bit thành
     * một mảng byte của ảnh xám 8bit/ 1 pixel
     * @param nBytes24bit
     * @param nBytes8bit 
     */
    public static void converIntsToInt(int[] nInts24bit,int[] nInts8bit)
    {
        for(int i=0;i<(nInts24bit.length/3);i++)
        {
            int[] store = new int[3];
            for(int j=0;j<3;j++)
            {
                store[j]=nInts24bit[i*3+j];
            }
            nInts8bit[i]=conver3IntsTo1Int(store);
        }
    }
}
