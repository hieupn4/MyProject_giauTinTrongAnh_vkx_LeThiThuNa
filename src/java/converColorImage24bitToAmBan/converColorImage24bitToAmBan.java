//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package converColorImage24bitToAmBan;
import controller.processByteBinary;
import controller.processFile;
import java.io.IOException;
import readImage.readImage;

/**
 * lớp này dùng để chuyển một ảnh màu bitmap 24 bit thành ảnh âm bản
 * giải thuật thì rất đơn giản chỉ cần lấy 255 - giá trị màu của mức xám của 3 màu R G B tại mỗi pixel là được
 * @author Administrator
 */
public class converColorImage24bitToAmBan {
    /**
     * 
     * @param url1 :vị trí của ảnh bimap 24 màu
     * @param url2 :vị trí mà chúng ta lưu ảnh âm bản
     * @throws IOException 
     */
    public static void conver(String url1,String url2) throws IOException
    {
        /* mình đang thử trong trường hợp file ảnh có chiều ngang với số byte chia hết cho 4 */
        //chuyển thanh luồng byte
        String anhcu = "";
        processFile obPro = new processFile();
        String x = processFile.converFileToBinaryString(url1);
        //lấy phần header và phần infomation của ảnh
        String header = readImage.readHeadIfomationBitmap(url1);
        anhcu = anhcu + header;
        StringBuffer y =new StringBuffer(x);
        // tách trích phần data bitmap ra
        String them = readImage.readDataBitmap(url1);
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
        
        // biến 24 bit thành 24 bit của ảnh âm bản
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
    /**
     * phương thức này từ 24 bit của ảnh màu ta chuyển thành 24 bit của ảnh âm bản 
     * @param nInts24bit : ảnh trước khi biến đổi
     * @param n2Ints24bit : ảnh sau khi biến đổi
     */
    public static void converInts24ToInts24(int[] nInts24bit,int[] n2Ints24bit)
    {
        for(int i=0;i<(nInts24bit.length);i++)
            n2Ints24bit[i] = 255-nInts24bit[i];
    }
}
