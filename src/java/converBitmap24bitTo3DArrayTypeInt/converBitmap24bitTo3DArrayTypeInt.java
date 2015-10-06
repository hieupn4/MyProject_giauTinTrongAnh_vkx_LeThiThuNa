//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package converBitmap24bitTo3DArrayTypeInt;

import controller.processByteBinary;
import controller.processFile;
import controller.processImage;
import java.awt.Dimension;

/**
 *
 * @author PhamNgocHieu
 */
public class converBitmap24bitTo3DArrayTypeInt {
    /**
     * 
     * @param url : location của ảnh gốc ban đầu
     * @return : trả về mảng kiểu int mức xám của cả 3 kênh màu theo thứ tự các pixel của ảnh
     */
    public static int[] process(String url)
    {
        /* mình đang thử trong trường hợp file ảnh có chiều ngang với số byte chia hết cho 4 */
        //chuyển thanh luồng byte
        String anhcu = "";
        processFile obPro = new processFile();
        String x = processFile.converFileToBinaryString(url);
        //lấy phần header và phần infomation của ảnh
        String header = x.substring(0,53*8);
        anhcu = anhcu + header;
        StringBuffer y =new StringBuffer(x);
        // tách trích phần data bitmap ra
        String them = y.substring(53*8);
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
        return a;
    }   
    public static int[][][] process3D(String url)
    {
        /* mình đang thử trong trường hợp file ảnh có chiều ngang với số byte chia hết cho 4 */
        // lấy kích thước ảnh
        Dimension sizeImage = processImage.getImageDim(url);
        int height = sizeImage.height;
        int width = sizeImage.width;
        // tạo ma trận 3 chiều để lưu 3 mảng hai chiều mức xám của 3 kênh màu
        int [][][] image = new int[3][width][height];
        //chuyển thanh luồng byte
        String anhcu = "";
        processFile obPro = new processFile();
        String x = processFile.converFileToBinaryString(url);
        //lấy phần header và phần infomation của ảnh
        String header = x.substring(0,54*8);
        anhcu = anhcu + header;
        StringBuffer y =new StringBuffer(x);
        // tách trích phần data bitmap ra
        String them = y.substring(54*8);
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
        //đưa vào mảng 3 chiều
        for(int i=0;i<(a.length/3);i++)
        {
            for(int j=0;j<width;j++)
                for(int k=0;k<height;k++)
                {
                    image[0][j][k]= a[i*3];
                    image[1][j][k]= a[i*3+1];
                    image[2][j][k]= a[i*3+2];
                }
        }
        System.out.println("Array a= "+ a.length );
        System.out.println("width=" + width);
        System.out.println("height="+height);
        return image;
    }   
} 
