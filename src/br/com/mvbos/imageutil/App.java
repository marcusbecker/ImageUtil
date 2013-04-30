/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvbos.imageutil;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author mbecker
 */
public class App {

    public static boolean criarMiniatura(File arquivo, File destino, int w, int h) {
        String ext;
        FileOutputStream fileOutStream;
        boolean fileSave = false;
        File temp = null;

        try {
            //criando imagem
            ImageIcon img = new ImageIcon(ImageIO.read(arquivo));

            if (img.getIconWidth() == w && img.getIconHeight() == h) {
                return true;
            }
            
            if(!destino.exists()){
                destino.mkdir();
            }

            String nameComp = arquivo.getName().toLowerCase();
            if (nameComp.endsWith(".gif")) {
                ext = "GIF";
            } else if (nameComp.endsWith(".bmp")) {
                ext = "BMP";//Nota: Nao funciona com BMP
            } else if (nameComp.endsWith(".png")) {
                ext = "PNG";
            } else {
                ext = "JPG";
            }

            temp = new File(destino.getAbsolutePath(), arquivo.getName());
            temp.createNewFile();
            //redimensionando
            BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            bi.createGraphics().drawImage(img.getImage(), 0, 0, w, h, null, null);

            //Gravando
            fileOutStream = new FileOutputStream(temp);
            ImageIO.write(bi, ext, fileOutStream);
            fileOutStream.flush();
            fileOutStream.close();

            fileSave = true;

        } catch (Exception e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, "Error do loag image {0}", arquivo.getName());
        }


        if (!fileSave && temp != null) {
            if (temp.exists()) {
                temp.delete();
            }
        }

        if (!fileSave) {

            FileInputStream in = null;
            FileOutputStream ou = null;
            try {
                temp = new File(destino.getAbsolutePath());
                temp.createNewFile();
                in = new FileInputStream(arquivo);
                ou = new FileOutputStream(temp);
                byte fileContent[] = new byte[(int) arquivo.length()];

                int i = -1;

                while ((i = in.read(fileContent)) != -1) {
                    ou.write(fileContent);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    in.close();
                    ou.close();
                } catch (IOException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return fileSave;
    }

    public static void main(String[] args) {
        //File saida = new File("C:/Users/mbecker/Desktop/Entregas/10082012/upload_10082012/saida");
        //File[] arr = new File("C:/Users/mbecker/Desktop/Entregas/10082012/upload_10082012/minis").listFiles();
        //for(File f : arr){
        //    criarMiniatura(f, saida, 134, 94);
        //}

        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AppView().setVisible(true);
            }
        });
    }
}
