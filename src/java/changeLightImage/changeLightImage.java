//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package changeLightImage;

import controller.processByteBinary;
import controller.processFile;
import java.io.IOException;
import readImage.readImage;

/**
 * lớp này được xây dựng để thay đổi độ sáng của ảnh
 * phương pháp là dùng toán tử điểm,tác động lên từng điểm ảnh
 * mức xám trên từng kênh màu của ảnh sẽ được cộng thêm một giá trị là c 
 * c nằm trong khoảng [-255,255]
 * nếu c>0 thì nghĩa là ảnh sáng lên 
 * c < 0 thì nghĩa là ảnh tối đi
 * @author Administrator
 */
public class changeLightImage {
    /**
     * chú ý là lớp này chưa được tối ưu nên xử lý với ảnh kích thước lớn rất chậm
     * đề nghị sử dụng những ảnh có kích thước bé để sử dụng những lớp này
     * @param url1 : location của ảnh nguồn
     * @param url2 : location của ảnh đích
     * @param c : giá trị tăng của mức xám nằm trong khoảng [-255,255]
     * @throws IOException 
     */
    public static void conver(int c,String url1,String url2) throws IOException
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
        converInts24ToInts24(c,a,b);
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
     * @param c : giá trị tăng của mức xám , nằm trong khoảng [-255,255]
     */
    public static void converInts24ToInts24(int c,int[] nInts24bit,int[] n2Ints24bit)
    {
        for(int i=0;i<(nInts24bit.length);i++)
        {
            n2Ints24bit[i] = c + nInts24bit[i];
            if(n2Ints24bit[i]>255)
                n2Ints24bit[i] = 255;
            if(n2Ints24bit[i]<0)
                n2Ints24bit[i] = 0;
        }
    }
}
