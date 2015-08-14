//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************

package controlerBitmap24bit;

import controller.processByteBinary;
import controller.processFile;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class implixitAndexPlixitFileToBitmap24bit {
    private static int countBit =98480;// đếm số lượng bit của file cần giấu
    /*
    phương thức này để giấu các bit của file trong các bit của file bitmap gốc có location là rootBitmap
    */
    public static void processHideFile(String rootBitmap,String file) throws IOException
    {
        //đầu tiên chuyển cả hai thành chuỗi nhị phân
        processFile prox = new processFile();
        String storeStringBinaryImage = prox.converFileToBinaryString(rootBitmap);
        
        String storeStringBinaryFile = prox.converFileToBinaryString(file);
        //countBit = storeStringBinaryFile.length();
        
        //lấy phần header và infomation của file Bitmap ra riêng
        String headerIfo = storeStringBinaryImage.substring(0,54*8);
        //tiếp theo là lấy phần data bitmap ra trong chuỗi nhị phân thu được
        String  storeDataBitmap =storeStringBinaryImage.substring(54*8);
        //gắn những bit thuộc file vào data bitmap
        if((storeDataBitmap.length()/8)<storeStringBinaryFile.length()  )
            //return null;
        {
            
        }
        else
        {
            StringBuffer returnBinary = new StringBuffer(storeDataBitmap);
            for(int i=0;i<storeStringBinaryFile.length();i++)
            {
               char x = storeStringBinaryFile.charAt(i);
               String y = "";
               y =y+x;
               returnBinary.replace(i*8+7,i*8+8,y);               
            }
            String filethu = headerIfo+returnBinary.toString();
            processFile x = new processFile();           
            byte[] y = processByteBinary.fromBinary(filethu);
            processFile z = new processFile();
            z.createFileFromByteArray(y,"C:\\Users\\Administrator\\Desktop\\xeonhan.bmp");
        }       
    }
    /*
    phương thức này để lấy dữ liệu từng bit của file nằm trong ảnh bitmap ra và chuyển nó thành file giấu
    ,nhược điểm là ta phải biết định dạng của file ẩn la gì để còn biết đặt tên cho file xuất ra.
    ví dụ thế này : url ="C:\\Users\\Administrator\\Desktop\\hungfile.docx", nghĩa là file bị ẩn là dạng docx
    và ta lấy nó ra với tên là hungfile
    */
    public static void processShowFile(String rootBitmap,String url) throws IOException
    {
        processFile prox = new processFile();
        String storeStringBinaryImage = prox.converFileToBinaryString(rootBitmap);
        //tiếp theo là lấy phần data bitmap ra trong chuỗi nhị phân thu được
        String  storeDataBitmap =storeStringBinaryImage.substring(54*8);
        if(countBit==0)
        {
            
        }
        else
        {
            String file ="";
            for(int i=0;i<countBit;i++)
            {
                file = file + storeDataBitmap.charAt(i*8+7);
            }
             processFile x = new processFile();
             byte[] y = processByteBinary.fromBinary(file);
             processFile z = new processFile();
             z.createFileFromByteArray(y,url);           
        }      
    }
}
