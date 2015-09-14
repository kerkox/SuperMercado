/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import supermecado.Almacen;
import supermecado.Compra;
import supermecado.DetalleCompra;
import supermecado.Empleado;
import supermecado.ObjectNotFoundException;
import supermecado.Producto;

/**
 *
 * @author Polker
 */
public class Venta extends javax.swing.JInternalFrame {

    /**
     * Creates new form Venta
     */
    private Almacen market = null;
    public boolean logeado = false;
    public boolean ClientAlive = false;
    private Producto item = null;
    private Empleado empleado = null;
    private Compra buy = null;


    public Venta(Almacen market) {
        this.market = market;
        this.logeado = this.market.log;
        this.buy = new Compra(null, market.logueado);
        initComponents();
        AlmacenName.setText(this.market.getNombre());
        AlmacenNit.setText(this.market.getNIT());

        //Evento para la busqueda de un cliente con el boton o Enter
        ListenerBuscarCliente lbc = new ListenerBuscarCliente();
        this.ClienteId.addActionListener(lbc);
        this.Buscar.addActionListener(lbc);
        //*****************************************
        
        //Agregado de Captura de evento al presionar enter para buscar
        this.ProductoCode.addActionListener((ActionEvent e) -> {
            try {

                item = this.market.BuscarProducto(ProductoCode.getText().trim());
                ProductoName.setText(item.getNombre());
                ProductoCosto.setText(item.getCostoUnitario() + "");

            } catch (ObjectNotFoundException notFound) {
                JOptionPane.showMessageDialog(null, notFound.getMessage());

            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, error.getMessage());
            }
        });

        this.CompraTabla.setModel(new AbstractTableModel() {

            private String[] nombres = {"Producto", "Costo Unitario", "Cantidad", "Costo"};

            @Override
            public String getColumnName(int column) {
                return this.nombres[column];
            }

            @Override
            public int getRowCount() {
//                return buy.getDetalleCompras().size();
                if(buy == null) return 0; //Necesario para cuando no se han realizado ventas y se cierra la sesion
                return buy.getDetalleCompras().size();
            }

            @Override
            public int getColumnCount() {
                return this.nombres.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
//                DetalleCompra detalle = buy.getDetalleCompras().get(rowIndex);
                DetalleCompra detalle = buy.getDetalleCompras().get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return detalle.getProducto().getNombre();
                    case 1:
                        return detalle.getProducto().getCostoUnitario();
                    case 2:
                        return detalle.getCantidadProductos();
                    case 3:
                        return detalle.CostoProducto();
                }
                return "";
            }
        });
