//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package nhanchap;

/**
 * lớp này được xây dựng với mục đích là thực hiện phép nhân chập tại tâm với ma trận 
 * nhân chập lẻ , thường là ma trận 3*3 hoặc 5*5
 * @author PhamNgocHieu
 */
public class nhanchap {
    /**
     * 
     * @param image : đây là ma trận điểm của ảnh
     * @param H : ma vuông trận nhân chập với kích thước lẻ 3*3 hoặc 5*5
     * @return :trả về ma trận điểm của ảnh với biên được dữ nguyên
     */
    public static int[][] process(int[][] image,int[][] H)
    {
       
       int M = image.length; // chiều rộng ảnh
       int N = image[0].length; // chiều cao ảnh
       int[][] Y = new int[M][N];
       // sao chép dữ liệu từ ảnh qua Y để giữ nguyên biên
       for(int i=0;i<M;i++)
           for(int j=0;j<N;j++)
               Y[i][j]=image[i][j];
       //nhân chập
       int K = H.length; // kích thước ma trận nhân chập , chú ý là ma trận nhân chập ở đây là vuông và lẻ nên chỉ lấy K là đủ
       int r = (K-1)/2;
       for(int i=r;i<(M-r);i++)
           for(int j=r;j<(N-r);j++)
           {
               int tam =0;
               for(int k=0;k<K;k++)
                   for(int l=0;l<K;l++)
                   {
                       tam = tam + H[k][l]*image[i-k+r][j-l+r];
                       System.out.print(H[k][l]+"*"+image[i-k+r][j-l+r]+" + ");
                   }
               System.out.println("");
               Y[i][j] = tam;
              // System.out.print(tam +" ");
           }
       return Y;
    }
}
