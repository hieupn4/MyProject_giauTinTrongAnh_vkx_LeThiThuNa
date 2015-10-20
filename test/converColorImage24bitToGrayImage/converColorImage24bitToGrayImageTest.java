/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package converColorImage24bitToGrayImage;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class converColorImage24bitToGrayImageTest {
    
    public converColorImage24bitToGrayImageTest() {
    }

    

   // @Test
    public void testConver3IntsTo1Int() {
        System.out.println("conver3IntsTo1Int");
        int[] threeInts = {1,2,3};
        int expResult = 0;
        int result = converColorImage24bitToGrayImage.conver3IntsTo1Int(threeInts);
        System.out.println(result);
    }

   // @Test
    public void testConverIntsToInt() {
        System.out.println("converIntsToInt");
        int[] nInts24bit = {1,2,3,4,5,6};
        int[] nInts8bit = new int[2];
        converColorImage24bitToGrayImage.converIntsToInt(nInts24bit, nInts8bit);
        for(int i=0;i<2;i++)
        System.out.println(nInts8bit[i]);
    }

    @Test
    public void testConver() throws Exception {
        System.out.println("conver");
        String url1 = "C:\\Users\\PhamNgocHieu\\Desktop\\changeContrast.bmp";
        String url2 = "C:\\Users\\PhamNgocHieu\\Desktop\\changeContrast2.bmp";
        converColorImage24bitToGrayImage.conver(url1, url2);
       // fail("The test case is a prototype.");
    }

   // @Test
    public void testConver3IntsTo3Ints() {
        System.out.println("conver3IntsTo3Ints");
        int[] threeInts = null;
        int expResult = 0;
        int result = converColorImage24bitToGrayImage.conver3IntsTo3Ints(threeInts);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

   // @Test
    public void testConverInts24ToInts24() {
        System.out.println("converInts24ToInts24");
        int[] nInts24bit = null;
        int[] n2Ints24bit = null;
        converColorImage24bitToGrayImage.converInts24ToInts24(nInts24bit, n2Ints24bit);
        fail("The test case is a prototype.");
    }
    
}
