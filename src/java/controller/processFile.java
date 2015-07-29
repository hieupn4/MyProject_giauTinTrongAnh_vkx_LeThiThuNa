/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author Pham Ngoc Hieu
 */
public class processFile {
/**
 * this method return Binary of File
 * @param : url of file
 * @return : return Binary String of File
 */
    public String converFileToBinaryString(String url) {
        String storeBinaryStream = "";
        FileInputStream fis = null;
        File file = new File(url);
        // convert file into array of bytes
        byte[] bFile = new byte[(int) file.length()];
        try {

            fis = new FileInputStream(file);
            fis.read(bFile);
            fis.close();
            for (int i = 0; i < bFile.length; i++) {
                String x = Integer.toBinaryString(bFile[i]);
                if (x.length() < 8) {
                    String y = "";
                    for (int j = 0; j < 8 - x.length(); j++) {
                        y = y + "0";
                    }
                    x = y + x;
                }
                storeBinaryStream = storeBinaryStream + x;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storeBinaryStream;

    }
    /**
     * this method return true if File's size < sizeMaxBye, else false
     * @param url
     * @param sizeMaxByte
     * @return 
     */
    public boolean checkSizeFile(String url,int sizeMaxByte)
    {
        File file = new File(url);
        // convert file into array of bytes
        byte[] bFile = new byte[(int) file.length()];
        if(bFile.length < sizeMaxByte)
            return true;
        else
            return false;
    }
}
