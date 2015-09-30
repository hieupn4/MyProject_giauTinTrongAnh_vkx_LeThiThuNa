//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package HistogramEqualation;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class HistogramEqualationTest {
    
    public HistogramEqualationTest() {
    }

    @Test
    public void testConver() throws Exception {
        System.out.println("conver");
        String url1 = "C:\\Users\\Administrator\\Desktop\\changeContrast5.bmp";
        String url2 = "C:\\Users\\Administrator\\Desktop\\changeContrast6.bmp";
        int a1 = 0;
        int b1 = 255;
        int a = 100;
        int b = 200;
        HistogramEqualation.conver(url1, url2, a1, b1, a, b);
       // fail("The test case is a prototype.");
    }

   // @Test
    public void testConverInts24ToInts24() {
        System.out.println("converInts24ToInts24");
        int[] nInts24bit = null;
        int[] n2Ints24bit = null;
        int a1 = 0;
        int b1 = 0;
        int a = 0;
        int b = 0;
        HistogramEqualation.converInts24ToInts24(nInts24bit, n2Ints24bit, a1, b1, a, b);
        fail("The test case is a prototype.");
    }

   // @Test
    public void testChange_Histogram() {
        System.out.println("change_Histogram");
        int x = 0;
        int a1 = 0;
        int b1 = 0;
        int a = 0;
        int b = 0;
        float[] H = null;
        int expResult = 0;
        int result = HistogramEqualation.change_Histogram(x, a1, b1, a, b, H);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
