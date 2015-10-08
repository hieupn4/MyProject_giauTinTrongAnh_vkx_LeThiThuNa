//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package controller;

import java.awt.Dimension;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PhamNgocHieu
 */
public class processImageTest {
    
    public processImageTest() {
    }

  //  @Test
    public void testGetFileSuffix() {
        System.out.println("getFileSuffix");
        String path = "";
        String expResult = "";
        String result = processImage.getFileSuffix(path);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

   @Test
    public void testGetImageDim() {
        System.out.println("getImageDim");
        String path = "C:\\Users\\PhamNgocHieu\\Desktop\\thu.bmp";
        Dimension expResult = null;
        Dimension result = processImage.getImageDim(path);
        System.out.println(result.height + " " + result.width);
    }

  //  @Test
    public void testGetBitPerPixelImage() {
        System.out.println("getBitPerPixelImage");
        int i = 0;
        String url = "";
        String expResult = "";
        String result = processImage.getBitPerPixelImage(i, url);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

  //  @Test
    public void testGetSizeOfBitmapFile() {
        System.out.println("getSizeOfBitmapFile");
        int i = 0;
        String url = "";
        String expResult = "";
        String result = processImage.getSizeOfBitmapFile(i, url);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

   // @Test
    public void testGetLocationOfDataPart() {
        System.out.println("getLocationOfDataPart");
        String url = "C:\\Users\\PhamNgocHieu\\Documents\\GitHub\\MyProject_giauTinTrongAnh_vkx_LeThiThuNa\\web\\image\\backWhite1.bmp";
        int expResult = 0;
        System.out.println(processImage.getLocationOfDataPart(url));
        
    }
    
}
