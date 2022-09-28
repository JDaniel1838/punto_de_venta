/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto_de_venta.productosGUI;

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import punto_de_venta.productosBL.productosBL;
import punto_de_venta.productosDAL.Conexion;

/**
 *
 * @author Daniel
 */
public class EditarProducto extends javax.swing.JFrame {

    int xMouse,yMouse;
    //Colores 
    Color Azul = new Color (57,162,219);
    Color AzulHover = new Color(162,219,250);
    Color Gris = new Color(204,204,204);
    
    String[] Numeros =new String[] {"0", "1", "2","3","4","5","6","7","8","9","."};
    
    
    //Valores por defecto de inputs
    String defaultName = "Nombre del producto",
           defaultPrecio = "Precio del producto",
           defaultCodigo = "0000000000000",
           defaultStock = "00000";
    
    //Valores de los inputs para validar
    String Nombre,PrecioTxt, Caducidad, Codigo, StockTxt;
    double Precio;
    int Stock;
    
    //Booleans para validaciones en SQL
    boolean isValid, isExists;
    
    
    public EditarProducto(String CodigoProducto, String NombreProducto, double PrecioProducto, int StockProducto ) {
        initComponents();
        
        //Obtener los datos del producto a Editar 
        InputCodigo.setText(CodigoProducto);
        InputCodigo.setForeground(Gris);
        TitleForm.setText(NombreProducto);
        InputName.setText(NombreProducto);
        InputName.setForeground(Color.black);
        InputPrecio.setText(String.valueOf(PrecioProducto));
        InputPrecio.setForeground(Color.black);
        InputStock.setText(String.valueOf(StockProducto));
        InputStock.setForeground(Color.black);
            
            
    }
    
