/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto_de_venta.productosGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import punto_de_venta.productosBL.ProductoVenta;
import punto_de_venta.productosBL.productosBL;
import punto_de_venta.productosDAL.Conexion;

/**
 *
 * @author Daniel
 */
public class Venta extends javax.swing.JFrame {

   
    int xMouse,yMouse;
    //Colores 
    Color Azul = new Color (57,162,219);
    Color AzulHover = new Color(162,219,250);
    Color Gris = new Color(204,204,204);
    
    //MODELO PARA LA TABLA
    DefaultTableModel modelo1;
    
    //DOCUMENT LISTENER GLOBAL PARA AGREGAGAR Y ELIMINAR CUANDO QUIERA
    DocumentListener documentListener;
    
    //String para validar codigo
    String Codigo;
    
    
    //OBJETO CONEXION PARA CONEXION A DB
    Conexion objConexion = new Conexion();//ESTABLECE CONEXIÓN
    
    //OBJ QUE OBTENDRA LA INFORMACION DE LA TABLA BUSQUEDA PRODUCTO PARA PODER ACTUALIZAR O ELIMINAR PRODUCTO
    productosBL oRegistro = new productosBL();
    
    //BOOLEAN VALIDA SI EL PRODUCTO YA EXISTE
    boolean existsProduc;
    
    //BOOLEAN PARA VALIDAR EL CODIGO
    boolean codigIsValid;
    
    //TITULOS PARA TABLAS 
    String[] titulosTabla = {"Nombre","Cantidad","Precio","Importe"};
    
    //CONTADOR DE PRECIO TOTAL
    Double PrecioTotal= 0.0;
    
    //LISTA QUE CONTIENE TODOS LOS CODIGOS DE LOS PRODUCTOS;
    List<ProductoVenta> ProductosVenta = new ArrayList<ProductoVenta>();
    
    
    //NUMERO DE FILAS-AUMENTA CON CADA PRODUCTO AGREGADO A LA TABLA
    int numFilas=0;
    
