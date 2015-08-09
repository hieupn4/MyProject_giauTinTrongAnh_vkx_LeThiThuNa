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

    @Test
    public void testConver() throws Exception {
        System.out.println("conver");
        String url1 = "C:\\Users\\Administrator\\Desktop\\thu.bmp";
        String url2 = "";
        converColorImage24bitToGrayImage.conver(url1, url2);
        
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
    
}
