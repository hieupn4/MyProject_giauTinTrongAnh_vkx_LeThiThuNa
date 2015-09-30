//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package relaxationHistogram;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class relaxationHistogramTest {
    
    public relaxationHistogramTest() {
    }

   @Test
    public void testConver() throws Exception {
        System.out.println("conver");
        String url1 = "C:\\Users\\Administrator\\Desktop\\linh2.bmp";
        String url2 = "C:\\Users\\Administrator\\Desktop\\changeContrast6.bmp";
        relaxationHistogram.conver(url1, url2,100,200,0,255);
        
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
        relaxationHistogram.converInts24ToInts24(nInts24bit, n2Ints24bit, a1, b1, a, b);
        fail("The test case is a prototype.");
    }

    //@Test
    public void testChange_Histogram() {
        System.out.println("change_Histogram");
        int x = 0;
        int a1 = 0;
        int b1 = 0;
        int a = 0;
        int b = 0;
        int expResult = 0;
        int result = relaxationHistogram.change_Histogram(80,50,120,0, 255);
        
    }
    
}
