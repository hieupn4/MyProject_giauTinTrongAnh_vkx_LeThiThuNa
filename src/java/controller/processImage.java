//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package controller;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import static java.rmi.server.LogStream.log;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;

/**
 * lớp này trả về các thông số của ảnh,cái này mình có chỉnh sửa từ một code nguồn trên mạng
 * @author copyright from Stackoverflow 
 * adress http://stackoverflow.com/questions/672916/how-to-get-image-height-and-width-using-java
 */
public class processImage {

    public static String getFileSuffix(final String path) {
        String result = null;
        if (path != null) {
            result = "";
            if (path.lastIndexOf('.') != -1) {
                result = path.substring(path.lastIndexOf('.'));
                if (result.startsWith(".")) {
                    result = result.substring(1);
                }
            }
        }
        return result;
    }
    // phương thức này trả về một đối tượng Dimension, đối tượng này chứa thông số 
    // chiều rộng và chiều cao của đối tượng ảnh
    public static Dimension getImageDim(final String path) {
        Dimension result = null;
        String suffix = getFileSuffix(path);
        Iterator<ImageReader> iter = ImageIO.getImageReadersBySuffix(suffix);
        if (iter.hasNext()) {
            ImageReader reader = iter.next();
            try {
                ImageInputStream stream = new FileImageInputStream(new File(path));
                reader.setInput(stream);
                int width = reader.getWidth(reader.getMinIndex());
                int height = reader.getHeight(reader.getMinIndex());
                result = new Dimension(width, height);
            } catch (IOException e) {
                log(e.getMessage());
            } finally {
                reader.dispose();
            }
        } else {
            log("No reader found for given format: " + suffix);
        }
        return result;
    }
    /**
     * phương thức này để kiểm tra xem ảnh bit map mà ta đưa vào là loại ảnh gì 
     * 1 bit, 8 bit hay 24 bit....
     * nó có 2 chế độ trả về , hoặc là trả về chuỗi nhị phân nếu i=2
     * hoặc là trả về chuỗi giá trị int nếu i=1
     * nếu không phải ảnh bit map thì trả về 0.
     * @param url
     * @return 
     */
    public static String getBitPerPixelImage(int i,String url)
    {
        //kiểm tra nếu đúng là file ảnh bitmap
        if(checkInfomationImplixitFile.returnExtendFile(url).equals("bmp"))
        {
            String fileBinary = processFile.converFileToBinaryString(url);
            String stringInfo = "";
            for(int j=28*8;j<30*8;j++)
            {
                stringInfo = stringInfo + fileBinary.charAt(j);
            }
            if(stringInfo.equals("0001100000000000")&&(i==1))
            return "24"; // ảnh 24 bit trong trường hợp trả về giá trị dạng 
            if(stringInfo.equals("0000000100000000")&&(i==1))
            return "1"; // ảnh 1 bit
            if(stringInfo.equals("0010000000000000")&&(i==1))
            return "32"; // ảnh 32 bit
            if(stringInfo.equals("0000100000000000")&&(i==1))
            return "8"; // ảnh 8 bit
            if(stringInfo.equals("0001100000000000")&&(i==2))
            return "0001100000000000"; // ảnh 24 bit
            if(stringInfo.equals("0000000100000000")&&(i==2))
            return "0000000100000000"; // ảnh 1 bit
            if(stringInfo.equals("0010000000000000")&&(i==2))
            return "0010000000000000"; // ảnh 32 bit
            if(stringInfo.equals("0000100000000000")&&(i==2))
            return "0000100000000000"; // ảnh 8 bit
        }  
            return "0";
    }
    /**
     * phương thức này trả về kích thước của ảnh bitmap dưới dạng 1 String
     * nó có hai chế độ trả về , hoặc là trả về một chuỗi là số byte của anh
     * hai là trả về chuỗi nhị phân 32 bit (byte thứ 3 đến thứ 6) 
     * nếu không phải file bitmap thì trả về "0"
     */
    public static String getSizeOfBitmapFile(int i,String url)
    {
        if(checkInfomationImplixitFile.returnExtendFile(url).equals("bmp"))
        {
            String fileBinary = processFile.converFileToBinaryString(url);
            String stringInfo = "";
            for(int j=2*8;j<6*8;j++)
            {
                stringInfo = stringInfo + fileBinary.charAt(j);
            }
            if(i!=1)
            return stringInfo;
            else
            return "";
        }  
        return "0";
    }
    /**
     * phương thức này để xác định xem phần databitmap của ảnh nằm ở vị trí byte
     * thứ mấy
     * @param url : location của ảnh bitmap 24bit
     * @return : vị trí byte thứ mấy của phần data bitmap
     * đã test thành công
     */
    public static int getLocationOfDataPart(String url)
    {
        String fileBinary = processFile.converFileToBinaryString(url);
        String stringInfo = "";
        // byte thông tin về phần data nằm ở byte thứ 11 đến 14
        for(int j=10*8;j<13*8;j++)
            stringInfo = stringInfo + fileBinary.charAt(j);
        // chỗ này chưa được chuẩn xác lắm khi mình lấy 8 byte đầu để xác định vị trí của phần data
        // nhưng thôi được tạm thời là như vậy
        String data8first = "";
        for(int j=0;j<8;j++)
            data8first = data8first + stringInfo.charAt(j);
        int orderByte = processByteBinary.converToInt255(data8first);
        return orderByte;
    }
}
