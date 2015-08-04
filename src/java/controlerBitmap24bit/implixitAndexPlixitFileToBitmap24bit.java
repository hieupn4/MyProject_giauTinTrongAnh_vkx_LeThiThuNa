/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlerBitmap24bit;

import controller.processByteBinary;
import controller.processFile;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class implixitAndexPlixitFileToBitmap24bit {
    private static int countBit =94064;// đếm số lượng bit của file cần giấu
    /*
    phương thức này để giấu các bit của file trong cắc bit của file bitmap gốc có location là rootBitmap
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
            z.createFileFromByteArray(y,"C:\\Users\\Administrator\\Desktop\\nguyetlu.bmp");
      
          /*  String filethu2 = filethu.substring(54*8);
            String trunggian="";
            for(int i=0;i<94064;i++)
               trunggian = trunggian + filethu2.charAt(i*8+7);
            processFile x = new processFile();
            
        byte[] y = processByteBinary.fromBinary(trunggian);
        processFile z = new processFile();
        z.createFileFromByteArray(y,"C:\\Users\\Administrator\\Desktop\\hung2.docx");
            //return (headerIfo+returnBinary.toString()); */
        }       
    }
    /*
    phương thức này để lấy dữ từng bit của file nằm trong ảnh bitmap ra
    */
    public static void processShowFile(String rootBitmap) throws IOException
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
             z.createFileFromByteArray(y,"C:\\Users\\Administrator\\Desktop\\hungfile.docx");           
        }      
    }
}
