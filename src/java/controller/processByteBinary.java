//***********************************************************************************
//Nguyen Kieu Oanh**********************Chu Thi Thuong Hien*****************************
//***************Tran Thi Khanh Linh*****************************Nguyen Thi Nguyet*******
//*******************************Nguyen Thi Thanh Nhan*********************************
//***********************************************************************************
//*****Author: hieupn89@gmail.com*******************************************************
package controller;

/**
 * this class conver byte to binary string
 * copy right from Stackoverflow 
 * adress : http://stackoverflow.com/questions/11528898/convert-byte-to-binary-in-java
 * @author Administrator
 */
public class processByteBinary {

    public static String toBinary(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for (int i = 0; i < Byte.SIZE * bytes.length; i++) {
            sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
        }
        return sb.toString();
    }

    public static byte[] fromBinary(String s) {
        int sLen = s.length();
        byte[] toReturn = new byte[(sLen + Byte.SIZE - 1) / Byte.SIZE];
        char c;
        for (int i = 0; i < sLen; i++) {
            if ((c = s.charAt(i)) == '1') {
                toReturn[i / Byte.SIZE] = (byte) (toReturn[i / Byte.SIZE] | (0x80 >>> (i % Byte.SIZE)));
            } else if (c != '0') {
                throw new IllegalArgumentException();
            }
        }
        return toReturn;
    }
    //chuyển 8 bit của 1 byte thành 1 số nằm trong khoảng từ 0 đến 255
    public static int converToInt255(String x)
    {
        int foo = Integer.parseInt(x, 2);
        return foo;
    }
    // chuyển 1 số trong khoảng 0-255 thành chuỗi 8 bit
    public static String converTo8Bit255(int x)
    {
       if(!(Integer.toBinaryString(x).length()<8))
           return Integer.toBinaryString(x);
       else
       {
           String y=Integer.toBinaryString(x);
           for(int j=0;j<(8-Integer.toBinaryString(x).length());j++)
               y ="0"+y;
           return y;   
        }
    }
    /**
     * chuyển một chuỗi bit(có số bit chia hết cho 8) thành giá trị thập phân
     * ví dụ 13 0B 00 00 hệ hex , kết quả hệ thập phân là 2835
     */
    public static String converToIntFromBit(String x)
    {
        return "";
    }
    
}
