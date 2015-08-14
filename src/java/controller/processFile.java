//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package controller;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Pham Ngoc Hieu
 */
public class processFile {

    /**
     * this method return Binary of File
     *
     * @param : url of file
     * @return : return Binary String of File
     */
    
    public static String converFileToBinaryString(String url) {
        String storeBinaryStream = "";
        FileInputStream fis = null;
        File file = new File(url);
        // convert file into array of bytes
        byte[] bFile = new byte[(int) file.length()];
        try {

            fis = new FileInputStream(file);
            fis.read(bFile);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return processByteBinary.toBinary(bFile);
    }
    /**
     * phương thức này chuyển một file ảnh bitmap nhị phân thành một mảng các bit, tương ứng
     * với mỗi pixel trên ảnh bitmap
     * @param url
     * @return 
     */
    public char[][] convertBitmapBlackWhiteToMatrixBinary(String url)
    {
        Dimension sizeImage = processImage.getImageDim(url);
        String binaryStringBitmapBlackWhite = converFileToBinaryString(url);
        int lengthBinaryString = binaryStringBitmapBlackWhite.length();
        // tạo một ma trận ảnh Bitmap, chú ý là mỗi điểm ảnh là 1 bit
        char[][] matrixImage = new char[sizeImage.height][sizeImage.width];
        if((sizeImage.width%32)==0)//nếu số byte trên một hàng ảnh của phần data bitmap chia hết cho 4 thì quá ngon, khỏi phải xử lý phức tạp
        {
            for(int i=0;i<sizeImage.height;i++)
                for(int j=0;j<sizeImage.width;j++)
                    matrixImage[i][j] = binaryStringBitmapBlackWhite.charAt(lengthBinaryString-((i+1)*(sizeImage.width))+j);
             
        }
        else // trog trường hợp số byte không chia hết cho 4 thì tự động thêm các bit 0 vào đuôi mỗi hàng để số byte chia hết cho 4
        {
            //tính xem có bao nhiêu bit 0 được thêm vào đuôi mỗi hàng
            int countAddBit = 32-(sizeImage.width%32);
            int lengthAct = countAddBit + sizeImage.width;
            for(int i=0;i<sizeImage.height;i++)
                for(int j=0;j<sizeImage.width;j++)
                    matrixImage[i][j] = binaryStringBitmapBlackWhite.charAt(lengthBinaryString-((i+1)*lengthAct)+j);
        }
        return matrixImage;
    }

    /**
     * this method return true if File's size < sizeMaxBye, else false @param
     * url
     *
     * @
     * param sizeMaxByte
     * @return
     */
    public boolean checkSizeFile(String url, int sizeMaxByte) {
        File file = new File(url);
        // convert file into array of bytes
        byte[] bFile = new byte[(int) file.length()];
        if (bFile.length < sizeMaxByte) {
            return true;
        } else {
            return false;
        }
    }

    public byte[] converBinaryToByteAarray(String s) {

       int sLen = s.length();
        byte[] toReturn = new byte[(sLen + Byte.SIZE - 1) / Byte.SIZE];
        char c;
        for (int i = 0; i < sLen; i++) {
            if ((c = s.charAt(i)) == '1') {
                toReturn[i / Byte.SIZE] = (byte) (toReturn[i / Byte.SIZE] | (0x80 >>> (i % Byte.SIZE)));
            } else if (c != '0') {
                throw new IllegalArgumentException();
            }
        }
        return toReturn;
    }
    /*  public byte[] converBinaryToByteAarray(String binaryString)
     {    
     byte a = Byte.parseByte(binaryString,1);
     ByteBuffer bytes = ByteBuffer.allocate(1).putShort(a);
     byte[] array = bytes.array();
     } */
    /**
     * this method convert byte[] array in to file
     * @param fileByteArray byte Array
     * @param url location of file
     * @throws IOException 
     */
    public void createFileFromByteArray(byte[] fileByteArray, String url) throws IOException {

        Path path = Paths.get(url);
        Files.write(path, fileByteArray);
    }
}
