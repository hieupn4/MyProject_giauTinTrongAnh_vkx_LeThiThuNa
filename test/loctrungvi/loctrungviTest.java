//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package loctrungvi;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PhamNgocHieu
 */
public class loctrungviTest {
    
    public loctrungviTest() {
    }

   

    //@Test
    public void testTrungvi() {
        System.out.println("trungvi");
        int[][] H = {{9,5,3},{4,8,6},{7,8,9}};
        int expResult = 0;
        int result = loctrungvi.trungvi(H);
        System.out.println(result);
    }

   // @Test
    public void testCover() {
        //System.out.println("cover");
        int[][] image = {{3,4,7,3},{7,2,-3,8},{8,10,4,5},{9,6,9,2},{6,5,8,1}};
        int[][] expResult = null;
        int[][] result = loctrungvi.cover(image);
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<4;j++)
                System.out.print("  "+result[i][j]);
            System.out.println();
        }
        
    }

   @Test
    public void testProcess() throws Exception {
        System.out.println("process");
        String url1 = "C:\\Users\\PhamNgocHieu\\Documents\\GitHub\\MyProject_giauTinTrongAnh_vkx_LeThiThuNa\\web\\image\\loctrungbinh1.bmp";
        String url2 = "C:\\Users\\PhamNgocHieu\\Documents\\GitHub\\MyProject_giauTinTrongAnh_vkx_LeThiThuNa\\web\\image\\loctrungvi.bmp";
        loctrungvi.process(url1, url2);
        //fail("The test case is a prototype.");
    }
    
}
