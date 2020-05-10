/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacen;

import alertas.ErrorAlert;
import alertas.SuccessAlert;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import librerias.RSTool;
import necesario.RSAWTUtilities;
import rojeru_san.complementos.RSMoveObject;
import rojeru_san.complementos.RSUtilities;

/**
 *
 * @author RojeruSan
 */
public class ModalRegistrar extends javax.swing.JDialog {

    private int id = 0;
    private ErrorAlert e = new ErrorAlert(new JFrame(), true);
    private SuccessAlert s = new SuccessAlert(new JFrame(), true);

    /**
     * Creates new form Producto
     */
    public ModalRegistrar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        addEventKey();
        initComponents();

        RSAWTUtilities.setOpaque(this, false);
        RSUtilities.setCentrarVentana(this);
        RSMoveObject.setMoverVentana(this);

        id = Operaciones.extraerIDMax();
        setLimpiar();
        Operaciones.getCategorias("registrar");
        setToolTip();
    }

    private void addEventKey() {
        KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }

    private void setLimpiar() {
        this.txtCodigo.requestFocus();
        this.txtCodigo.setNextFocusableComponent(this.txtDescripcion);
        this.txtDescripcion.setNextFocusableComponent(this.txtPrecio);
        this.txtPrecio.setNextFocusableComponent(this.txtPrecioVenta);
        this.txtPrecioVenta.setNextFocusableComponent(this.txtStockMin);
        this.txtStockMin.setNextFocusableComponent(this.txtExistencias);
        this.txtExistencias.setNextFocusableComponent(this.comboCantidades);
        this.comboCantidades.setNextFocusableComponent(this.txtUbicacion);

        this.txtCodigo.setText("");
        this.txtDescripcion.setText("");
        this.txtPrecio.setText("");
        this.txtPrecioVenta.setText("");
        this.txtStockMin.setText("");
        this.txtExistencias.setText("");
        this.comboCantidades.setSelectedIndex(0);
        this.comboCategorias.setSelectedIndex(0);
        this.txtUbicacion.setText("");

        Operaciones.setListar("");
        deshabilitarPegar();
    }

    private boolean isLlenado() {
        if (this.txtCodigo.getText().isEmpty()
                || this.txtDescripcion.getText().isEmpty()
                || this.txtPrecio.getText().isEmpty()
                || this.txtPrecioVenta.getText().isEmpty()) {

            return false;
        } else {
            return true;
        }
    }

    private void deshabilitarPegar() {
        InputMap map1 = this.txtCodigo.getInputMap(this.txtCodigo.WHEN_FOCUSED);
        map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

        InputMap map2 = this.txtPrecio.getInputMap(this.txtPrecio.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

        InputMap map3 = this.txtPrecioVenta.getInputMap(this.txtPrecioVenta.WHEN_FOCUSED);
        map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

        InputMap map4 = this.txtStockMin.getInputMap(this.txtStockMin.WHEN_FOCUSED);
        map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

        InputMap map5 = this.txtExistencias.getInputMap(this.txtExistencias.WHEN_FOCUSED);
        map5.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelShadow1 = new rojeru_san.rspanel.RSPanelShadow();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCerrar = new rojeru_san.RSButtonRiple();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboCantidades = new rojerusan.RSComboMetro();
        jLabel10 = new javax.swing.JLabel();
        comboCategorias = new rojerusan.RSComboMetro();
        jLabel11 = new javax.swing.JLabel();
        txtCodigo = new rojeru_san.rsfield.RSTextMaterial();
        txtDescripcion = new rojeru_san.rsfield.RSTextMaterial();
        txtPrecio = new rojeru_san.rsfield.RSTextMaterial();
        txtPrecioVenta = new rojeru_san.rsfield.RSTextMaterial();
        txtStockMin = new rojeru_san.rsfield.RSTextMaterial();
        txtExistencias = new rojeru_san.rsfield.RSTextMaterial();
        txtUbicacion = new rojeru_san.rsfield.RSTextMaterial();
        rSPanelImage1 = new rojeru_san.rspanel.RSPanelImage();
        checkUtiliza = new usuarios.RSCheckBox();
        btnRegistrar = new rojeru_san.RSButtonRiple();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(69, 87, 252));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRAR NUEVO PRODUCTO");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/btnProductos.png"))); // NOI18N

        btnCerrar.setBackground(new java.awt.Color(69, 87, 252));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login/btn-cerrar.png"))); // NOI18N
        btnCerrar.setColorHover(new java.awt.Color(69, 87, 252));
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/label-codBarras.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/label-precio-compra.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/label-precio-venta.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/label-stock-minimo.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/label-descripcion.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/label-existencias.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/label-piezas.png"))); // NOI18N

        comboCantidades.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Se venden en", "Kg", "Piezas", "Cajas", "Botes", "Litros", "Bultos", "Metros", "Pares" }));
        comboCantidades.setToolTipText("SE VENDEN EN");
        comboCantidades.setColorArrow(new java.awt.Color(69, 87, 252));
        comboCantidades.setColorBorde(new java.awt.Color(255, 255, 255));
        comboCantidades.setColorFondo(new java.awt.Color(69, 87, 252));
        comboCantidades.setColorSeleccion(new java.awt.Color(69, 87, 252));
        comboCantidades.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/label-ubicacion.png"))); // NOI18N

        comboCategorias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar categoría" }));
        comboCategorias.setToolTipText("Categoría");
        comboCategorias.setColorArrow(new java.awt.Color(69, 87, 252));
        comboCategorias.setColorBorde(new java.awt.Color(255, 255, 255));
        comboCategorias.setColorFondo(new java.awt.Color(69, 87, 252));
        comboCategorias.setColorSeleccion(new java.awt.Color(69, 87, 252));
        comboCategorias.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/label-categoria.png"))); // NOI18N

        txtCodigo.setForeground(new java.awt.Color(0, 0, 0));
        txtCodigo.setColorMaterial(new java.awt.Color(69, 87, 252));
        txtCodigo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtCodigo.setMayusculas(true);
        txtCodigo.setPlaceholder("Código de barras (*)");
        txtCodigo.setSelectionColor(new java.awt.Color(220, 23, 111));
        txtCodigo.setSoloNumeros(true);

        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setColorMaterial(new java.awt.Color(69, 87, 252));
        txtDescripcion.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtDescripcion.setPlaceholder("Descripción (*)");
        txtDescripcion.setSelectionColor(new java.awt.Color(220, 23, 111));

        txtPrecio.setForeground(new java.awt.Color(0, 0, 0));
        txtPrecio.setColorMaterial(new java.awt.Color(69, 87, 252));
        txtPrecio.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtPrecio.setMayusculas(true);
        txtPrecio.setPlaceholder("Precio compra $ (*)");
        txtPrecio.setSelectionColor(new java.awt.Color(220, 23, 111));
        txtPrecio.setSoloNumeros(true);

        txtPrecioVenta.setForeground(new java.awt.Color(0, 0, 0));
        txtPrecioVenta.setColorMaterial(new java.awt.Color(69, 87, 252));
        txtPrecioVenta.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtPrecioVenta.setMayusculas(true);
        txtPrecioVenta.setPlaceholder("Precio venta $ (*)");
        txtPrecioVenta.setSelectionColor(new java.awt.Color(220, 23, 111));
        txtPrecioVenta.setSoloNumeros(true);

        txtStockMin.setForeground(new java.awt.Color(0, 0, 0));
        txtStockMin.setColorMaterial(new java.awt.Color(69, 87, 252));
        txtStockMin.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtStockMin.setMayusculas(true);
        txtStockMin.setPlaceholder("Stock mínimo");
        txtStockMin.setSelectionColor(new java.awt.Color(220, 23, 111));
        txtStockMin.setSoloNumeros(true);

        txtExistencias.setForeground(new java.awt.Color(0, 0, 0));
        txtExistencias.setColorMaterial(new java.awt.Color(69, 87, 252));
        txtExistencias.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtExistencias.setMayusculas(true);
        txtExistencias.setPlaceholder("Existencias");
        txtExistencias.setSelectionColor(new java.awt.Color(220, 23, 111));
        txtExistencias.setSoloNumeros(true);

        txtUbicacion.setForeground(new java.awt.Color(0, 0, 0));
        txtUbicacion.setColorMaterial(new java.awt.Color(69, 87, 252));
        txtUbicacion.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtUbicacion.setPlaceholder("Ubicación");
        txtUbicacion.setSelectionColor(new java.awt.Color(220, 23, 111));

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/img/login/sombra.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        checkUtiliza.setForeground(new java.awt.Color(114, 114, 114));
        checkUtiliza.setSelected(true);
        checkUtiliza.setText("Este producto SI utiliza existencias para el inventario.");
        checkUtiliza.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        checkUtiliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkUtilizaActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(69, 87, 252));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/btn-registrar.png"))); // NOI18N
        btnRegistrar.setText("Registar");
        btnRegistrar.setColorHover(new java.awt.Color(173, 187, 194));
        btnRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(27, 27, 27)
                        .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkUtiliza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboCantidades, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtExistencias, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkUtiliza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtExistencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboCantidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(comboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 71, Short.MAX_VALUE)))
                .addContainerGap())
        );

        rSPanelShadow1.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rSPanelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (isLlenado()) {
            if (Operaciones.isExiste(this.txtCodigo.getText())) {

                e.msj1.setText("El código que intentas");
                e.msj2.setText("registrar ya éxiste.");
                e.msj3.setText("");
                e.setVisible(true);
            } else {
                if (Float.parseFloat(this.txtPrecioVenta.getText()) <= 0) {

                    e.msj1.setText("Algo salio mal. El precio de venta");
                    e.msj2.setText("no puede ser MENOR O IGUAL A CERO.");
                    e.msj3.setText("");
                    e.setVisible(true);
                } else {
                    if (isRegistrado()) {
                        setLimpiar();
                        Operaciones.selecionaFila(String.valueOf(this.id));
                        id = Operaciones.extraerIDMax();

                        s.msj1.setText("Nuevo producto dado de alta");
                        s.msj2.setText("con éxito.");
                        s.msj3.setText("");
                        s.setVisible(true);
                    } else {

                        e.msj1.setText("Algo salio mal. No fue posible");
                        e.msj2.setText("registrar el nuevo producto.");
                        e.msj3.setText("");
                        e.setVisible(true);
                    }
                }
            }
        } else {

            e.msj1.setText("Todos los campos marcados con (*)");
            e.msj2.setText("son requeridos.");
            e.msj3.setText("");
            e.setVisible(true);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void checkUtilizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkUtilizaActionPerformed
        if (!checkUtiliza.isSelected()) {
            txtExistencias.setEditable(false);
            txtStockMin.setEditable(false);

            txtExistencias.setText("");
            txtStockMin.setText("");
        } else {
            txtExistencias.setEditable(true);
            txtStockMin.setEditable(true);
        }
    }//GEN-LAST:event_checkUtilizaActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ModalRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModalRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModalRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModalRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModalRegistrar dialog = new ModalRegistrar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnCerrar;
    public static rojeru_san.RSButtonRiple btnRegistrar;
    private usuarios.RSCheckBox checkUtiliza;
    private rojerusan.RSComboMetro comboCantidades;
    public static rojerusan.RSComboMetro comboCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojeru_san.rspanel.RSPanelImage rSPanelImage1;
    private rojeru_san.rspanel.RSPanelShadow rSPanelShadow1;
    public static rojeru_san.rsfield.RSTextMaterial txtCodigo;
    public static rojeru_san.rsfield.RSTextMaterial txtDescripcion;
    public static rojeru_san.rsfield.RSTextMaterial txtExistencias;
    public static rojeru_san.rsfield.RSTextMaterial txtPrecio;
    public static rojeru_san.rsfield.RSTextMaterial txtPrecioVenta;
    public static rojeru_san.rsfield.RSTextMaterial txtStockMin;
    public static rojeru_san.rsfield.RSTextMaterial txtUbicacion;
    // End of variables declaration//GEN-END:variables

    private boolean isRegistrado() {
        Sentencias s = new Sentencias();

        s.setId(this.id);
        s.setCategoria(this.comboCategorias.getSelectedItem().toString());
        s.setCodigo(this.txtCodigo.getText());
        s.setDescripcion(this.txtDescripcion.getText());
        s.setPrecio(Double.parseDouble(this.txtPrecio.getText()));
        s.setPrecio_venta(Double.parseDouble(this.txtPrecioVenta.getText()));

        if (this.checkUtiliza.isSelected()) {
            if (this.txtStockMin.getText().isEmpty()) {
                s.setStock_min(0);
            } else {
                s.setStock_min(Integer.parseInt(this.txtStockMin.getText()));
            }
            if (this.txtExistencias.getText().isEmpty()) {
                s.setExistencias(0);
            } else {
                s.setExistencias(Integer.parseInt(this.txtExistencias.getText()));
            }
        } else {
            if (this.txtStockMin.getText().isEmpty()) {
                s.setStock_min(0);
            }
            if (this.txtExistencias.getText().isEmpty()) {
                s.setExistencias(0);
            }
        }

        if (this.comboCantidades.getSelectedIndex() == 0) {
            s.setSe_venden_en("");
        } else {
            s.setSe_venden_en(this.comboCantidades.getSelectedItem().toString());
        }
        s.setUbicacion(this.txtUbicacion.getText());

        s.setInventario_utiliza(this.checkUtiliza.isSelected());

        if (Operaciones.isRegistrado(s)) {
            return true;
        } else {
            return false;
        }
    }

    private void setToolTip() {
        comboCategorias.setToolTipText(RSTool.head + RSTool.body + "Categoría del producto" + RSTool.pie);
        txtCodigo.setToolTipText(RSTool.head + RSTool.body + "Código de barras" + RSTool.pie);
        txtDescripcion.setToolTipText(RSTool.head + RSTool.body + "Nombre del producto" + RSTool.pie);
        txtPrecio.setToolTipText(RSTool.head + RSTool.body + "Precio de compra" + RSTool.pie);
        txtPrecioVenta.setToolTipText(RSTool.head + RSTool.body + "Precio de venta" + RSTool.pie);
        txtExistencias.setToolTipText(RSTool.head + RSTool.body + "Cantidad en almacén" + RSTool.pie);
        txtStockMin.setToolTipText(RSTool.head + RSTool.body + "Cantidad mínima para el almacén" + RSTool.pie);
        comboCantidades.setToolTipText(RSTool.head + RSTool.body + "Como se vende el producto" + RSTool.pie);
        txtUbicacion.setToolTipText(RSTool.head + RSTool.body + "Lugar donde se ecnuentra el producto" + RSTool.pie);
    }
}