/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

/**
 *
 * @author Polker
 */
public class Background implements Border {

    public BufferedImage back;

    public Background() {
        try {
            URL imagePath = new URL(getClass().getResource("../imagenes/fondo.jpg").toString());
            back = ImageIO.read(imagePath);
        } catch (Exception ex) {

        }
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Dimension tam = c.getSize();
    
          ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("../imagenes/fondo.jpg")).getImage());
          g.drawImage(imagen.getImage(),0,0,tam.width,tam.height,null);
//        g.drawImage(back, (x + (width - back.getWidth()) / 2), (y + (height - back.getHeight()) / 2), null);
        
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);

    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

}
