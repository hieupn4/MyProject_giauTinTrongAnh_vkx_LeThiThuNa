//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************

package controller;

import java.io.File;
import java.io.IOException;

/**
 * lớp này là để check tất cả các thông tin cần thiết của file ẩn, ta phải lấy được định dạng file ẩn là gì ?
 * kích thước, chiều rộng , chiều cao pixel
 * bao nhiêu bye -> tính ra số bít
 * @author Administrator
 */
public class checkInfomationImplixitFile {
    /**
     * hàm này là để kiểm tra xem file có tồn tại hay không
     * nếu có thì trả về true và nếu không thì trả về false
     * @param file: đường dẫn của file
     * @return : trả về true hoặc false
     */
    public static boolean isFilenameValid(String file) 
    {
      File f = new File(file);
      if(f.canRead())
       return true;
      else
       return false;
    }
    /**
     * hàm này trả về tên của file khi đã xác nhận file tồn tại
     * nếu file không tồn tại hoặc không hợp lệ thì trả về null
     * @param url : địa chỉ của file
     * @return hoặc tên file hoặc null
     */
    public static String returnName(String url)
    {
        if(isFilenameValid(url))
        return new File(url).getName(); 
        else
        return null;
    }
    /**
     * hàm này trả về phần mở rộng của file,mục đích của nó là xác định xem 
     * file này là loại file gì, nếu file không hợp lệ hoặc không có phần mở 
     * rộng thì trả về null
     */
    public static String returnNameNonExtendFile(String url)
    {
        String str = returnName(url);
        // Handle null case specially.
        if (str == null) return null;
        // Get position of last '.'.
        int pos = str.lastIndexOf(".");
        // If there wasn't any '.' just return the string as is.
        if (pos == -1) return null;
        // Otherwise return the string, up to the dot.
        return str.substring(0, pos);      
    }
    /**
     * phương thức này trả về phần mở rộng của file
     * nếu không có phần mở rộng hoặc không hợp lệ thì trả về null
     * @param url
     * @return 
     */
    public static String returnExtendFile(String url)
    {
        String str = returnName(url);
        String str2 = returnNameNonExtendFile(url);
        if(str2==null)
            return null;
        else
        {
            int dot = str.lastIndexOf(".");
            return str.substring(dot + 1);
        }
    }
    /**
     * phương thức này trả về dung lượng của file theo đơn vị bytes
     * nếu file không tồn tại tại trả về 0
     * @param url
     * @return 
     */
    public static long returnSizeBytesFile(String url)
    {
        if(!isFilenameValid(url))
            return 0;
        else
        {
            File f = new File(url);
            long x =f.length();
            return x;     
        }
    }
    /**
     * phương thức này trả về số bit của file
     * @param url
     * @return 
     */
    public static long returnSizeBitsFile(String url)
    {
        long x = returnSizeBytesFile(url)*8;
        return x;
    }
    
}
