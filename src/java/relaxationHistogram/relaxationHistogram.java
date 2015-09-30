//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package relaxationHistogram;
import controller.processByteBinary;
import controller.processFile;
import java.io.IOException;
/**
 * đây là lớp dùng để giãn Histogram
 * ví dụ một bức ảnh có độ sáng nằm trong dải [a,b], mà chúng ta muốn nó dãn ra nằm trong dải [a1,b1]
 * thì chúng ta áp dụng công thức đã có trong sách giáo khoa.
 * Chú ý rằng là co giãn histogram chúng ta có thể thay đổi độ tương phản cho ảnh 
 * @author Administrator
 */
public class relaxationHistogram {
    /**
     * phương thức co giãn histogram của ảnh
     * @param url1 : location của ảnh gốc
     * @param url2 : location của ảnh sau khi biến đổi
     * @param a1 : mức xám cực tiểu mong muốn
     * @param b1 : mức xám cực đại mong muốn
     * @param a : mức xám cực tiểu ban đầu
     * @param b : mức xám cực đại ban đầu
     * @throws IOException 
     */
    public static void conver(String url1,String url2,int a1,int b1,int a,int b) throws IOException
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
     //  System.out.println(them.length());
        anhcu = anhcu + them;
        int[] a2 = new int[them.length()/8];
       // System.out.println(them.length()%8);
       //đưa độ xám của mỗi màu vào mảng kiểu int
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
        System.out.println(b2.length);
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
        for(int i=0;i<(nInts24bit.length);i++)
            n2Ints24bit[i] = change_Histogram(nInts24bit[i],a1,b1,a,b);
    }
    /**
     * giải thuật co giãn histogram được thể hiện qua phương thức này
     * @param x : giá trị mức xám cần thay đổi
     * @param a1 : mức xám cực tiểu của histogram mới
     * @param b1 : mức xám cực đại của histogram mới
     * @param a : mức xám cực tiểu của histogram cũ
     * @param b : mức xám cực đại của histogram cũ
     * @return : đã test thành công
     */
    public static int change_Histogram(int x,int a1,int b1,int a,int b)
    {
       // int store =0;
        float tg1 = (float)(b1-a1)/(float)(b-a);
        float tg2 = (float)(b*a1 - a*b1)/(float)(b-a);
        int tg3 = (int)(tg1*x + tg2);
        return tg3;
    } 
    
}
