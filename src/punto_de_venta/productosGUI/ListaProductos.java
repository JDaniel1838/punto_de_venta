/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto_de_venta.productosGUI;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import punto_de_venta.productosBL.productosBL;
import punto_de_venta.productosDAL.Conexion;

/**
 *
 * @author Daniel
 */
public class ListaProductos extends javax.swing.JFrame {

    int xMouse,yMouse;
    //Colores 
    Color Azul = new Color (57,162,219);
    Color AzulHover = new Color(162,219,250);
    Color Gris = new Color(204,204,204);
    
    String Codigo;
    
    boolean existsProduc;
    
    int cantidadDeProductos=0;
    
    //MODELO DE TABLA TODOS LOS PRODUCTOS
    DefaultTableModel modelo1,modelo2;
    
    
    //OBJETO CONEXION PARA CONEXION A DB
    Conexion objConexion = new Conexion();//ESTABLECE CONEXIÓN
    
    //OBJ QUE OBTENDRA LA INFORMACION DE LA TABLA BUSQUEDA PRODUCTO PARA PODER ACTUALIZAR O ELIMINAR PRODUCTO
    productosBL oRegistro = new productosBL();
    
    //TITULOS PARA TABLAS 
    String[] titulosTabla = {"Código","Nombre","Precio","Stock"};
    
