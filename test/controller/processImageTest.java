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

    @Test
    public void testSomeMethod() {
        processImage x = new processImage();
        Dimension y = x.getImageDim("C:\\Users\\Administrator\\Desktop\\dentrang.bmp");
        System.out.print(y.height + "  " +y.width);
    }
    
}
