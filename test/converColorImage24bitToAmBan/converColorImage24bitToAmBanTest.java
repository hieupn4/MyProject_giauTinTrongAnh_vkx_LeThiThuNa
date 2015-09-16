//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package converColorImage24bitToAmBan;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class converColorImage24bitToAmBanTest {
    
    public converColorImage24bitToAmBanTest() {
    }

    @Test
    public void testConver() throws Exception {
        System.out.println("conver");
        String url1 = "C:\\Users\\Administrator\\Desktop\\linh2.bmp";
        String url2 = "C:\\Users\\Administrator\\Desktop\\amban.bmp";
        converColorImage24bitToAmBan.conver(url1, url2);
       // fail("The test case is a prototype.");
    }

   // @Test
    public void testConverInts24ToInts24() {
        System.out.println("converInts24ToInts24");
        int[] nInts24bit = null;
        int[] n2Ints24bit = null;
        converColorImage24bitToAmBan.converInts24ToInts24(nInts24bit, n2Ints24bit);
        fail("The test case is a prototype.");
    }
    
}