    public Venta() {
        initComponents();
        
        //ESCUCHAMOS LOS CAMBIOS EN EL INPUT
        //setJTexFieldChanged(InputCodigo);
        
        //OCULTAMOS PANEL VENTA LA PRIMERA VEZ QUE SE EJECUTA LA VENTA
        PanelConfirmarCompra.setVisible(false);
        
        
        
        
        //ASIGNAMOS EL MODELO A LA TABLA
        modelo1 = new DefaultTableModel(null,titulosTabla);
        TableProducts.setModel(modelo1);
        
        
        //Busqueda Producto
        TableProducts.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,17));
        TableProducts.getTableHeader().setOpaque(false);
        TableProducts.getTableHeader().setBackground(new Color(57,162,219));
        TableProducts.getTableHeader().setForeground(new Color(255,255,255));
        TableProducts.setRowHeight(25);
        
        
        //ALINEAR CONTENIDO DE TABLA AL CENTRO
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        TableProducts.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        TableProducts.getColumnModel().getColumn(1).setCellRenderer(Alinear);
        TableProducts.getColumnModel().getColumn(2).setCellRenderer(Alinear);
        TableProducts.getColumnModel().getColumn(3).setCellRenderer(Alinear);
       
        
    }
    
    public boolean Validaciones(){
        //VALIDACIONES CÓDIGO
        Codigo = InputCodigo.getText();
        if(Codigo.replaceAll("^0+", "").equals("")){//No acepta 0000000
            //NO SE MUESTRAN ALERTAS PORQUE CADA VEZ QUE INGRESE UNA LETRA SE MUESTRAN
            //JOptionPane.showMessageDialog(this, "Ingrese un valor diferente de 0 en código","CÓDIGO DEL PRODUCTO",JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(Codigo.length()<= 7 || Codigo.length()>23){//Codigo solo acepta de 8 a 23 digitos
            //NO SE MUESTRAN ALERTAS PORQUE CADA VEZ QUE INGRESE UNA LETRA SE MUESTRAN
            //JOptionPane.showMessageDialog(this, "El código solo acepta de 8 a 23 digitos","CÓDIGO DEL PRODUCTO",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
       //Paso validaciones
        
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

        Venta = new javax.swing.JPanel();
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
        BtnExit = new javax.swing.JLabel();
        LabelCodigo = new javax.swing.JLabel();
        InputCodigo = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProducts = new javax.swing.JTable();
        PanelEditAndDelete = new javax.swing.JPanel();
        BtnSearch = new javax.swing.JLabel();
        LabelContadorTotal = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PanelConfirmarCompra = new javax.swing.JPanel();
        BtnConfirmarCompra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Venta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        btn_venta.setBackground(new java.awt.Color(57, 162, 219));
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

        btn_lista.setBackground(new java.awt.Color(162, 219, 250));
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

        Venta.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 540));

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

        BtnExit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnExit.setText("X");
        BtnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnExitMouseExited(evt);
            }
        });
        PanelBtnClose.add(BtnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        Header.add(PanelBtnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 40, 40));

        Main.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(-270, 0, 970, 40));

        LabelCodigo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelCodigo.setText("Código de producto:");
        Main.add(LabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        InputCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        InputCodigo.setForeground(new java.awt.Color(51, 51, 51));
        InputCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        InputCodigo.setBorder(null);
        InputCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                InputCodigoMousePressed(evt);
            }
        });
        InputCodigo.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                InputCodigoCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                InputCodigoInputMethodTextChanged(evt);
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
        Main.add(InputCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 300, 40));

        jSeparator4.setForeground(new java.awt.Color(67, 67, 67));
        Main.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 320, 20));

        TableProducts.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Cantidad", "Importe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableProducts);
        if (TableProducts.getColumnModel().getColumnCount() > 0) {
            TableProducts.getColumnModel().getColumn(1).setResizable(false);
            TableProducts.getColumnModel().getColumn(2).setResizable(false);
            TableProducts.getColumnModel().getColumn(3).setResizable(false);
        }

        Main.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 640, 310));

        PanelEditAndDelete.setBackground(new java.awt.Color(255, 255, 255));
        PanelEditAndDelete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/punto_de_venta/images/BtnSearch.png"))); // NOI18N
        BtnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSearchMouseClicked(evt);
            }
        });
        PanelEditAndDelete.add(BtnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main.add(PanelEditAndDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 50, 50));

        LabelContadorTotal.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        LabelContadorTotal.setText("0.00");
        Main.add(LabelContadorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 170, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel8.setText(" Total: ");
        Main.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        PanelConfirmarCompra.setBackground(new java.awt.Color(57, 162, 219));
        PanelConfirmarCompra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnConfirmarCompra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnConfirmarCompra.setForeground(new java.awt.Color(255, 255, 255));
        BtnConfirmarCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnConfirmarCompra.setText("CONFIRMAR COMPRA");
        BtnConfirmarCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnConfirmarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnConfirmarCompraMouseClicked(evt);
            }
        });
        PanelConfirmarCompra.add(BtnConfirmarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 50));

        Main.add(PanelConfirmarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 190, 50));

        Venta.add(Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 700, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Venta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Venta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregarMouseEntered
        btn_agregar.setBackground(AzulHover);
    }//GEN-LAST:event_btn_agregarMouseEntered

    private void btn_agregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregarMouseExited
        btn_agregar.setBackground(Azul);
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
        ListaProductos Lista = new ListaProductos();
        Lista.setLocationRelativeTo(null);
        Lista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_ventaMousePressed

    private void btn_listaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_listaMouseEntered
       
    }//GEN-LAST:event_btn_listaMouseEntered

    private void btn_listaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_listaMouseExited
        
    }//GEN-LAST:event_btn_listaMouseExited

    private void btn_listaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_listaMousePressed
        ListaProductos Lista = new ListaProductos();
        Lista.setLocationRelativeTo(null);
        Lista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_listaMousePressed

    private void HeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMouseDragged
        //Mueve ventana
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x-xMouse,y -yMouse);
    }//GEN-LAST:event_HeaderMouseDragged

    private void HeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_HeaderMousePressed

    private void InputCodigoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputCodigoMousePressed

    }//GEN-LAST:event_InputCodigoMousePressed

    private void InputCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputCodigoActionPerformed

    private void InputCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputCodigoKeyTyped
        int key = evt.getKeyChar();
        
        
        boolean numeros = (key >= 48 && key <= 57);
        if (!numeros){
            evt.consume();
        };
        if (InputCodigo.getText().trim().length() == 23) {
            evt.consume();
        };        
        
    }//GEN-LAST:event_InputCodigoKeyTyped

    private void InputCodigoCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_InputCodigoCaretPositionChanged
        System.out.println("Caret");
    }//GEN-LAST:event_InputCodigoCaretPositionChanged

    private void InputCodigoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_InputCodigoInputMethodTextChanged
        System.out.println("TextChanged");
    }//GEN-LAST:event_InputCodigoInputMethodTextChanged

    private void BtnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSearchMouseClicked
        // BUSUQEDA
        codigIsValid = Validaciones();
            if(codigIsValid){
                buscarProducto();//PRODUCTO EXISTE- VARIABLE productExist ahora es true, ve a el insert metodo warn para ejecutar algo
            };
            if(existsProduc){//PRODUCTO EXISTE
                
                //RESETEAMOS INPUT CODIGO
                InputCodigo.setText("");
                existsProduc=false;
            }
    }//GEN-LAST:event_BtnSearchMouseClicked

    private void BtnConfirmarCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnConfirmarCompraMouseClicked
        //IMPRIME VALORES DE LISTA CON PRODUCTOS
        JOptionPane.showMessageDialog(this,"COMPRA EXITOSA","COMPRA EXITOSA",JOptionPane.INFORMATION_MESSAGE);

        
        //SENTENCIAS DE ACTUALIZACION EN SQL
        List<String> ListaCodigosProd = new ArrayList<String>();
        List<Integer> NuevoStock = new ArrayList<Integer>();
        List<String> ListaNombresProd = new ArrayList<String>();
        
        for(int q = 0; q<ProductosVenta.size();q++){
            
            ListaCodigosProd.add(ProductosVenta.get(q).getCodigo());
            NuevoStock.add(ProductosVenta.get(q).getStock() - ProductosVenta.get(q).getCantidad());
            ListaNombresProd.add(ProductosVenta.get(q).getNombre());
        };
        
        //RESTA DE STOCK - UNIDADES PARA OBTENER UNIDADES RESTANTES
        for(int e = 0; e<ListaCodigosProd.size();e++){
            if(NuevoStock.get(e)<=1){
                System.out.println("SE HAN VENDIDO LA ULTIMA UNIDAD DE: "+ListaNombresProd.get(e));
                
                //ACTUALIZAR STOCK PRODUCTO A 1
                try {//REALIZA CONSULTA
                    //SQL SI YA NO HAY PRODUCTO ASIGNA POR DEFECTO 1 A STOCK, SI LO QUIERES ELIMINAR DEL SISTEMA SOLO CAMBIA POR DELETE
                    String strSentenciaActualizar = String.format("UPDATE Productos SET Stock='1' WHERE Codigo='%s'", ListaCodigosProd.get(e));
                    objConexion.ejecutarSentenciaSQL(strSentenciaActualizar);
                    
                }catch (Exception MiError) {//ERROR AL EJECUTAR CONSULTA GET
                    System.out.println(MiError);
                };
            }else{
                System.out.println("Restan "+NuevoStock.get(e)+"del producto "+ListaNombresProd.get(e));
                try {//REALIZA CONSULTA
                    //SQL SI YA NO HAY PRODUCTO ASIGNA POR DEFECTO 1 A STOCK, SI LO QUIERES ELIMINAR DEL SISTEMA SOLO CAMBIA POR DELETE
                    String strSentenciaActualizar = String.format("UPDATE Productos SET Stock='%s' WHERE Codigo='%s'",NuevoStock.get(e), ListaCodigosProd.get(e));
                    objConexion.ejecutarSentenciaSQL(strSentenciaActualizar);
                    
                }catch (Exception MiError) {//ERROR AL EJECUTAR CONSULTA GET
                    System.out.println(MiError);
                };
            }
            
        }
        
        
        
        
        //RESETEANDO VALORES
        modelo1.setRowCount(0);
        
        ProductosVenta.clear();
        
        PrecioTotal=0.0;
        LabelContadorTotal.setText("$"+String.valueOf(PrecioTotal));
        numFilas=0;
        
        
        
        PanelConfirmarCompra.setVisible(false);
    }//GEN-LAST:event_BtnConfirmarCompraMouseClicked

    private void BtnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnExitMouseClicked
        int option = JOptionPane.showConfirmDialog(this, "¿Esta seguro de cerrar el sistema?");
        if(option==0){
            System.exit(0);
        }
    }//GEN-LAST:event_BtnExitMouseClicked

    private void BtnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnExitMouseEntered
        //Hover exit
        PanelBtnClose.setBackground(new Color(240,84,84));
        BtnExit.setForeground(Color.WHITE);
    }//GEN-LAST:event_BtnExitMouseEntered

    private void BtnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnExitMouseExited
       PanelBtnClose.setBackground(Color.WHITE);
        BtnExit.setForeground(Color.BLACK);
    }//GEN-LAST:event_BtnExitMouseExited

    //MÉTODO PARA EVENTO EN INPUT - CODIGO NO FUNCIONA
    private void setJTexFieldChanged(JTextField txt)
    {
        documentListener = new DocumentListener() {
 
            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                println(documentEvent);
            };
            
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                println(documentEvent);
                
            };   
 
            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                println(documentEvent);
                
            };
            
            /*SwingUtilities.invokeLater(new Runnable(){
                public void run(){
                    jTextField2.setText("");
                }
            });*/


            
        };
        
        txt.getDocument().addDocumentListener(documentListener);
    }
    
    
    //METODO IMPRIME EL TEXTO ESCRITO EN EL INPUT- CODIGO NO FUNCIONA
    private void println(DocumentEvent documentEvent) {
        DocumentEvent.EventType type = documentEvent.getType();
 
        if (type.equals(DocumentEvent.EventType.CHANGE))
        {
            System.out.println("EVENTO CHANGE: "+InputCodigo.getText());
        }
        else if (type.equals(DocumentEvent.EventType.INSERT))
        {
            //CADA QUE AGREGE UN CARACTER
            codigIsValid = Validaciones();
            if(codigIsValid){
                buscarProducto();//PRODUCTO EXISTE- VARIABLE productExist ahora es true, ve a el insert metodo warn para ejecutar algo
            };
            if(existsProduc){
                //InputCodigo.addKey
            }
            System.out.println("EVENTO INSERT: "+InputCodigo.getText());
            
        }
        else if (type.equals(DocumentEvent.EventType.REMOVE))
        {
            //CADA QUE ELIMINE UN CARACTER
            System.out.println("EVENTO REMOVE: "+InputCodigo.getText());
        }
    }

    
    public void buscarProducto(){
        int i=0;//CONTADOR POR SI NO HAY NINGUN RESULTADO
        
        try {//REALIZA CONSULTA
                String Consulta = String.format("SELECT * FROM Productos WHERE Codigo='%s'",InputCodigo.getText());
                ResultSet resProduct = objConexion.consultarRegistros(Consulta);
                
                while (resProduct.next()){//IMPRIME CADA CAMPO DEL REGISTRO

                    //GUARDAMOS LOS DATOS DE LA CONSULTA POR SI SE QUIERE EDITAR O BORRAR EL OBJ
                    oRegistro.setCodigo(resProduct.getString("Codigo"));//GUARDAMOS CÓDIGO;
                    oRegistro.setNombre(resProduct.getString("Nombre"));//GUARDAMOS NOMBRE;
                    double Precio =Double.parseDouble(resProduct.getString("Precio"));
                    oRegistro.setPrecio(Precio);//GUARDAMOS PRECIO
                    int Stock = Integer.parseInt(resProduct.getString("Stock"));
                    oRegistro.setStock(Stock);//GUARDAMOS STOCK                 
                    
                    //EL PRECIO LO SUMAMOS AL TOTAL DE LA COMPRA
                    PrecioTotal +=Precio;
                    PrecioTotal = Math.round(PrecioTotal*100)/100.0;//REDONDEO DE 2 DECIMALES
                    //MANDAMOS VALOR A VISTA
                    LabelContadorTotal.setText("$"+String.valueOf(PrecioTotal));
                    
                    //ACTIVAMOS EL BTNCONFIRMARCOMPRA
                    if(!PanelConfirmarCompra.isVisible()){
                        PanelConfirmarCompra.setVisible(true);
                    };
                    
                    //------------------------------------------
                    //CODIGO EVITA REPETIR PRODUCTOS EN TABLA
                    //------------------------------------------
                    ProductoVenta NuevoProducto2 = new ProductoVenta();
                    NuevoProducto2.setCodigo(resProduct.getString("Codigo"));
                    NuevoProducto2.setNombre(resProduct.getString("Nombre"));
                    NuevoProducto2.setCantidad(1);//1 POR DEFECTO
                    NuevoProducto2.setNumFilaEnTabla(numFilas);//NUMERO DE FILAS
                    NuevoProducto2.setStock(Stock);
                    NuevoProducto2.setPrecio(Precio);
                    
                    
                    List<String> ListaCodigos = new ArrayList<String>();
                    int indiceCodigo =  0;
                    for(ProductoVenta el:ProductosVenta ){
                        ListaCodigos.add(el.getCodigo());  
                    };
      
                    if(ListaCodigos.contains(NuevoProducto2.getCodigo())){
                        //System.out.println("Codigo repetido");
                        for(int j =0;j<ListaCodigos.size();j++){
                            if(ListaCodigos.get(j).equals(NuevoProducto2.getCodigo())){
                                indiceCodigo=j;
                                break;
                            };
                        };
                        
                        
                        int NuevoCantidad = ProductosVenta.get(indiceCodigo).getCantidad()+1;
                        ProductosVenta.get(indiceCodigo).setCantidad(NuevoCantidad);
                        
                        
                        Object[] OProductos = {resProduct.getString("Nombre"),"x1",resProduct.getString("Precio")};
                
                        //SUMAMOS 1 UNIDAD A LA CANTIDAD
                        int NumeroFila = ProductosVenta.get(indiceCodigo).getNumFilaEnTabla();
                        modelo1.setValueAt("x"+NuevoCantidad,NumeroFila, 1);
                        
                        //MULTIPLICAMOS EL PRECIO UNITARIO POR LAS UNIDADES DEL PRODUCTO
                        Double NuevoPrecio = ProductosVenta.get(indiceCodigo).getPrecio() * NuevoCantidad;
                        modelo1.setValueAt(NuevoPrecio,NumeroFila,3);
                        
                    }else{
                        
                        Object[] OProductos = {resProduct.getString("Nombre"),"x1",resProduct.getString("Precio"),resProduct.getString("Precio")};
                
                        //AÑADE UNA FILA CON LOS DATOS DEL PRODUCTO
                        modelo1.addRow(OProductos);
                        
                        //AUMENTAMOS EL NUMERO DE FILA PARA LA SIGUIENTE BUSQUEDA
                        numFilas++;
                        
                        
                        ProductosVenta.add(NuevoProducto2);//AÑADIMOS EL PRODUCTO A LA LISTA
                    };
                    
                    
                    
                    //------------------------------------------
                    //TERMINA CODIGO EVITA REPETIR PRODUCTOS EN TABLA
                    //------------------------------------------

                    //MARCAMOS QUE PRODUCTO SI EXISTE
                    existsProduc = true;
                    
                    //RESETEAMOS INPUT
                    //System.out.println("PRODUCTO AGREGADO A TABLA CORRECTAMENTE");
                    
                    
                    
                };
                
                
                //System.out.println(modelo1.getValueAt(0, 0));
                //System.out.println(modelo1.getValueAt(0, 1));
                //System.out.println(modelo1.getValueAt(0, 2));
                //modelo1.setValueAt("VALOR DEFECTO", 0,0);
                //modelo1.setValueAt(0.0,0, 1);
                //modelo1.setValueAt("x20",0, 2);
                
            } catch (Exception e) {//ERROR AL EJECUTAR CONSULTA GET
                System.out.println(e);
            }
    }
    

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Venta VistaVenta = new  Venta();
                VistaVenta.setVisible(true);
                VistaVenta.setVisible(true);
                VistaVenta.setLocationRelativeTo(null);
                
            };
            
        });
        
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnConfirmarCompra;
    private javax.swing.JLabel BtnExit;
    private javax.swing.JLabel BtnSearch;
    private javax.swing.JPanel Header;
    private javax.swing.JTextField InputCodigo;
    private javax.swing.JLabel LabelCodigo;
    private javax.swing.JLabel LabelContadorTotal;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel PanelBtnClose;
    private javax.swing.JPanel PanelConfirmarCompra;
    private javax.swing.JPanel PanelEditAndDelete;
    private javax.swing.JTable TableProducts;
    private javax.swing.JLabel Titulo;
    private javax.swing.JPanel Venta;
    private javax.swing.JPanel btn_agregar;
    private javax.swing.JPanel btn_lista;
    private javax.swing.JPanel btn_venta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
