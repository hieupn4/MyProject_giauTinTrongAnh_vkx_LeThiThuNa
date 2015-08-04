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
        
        processFile x = new processFile();
        String y = x.converFileToBinaryString("C:\\Users\\Administrator\\Desktop\\dentrang.bmp");
        System.out.print(y.length());
        int dem =0;
        for(int i=62*8;i<942*8;i++)
        {
             System.out.print(y.charAt(i));
             dem = dem +1;
             if(dem==64)
             {
             System.out.println("");
             dem=0;
             }
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

    //@Test
    public void testCreateFileFromByteArray() throws Exception {
        System.out.print(Integer.valueOf("11111111", 2));
        
    }

    @Test
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
