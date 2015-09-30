//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package convertToWhiteAndBackImage;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class toWhiteAndBlackImageTest {
    
    public toWhiteAndBlackImageTest() {
    }

    @Test
    public void testConver() throws Exception {
        System.out.println("conver");
        int anpha = 150;
        String url1 = "C:\\Users\\Administrator\\Desktop\\backWhite1.bmp";
        String url2 = "C:\\Users\\Administrator\\Desktop\\backWhite2.bmp";
        toWhiteAndBlackImage.conver(anpha, url1, url2);
        //fail("The test case is a prototype.");
    }

  //  @Test
    public void testConver3IntsTo3Ints() {
        System.out.println("conver3IntsTo3Ints");
        int[] threeInts = null;
        int expResult = 0;
        int result = toWhiteAndBlackImage.conver3IntsTo3Ints(threeInts);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

  //  @Test
    public void testConverInts24ToInts24() {
        System.out.println("converInts24ToInts24");
        int anpha = 0;
        int[] nInts24bit = null;
        int[] n2Ints24bit = null;
        toWhiteAndBlackImage.converInts24ToInts24(anpha, nInts24bit, n2Ints24bit);
        fail("The test case is a prototype.");
    }
    
}