    public ListaProductos() {
        initComponents();
        
        //ASIGNAMOS EL MODELO A LA TABLA
        modelo1 = new DefaultTableModel(null,titulosTabla);
        TablePropsProduct.setModel(modelo1);
        modelo1.addRow(new Object[]{"00000", "N/A", "0","0"});
        TablePropsProduct.setDefaultEditor(Object.class, null);
        buscarProducto();
        
        
        //ASIGNAMOS EL MODELO A LA TABLA ALLPRODUCTOS
        
        modelo2 = new DefaultTableModel(null,titulosTabla);
        TablePropsAllProducts.setModel(modelo2);
         
        //DESACTIVA EL PODER EDITAR LAS FILAS
        //TablePropsAllProducts.setDefaultEditor(Object.class, null);
        
        //METODO QUE CARGA DATOS DE LA DB Y LOS INSERTA  A TABLA
        mostrarDatos();
        
        System.out.println(cantidadDeProductos);
        
        
        //DESING TABLE
        //Busqueda Producto
        TablePropsProduct.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,14));
        TablePropsProduct.getTableHeader().setOpaque(false);
        TablePropsProduct.getTableHeader().setBackground(new Color(57,162,219));
        TablePropsProduct.getTableHeader().setForeground(new Color(84,84,84));
        TablePropsProduct.setRowHeight(25);
        
        //Lista todos los productos
        TablePropsAllProducts.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,14));
        TablePropsAllProducts.getTableHeader().setOpaque(false);
        TablePropsAllProducts.getTableHeader().setBackground(new Color(57,162,219));
        TablePropsAllProducts.getTableHeader().setForeground(new Color(84,84,84));
        TablePropsAllProducts.setRowHeight(25);
        
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        TablePropsProduct.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        TablePropsProduct.getColumnModel().getColumn(1).setCellRenderer(Alinear);
        TablePropsProduct.getColumnModel().getColumn(2).setCellRenderer(Alinear);
        TablePropsProduct.getColumnModel().getColumn(3).setCellRenderer(Alinear);
        
        TablePropsAllProducts.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        TablePropsAllProducts.getColumnModel().getColumn(1).setCellRenderer(Alinear);
        TablePropsAllProducts.getColumnModel().getColumn(2).setCellRenderer(Alinear);
        TablePropsAllProducts.getColumnModel().getColumn(3).setCellRenderer(Alinear);
        
        //OCULTAR BOTONES DE EDITAR Y ELIMINAR
        PanelEdit.setVisible(false);
        PanelDelete.setVisible(false);
    }
    
    public boolean Validaciones(){
        //VALIDACIONES CÓDIGO
        Codigo = InputCodigo.getText();
        if(Codigo.replaceAll("^0+", "").equals("")){//No acepta 0000000
            JOptionPane.showMessageDialog(this, "Ingrese un valor diferente de 0 en código","CÓDIGO DEL PRODUCTO",JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(Codigo.length()<= 7 || Codigo.length()>23){//Codigo solo acepta de 8 a 23 digitos
            JOptionPane.showMessageDialog(this, "El código solo acepta de 8 a 23 digitos","CÓDIGO DEL PRODUCTO",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
       //Paso validaciones
        System.out.print("Se ingreso un código valido");
        return true;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        btn_agregar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_venta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_lista = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Main = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        PanelBtnClose = new javax.swing.JPanel();
        BtnClose = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PanelCodigo = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        InputCodigo = new javax.swing.JTextField();
        PanelSearch = new javax.swing.JPanel();
        BtnSearch = new javax.swing.JLabel();
        PanelEdit = new javax.swing.JPanel();
        BtnEdit = new javax.swing.JLabel();
        PanelDelete = new javax.swing.JPanel();
        BtnDelete = new javax.swing.JLabel();
        PanelTable = new javax.swing.JScrollPane();
        TablePropsProduct = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePropsAllProducts = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        PanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(57, 162, 219));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/punto_de_venta/images/Logo.png"))); // NOI18N
        Menu.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        Titulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("MI TIENDA");
        Menu.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        btn_agregar.setBackground(new java.awt.Color(57, 162, 219));
        btn_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_agregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_agregarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_agregarMousePressed(evt);
            }
        });
        btn_agregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/punto_de_venta/images/producto.png"))); // NOI18N
        btn_agregar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Agregar Productos");
        btn_agregar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        Menu.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 270, 50));

        btn_venta.setBackground(new java.awt.Color(162, 219, 250));
        btn_venta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_venta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ventaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ventaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ventaMousePressed(evt);
            }
        });
        btn_venta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/punto_de_venta/images/lista.png"))); // NOI18N
        btn_venta.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Lista de Productos");
        btn_venta.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        Menu.add(btn_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 270, 50));

        btn_lista.setBackground(new java.awt.Color(57, 162, 219));
        btn_lista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_listaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_listaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_listaMousePressed(evt);
            }
        });
        btn_lista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/punto_de_venta/images/carrito.png"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(24, 24));
        jLabel3.setMinimumSize(new java.awt.Dimension(24, 24));
        jLabel3.setPreferredSize(new java.awt.Dimension(24, 24));
        btn_lista.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Venta");
        btn_lista.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        Menu.add(btn_lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 270, 50));

        PanelFondo.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 540));

        Main.setBackground(new java.awt.Color(255, 255, 255));
        Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HeaderMouseDragged(evt);
            }
        });
        Header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HeaderMousePressed(evt);
            }
        });
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelBtnClose.setBackground(new java.awt.Color(255, 255, 255));
        PanelBtnClose.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnClose.setBackground(new java.awt.Color(255, 255, 255));
        BtnClose.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnClose.setText("X");
        BtnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnCloseMouseExited(evt);
            }
        });
        PanelBtnClose.add(BtnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 40, 30));

        Header.add(PanelBtnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 40, 50));

        Main.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(-270, 0, 960, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Buscar producto por código:");
        Main.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        PanelCodigo.setBackground(new java.awt.Color(255, 255, 255));
        PanelCodigo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator4.setForeground(new java.awt.Color(67, 67, 67));
        PanelCodigo.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 280, 20));

        InputCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        InputCodigo.setForeground(new java.awt.Color(51, 51, 51));
        InputCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        InputCodigo.setBorder(null);
        InputCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                InputCodigoMousePressed(evt);
            }
        });
        InputCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputCodigoActionPerformed(evt);
            }
        });
        InputCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                InputCodigoKeyTyped(evt);
            }
        });
        PanelCodigo.add(InputCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 260, 40));

        PanelSearch.setBackground(new java.awt.Color(255, 255, 255));

        BtnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/punto_de_venta/images/BtnSearch.png"))); // NOI18N
        BtnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelSearchLayout = new javax.swing.GroupLayout(PanelSearch);
        PanelSearch.setLayout(PanelSearchLayout);
        PanelSearchLayout.setHorizontalGroup(
            PanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSearchLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnSearch))
        );
        PanelSearchLayout.setVerticalGroup(
            PanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSearchLayout.createSequentialGroup()
                .addComponent(BtnSearch)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelCodigo.add(PanelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 50, 50));

        Main.add(PanelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 380, -1));

        PanelEdit.setBackground(new java.awt.Color(255, 255, 255));
        PanelEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/punto_de_venta/images/BtnEdit.png"))); // NOI18N
        BtnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnEditMouseClicked(evt);
            }
        });
        PanelEdit.add(BtnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(PanelEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 50, 50));

        PanelDelete.setBackground(new java.awt.Color(255, 255, 255));
        PanelDelete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/punto_de_venta/images/BtnDelete.png"))); // NOI18N
        BtnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnDeleteMouseClicked(evt);
            }
        });
        PanelDelete.add(BtnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(PanelDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, -1, 50));

        TablePropsProduct.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        TablePropsProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"00000", "N/A",  new Double(0.0),  new Integer(0)}
            },
            new String [] {
                "Código", "Nombre", "Precio", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablePropsProduct.setFocusable(false);
        TablePropsProduct.setGridColor(new java.awt.Color(255, 255, 255));
        TablePropsProduct.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TablePropsProduct.setOpaque(false);
        TablePropsProduct.setRowHeight(25);
        TablePropsProduct.setSelectionBackground(new java.awt.Color(255, 255, 255));
        TablePropsProduct.setSelectionForeground(new java.awt.Color(84, 84, 84));
        TablePropsProduct.setShowVerticalLines(false);
        TablePropsProduct.getTableHeader().setReorderingAllowed(false);
        PanelTable.setViewportView(TablePropsProduct);
        if (TablePropsProduct.getColumnModel().getColumnCount() > 0) {
            TablePropsProduct.getColumnModel().getColumn(0).setResizable(false);
            TablePropsProduct.getColumnModel().getColumn(1).setResizable(false);
            TablePropsProduct.getColumnModel().getColumn(2).setResizable(false);
            TablePropsProduct.getColumnModel().getColumn(3).setResizable(false);
        }

        Main.add(PanelTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 470, 57));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("PRODUCTOS EN SUCURSAL");
        Main.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setOpaque(false);

        TablePropsAllProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombrel Producto", "Precio", "Stock "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablePropsAllProducts.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TablePropsAllProducts.setRowHeight(25);
        TablePropsAllProducts.setSelectionBackground(new java.awt.Color(57, 162, 219));
        TablePropsAllProducts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TablePropsAllProducts.setShowVerticalLines(false);
        TablePropsAllProducts.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TablePropsAllProducts);
        if (TablePropsAllProducts.getColumnModel().getColumnCount() > 0) {
            TablePropsAllProducts.getColumnModel().getColumn(0).setResizable(false);
            TablePropsAllProducts.getColumnModel().getColumn(1).setResizable(false);
            TablePropsAllProducts.getColumnModel().getColumn(2).setResizable(false);
            TablePropsAllProducts.getColumnModel().getColumn(3).setResizable(false);
        }

        Main.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 600, 290));

        PanelFondo.add(Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 690, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregarMouseEntered

    private void btn_agregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregarMouseExited

    private void btn_agregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregarMousePressed
        AgregarProductos Producto = new AgregarProductos();
        Producto.setLocationRelativeTo(null);
        Producto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_agregarMousePressed

    private void btn_ventaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ventaMouseEntered
        btn_venta.setBackground(AzulHover);
    }//GEN-LAST:event_btn_ventaMouseEntered

    private void btn_ventaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ventaMouseExited
        btn_venta.setBackground(Azul);
    }//GEN-LAST:event_btn_ventaMouseExited

    private void btn_ventaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ventaMousePressed
        
    }//GEN-LAST:event_btn_ventaMousePressed

    private void btn_listaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_listaMouseEntered
        btn_lista.setBackground(AzulHover);
    }//GEN-LAST:event_btn_listaMouseEntered

    private void btn_listaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_listaMouseExited
        btn_lista.setBackground(Azul);
    }//GEN-LAST:event_btn_listaMouseExited

    private void btn_listaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_listaMousePressed
        Venta Venta = new Venta();
        Venta.setLocationRelativeTo(null);
        Venta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_listaMousePressed

    private void BtnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSearchMouseClicked
        //BOTON SEARCH
        boolean codigIsValid = Validaciones();

        if(codigIsValid){
            
            
            buscarProducto();
            if(existsProduc){//EL PRODUCTO SI EXISTE EN LA DB
                PanelEdit.setVisible(true);
                PanelDelete.setVisible(true);
                //PRUEBA
                System.out.println(oRegistro.getCodigo());
                System.out.println(oRegistro.getNombre());
                System.out.println(oRegistro.getPrecio());
                System.out.println(oRegistro.getStock());
                       
                
                existsProduc=false;//RESETEAMOS VALOR
            
            }else{//EL PRODUCTO NO EXISTE 
                //OCULTA BOTONES 
                PanelEdit.setVisible(false);
                PanelDelete.setVisible(false);
                //ELIMINA LA FILA ANTERIOR
                modelo1.removeRow(0);
                //AÑADE UNA FILA CON LOS DATOS DEL PRODUCTO
                modelo1.addRow(new Object[]{"00000", "N/A", "0","0"});
                //MENSAJE PARA USUARIO
                JOptionPane.showMessageDialog(this, "El código ingresado no se encuentra en el sistema","SIN RESULTADOS", JOptionPane.WARNING_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_BtnSearchMouseClicked

    private void InputCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputCodigoKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = (key >= 48 && key <= 57);
        if (!numeros){
            evt.consume();
        }
        if (InputCodigo.getText().trim().length() == 23) {
            evt.consume();
        }
    }//GEN-LAST:event_InputCodigoKeyTyped

    private void InputCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputCodigoActionPerformed

    private void InputCodigoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputCodigoMousePressed

    }//GEN-LAST:event_InputCodigoMousePressed

    private void HeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_HeaderMousePressed

    private void HeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMouseDragged
        //Mueve ventana
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x-xMouse,y -yMouse);
    }//GEN-LAST:event_HeaderMouseDragged

    private void BtnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCloseMouseExited
        PanelBtnClose.setBackground(Color.WHITE);
        BtnClose.setForeground(Color.BLACK);
    }//GEN-LAST:event_BtnCloseMouseExited

    private void BtnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCloseMouseEntered
        //Hover exit
        PanelBtnClose.setBackground(new Color(240,84,84));
        BtnClose.setForeground(Color.WHITE);
    }//GEN-LAST:event_BtnCloseMouseEntered

    private void BtnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCloseMouseClicked
        int option = JOptionPane.showConfirmDialog(this, "¿Esta seguro de cerrar el sistema?");
        if(option==0){
            System.exit(0);
        }
    }//GEN-LAST:event_BtnCloseMouseClicked

    private void BtnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEditMouseClicked
        //CAMBIA A AL VISTA EDITAR PRODUCTO Y PASA LOS DATOS DEL PRODUCTO
        
        EditarProducto EditarProducto = new EditarProducto(oRegistro.getCodigo(),oRegistro.getNombre(),oRegistro.getPrecio(),oRegistro.getStock());
        EditarProducto.setLocationRelativeTo(null);
        EditarProducto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnEditMouseClicked

    private void BtnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDeleteMouseClicked
        
        if(oRegistro.getStock()>0){//AUN HAY UNIDADES DEL PRODUCTO EN EL SISTEMA 
            String hayUnidades = String.format("¿Está seguro de eliminar este producto?\nAun tiene %d unidades de este producto.",oRegistro.getStock());
            int confirmDeleteProduct = JOptionPane.showConfirmDialog(this, hayUnidades);//PREGUNTA AL USUARIO
        
            if(confirmDeleteProduct==0){//USUARIO CONFIRMA ELIMINAR
                
                if(oRegistro.getCodigo()==""){//HAY UN ERROR

                    JOptionPane.showMessageDialog(this, "SE HA PRODUCIDO UN ERROR AL ELIMINAR EL PRODUCTO\nPOR FAVOR CIERRE EL SISTEMA Y VUELVA ABRIRLO","SIN RESULTADOS", JOptionPane.WARNING_MESSAGE);
                }else{
                    String StrSentenciaDelete = String.format("DELETE FROM Productos WHERE Codigo='%s'",oRegistro.getCodigo());
                    objConexion.ejecutarSentenciaSQL(StrSentenciaDelete);  
                
                    //MOSTRAMOS MENSAJE AL USUARIO
                    String StrMessageDelete = String.format("El producto '%s' ha sido eliminado del sistema", oRegistro.getNombre());
                    JOptionPane.showMessageDialog(this, StrMessageDelete,"PRODUCTO ELIMINADO", JOptionPane.INFORMATION_MESSAGE);
                    
                    //RESETEAMOS VALORES Y OCULTAMOS DATOS
                    InputCodigo.setText("");
                    PanelDelete.setVisible(false);
                    PanelEdit.setVisible(false);
                    //RESETEAMOS TABLA DE RESULTADO PRODUCTO
                    modelo1.removeRow(0);
                    modelo1.addRow(new Object[]{"00000", "N/A", "0","0"});
                
                
                    //RESETEAMOS QUE RECOJE DATOS PARA EVITAR ELIMINAR PRODUCTOS QUE YA NO EXISTEN
                    oRegistro.setCodigo("");
                
                    DefaultTableModel modeloActualizacion =  new DefaultTableModel(null,titulosTabla);//NUEVO MODELO DE ACTUALIZACION
                    try {//REALIZA UNA NUEVA CONSULTA PARA ACTUALIZAR TABLA
                
                        ResultSet resultado = objConexion.consultarRegistros("SELECT * FROM Productos");
                
                        while (resultado.next()){//IMPRIME CADA CAMPO DEL REGISTRO
                            //POR CADA REGISTRO
                            Object[] OProductos = {resultado.getString("Codigo"),resultado.getString("Nombre"),resultado.getString("Precio"),resultado.getString("Stock")};
                
                            //AÑADE EL REGISTRO A LA TABLA
                            modeloActualizacion.addRow(OProductos);
                        };
                    
                    
                    
                    } catch (Exception e) {//ERROR AL EJECUTAR CONSULTA GET
                        System.out.println(e);
                    };
                
                    TablePropsAllProducts.setModel(modeloActualizacion);
                
                
                };
                
                
            }
            
            
        }
        
        
        
    }//GEN-LAST:event_BtnDeleteMouseClicked

    
    //METODO OBTIENE LOS PRODUCTOS DE LA BASE DE DATOS
    public void mostrarDatos(){
        
        /*while(modelo2.getRowCount()>0){//ACTUALIZA LA TABLA Y ELIMINA EL REGISTRO ACTUAL
            modelo2.removeRow(0); 
        }*/
        
            try {//REALIZA CONSULTA
                
                ResultSet resultado = objConexion.consultarRegistros("SELECT * FROM Productos");
                while (resultado.next()){//IMPRIME CADA CAMPO DEL REGISTRO
                    //POR CADA REGISTRO
                    Object[] OProductos = {resultado.getString("Codigo"),resultado.getString("Nombre"),resultado.getString("Precio"),resultado.getString("Stock")};
                
                    //AÑADE EL REGISTRO A LA TABLA
                    modelo2.addRow(OProductos);
                    cantidadDeProductos++;//CONTADOR DEL  NUMERO DE REGISTROS EN LA TABLA
                };
                
                
    
            } catch (Exception e) {//ERROR AL EJECUTAR CONSULTA GET
                System.out.println(e);
            }
    }
    
    public void buscarProducto(){
        int i=0;//CONTADOR POR SI NO HAY NINGUN RESULTADO
        
        try {//REALIZA CONSULTA
                String Consulta = String.format("SELECT * FROM Productos WHERE Codigo='%s'",InputCodigo.getText());
                ResultSet resProduct = objConexion.consultarRegistros(Consulta);
                
                
                while (resProduct.next()){//IMPRIME CADA CAMPO DEL REGISTRO
                    //POR CADA REGISTRO
                    Object[] OProductos = {resProduct.getString("Codigo"),resProduct.getString("Nombre"),resProduct.getString("Precio"),resProduct.getString("Stock")};
                
                    //ELIMINA LA FILA ANTERIOR
                    modelo1.removeRow(0);
                    //AÑADE UNA FILA CON LOS DATOS DEL PRODUCTO
                    modelo1.addRow(OProductos);
                    
                    //GUARDAMOS LOS DATOS DE LA CONSULTA POR SI SE QUIERE EDITAR O BORRAR EL OBJ
                    oRegistro.setCodigo(resProduct.getString("Codigo"));//GUARDAMOS CÓDIGO;
                    oRegistro.setNombre(resProduct.getString("Nombre"));//GUARDAMOS NOMBRE;
                    double Precio =Double.parseDouble(resProduct.getString("Precio"));
                    oRegistro.setPrecio(Precio);//GUARDAMOS PRECIO
                    int Stock = Integer.parseInt(resProduct.getString("Stock"));
                    oRegistro.setStock(Stock);//GUARDAMOS STOCK
                    
                    
                    
                    
                    //MARCAMOS QUE PRODUCTO SI EXISTE
                    existsProduc = true;
                };
                
                
    
            } catch (Exception e) {//ERROR AL EJECUTAR CONSULTA GET
                System.out.println(e);
            }
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListaProductos Lista = new ListaProductos();
                Lista.setVisible(true);
                Lista.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnClose;
    private javax.swing.JLabel BtnDelete;
    private javax.swing.JLabel BtnEdit;
    private javax.swing.JLabel BtnSearch;
    private javax.swing.JPanel Header;
    private javax.swing.JTextField InputCodigo;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel PanelBtnClose;
    private javax.swing.JPanel PanelCodigo;
    private javax.swing.JPanel PanelDelete;
    private javax.swing.JPanel PanelEdit;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JPanel PanelSearch;
    private javax.swing.JScrollPane PanelTable;
    private javax.swing.JTable TablePropsAllProducts;
    private javax.swing.JTable TablePropsProduct;
    private javax.swing.JLabel Titulo;
    private javax.swing.JPanel btn_agregar;
    private javax.swing.JPanel btn_lista;
    private javax.swing.JPanel btn_venta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables

    
}
