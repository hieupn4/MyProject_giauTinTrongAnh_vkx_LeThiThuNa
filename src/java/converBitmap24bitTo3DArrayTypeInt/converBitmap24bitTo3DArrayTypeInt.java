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
     * phương thức này dùng để lấy thông tin của ảnh 
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
    /**
     * phương thức này để đưa thông tin các mức xám của ảnh vào ba ma trận tương ứng với 
     * 3 kênh màu R,G,B
     * @param url
     * @return : ma trận 3 chiều
     */
    public static int[][][] process3D(String url)
    {
        /* mình đang thử trong trường hợp file ảnh có chiều ngang với số byte chia hết cho 4 */
        // lấy kích thước ảnh
        Dimension sizeImage = processImage.getImageDim(url);
        int height = sizeImage.height;
        int width = sizeImage.width;
        // tạo ma trận 3 chiều để lưu 3 mảng hai chiều mức xám của 3 kênh màu
        int [][][] image = new int[3][height][width];
        //chuyển thanh luồng byte
        String anhcu = "";
        processFile obPro = new processFile();
        String x = processFile.converFileToBinaryString(url);
        //lấy phần header và phần infomation của ảnh
        String header = x.substring(0,processImage.getLocationOfDataPart(url)*8);
        anhcu = anhcu + header;
        StringBuffer y =new StringBuffer(x);
        // tách trích phần data bitmap ra
        String them = y.substring(processImage.getLocationOfDataPart(url)*8);
        
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
            System.out.print(a[i]);          
        }
       
     //   System.out.println(a[33]+" "+a[34]+" "+a[35]);
        //đưa vào mảng 3 chiều. chú ý là lưu theo thứ tự hàng
        int i=0;
        System.out.println(" ");
        System.out.println("a="+a.length);
        System.out.println("height="+height);
        System.out.println("width="+width);
            for(int j=0;j<height;j++)
            {
                for(int k=0;k<width;k++)
                {
                    image[0][j][k]= a[i*3];
                    System.out.println("i="+i+" "+"j="+j+"k="+k);
                    image[1][j][k]= a[i*3+1];
                 //   System.out.println(a[i*3+1]);
                    image[2][j][k]= a[i*3+2];
                 //   System.out.println(a[i*3+2]);
                    i++;
                }
                
             //   System.out.println(i);
            }
     //   System.out.println("Array a= "+ a.length );
     //   System.out.println("width=" + width);
     //   System.out.println("height="+height);
        return image;// không biết là đã đúng hay chưa, nhưng mà có vẻ ổn rồi
    }  
    /**
     * phương thức này dùng để tái tạo lại phần data bitmap từ mảng 3 chiều  
     * @param image : mảng 3 chiều của ảnh, tượng trưng cho 3 kênh màu R,G,B
     * @return : mảng một chiều
     */
    public static int[] return1dArrayFrom3dArray(int[][][] image)
    {
       int height = image[0].length;
       int width = image[0][0].length;
       int a[] = new int[3*height*width];
        int i=0;
            for(int j=0;j<height;j++)
            {
                for(int k=0;k<width;k++)
                {
                    a[i*3]=image[0][j][k];
                 //   System.out.println(a[i*3]);
                    a[i*3+1]=image[1][j][k];
                 //   System.out.println(a[i*3+1]);
                    a[i*3+2]=image[2][j][k];
                 //   System.out.println(a[i*3+2]);
                    i++;
                }
                
            //    System.out.println(i);
            }
        return a;
    }
} 
