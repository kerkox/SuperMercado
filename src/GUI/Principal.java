/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import supermecado.clases.Almacen;
import supermecado.clases.Compra;
import supermecado.clases.DetalleCompra;
import supermecado.clases.Empleado;
import supermecado.clases.ObjectNotFoundException;
import supermecado.clases.Producto;

/**
 *
 * @author Polker
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    private Venta ventana1 = null;
    private About info = null;
    private Almacen market = null;
    public boolean logeado = false;
    private boolean ClientAlive = false;
    private Producto item = null;
    private Compra buy = null;
    private Empleado empleado = null;
    private ArrayList<DetalleCompra> detalleCompras = new ArrayList<>(); //error al iniciar la GUI por nullPointerException
    private Login windowLog = null;


    
    /**
     * Constructor de la ventana 
     * @param market Es un objeto de tipo Almacen
     */
    public Principal(Almacen market) {
        this.market = market;
        this.info = new About();
        initComponents();
        setLocationRelativeTo(null); // Para hacer aparecer la ventana en el centro
        //*****************************
        //Imagen de Fondo metodos:
        //1.  por Border
        this.Desktop.setBorder(new Background());
        //*****************************
        this.ShowVentas.addActionListener(new ActionListener() {
            private VentasRealizadas vr = null;

            public void actionPerformed(ActionEvent e) {
                if (this.vr == null) {
                    this.vr = new VentasRealizadas(market);
                    Desktop.add(this.vr);

                }
                this.vr.setVisible(true);

            }

        });

        ListenerLogueo log = new ListenerLogueo();
        this.Password.addActionListener(log);
        this.access.addActionListener(log);
        this.User.addActionListener(log);
        
        /**
         * 
         */
        super.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                //System.out.println("windowClosing");
                ObjectOutputStream oos = null;
                try {
                    oos = new ObjectOutputStream(new FileOutputStream("market.data"));
                    oos.writeObject(Principal.this.market);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (oos != null) {
                        try {
                            oos.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

            }

            @Override
            public void windowClosed(WindowEvent e) {
                //System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        
    }
    
    
    //********************************
    //Funciones Auxliares
    
    //Limpia el campo de texto del usuario
    public void clearUser() {
        User.setText("");

    }
    //Limpia el campo de Password
    public void clearPassword() {
        Password.setText("");
    }
    //Limpia los campos de texto del Login
    public void clear() {
        User.setText("");
        Password.setText("");
    }

    /**
     * Anuncia al Almacen que se ha logueado un Empleado
     * @param log  el valor booleano 
     * Este metodo permite hacer visible la ventande la venta
     */
    public void setLogeado(boolean log) {
        if (this.ventana1 == null) {
            this.ventana1 = new Venta(market);
            Desktop.add(ventana1);
        }
        ventana1.setVisible(log);
        ventana1.setLogeado(log);
        ventana1.logeado = log;

    }
    //********************************
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        PanelLogin = new javax.swing.JPanel();
        User = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        access = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        Login = new javax.swing.JMenuItem();
        LogOut = new javax.swing.JMenuItem();
        ShowVentas = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Super Mercado");
        setMinimumSize(new java.awt.Dimension(820, 630));

        Desktop.setBackground(new java.awt.Color(6, 129, 221));

        PanelLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelLogin.setOpaque(false);

        User.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        User.setText("user");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Password:");

        Password.setText("password");

        access.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        access.setText("Acceder");

        javax.swing.GroupLayout PanelLoginLayout = new javax.swing.GroupLayout(PanelLogin);
        PanelLogin.setLayout(PanelLoginLayout);
        PanelLoginLayout.setHorizontalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(access, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        PanelLoginLayout.setVerticalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(access)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 847, Short.MAX_VALUE)
            .addGroup(DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DesktopLayout.createSequentialGroup()
                    .addGap(292, 292, 292)
                    .addComponent(PanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(292, Short.MAX_VALUE)))
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DesktopLayout.createSequentialGroup()
                    .addGap(277, 277, 277)
                    .addComponent(PanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(277, Short.MAX_VALUE)))
        );
        Desktop.setLayer(PanelLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);

        PanelLogin.getAccessibleContext().setAccessibleParent(this);

        jMenu3.setText("Aplicación");

        Login.setText("Iniciar Sesión");
        jMenu3.add(Login);

        LogOut.setText("Cerrar Sesión");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });
        jMenu3.add(LogOut);

        ShowVentas.setText("Mostrar Ventas");
        jMenu3.add(ShowVentas);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Ayuda");

        jMenuItem4.setText("Acerca de...");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        this.market.log = false;
        this.market.logueado = null;
        this.logeado = false;
        this.ClientAlive = false;
        setLogeado(logeado);
        ventana1.vendedor.setText("Vendedor: No Registrado");
        ventana1.inicio();
        buy = null;
        item = null;
        this.detalleCompras = new ArrayList<>(); // para liberar la lista de Detalle de compras al salir de la sesion
        ventana1.CompraTabla.updateUI();
        this.PanelLogin.setVisible(true);
    }//GEN-LAST:event_LogOutActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        info.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuItem LogOut;
    private javax.swing.JMenuItem Login;
    private javax.swing.JPanel PanelLogin;
    private javax.swing.JPasswordField Password;
    private javax.swing.JMenuItem ShowVentas;
    private javax.swing.JTextField User;
    private javax.swing.JButton access;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables
public class ListenerLogueo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Empleado empleado = null;
                String loginEmpleado;
                char[] passEmpleado;

                loginEmpleado = User.getText().trim();

                empleado = market.BuscarEmpleado(loginEmpleado.trim());
                passEmpleado = Password.getPassword();

                if (market.Logueo(loginEmpleado, passEmpleado)) {
                    clear();
                    PanelLogin.setVisible(false);
                    setLogeado(market.log);

                } else {
                    JOptionPane.showMessageDialog(null, "Password Incorrecto");
                    clearPassword();
                }

            } catch (NullPointerException nullPointer) {
                JOptionPane.showMessageDialog(null, "Error: Password Vacio");
                nullPointer.printStackTrace();

            } catch (ObjectNotFoundException notFound) {
                JOptionPane.showMessageDialog(null, notFound.getMessage());
                clearUser();
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, error.getMessage());
            }

        }

    }

}