    private  boolean Validaciones(){
        System.out.println("Validando");
        
        //Validaciones Nombre
        Nombre = InputName.getText();
        if(Nombre.length()<= 1 ){
            JOptionPane.showMessageDialog(this, "El nombre necesita al menos 2 caracteres","NOMBRE DEL PRODUCTO",JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(Nombre.trim().equals("") || Nombre.equals(defaultName)){
            JOptionPane.showMessageDialog(this, "Ingrese un nombre valido","NOMBRE DEL PRODUCTO",JOptionPane.WARNING_MESSAGE);
            InputName.setText("");
            return false;
        };
        
        //VALIDACIONES PRECIO
        PrecioTxt = InputPrecio.getText();
        if(PrecioTxt.equals(defaultPrecio)){//No acepta el texto por defecto
            JOptionPane.showMessageDialog(this, "Ingrese un precio valido","PRECIO DEL PRODUCTO",JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(PrecioTxt.replaceAll("^0+", "").equals("")){//No acepta 0000000
            JOptionPane.showMessageDialog(this, "Ingrese un valor diferente de 0 en precio", "PRECIO DEL PRODUCTO",JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(!PrecioTxt.matches("[+-]?\\d*(\\.\\d+)?")){//Solo acepta numeros
            JOptionPane.showMessageDialog(this, "El valor ingresado en precio no es un número, verifiquelo por favor", "PRECIO DEL PRODUCTO",JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(PrecioTxt.substring(0, 1).equals(".")){//Sin puntos decimales 
            JOptionPane.showMessageDialog(this, "No puede colocar un punto decimal al inicio en precio","PRECIO DEL PRODUCTO",JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(!(Double.parseDouble(PrecioTxt) >= 0.5 && Double.parseDouble(PrecioTxt)<= 1000000.0)){//Minimo .5 Maximo 1,000,000
            JOptionPane.showMessageDialog(this, "Solo puede ingresar valores entre $0.5 y 1,000,000 en precio","PRECIO DEL PRODUCTO",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        
        //VALIDACIONES CÓDIGO
        Codigo = InputCodigo.getText();
        if(Codigo.equals(defaultCodigo)){//No acepta el texto por defecto
            JOptionPane.showMessageDialog(this, "Ingrese un código valido","CÓDIGO DEL PRODUCTO",JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(Codigo.replaceAll("^0+", "").equals("")){//No acepta 0000000
            JOptionPane.showMessageDialog(this, "Ingrese un valor diferente de 0 en código","CÓDIGO DEL PRODUCTO",JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(Codigo.length()<= 7 || Codigo.length()>23){//Codigo solo acepta de 8 a 23 digitos
            JOptionPane.showMessageDialog(this, "El código solo acepta de 8 a 23 digitos","CÓDIGO DEL PRODUCTO",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        //VALIDACIONES STOCK
        StockTxt = InputStock.getText();
        Stock = Integer.parseInt(InputStock.getText());
        if(StockTxt.equals(defaultStock)){//No acepta el texto por defecto
            JOptionPane.showMessageDialog(this, "Ingrese un numero en stock", "STOCK DEL PRODUCTO",JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(StockTxt.replaceAll("^0+", "").equals("")){//No acepta 0000000
            JOptionPane.showMessageDialog(this, "Ingrese un valor diferente de 0 en Stock", "STOCK DEL PRODUCTO", JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(!StockTxt.matches("[+-]?\\d*(\\.\\d+)?")){//Solo acepta numeros
            JOptionPane.showMessageDialog(this, "El valor ingresado en stock no es un número, verifiquelo por favor","STOCK DEL PRODUCTO", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(!(Stock >= 1 && Stock<= 10000)){//Minimo .5 Maximo 1,000,000
            JOptionPane.showMessageDialog(this, "Solo puede ingresar valores entre 1 y 10,000 en stock", "STOCK DEL PRODUCTO", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        //Paso validaciones
        System.out.print("Pasaron valicaciones");
        return true;

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        PanelBg = new javax.swing.JPanel();
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
        Form = new javax.swing.JPanel();
        TitleForm = new javax.swing.JLabel();
        PanelName = new javax.swing.JPanel();
        Name = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        InputName = new javax.swing.JTextField();
        PanelPrecio = new javax.swing.JPanel();
        Name1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        InputPrecio = new javax.swing.JTextField();
        PanelCodigo = new javax.swing.JPanel();
        Name3 = new javax.swing.JLabel();
        InputCodigo = new javax.swing.JTextField();
        PanelStock = new javax.swing.JPanel();
        Name4 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        InputStock = new javax.swing.JTextField();
        PanelBtn = new javax.swing.JPanel();
        BtnAgregar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        PanelBtnClose = new javax.swing.JPanel();
        BtnClose = new javax.swing.JLabel();

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        PanelBg.setBackground(new java.awt.Color(255, 255, 255));
        PanelBg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelBg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        PanelBg.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 540));

        Form.setBackground(new java.awt.Color(255, 255, 255));
        Form.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleForm.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        TitleForm.setForeground(new java.awt.Color(67, 67, 67));
        TitleForm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleForm.setText("Editar Producto");
        Form.add(TitleForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 50, 630, -1));

        PanelName.setBackground(new java.awt.Color(255, 255, 255));
        PanelName.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Name.setForeground(new java.awt.Color(67, 67, 67));
        Name.setText("Nombre:");
        PanelName.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(67, 67, 67));
        PanelName.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 270, 20));

        InputName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        InputName.setForeground(new java.awt.Color(204, 204, 204));
        InputName.setText("Nombre del producto");
        InputName.setBorder(null);
        InputName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                InputNameMousePressed(evt);
            }
        });
        InputName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputNameActionPerformed(evt);
            }
        });
        InputName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                InputNameKeyTyped(evt);
            }
        });
        PanelName.add(InputName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 270, 40));

        Form.add(PanelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 398, -1));

        PanelPrecio.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrecio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Name1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Name1.setForeground(new java.awt.Color(67, 67, 67));
        Name1.setText("Precio:");
        PanelPrecio.add(Name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(67, 67, 67));
        PanelPrecio.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 230, 20));

        InputPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        InputPrecio.setForeground(new java.awt.Color(204, 204, 204));
        InputPrecio.setText("Precio del producto");
        InputPrecio.setBorder(null);
        InputPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                InputPrecioMousePressed(evt);
            }
        });
        InputPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputPrecioActionPerformed(evt);
            }
        });
        InputPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                InputPrecioKeyTyped(evt);
            }
        });
        PanelPrecio.add(InputPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 220, 40));

        Form.add(PanelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 330, -1));

        PanelCodigo.setBackground(new java.awt.Color(255, 255, 255));
        PanelCodigo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Name3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Name3.setForeground(new java.awt.Color(67, 67, 67));
        Name3.setText("Código:");
        PanelCodigo.add(Name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        InputCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        InputCodigo.setForeground(new java.awt.Color(204, 204, 204));
        InputCodigo.setText("0000000000000");
        InputCodigo.setBorder(null);
        InputCodigo.setEnabled(false);
        InputCodigo.setFocusable(false);
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
        PanelCodigo.add(InputCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 210, 40));

        Form.add(PanelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        PanelStock.setBackground(new java.awt.Color(255, 255, 255));
        PanelStock.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Name4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Name4.setForeground(new java.awt.Color(67, 67, 67));
        Name4.setText("Stock:");
        PanelStock.add(Name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(67, 67, 67));
        PanelStock.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 110, 20));

        InputStock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        InputStock.setForeground(new java.awt.Color(204, 204, 204));
        InputStock.setText("00000");
        InputStock.setBorder(null);
        InputStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                InputStockMousePressed(evt);
            }
        });
        InputStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputStockActionPerformed(evt);
            }
        });
        InputStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                InputStockKeyTyped(evt);
            }
        });
        PanelStock.add(InputStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 110, 40));

        Form.add(PanelStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        PanelBtn.setBackground(new java.awt.Color(57, 162, 219));
        PanelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelBtn.setEnabled(false);
        PanelBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnAgregar.setText("ACTUALIZAR");
        BtnAgregar.setToolTipText("");
        BtnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAgregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnAgregarMouseExited(evt);
            }
        });
        PanelBtn.add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        Form.add(PanelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 130, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/punto_de_venta/images/Frutitas.png"))); // NOI18N
        Form.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, -1));

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

        Form.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(-270, 0, 960, 40));

        PanelBg.add(Form, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 690, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ventaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ventaMouseEntered
        btn_venta.setBackground(AzulHover);
    }//GEN-LAST:event_btn_ventaMouseEntered

    private void btn_ventaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ventaMouseExited
       btn_venta.setBackground(Azul);
    }//GEN-LAST:event_btn_ventaMouseExited

    private void btn_ventaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ventaMousePressed
        //ERROR btn_venta REDIRECCIONA A LISTAPRODUCTOS 
        int option = JOptionPane.showConfirmDialog(this, "¿Está seguro de cambiar de ventana?\nLos cambios de este producto se perderan");
        if(option==0){
            ListaProductos Lista = new ListaProductos();
            Lista.setLocationRelativeTo(null);
            Lista.setVisible(true);
            this.dispose();
        }
        
        
    }//GEN-LAST:event_btn_ventaMousePressed

    private void btn_agregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregarMouseEntered
        // TODO add your handling code here:
        
        btn_agregar.setBackground(AzulHover);
    }//GEN-LAST:event_btn_agregarMouseEntered

    private void btn_agregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregarMouseExited
        btn_agregar.setBackground(Azul);
    }//GEN-LAST:event_btn_agregarMouseExited

    private void btn_agregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregarMousePressed
        int option = JOptionPane.showConfirmDialog(this, "¿Está seguro de cambiar de ventana?\nLos cambios de este producto se perderan");
        if(option==0){
            AgregarProductos Agregar = new AgregarProductos();
            Agregar.setLocationRelativeTo(null);
            Agregar.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_agregarMousePressed

    private void btn_listaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_listaMouseEntered
        btn_lista.setBackground(AzulHover);
    }//GEN-LAST:event_btn_listaMouseEntered

    private void btn_listaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_listaMouseExited
        btn_lista.setBackground(Azul);
    }//GEN-LAST:event_btn_listaMouseExited

    private void btn_listaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_listaMousePressed
        int option = JOptionPane.showConfirmDialog(this, "¿Está seguro de cambiar de  ventana?\nLos cambios de este producto se perderan");
        if(option==0){
            Venta MiVenta = new Venta();
            MiVenta.setLocationRelativeTo(null);
            MiVenta.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_btn_listaMousePressed

    private void InputCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputCodigoActionPerformed

    private void InputCodigoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputCodigoMousePressed
        if(InputCodigo.getText().equals(defaultCodigo)){
            InputCodigo.setText("");
            InputCodigo.setForeground(Color.BLACK);
        };
        if(InputName.getText().isEmpty()){
            InputName.setText(defaultName);
            InputName.setForeground(Gris);
        };
        if(InputPrecio.getText().isEmpty()){
            InputPrecio.setText(defaultPrecio);
            InputPrecio.setForeground(Gris);
        };
        
        if(InputStock.getText().isEmpty()){
            InputStock.setText(defaultStock);
            InputStock.setForeground(Gris);
        };
    }//GEN-LAST:event_InputCodigoMousePressed

    private void InputPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputPrecioActionPerformed

    private void InputPrecioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputPrecioMousePressed
        if(InputPrecio.getText().equals(defaultPrecio)){
            InputPrecio.setText("");
            InputPrecio.setForeground(Color.BLACK);
        };
        if(InputName.getText().isEmpty()){
            InputName.setText(defaultName);
            InputName.setForeground(Gris);
        };
        
        if(InputCodigo.getText().isEmpty()){
            InputCodigo.setText(defaultCodigo);
            InputCodigo.setForeground(Gris);
        };
        if(InputStock.getText().isEmpty()){
            InputStock.setText(defaultStock);
            InputStock.setForeground(Gris);
        };
        
    }//GEN-LAST:event_InputPrecioMousePressed

    private void InputNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputNameActionPerformed
        
    }//GEN-LAST:event_InputNameActionPerformed

    private void InputNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputNameMousePressed
        if(InputName.getText().equals(defaultName)){
            InputName.setText("");
            InputName.setForeground(Color.BLACK);
        };
        if(InputPrecio.getText().isEmpty()){
            InputPrecio.setText(defaultPrecio);
            InputPrecio.setForeground(Gris);
        };
        
        if(InputCodigo.getText().isEmpty()){
            InputCodigo.setText(defaultCodigo);
            InputCodigo.setForeground(Gris);
        };
        if(InputStock.getText().isEmpty()){
            InputStock.setText(defaultStock);
            InputStock.setForeground(Gris);
        };
        
    }//GEN-LAST:event_InputNameMousePressed

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

    private void BtnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCloseMouseClicked
        int option = JOptionPane.showConfirmDialog(this, "¿Esta seguro de cerrar el sistema?");
        if(option==0){
            System.exit(0);
        }
    }//GEN-LAST:event_BtnCloseMouseClicked

    private void BtnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCloseMouseEntered
        //Hover exit
        PanelBtnClose.setBackground(new Color(240,84,84));
        BtnClose.setForeground(Color.WHITE);
    }//GEN-LAST:event_BtnCloseMouseEntered

    private void BtnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCloseMouseExited
        PanelBtnClose.setBackground(Color.WHITE);
        BtnClose.setForeground(Color.BLACK);
    }//GEN-LAST:event_BtnCloseMouseExited

    private void BtnAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAgregarMouseEntered
        //Hover Btn Agregar
        PanelBtn.setBackground(Color.WHITE);
        PanelBtn.setBorder(BorderFactory.createLineBorder(Azul));
        BtnAgregar.setForeground(Azul);
    }//GEN-LAST:event_BtnAgregarMouseEntered

    private void BtnAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAgregarMouseExited
        PanelBtn.setBackground(Azul);
        PanelBtn.setBorder(BorderFactory.createLineBorder(Azul));
        BtnAgregar.setForeground(Color.WHITE);
        
    }//GEN-LAST:event_BtnAgregarMouseExited

    private void BtnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAgregarMouseClicked
        //Btn Agregar 
        isValid = Validaciones();//Hace validaciones
        
        //Datos pasaron las valicadiones();
        if(isValid){
            Conexion objConexion = new Conexion();//ESTABLECE CONEXIÓN
            productosBL oRegistro = recuperarDatosGUI();//RECUPERA DATOS DE UI
            
            
            //VALIDACION EL CODIGO DEL PRODUCTO YA EXISTE EN LA BASE DE DATOS
            try {
                String strSentenciaActualizar = String.format("UPDATE Productos SET Nombre='%s', Precio='%s', Stock='%d' WHERE Codigo='%s'",oRegistro.getNombre(),oRegistro.getPrecio(), oRegistro.getStock(),oRegistro.getCodigo());
                objConexion.ejecutarSentenciaSQL(strSentenciaActualizar);
                JOptionPane.showMessageDialog(this, "Datos del producto actualizados","DATOS ACTUALIZADOS", JOptionPane.INFORMATION_MESSAGE);
                
                
                ListaProductos Lista = new ListaProductos();//CAMBIA DE VENTANA A LISTA DE PRODUCTOS 
                Lista.setLocationRelativeTo(null);
                Lista.setVisible(true);
                this.dispose();
                
                                
            } catch (Exception e) {//ERROR AL EJECUTAR CONSULTA GET
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado, por favor cierre el sistema y vuelva abrirlo.","ERROR AL ACTUALIZAR PRODUCTOS",JOptionPane.ERROR_MESSAGE);
            }

        }
        
        

    }//GEN-LAST:event_BtnAgregarMouseClicked

    private void InputStockMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputStockMousePressed
        if(InputStock.getText().equals(defaultStock)){
            InputStock.setText("");
            InputStock.setForeground(Color.BLACK);
        };
        
        if(InputName.getText().isEmpty()){
            InputName.setText(defaultName);
            InputName.setForeground(Gris);
        };
        if(InputPrecio.getText().isEmpty()){
            InputPrecio.setText(defaultPrecio);
            InputPrecio.setForeground(Gris);
        };
        
        if(InputCodigo.getText().isEmpty()){
            InputCodigo.setText(defaultCodigo);
            InputCodigo.setForeground(Gris);
        };
    }//GEN-LAST:event_InputStockMousePressed

    private void InputStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputStockActionPerformed

    private void InputPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputPrecioKeyTyped
        // Valida solo numeros y puntos, longitud menor a 8
        int key = evt.getKeyChar();
    
        boolean numeros = (key >= 48 && key <= 57) || key==46;
        if (!numeros){
            evt.consume();
        }
        if (InputPrecio.getText().trim().length() == 8) {
            evt.consume();
        }

    }//GEN-LAST:event_InputPrecioKeyTyped

    private void InputNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputNameKeyTyped
        // Nombres maximo de 45 
        if (InputName.getText().trim().length() == 45) {
            evt.consume();
        }
    }//GEN-LAST:event_InputNameKeyTyped

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

    private void InputStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputStockKeyTyped
        //Solo numeros y maximo 5, osea 10,000
        int key = evt.getKeyChar();
        boolean numeros = (key >= 48 && key <= 57);
        if (!numeros){
            evt.consume();
        }
        if (InputStock.getText().trim().length() == 5) {
            evt.consume();
        }
    }//GEN-LAST:event_InputStockKeyTyped

    public productosBL recuperarDatosGUI(){//RECOJE LOS DATOS DE LOS INPUT YA VALIDADOS
        productosBL oRegistro = new productosBL();

        //Codigo
        oRegistro.setCodigo(InputCodigo.getText());
        //Nombre
        oRegistro.setNombre(InputName.getText());
        //Precio
        double Precio = (InputPrecio.getText().isEmpty())?0: Double.parseDouble(InputPrecio.getText());
        oRegistro.setPrecio(Precio);
        //Stock
        int Stock = (InputStock.getText().isEmpty())?0: Integer.parseInt(InputStock.getText());
        oRegistro.setStock(Stock);
        
       
        return oRegistro;
    }
    
    public static void main(String args[]) {
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnAgregar;
    private javax.swing.JLabel BtnClose;
    private javax.swing.JPanel Form;
    private javax.swing.JPanel Header;
    private javax.swing.JTextField InputCodigo;
    private javax.swing.JTextField InputName;
    private javax.swing.JTextField InputPrecio;
    private javax.swing.JTextField InputStock;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Name1;
    private javax.swing.JLabel Name3;
    private javax.swing.JLabel Name4;
    private javax.swing.JPanel PanelBg;
    private javax.swing.JPanel PanelBtn;
    private javax.swing.JPanel PanelBtnClose;
    private javax.swing.JPanel PanelCodigo;
    private javax.swing.JPanel PanelName;
    private javax.swing.JPanel PanelPrecio;
    private javax.swing.JPanel PanelStock;
    private javax.swing.JLabel TitleForm;
    private javax.swing.JLabel Titulo;
    private javax.swing.JPanel btn_agregar;
    private javax.swing.JPanel btn_lista;
    private javax.swing.JPanel btn_venta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
