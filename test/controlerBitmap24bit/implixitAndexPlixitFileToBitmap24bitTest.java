/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlerBitmap24bit;

import controller.processByteBinary;
import controller.processFile;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class implixitAndexPlixitFileToBitmap24bitTest {
    
    public implixitAndexPlixitFileToBitmap24bitTest() {
    }

   

    @Test
    public void testProcessShowFile() throws IOException {
        
     implixitAndexPlixitFileToBitmap24bit.processShowFile("C:\\Users\\PhamNgocHieu\\Desktop\\anhan.bmp", "C:\\Users\\PhamNgocHieu\\Desktop\\hieu.txt");
        
        
    }

    //@Test
    public void testProcessHideFile() throws Exception {
        System.out.println("processHideFile");
        String rootBitmap = "C:\\Users\\PhamNgocHieu\\Desktop\\implixit.bmp";
        String file = "C:\\Users\\PhamNgocHieu\\Desktop\\implixit.txt";
        implixitAndexPlixitFileToBitmap24bit.processHideFile(rootBitmap, file);
       // fail("The test case is a prototype.");
    }
    
}
