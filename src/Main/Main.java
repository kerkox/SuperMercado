package Main;

import GUI.Principal;
import java.awt.SplashScreen;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import supermecado.clases.Almacen;
import supermecado.clases.Cliente;
import supermecado.clases.Empleado;
import supermecado.clases.ObjectNotFoundException;
import supermecado.clases.Producto;

/**
 *
 * @author Polker
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        splashInit();           // initialize splash overlay drawing parameters
        appInit();              // simulate what an application would do 

        // before starting
        if (mySplash != null) // check if we really had a spash screen
        {
            mySplash.close();   // if so we're now done with it
        }
        // begin with the interactive portion of the program

        //Carga de almacen viejo por memoria
        //carga de Almacen por archivo
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Almacen market = null;
                ObjectInputStream ois = null;

                try {
                    ois = new ObjectInputStream(new FileInputStream("market.data"));
                    market = (Almacen) ois.readObject();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (ois != null) {
                        try {
                            ois.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

                if (market == null) {
                    market = new Almacen("PoltaByte", "800.456.123-1");
                    try {

                        Empleado[] worker = {new Empleado(12345, "Fabio", "Mendez", "Fer", "F123"),
                            new Empleado(123, "Esperanza", "Gomez", "Esgo", "gomez123"),
                            new Empleado(789, "Juan", "Perez", "admin", "admin"),
                            new Empleado(654, "Carlos", "Martinez", "admin1", "1234"),
                            new Empleado(321, "Pedro", "salas", "admin2", "password")};
                        Producto[] item = {new Producto("001", "RAM 4GB", 90000),
                            new Producto("002", "RAM 8GB", 180000),
                            new Producto("003", "SDD 256GB", 320000),
                            new Producto("004", "HUB USB", 10000),
                            new Producto("1", "Board MSI", 280000),
                            new Producto("2", "Teclado", 20000),
                            new Producto("3", "Mouse", 18000),
                            new Producto("4", "Combo Teclado y Mouse Wireless", 950000),
                            new Producto("5", "Parlantes", 35000),
                            new Producto("6", "Disco Duro 500 Gb", 120000),
                            new Producto("7", "Disco Duro 1 TB", 140000),
                            new Producto("8", "Grafica nvidia GTX 550 ti ", 320000),
                            new Producto("9", "Intel Core i7 5960X", 2650000),
                            new Producto("10", "Refrigeracion Liquida", 285000),
                            new Producto("11", "Memoria USB 8Gb", 15000),
                            new Producto("12", "Memoria USB 16Gb", 23000),
                            new Producto("13", "Memoria USB 32Gb", 56000),
                            new Producto("14", "Fuente de poder sencilla", 20000),
                            new Producto("15", "Fuente de poder Real 600W", 156000),
                            new Producto("16", "Fuente de poder Real 700W", 185000),
                            new Producto("17", "Fuente de Poder Real 1200W", 756000),
                            new Producto("18", "Gabinete ThermalTake Armor Revo", 560000),
                            new Producto("19", "Mantenimiento Completo de PC", 80000),
                            new Producto("20", "Pagina web Sencilla", 250000)
                        };

                        Cliente[] customer = {new Cliente(123456789, "Pol", "KER"),
                            new Cliente(12345, "Carlos", "Lara"),
                            new Cliente(123, "Juan", "Carmona"),
                            new Cliente(1234, "Carlos", "Tamayo"),
                            new Cliente(54321, "Jeniffer", "Manzano"),
                            new Cliente(1, "Prueba", "Test"),};

                        for (int x = 0; x < worker.length; x++) {
                            market.add(worker[x]);
                        }

                        for (int x = 0; x < customer.length; x++) {
                            market.add(customer[x]);
                        }

                        for (int x = 0; x < item.length; x++) {
                            market.add(item[x]);
                        }

                    } catch (ObjectNotFoundException notFound) {
                        notFound.printStackTrace();
                    } catch (Exception error) {
                        error.printStackTrace();
                    }

                }
                try {
                    new Principal(market).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    /**
     * Prepare the global variables for the other splash functions
     */
    static Rectangle2D.Double splashTextArea;
    static Rectangle2D.Double splashProgressArea;
    static Graphics2D splashGraphics;
    static Font font;
    static SplashScreen mySplash;

    private static void splashInit() {

        mySplash = SplashScreen.getSplashScreen();
        if (mySplash != null) {   // if there are any problems displaying the splash this will be null
            Dimension ssDim = mySplash.getSize();
            int height = ssDim.height;
            int width = ssDim.width;
            // stake out some area for our status information
            splashTextArea = new Rectangle2D.Double(15., height * 0.88, width * .45, 32.);
            splashProgressArea = new Rectangle2D.Double(width * .55, height * .92, width * .4, 12);

            // create the Graphics environment for drawing status info
            splashGraphics = mySplash.createGraphics();
            font = new Font("Dialog", Font.PLAIN, 14);
            splashGraphics.setFont(font);

            // initialize the status info
            splashText("Starting");
            splashProgress(0);
        }
    }

    /**
     * Display text in status area of Splash. Note: no validation it will fit.
     *
     * @param str - text to be displayed
     */
    public static void splashText(String str) {
        if (mySplash != null && mySplash.isVisible()) {   // important to check here so no other methods need to know if there
            // really is a Splash being displayed

            // erase the last status text
            splashGraphics.setPaint(Color.LIGHT_GRAY);
            splashGraphics.fill(splashTextArea);

            // draw the text
            splashGraphics.setPaint(Color.BLACK);
            splashGraphics.drawString(str, (int) (splashTextArea.getX() + 10), (int) (splashTextArea.getY() + 15));

            // make sure it's displayed
            mySplash.update();
        }
    }

    /**
     * Display a (very) basic progress bar
     *
     * @param pct how much of the progress bar to display 0-100
     */
    public static void splashProgress(int pct) {
        if (mySplash != null && mySplash.isVisible()) {

            // Note: 3 colors are used here to demonstrate steps
            // erase the old one
            splashGraphics.setPaint(Color.LIGHT_GRAY);
            splashGraphics.fill(splashProgressArea);

            // draw an outline
            splashGraphics.setPaint(Color.BLUE);
            splashGraphics.draw(splashProgressArea);

            // Calculate the width corresponding to the correct percentage
            int x = (int) splashProgressArea.getMinX();
            int y = (int) splashProgressArea.getMinY();
            int wid = (int) splashProgressArea.getWidth();
            int hgt = (int) splashProgressArea.getHeight();

            int doneWidth = Math.round(pct * wid / 100.f);
            doneWidth = Math.max(0, Math.min(doneWidth, wid - 1));  // limit 0-width

            // fill the done part one pixel smaller than the outline
            splashGraphics.setPaint(Color.GREEN);
            splashGraphics.fillRect(x, y + 1, doneWidth, hgt - 1);

            // make sure it's displayed
            mySplash.update();
        }
    }

    /**
     * just a stub to simulate a long initialization task that updates the text
     * and progress parts of the status in the Splash
     */
    private static void appInit() {
        for (int i = 1; i <= 10; i++) {
            int pctDone = i * 10;
            splashText("Doing task #" + i);
            splashProgress(pctDone);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                // ignore it
            }
        }
    }

}
