//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package nhanchap;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PhamNgocHieu
 */
public class nhanchapTest {
    
    public nhanchapTest() {
    }

    @Test
    public void testProcess() {
      /* int[][] x = new int[23][56];
        System.out.println(x[22].length); */
        System.out.println("process");
        int image[][] ={{3,4,7,3},{7,2,-3,8},{8,10,4,5},{9,6,9,2},{6,5,8,1}};
        int H[][] = {{1,1,1},
                       {1,-8,1},
                       {1,1,1},
                      };
        int[][] Y = null;
        Y = nhanchap.process(image, H);
        for(int i=0;i<5;i++)
        {
            System.out.println("");
            for(int j=0;j<4;j++)
                System.out.print(Y[i][j]+" ");
        }
        
    }
    
}
