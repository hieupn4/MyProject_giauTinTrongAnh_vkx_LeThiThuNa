//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package changeContrastImage;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class changeContrastImageTest {
    
    public changeContrastImageTest() {
    }

    @Test
    public void testConver() throws Exception {
        System.out.println("conver");
        String url1 = "C:\\Users\\Administrator\\Desktop\\changeContrast.bmp";
        String url2 = "C:\\Users\\Administrator\\Desktop\\changeContrast2.bmp";
        int a_para = 90;
        int b_para = 150;
        int Va = 30;
        int Vb = 220;
        int Vc = 240;
        changeContrastImage.conver(url1,url2,a_para,b_para,Va,Vb,Vc);
        //fail("The test case is a prototype.");
    }

    //@Test
    public void testConverInts24ToInts24() {
        System.out.println("converInts24ToInts24");
        int[] nInts24bit = null;
        int[] n2Ints24bit = null;
        float anpha = 0.0F;
        float beta = 0.0F;
        float lamda = 0.0F;
        int a_para = 0;
        int b_para = 0;
        int Va = 0;
        int Vb = 0;
        //changeContrastImage.converInts24ToInts24(nInts24bit, n2Ints24bit,a_para, b_para, Va, Vb);
        fail("The test case is a prototype.");
    }

    //@Test
    public void testChange_Contrast() {
        System.out.println("change_Contrast");
        int x = 0;
        float anpha = 0.0F;
        float beta = 0.0F;
        float lamda = 0.0F;
        int a_para = 0;
        int b_para = 0;
        int Va = 0;
        int Vb = 0;
        int expResult = 0;
       // int result = changeContrastImage.change_Contrast(x,a_para, b_para, Va, Vb);
       // assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
