//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package changeLightImage;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class changeLightImageTest {
    
    public changeLightImageTest() {
    }

    @Test
    public void testConver() throws Exception {
        System.out.println("conver");
        int c = 0;
        String url1 = "C:\\Users\\PhamNgocHieu\\Desktop\\changeContrast.bmp";
        String url2 = "C:\\Users\\PhamNgocHieu\\Desktop\\changeContrast2.bmp";
        changeLightImage.conver(100,url1, url2);
      //  fail("The test case is a prototype.");
    }

   // @Test
    public void testConverInts24ToInts24() {
        System.out.println("converInts24ToInts24");
        int c = 0;
        int[] nInts24bit = null;
        int[] n2Ints24bit = null;
        changeLightImage.converInts24ToInts24(c, nInts24bit, n2Ints24bit);
        fail("The test case is a prototype.");
    }
    
}
