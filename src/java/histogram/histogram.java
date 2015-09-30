//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package histogram;
import controller.processByteBinary;
import controller.processFile;
import controller.processImage;
import java.awt.Dimension;
import static relaxationHistogram.relaxationHistogram.converInts24ToInts24;

/**
 * lớp này dùng để lấy ra các thông số histogram của ảnh màu bitmap 24bit
 * chú ý rằng với ảnh bitmap 24 bit thì sẽ có H của 3 kênh màu khác nhau là R ,G ,B
 * @author Phạm Ngọc Hiếu
 */
public class histogram {
    /**
     * 
     * @param url: location của ảnh bitmap
     * @param R : mảng 255 chứa tỷ lệ phần trăm của kênh Red
     * @param G : ______________________________________ Green
     * @param B : ______________________________________ Black
     */
    public static void getInfomationHistogram(String url,float R[],float G[],float B[])
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
        int[] a2 = new int[them.length()/8];
       //đưa độ xám của mỗi màu vào mảng kiểu int
        for(int i=0;i<a2.length;i++)
        {
            String x1 ="";
            for(int j=i*8;j<i*8+8;j++)
            {
                x1=x1+them.charAt(j);
            }
            a2[i] = processByteBinary.converToInt255(x1);        
        }
        //tạo các mảng để lưu mức xám của 3 kênh màu R,G,B
        int r[] = new int[(a2.length)/3];
        int g[] = new int[(a2.length)/3];
        int b[] = new int[(a2.length)/3];
        for(int i=0;i<r.length;i++)
        {
            r[i] = a2[i*3];
            g[i] = a2[i*3]+1;
            b[i] = a2[i*3]+2;
        }
        // tính mỗi mức xám thì có bao nhiêu điểm ảnh có mức xám
        int[] rK = new int[256];
        int[] gK = new int[256];
        int[] bK = new int[256];
        //gán giá trị bằng 0 ban đầu
        for(int i=0;i<=255;i++)
        {
            rK[i]=0;
            gK[i]=0;
            bK[i]=0;
        }
        for(int i=0;i<=255;i++)
        {
            for(int j=0;j<r.length;j++)
            {
                if(r[j]==i) rK[i]++;
                if(g[j]==i) gK[i]++;
                if(b[j]==i) bK[i]++;
            }
        }
        System.out.println(bK[255]);
       // tính Histogram
        Dimension size = new Dimension(processImage.getImageDim(url));
        int height = size.height;
       // System.out.println(height);
        int width = size.width;
       // System.out.println(width);
        for(int i=0;i<=255;i++)
        {
            R[i] =(float)rK[i]/(float)(height*width);
            G[i] =(float)gK[i]/(float)(height*width);
            B[i] =(float)bK[i]/(float)(height*width);           
        }
    }
    
}
