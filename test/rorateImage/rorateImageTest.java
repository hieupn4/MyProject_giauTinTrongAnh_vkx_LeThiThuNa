//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package rorateImage;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class rorateImageTest {
    
    public rorateImageTest() {
    }

    @Test
    public void testConver() throws Exception {
        System.out.println("conver");
        String url1 = "C:\\Users\\PhamNgocHieu\\Desktop\\changeContrast.bmp";
        String url2 = "C:\\Users\\PhamNgocHieu\\Desktop\\xoayanh.bmp";
        rorateImage.conver(url1, url2);
        
    }

   // @Test
    public void testConverInts24ToInts24() {
        System.out.println("converInts24ToInts24");
        int[] nInts24bit = {4,7,8,9,2,5};
        int[] n2Ints24bit = {0,0,0,0,0,0};
        rorateImage.converInts24ToInts24(nInts24bit, n2Ints24bit);
        for(int i=0;i<6;i++)
            System.out.print(nInts24bit[i]);
        for(int i=0;i<6;i++)
            System.out.print(n2Ints24bit[i]);
        
    }

    //@Test
    public void testGetWidthImage() {
        System.out.println("getWidthImage");
        String url = "";
        int expResult = 0;
        int result = rorateImage.getWidthImage(url);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
