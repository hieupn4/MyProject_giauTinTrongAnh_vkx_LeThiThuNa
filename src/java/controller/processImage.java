/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import static java.rmi.server.LogStream.log;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;

/**
 * this class return width , height and infomation of Image
 * @author copyright from Stackoverflow 
 * adress http://stackoverflow.com/questions/672916/how-to-get-image-height-and-width-using-java
 */
public class processImage {

    public static String getFileSuffix(final String path) {
        String result = null;
        if (path != null) {
            result = "";
            if (path.lastIndexOf('.') != -1) {
                result = path.substring(path.lastIndexOf('.'));
                if (result.startsWith(".")) {
                    result = result.substring(1);
                }
            }
        }
        return result;
    }
    // phương thức này trả về một đối tượng Dimension, đối tượng này chứa thông số 
    // chiều rộng và chiều cao của đối tượng ảnh
    public static Dimension getImageDim(final String path) {
        Dimension result = null;
        String suffix = getFileSuffix(path);
        Iterator<ImageReader> iter = ImageIO.getImageReadersBySuffix(suffix);
        if (iter.hasNext()) {
            ImageReader reader = iter.next();
            try {
                ImageInputStream stream = new FileImageInputStream(new File(path));
                reader.setInput(stream);
                int width = reader.getWidth(reader.getMinIndex());
                int height = reader.getHeight(reader.getMinIndex());
                result = new Dimension(width, height);
            } catch (IOException e) {
                log(e.getMessage());
            } finally {
                reader.dispose();
            }
        } else {
            log("No reader found for given format: " + suffix);
        }
        return result;
    }
    /**
     * phương thức này để kiểm tra xem ảnh bit map mà ta đưa vào là loại ảnh gì 
     * 1 bit, 8 bit hay 24 bit....
     * nếu không phải ảnh bit map thì trả về 0.
     * @param url
     * @return 
     */
    public static int getTypeImage(String url)
    {
        //kiểm tra nếu đúng là file ảnh bitmap
        if(checkInfomationImplixitFile.returnExtendFile(url).equals("bmp"))
        {
            String fileBinary = processFile.converFileToBinaryString(url);
            String stringInfo = "";
            for(int i=28*8;i<30*8;i++)
            {
                stringInfo = stringInfo + fileBinary.charAt(i);
            }
            if(stringInfo.equals("0001100000000000"))
            return 24; // ảnh 24 bit
            if(stringInfo.equals("0000000100000000"))
            return 1; // ảnh 1 bit
            if(stringInfo.equals("0010000000000000"))
            return 32; // ảnh 32 bit
            if(stringInfo.equals("0000100000000000"))
            return 8; // ảnh 8 bit
        }  
            return 0;
    }
}
