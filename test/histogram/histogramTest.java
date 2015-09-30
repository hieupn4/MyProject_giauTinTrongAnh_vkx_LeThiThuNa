//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package histogram;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class histogramTest {
    
    public histogramTest() {
    }

    @Test
    public void testGetInfomationHistogram() {
        System.out.println("getInfomationHistogram");
        String url = "C:\\Users\\Administrator\\Desktop\\thu.bmp";
        float[] R = new float[256];
        float[] G = new float[256];
        float[] B = new float[256];
        for(int i=0;i<=255;i++)
        {
            R[i]=0;
            G[i]=0;
            B[i]=0;
        }
        histogram.getInfomationHistogram(url,R,G,B);
        for(int i=0;i<=255;i++)
            System.out.print(R[i]);
    }
    
}
