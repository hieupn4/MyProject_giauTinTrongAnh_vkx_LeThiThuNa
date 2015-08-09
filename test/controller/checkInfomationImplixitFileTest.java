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
public class checkInfomationImplixitFileTest {
    
    public checkInfomationImplixitFileTest() {
    }

    //@Test
    public void testReturnName() {
        System.out.println("returnName");
        String url = "";
        String expResult = "";
        String result = checkInfomationImplixitFile.returnName("C:\\Users\\Administrator\\Desktop\\nhanxeo.bmp");
        System.out.println(result);
    }

   // @Test
    public void testIsFilenameValid() {
        System.out.println("isFilenameValid");
        String file = "C:\\Users\\Administrator\\Desktop\\nguyet.doc";
        boolean expResult = false;
        boolean result = checkInfomationImplixitFile.isFilenameValid(file);
        System.out.println(result);
    }
    //@Test
    public void testReturnExtendFile() {
        System.out.println("returnExtendFile");
        String url = "C:\\Users\\Administrator\\Desktop\\nguyet2.docx";
        String expResult = checkInfomationImplixitFile.returnExtendFile(url) ;
        System.out.println(expResult);
        

    }

   // @Test
    public void testReturnNameNonExtendFile() {
        System.out.println("returnNameNonExtendFile");
        String url = "C:\\Users\\Administrator\\Desktop\\nhanxeo";
        String expResult = "";
        String result = checkInfomationImplixitFile.returnNameNonExtendFile(url);
        System.out.println(result);
    }

    @Test
    public void testReturnSizeBytesFile() {
        System.out.println("returnSizeBytesFile");
        String url = "C:\\Users\\Administrator\\Desktop\\nguyet.docx";
        long expResult = 0L;
        long result = checkInfomationImplixitFile.returnSizeBytesFile(url);
        System.out.print(result);
    }
    
}
