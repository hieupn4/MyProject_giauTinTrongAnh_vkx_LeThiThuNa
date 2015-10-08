//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package loc_nhieu_trungbinh;

import controller.processByteBinary;
import controller.processFile;
import converBitmap24bitTo3DArrayTypeInt.converBitmap24bitTo3DArrayTypeInt;
import java.io.IOException;
import nhanchap.nhanchap;
import readImage.readImage;

/**
 * lớp này có chức năng chạy giải thuật lọc nhiễu trung bình
 * @author PhamNgocHieu
 */
public class locnhieutrungbinh {
    /**
     * phương thức này chạy thuật toán lọc nhiễu bằng lọc trung bình, khử nhiễu cộng
     * @param url1 : location của ảnh ban đầu có nhiễu
     * @param url2 : location của ảnh sau khi khử nhiễu
     * @throws IOException 
     */
    public static void process(String url1,String url2) throws IOException
    {
        
        // đưa phần databitmap thành ma trận 3 chiều
        int[][][] matrixImage = converBitmap24bitTo3DArrayTypeInt.process3D(url1);
        int[][][] matrixImageAfter = matrixImage;
        // lấy phần header và phần infomatio của ảnh ra
        String header = readImage.readHeadIfomationBitmap(url1);
        // xác định bộ lọc trung bình
        int[][] H = {{1,1,1},{1,1,1},{1,1,1}};
        matrixImageAfter[0] = nhanchap.process(matrixImage[0],H);
        matrixImageAfter[1] = nhanchap.process(matrixImage[1],H);
        matrixImageAfter[2] = nhanchap.process(matrixImage[2],H);
        for(int i=0;i<3;i++)
            for(int j=0;j<matrixImageAfter[0].length;j++)
                for(int k=0;k<matrixImageAfter[0][0].length;k++)
                    matrixImageAfter[i][j][k] = matrixImageAfter[i][j][k] /9;
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
}
