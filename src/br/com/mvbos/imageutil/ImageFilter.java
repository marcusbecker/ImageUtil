/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvbos.imageutil;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author mbecker
 */
public class ImageFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = getExtension(f.getName());
        if (extension != null) {
            if (extension.equals("tiff") ||
                extension.equals("tif") ||
                extension.equals("gif") ||
                extension.equals("jpeg") ||
                extension.equals("jpg") ||
                extension.equals("png")) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return "Just Images";
    }
    
    
    public String getExtension(String f){
        return f.substring(f.lastIndexOf("."));
    }
}
