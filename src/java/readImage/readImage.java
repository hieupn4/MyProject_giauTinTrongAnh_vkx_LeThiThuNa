//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package readImage;

import controller.processByteBinary;
import controller.processFile;
import controller.processImage;
import java.io.IOException;
import static relaxationHistogram.relaxationHistogram.converInts24ToInts24;

/**
 *
 * @author Administrator
 */
public class readImage {
    /**
     * phương thức này đọc ra chuỗi bit phần data bitmap của ảnh bitmap
     * @param url1: location của ảnh bitmap
     * @return : chuỗi
     * @throws IOException 
     */
    public static String readDataBitmap(String url1) throws IOException
    {
        /* mình đang thử trong trường hợp file ảnh có chiều ngang với số byte chia hết cho 4 */
        //chuyển thanh luồng byte
        String anhcu = "";
        processFile obPro = new processFile();
        String x = processFile.converFileToBinaryString(url1);
        //lấy phần header và phần infomation của ảnh
        String header = x.substring(0,processImage.getLocationOfDataPart(url1)*8);
        anhcu = anhcu + header;
        StringBuffer y =new StringBuffer(x);
        // tách trích phần data bitmap ra
        String them = y.substring(processImage.getLocationOfDataPart(url1)*8);
     //  System.out.println(them.length());
        return them;     
    }
    /**
     * phương thức này trả về chuỗi nhị phân phần header và phần infomation của ảnh bitmap
     * @param url1:location của ảnh bitmap
     * @return : chuỗi nhị phân
     */
    public static String readHeadIfomationBitmap(String url1)
    {
        String anhcu = "";
        processFile obPro = new processFile();
        String x = processFile.converFileToBinaryString(url1);
        //lấy phần header và phần infomation của ảnh
        String header = x.substring(0,processImage.getLocationOfDataPart(url1)*8);
        return header;
    }
}
