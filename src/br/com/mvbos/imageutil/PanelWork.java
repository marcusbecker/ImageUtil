/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvbos.imageutil;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author mbecker
 */
public class PanelWork extends JPanel {

    private ImageIcon image;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        if (image != null) {
            image.paintIcon(this, g, 0, 0);
        } else {
            g.setColor(Color.DARK_GRAY);
            g.setFont(new Font("Arial", Font.BOLD, 22));
            g.drawString("Imagem inválida...", getWidth() / 3, getHeight() / 2);
        }
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
        repaint();
    }

    public void setPixelImage(List<ImageIcon> imgs) {
        int s = imgs.size() > 3 ? 3 : imgs.size();
        
        int w = this.getWidth();
        int h = this.getHeight();

        int start = 0;
        int toResize = w / s;
        
        int maxHeight = 0;
        int maxLine = 3;
        int count = 0;
        int y = 0;
        
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        for (ImageIcon img : imgs) {
            int iw = img.getIconWidth();
            int ih = img.getIconHeight();
            //res = h x nw / w
            int porcentHeight = (ih * toResize) / iw;
            maxHeight = porcentHeight > maxHeight ? porcentHeight : maxHeight;
            
            int end = start + toResize;
            if(end > w){
               start = 0;
               end = toResize;
               y += maxHeight;
               maxHeight = 0;
            }
            
            bi.createGraphics().drawImage(img.getImage(), start, y, toResize, porcentHeight, null, null);
            
            start = end;
            
            count++;
            if(count > maxLine){
                count = 0;
            }
        }

        setImage(new ImageIcon(bi));
    }
    
    public void updateScreen(ImageIcon img){
        setImage(img);
    }

    public void updateScreen(List<ImageIcon> imgs) {
        setPixelImage(imgs);
    }
}