//        this.Ventas.setModel(new AbstractTableModel(){
//            private String[] nombres ={"Vendedor","Cliente","Costo","Puntos Otorgados"};
//
//            @Override
//            public String getColumnName(int column){
//                return this.nombres[column];
//            }
//            
//            
//            @Override
//            public int getRowCount() {
//                return market.getCompras().size();
//            }
//
//            @Override
//            public int getColumnCount() {
//                return this.nombres.length;
//            }
//
//            @Override
//            public Object getValueAt(int rowIndex, int columnIndex) {
//                Compra purchase = market.getCompras().get(rowIndex);
//                switch(columnIndex){
//                    case 0:
//                        return purchase.getEmpleado().getNombres()+" "+purchase.getEmpleado().getApellidos();
//                    case 1:
//                        return purchase.getCliente().getNombres()+" "+purchase.getCliente().getApellidos();
//                    case 2:
//                        return purchase.getCostoTotal();
//                    case 3:
//                        return purchase.puntosCompra();
//                }
//                return "";
//            }
//            
//        });

    }
    
    public void inicio(){
        clear();
        this.Buscar.setEnabled(true);
        buy = null;
        item = null;
        CompraTabla.updateUI();
        ClienteId.setEditable(logeado);
        this.ClientAlive=false;
        
    }
    public void clear() {
        ClienteId.setText("");
        ClienteName.setText("");
        ClientePuntos.setText("");
//        ProductoCantidad.setText("");
        ProductoCantidad.setValue(0);
        ProductoCode.setText("");
        ProductoCosto.setText("");
        ProductoName.setText("");
        CompraPuntos.setText("");
        CompraTotal.setText("");
    }

    public void clearProducto() {
//        ProductoCantidad.setText("");
        ProductoCantidad.setValue(0);
        ProductoCode.setText("");
        ProductoCosto.setText("");
        ProductoName.setText("");
    }

    /**
     * 
     * @param login  recibe un valor boolenao
     * Pero hay que mejorarlo para que tome el valor del booleano de la clase
     */
    public void setLogeado(boolean login) {

        ClienteId.setEditable(login);
//        ClienteName.setEditable(login);
//        ClientePuntos.setEditable(login);
        ProductoCantidad.setEnabled(login);
        
//        ProductoCantidad.setEditable(login);
        ProductoCode.setEditable(login);
//        ProductoCosto.setEditable(login);
//        ProductoName.setEditable(login);
//        CompraPuntos.setEditable(login);
//        CompraTotal.setEditable(login);
        
        Buscar.setEnabled(login);
        if(this.market.logueado==null){
            vendedor.setText("Vendedor:  No Registrado");
        }else{
            empleado = this.market.logueado;
        vendedor.setText("Vendedor: "+this.market.logueado.getNombres()+" "+this.market.logueado.getApellidos());
        }
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        VentasRealizadas = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        Ventas = new javax.swing.JTable();
        AlmacenName = new javax.swing.JLabel();
        AlmacenNit = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ClienteName = new javax.swing.JTextField();
        ClientePuntos = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        ClienteId = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ProductoCode = new javax.swing.JTextField();
        ProductoName = new javax.swing.JTextField();
        ProductoCosto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Registro = new javax.swing.JButton();
        Devolver = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        CompraPuntos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        CompraTabla = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        CompraTotal = new javax.swing.JTextField();
        RegistrarVenta = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        ProductoCantidad = new javax.swing.JSpinner();
        vendedor = new javax.swing.JLabel();

        jLabel10.setText("jLabel10");

        jButton4.setText("jButton4");

        VentasRealizadas.setTitle("Ventas Realizadas");
        VentasRealizadas.setMinimumSize(new java.awt.Dimension(500, 300));

        Ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(Ventas);

        javax.swing.GroupLayout VentasRealizadasLayout = new javax.swing.GroupLayout(VentasRealizadas.getContentPane());
        VentasRealizadas.getContentPane().setLayout(VentasRealizadasLayout);
        VentasRealizadasLayout.setHorizontalGroup(
            VentasRealizadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentasRealizadasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );
        VentasRealizadasLayout.setVerticalGroup(
            VentasRealizadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentasRealizadasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Software - SuperMercado");
        setMinimumSize(new java.awt.Dimension(543, 557));

        AlmacenName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AlmacenName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AlmacenName.setText("SuperMercado MercaMAX");
        AlmacenName.setToolTipText("");

        AlmacenNit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AlmacenNit.setText("Nit 1.233544");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jLabel2.setText("Nombre:");

        jLabel3.setText("Puntos:");

        ClienteName.setEditable(false);

        ClientePuntos.setEditable(false);

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        ClienteId.setEditable(false);
        ClienteId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel12.setText("Identificacion:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel12))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ClienteName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ClienteId, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Buscar)))
                        .addGap(4, 4, 4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ClientePuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Buscar)
                    .addComponent(ClienteId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ClienteName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ClientePuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setText("Código: ");

        ProductoCode.setEditable(false);

        ProductoName.setEditable(false);

        ProductoCosto.setEditable(false);

        jLabel5.setText("Nombre:");

        jLabel6.setText("Costo:");

        jLabel7.setText("Cantidad:");

        Registro.setText("Resgistrar");
        Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroActionPerformed(evt);
            }
        });

        Devolver.setText("Devolver");
        Devolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DevolverActionPerformed(evt);
            }
        });

        jLabel8.setText("Detalle de la Compra:");

        jLabel9.setText("Puntos Compra Actual:");

        CompraPuntos.setEditable(false);

        CompraTabla.setAutoCreateRowSorter(true);
        CompraTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CompraTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "null"
            }
        ));
        jScrollPane1.setViewportView(CompraTabla);

        jLabel11.setText("Total:");

        CompraTotal.setEditable(false);

        RegistrarVenta.setText("Registrar Venta");
        RegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarVentaActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar Venta");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Devolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ProductoCode, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ProductoName, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(ProductoCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ProductoCantidad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(CompraPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CompraTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(RegistrarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProductoCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductoName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductoCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Registro)
                    .addComponent(Devolver))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(CompraPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CompraTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegistrarVenta)
                    .addComponent(Cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        vendedor.setText("Vendedor: No Registrado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AlmacenNit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AlmacenName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(vendedor)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AlmacenName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AlmacenNit, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(vendedor))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
//        if (this.logeado) {
//            try {
//                
//                if(ClienteId.getText().trim().equals("")){
//                    throw new Exception("El campo de id de Cliente no puede estar vacio");
//                }
//                long idCliente = Long.parseLong(ClienteId.getText().trim());
//
//                buy = new Compra(this.market.BuscarCliente(idCliente), empleado); // Crecacion de Compra con un cliente
////                customer = this.market.BuscarCliente(idCliente);
//                ClienteName.setText(buy.getCliente().getNombres() + " " + buy.getCliente().getApellidos());
//                ClientePuntos.setText(buy.getCliente().getPuntos() + "");
//                Buscar.setEnabled(false);
//                ClienteId.setEditable(false);
//                this.ClientAlive = true;
//                
//            } catch (ObjectNotFoundException notFound) {
//                JOptionPane.showMessageDialog(null, notFound.getMessage());
//
//            } catch (Exception error) {
//                JOptionPane.showMessageDialog(null, error.getMessage());
//            }
//        }

    }//GEN-LAST:event_BuscarActionPerformed

    private void RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroActionPerformed
        if (this.logeado&&this.ClientAlive) {
//            String quantity = ProductoCantidad.getText().trim();
            int quantity = (int) ProductoCantidad.getValue();
            if (item == null) {
                JOptionPane.showMessageDialog(null, "No has introducido un Producto");
            } else if (quantity==0) {
                JOptionPane.showMessageDialog(null, "No se ha registrado la Cantidad");
            } else {
                //Aqui se creara el Detalle de Compra
//                int cantidad = Integer.parseInt(quantity);
                int cantidad = quantity;
                if (cantidad <= 0) {
                    JOptionPane.showMessageDialog(null, "Cantidad de Productos Invalida");
                } else {
//                    detail = new DetalleCompra(cantidad, item); // Creacion de Detalle de compra con producto

                    buy.add(new DetalleCompra(cantidad, item)); //agregado a la lista el Detalle de compra
//                    puntos = buy.puntosCompra(); //Calculo de puntos en la compra actual
                    CompraPuntos.setText(buy.puntosCompra() + ""); //Mostrando puntos compra actual

//                    detalleCompras = buy.getDetalleCompras(); // para poder actulizar la GUI **********
                    CompraTotal.setText(buy.getCostoTotal() + "");
                    CompraTabla.updateUI();
                    

//                    detail = null; //liberando forzadamente 
                    item = null;
                    clearProducto();

                }

            }
        }

    }//GEN-LAST:event_RegistroActionPerformed

    private void DevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DevolverActionPerformed
        if (this.logeado&&this.ClientAlive) {
            DetalleCompra detail = null;
//            String quantity = ProductoCantidad.getText().trim();
            int quantity = (int) ProductoCantidad.getValue();

        //*******************************
            //Selecionando el producto de la tabla
            if (buy.getDetalleCompras().size() == 1) {
                detail = buy.getDetalleCompras().get(0);
            } else {
                int index = 0;
                index = CompraTabla.getSelectedRow(); //obtiene el numero de la fila del elemnto a devolver
                detail = buy.getDetalleCompras().get(index);
            }
            try {
                buy.remove(detail);
//                puntos = buy.puntosCompra(); //Calculo de puntos en la compra actual
                CompraPuntos.setText(buy.puntosCompra() + ""); //Mostrando puntos compra actual
//                detalleCompras = buy.getDetalleCompras(); // para poder actualizar la GUI **********
                CompraTotal.setText(buy.getCostoTotal() + "");
                CompraTabla.updateUI();
//                detail = null; //liberando forzadamente //ya no se usa porque solo es local
                item = null;
                clearProducto();
                CompraTabla.clearSelection();

            } catch (ObjectNotFoundException notFound) {
                JOptionPane.showMessageDialog(null, notFound.getMessage());
            } catch (Exception error) {
                error.printStackTrace();
                JOptionPane.showMessageDialog(null, error.getMessage());
            }

//        //*******************************
//        //Forma manual
//        if (item == null) {
//            JOptionPane.showMessageDialog(null, "No has introducido un Producto");
//        } else if (quantity.equals("")) {
//            JOptionPane.showMessageDialog(null, "No se ha registrado la Cantidad");
//        } else {
//            //Aqui se Eliminara el Detalle de Compra
//            int cantidad = Integer.parseInt(quantity);
//            if (cantidad <= 0) {
//                JOptionPane.showMessageDialog(null, "Cantidad de Productos Invalida");
//            } else {
//                detail = new DetalleCompra(cantidad, item); // Creacion de Detalle de compra con producto
//                try {
//                    buy.remove(detail);
//                    puntos = buy.puntosCompra(); //Calculo de puntos en la compra actual
//                    CompraPuntos.setText(puntos + ""); //Mostrando puntos compra actual
//
//                    detalleCompras = buy.getDetalleCompras();
//                    CompraTotal.setText(buy.getCostoTotal() + "");
//                    CompraTabla.updateUI();
//
//                    detail = null; //liberando forzadamente 
//                    item = null;
//                    clearProducto();
//                } catch (ObjectNotFoundException notFound) {
//                    JOptionPane.showMessageDialog(null, notFound.getMessage());
//                } catch (Exception error) {
//                    JOptionPane.showMessageDialog(null, error.getMessage());
//                }
//            }
//
//        }
        }
    }//GEN-LAST:event_DevolverActionPerformed

    private void RegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarVentaActionPerformed
        if(this.logeado&&this.ClientAlive){
        try {
            buy.getCliente().incrementarPuntos(buy.puntosCompra());
            this.market.add(buy);
//            this.Compras = this.market.getCompras(); 
//            this.Ventas.updateUI();
            inicio();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        }
    }//GEN-LAST:event_RegistrarVentaActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        inicio();
        
    }//GEN-LAST:event_CancelarActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Venta().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel AlmacenName;
    public javax.swing.JLabel AlmacenNit;
    public javax.swing.JButton Buscar;
    public javax.swing.JButton Cancelar;
    public javax.swing.JFormattedTextField ClienteId;
    public javax.swing.JTextField ClienteName;
    public javax.swing.JTextField ClientePuntos;
    public javax.swing.JTextField CompraPuntos;
    public javax.swing.JTable CompraTabla;
    public javax.swing.JTextField CompraTotal;
    public javax.swing.JButton Devolver;
    private javax.swing.JSpinner ProductoCantidad;
    public javax.swing.JTextField ProductoCode;
    public javax.swing.JTextField ProductoCosto;
    public javax.swing.JTextField ProductoName;
    public javax.swing.JButton RegistrarVenta;
    public javax.swing.JButton Registro;
    private javax.swing.JTable Ventas;
    private javax.swing.JFrame VentasRealizadas;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel vendedor;
    // End of variables declaration//GEN-END:variables
    public class ListenerBuscarCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (logeado) {  
            try {
                
                if(ClienteId.getText().trim().equals("")){
                    throw new Exception("El campo de id de Cliente no puede estar vacio");
                }
                long idCliente = Long.parseLong(ClienteId.getText().trim());

                buy = new Compra(market.BuscarCliente(idCliente), empleado); // Crecacion de Compra con un cliente
                
//                customer = this.market.BuscarCliente(idCliente);
                ClienteName.setText(buy.getCliente().getNombres() + " " + buy.getCliente().getApellidos());
                ClientePuntos.setText(buy.getCliente().getPuntos() + "");
                Buscar.setEnabled(false);
                ClienteId.setEditable(false);
                ClientAlive = true;
                
            } catch (ObjectNotFoundException notFound) {
                JOptionPane.showMessageDialog(null, notFound.getMessage());

            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, error.getMessage());
            }
        }
        }
        
    }


}
