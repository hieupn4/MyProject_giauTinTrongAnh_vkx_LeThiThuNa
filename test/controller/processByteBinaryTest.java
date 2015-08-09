/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class processByteBinaryTest {
    
    public processByteBinaryTest() {
    }

  //  @Test
    public void testToBinary() {
        System.out.println("toBinary");
      //  byte[] bytes = new byte[1,0];
        byte month_days[] = {-128,1};
        String result = processByteBinary.toBinary(month_days);
        System.out.println(result);
        
    }
    //@Test
    public void testFromBinary() {
        System.out.println("fromBinary");
        String s = "";
        byte[] expResult = null;
        byte[] result = processByteBinary.fromBinary(s);
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testConverToInt255() {
        System.out.println("converToInt255");
        String x = "11111111";
        int result = processByteBinary.converToInt255(x);
        System.out.println(result);
    }

   // @Test
    public void testConverTo8Bit255() {
        System.out.println("converTo8Bit255");
        int x = 0;
        String expResult = "";
        String result = processByteBinary.converTo8Bit255(x);
        System.out.println(result);
    }
    
}
