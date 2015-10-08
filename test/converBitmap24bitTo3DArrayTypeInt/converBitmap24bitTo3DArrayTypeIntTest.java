//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package converBitmap24bitTo3DArrayTypeInt;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PhamNgocHieu
 */
public class converBitmap24bitTo3DArrayTypeIntTest {
    
    public converBitmap24bitTo3DArrayTypeIntTest() {
    }

   // @Test
    public void testProcess() {
        System.out.println("process");
        String url = "C:\\Users\\PhamNgocHieu\\Documents\\GitHub\\MyProject_giauTinTrongAnh_vkx_LeThiThuNa\\web\\image\\amban1.bmp";
        int[] expResult = null;
        int[] result = converBitmap24bitTo3DArrayTypeInt.process(url);
        
    }

    @Test
    public void testProcess3D() {
        System.out.println("process3D");
        String url = "C:\\Users\\PhamNgocHieu\\Desktop\\diecphi.bmp";
        int[][][] expResult = null;
        int[][][] result = converBitmap24bitTo3DArrayTypeInt.process3D(url);
        int[] l = converBitmap24bitTo3DArrayTypeInt.return1dArrayFrom3dArray(result);
        System.out.println();
        for(int i=0;i<l.length;i++)
            System.out.print(l[i]);
        
    }

   // @Test
    public void testReturn1dArrayFrom3dArray() {
        System.out.println("return1dArrayFrom3dArray");
        int[][][] image = null;
        int[] expResult = null;
        int[] result = converBitmap24bitTo3DArrayTypeInt.return1dArrayFrom3dArray(image);
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
