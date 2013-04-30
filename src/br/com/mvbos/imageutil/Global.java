/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvbos.imageutil;

import java.io.File;

/**
 *
 * @author mbecker
 */
public class Global {

    public static int parseInt(String param) {
        try {
            return Integer.parseInt(param);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String getDir(File file) {
        if(file.isFile()){
            return file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator));
        }
        
        return null;
    }
}
