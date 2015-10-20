/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import static com.oracle.jrockit.jfr.ContentType.Bytes;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class processFileTest {
    
    public processFileTest() {
    }
    
    //@Before
    public void setUp() {
    }
   // @Test
    public void testConverFileToBinaryString() {
        
       String x = processFile.converFileToBinaryString("C:\\Users\\Administrator\\Desktop\\thu.bmp");
       String y = x.substring(16,48);
       
       for(int i=16;i<6*8;i++)
       {
          System.out.print(x.charAt(i)); 
       }
           
    }
    //@Test
    public void testCheckSizeFile() {
    }

    //@Test
    public void testConverBinaryToByteAarray() {
     /*   processFile x = new processFile();
        byte[] y =x.converBinaryToByteAarray("0000000011000000");
        for(int i=0;i<y.length;i++)
        {
            System.out.print(y[i]);
        } */
        System.out.println(Byte.parseByte("11111111", 2));
    }

    @Test
    public void testCreateFileFromByteArray() throws Exception {
        
        /*String x = processFile.converFileToBinaryString("C:\\Users\\PhamNgocHieu\\Desktop\\implixit.bmp");
        byte[] y = processFile.converBinaryToByteAarray(x);
        processFile.createFileFromByteArray(y,"C:\\Users\\PhamNgocHieu\\Desktop\\implixit2.bmp");*/
      /*  String storeStringBinaryImage = processFile.converFileToBinaryString("C:\\Users\\PhamNgocHieu\\Desktop\\implixit.bmp");
        byte[] z = processFile.converBinaryToByteAarray(storeStringBinaryImage);
        processFile.createFileFromByteArray(z,"C:\\Users\\Administrator\\Desktop\\implixit2.bmp");*/
       String x = processFile.converFileToBinaryString("C:\\Users\\PhamNgocHieu\\Desktop\\implixit.bmp");
        byte[] y = processFile.converBinaryToByteAarray(x);
        processFile.createFileFromByteArray(y,"C:\\Users\\PhamNgocHieu\\Desktop\\xeonhan.bmp");
      /*  String x = processFile.converFileToBinaryString("C:\\Users\\PhamNgocHieu\\Desktop\\implixit.bmp");
        byte[] y = processFile.converBinaryToByteAarray(x);
        processFile.createFileFromByteArray(y,"C:\\Users\\PhamNgocHieu\\Desktop\\xeonhan.bmp"); */
             
        
        
    }

    //@Test
    public void testConvertBitmapBlackWhiteToMatrixBinary() {
    processFile x = new processFile();   
    int width = processImage.getImageDim("C:\\Users\\Administrator\\Desktop\\bm2.bmp").width;
    int height = processImage.getImageDim("C:\\Users\\Administrator\\Desktop\\bm2.bmp").height;
    char[][] y = x.convertBitmapBlackWhiteToMatrixBinary("C:\\Users\\Administrator\\Desktop\\bm2.bmp");
    for(int i=0;i<height;i++)
    {
        for(int j=0;j<width;j++)
            System.out.print(y[i][j]+" ");
        System.out.println("");
    }   
    }
}
