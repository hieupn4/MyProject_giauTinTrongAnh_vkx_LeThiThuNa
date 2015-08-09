/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.Dimension;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class processImageTest {
    
    public processImageTest() {
    }

    //@Test
    public void testGetFileSuffix() {
        System.out.println("getFileSuffix");
        String path = "";
        String expResult = "";
        String result = processImage.getFileSuffix(path);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    //@Test
    public void testGetImageDim() {
        System.out.println("getImageDim");
        String path = "";
        Dimension expResult = null;
        Dimension result = processImage.getImageDim(path);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTypeImage() {
        System.out.println("getTypeImage");
        String url = "C:\\Users\\Administrator\\Desktop\\hung2.docx";
        int expResult = 0;
        int result = processImage.getTypeImage(url);
        System.out.println(result);
        
    }

    
    
}
