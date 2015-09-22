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
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.border.Border;



/**
 *
 * @author Polker
 */
public class Background implements Border {

    public BufferedImage back;
    public ImageIcon imagen;

    public Background() {
        try {
//            System.out.println("=========================================================================");
//            System.out.println("URL : " + getClass().getResource("/imagenes/fondo.jpg"));
//            System.out.println("=========================================================================");
//            System.out.println("URL : " + getClass().getResourceAsStream("/imagenes/fondo.jpg"));
//            System.out.println("=========================================================================");
//            InputStream stream = getClass().getResourceAsStream("/imagenes/fondo.jpg");
//            back = ImageIO.read(stream);
//            URL imagePath = new URL(getClass().getResource("/imagenes/fondo.jpg").toString());
            imagen = new ImageIcon(getClass().getResource("/imagenes/fondo.jpg"));
        } catch (Exception ex) {

        }
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Dimension tam = c.getSize();

//        ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("../imagenes/fondo.jpg")).getImage());
//        ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/fondo.jpg")).getImage());
//        ImageIcon imagen = new ImageIcon().getImage());
//        ImageIcon imagen = new ImageIcon(back.);
        g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
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
