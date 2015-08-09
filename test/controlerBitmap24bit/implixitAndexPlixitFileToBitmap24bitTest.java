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

    //@Test
    public void testProcessHideFile() throws IOException {
       // int dem =0;
      
        //String result = implixitAndexPlixitFileToBitmap24bit.processHideFile("C:\\Users\\Administrator\\Desktop\\nguyet.bmp","C:\\Users\\Administrator\\Desktop\\nguyet.docx");
      /*  processFile x = new processFile();
        String result2 = implixitAndexPlixitFileToBitmap24bit.processShowFile("C:\\Users\\Administrator\\Desktop\\nguyethide.bmp");
        String result3 = x.converFileToBinaryString("C:\\Users\\Administrator\\Desktop\\nguyet.docx"); */
        
      /*  processFile x = new processFile();
        byte[] y = processByteBinary.fromBinary(result2);
        processFile z = new processFile();
        z.createFileFromByteArray(y,"C:\\Users\\Administrator\\Desktop\\hung2.docx"); */
      //  String result = implixitAndexPlixitFileToBitmap24bit.processHideFile("C:\\Users\\Administrator\\Desktop\\nguyet.bmp","C:\\Users\\Administrator\\Desktop\\nguyet.docx");
        
       /*     String filethu2 = filethu.substring(54*8);
            String trunggian="";
            for(int i=0;i<94064;i++)
               trunggian = trunggian + filethu2.charAt(i*8+7);
            processFile x = new processFile();
            
        byte[] y = processByteBinary.fromBinary(trunggian);
        processFile z = new processFile();
        z.createFileFromByteArray(y,"C:\\Users\\Administrator\\Desktop\\hung2.docx"); */
        implixitAndexPlixitFileToBitmap24bit.processHideFile("C:\\Users\\Administrator\\Desktop\\nhanxeo.bmp","C:\\Users\\Administrator\\Desktop\\nguyet.docx");
        
    }

    @Test
    public void testProcessShowFile() throws IOException {
        
       
        
        
    }
    
}
