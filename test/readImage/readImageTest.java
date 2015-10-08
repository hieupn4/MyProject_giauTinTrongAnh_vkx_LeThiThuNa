//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package readImage;

import controller.processFile;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class readImageTest {
    
    public readImageTest() {
    }

    @Test
    public void testReadDataBitmap() throws Exception {
       /* System.out.println("readDataBitmap");
        String url1 = "C:\\Users\\Administrator\\Desktop\\rotareImage.bmp";
        String expResult = "";
        String result = readImage.readDataBitmap(url1);
        System.out.println(result.length()); */
        String url = "C:\\Users\\PhamNgocHieu\\Documents\\GitHub\\MyProject_giauTinTrongAnh_vkx_LeThiThuNa\\web\\image\\thay_doi_do_sang1.bmp";
        processFile obPro = new processFile();
        String x = processFile.converFileToBinaryString(url);
        //lấy phần header và phần infomation của ảnh
        String header = x.substring(138*8);
        System.out.println(header.length());
    }
    
}
