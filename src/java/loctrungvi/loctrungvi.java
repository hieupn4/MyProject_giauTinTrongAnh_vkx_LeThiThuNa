//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package loctrungvi;

import controller.processByteBinary;
import controller.processFile;
import converBitmap24bitTo3DArrayTypeInt.converBitmap24bitTo3DArrayTypeInt;
import java.io.IOException;
import java.util.Arrays;
import static loctrungvi.loctrungvi.cover;
import nhanchap.nhanchap;
import readImage.readImage;

/**
 * lọc trung vị là một trường hợp đặc biệt của lọc thông thấp
 * nó là một dạng của lọc phi tuyến
 * nó dùng để
 * @author PhamNgocHieu
 */
public class loctrungvi {
    /**
     * phương thức này là phương thức demo giải thuật lọc trung vị
     * @param url1
     * @param url2
     * @throws IOException 
     */
    public static void process(String url1,String url2) throws IOException
    {
        
        // đưa phần databitmap thành ma trận 3 chiều
        int[][][] matrixImage = converBitmap24bitTo3DArrayTypeInt.process3D(url1);
        int[][][] matrixImageAfter = matrixImage;
        // lấy phần header và phần infomatio của ảnh ra
        String header = readImage.readHeadIfomationBitmap(url1);
        matrixImageAfter[0] = cover(matrixImage[0]);
        matrixImageAfter[1] = cover(matrixImage[1]);
        matrixImageAfter[2] = cover(matrixImage[2]);
        // chuyển lại về ma trận 1 chiều 
        int imageData[] = converBitmap24bitTo3DArrayTypeInt.return1dArrayFrom3dArray(matrixImageAfter);
        String tg2 ="";
        for(int i=0;i<imageData.length;i++)
            tg2 = tg2+processByteBinary.converTo8Bit255(imageData[i]);
        //ghep phan header va phan data bitmap
        String bm = header + tg2;
        // tí tạo lại file mới 
        processFile obPro = new processFile();
        byte[] file = new byte[bm.length()/8];
        file = obPro.converBinaryToByteAarray(bm);
        obPro.createFileFromByteArray(file,url2);
    }
    /**
     * đây là cài đặt giải thuật lọc trung vị
     * @param image : ma trận với 1 kênh màu
     * @return : ma trận mới
     */
    public static int[][] cover(int[][] image)
    {
       int H[][] = {{1,1,1},{1,1,1},{1,1,1}};
       int M = image.length; // chiều rộng ảnh
       int N = image[0].length; // chiều cao ảnh
       int[][] Y = new int[M][N];
       // sao chép dữ liệu từ ảnh qua Y để giữ nguyên biên
       for(int i=0;i<M;i++)
           for(int j=0;j<N;j++)
               Y[i][j]=image[i][j];
       //nhân chập
       int K = H.length; // kích thước ma trận nhân chập , chú ý là ma trận nhân chập ở đây là vuông và lẻ nên chỉ lấy K là đủ
       int r = (K-1)/2;
       for(int i=r;i<(M-r);i++)
           for(int j=r;j<(N-r);j++)
           {
               int tg[][] = {{1,1,1},{1,1,1},{1,1,1}};
               for(int k=0;k<K;k++)
                   for(int l=0;l<K;l++)
                      // tam = tam + H[k][l]*image[i-k+r][j-l+r];
                   {
                       tg[k][l] = H[k][l]*image[i-k+r][j-l+r];
                       System.out.println(tg[k][l]);
                   }
               Y[i][j] = trungvi(tg);           
           }
       return Y;
    }
    /**
     * phương thức trả về phần tử trung vị của các giá trị của mảng
     * @param H : ma trận chứa các giá trị
     * @return : phần tử trung vị H(4), chú ý là ở đây H làm ma trận 3*3
     */
    public static int trungvi(int[][] H)
    {
       int M = H.length; // chiều rộng ảnh
       int N = H[0].length; // chiều cao ảnh
       int K[] = new int[M*N];
       int l=0;
       for(int i=0;i<M;i++)
           for(int j=0;j<N;j++)
           {
               K[l]=H[i][j];
               l++;
           }
       //sắp xếp lại mảng
       Arrays.sort(K);
       return K[4];
    }
    
}
