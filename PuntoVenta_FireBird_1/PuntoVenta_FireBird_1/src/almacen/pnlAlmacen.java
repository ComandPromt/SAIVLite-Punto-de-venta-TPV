/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacen;

import alertas.Cargando;
import alertas.ErrorAlert;
import alertas.SuccessAlert;
import alertas.WarningAlert;
import conexion.ConexionBD;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import necesario.RSFileChooser;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author RojeruSan
 */
public class pnlAlmacen extends javax.swing.JPanel {

    private int PosicionMouse;

    /**
     * Creates new form pnlAlmacen
     */
    public pnlAlmacen() {
        initComponents();
        
        if(conexion.ConexionBD.conect == null){
            new ConexionBD().conexion();
        }

        this.tabla.setCursor(new Cursor(12));
        this.scroll.getViewport().setBackground(Color.WHITE);
        this.menu.add(pnlMenu);

        Operaciones.setListar("");

        this.tabla.setDefaultRenderer(Object.class, new modelosTablas.TablaAlmacen());

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtBuscar.requestFocus();
            }
        });
        timer.setRepeats(true);
        timer.start();
        deshabilitarPegar();

        addEventKey();
    }

    private void deshabilitarPegar() {
        InputMap map1 = this.txtBuscar.getInputMap(this.txtBuscar.WHEN_FOCUSED);
        map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }

    private void addEventKey() {

        KeyStroke f1 = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0, false);
        Action f1Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                new ModalRegistrar(new JFrame(), true).setVisible(true);
            }
        };
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f1, "F1");
        this.getActionMap().put("F1", f1Action);

        //---------------------------------------------------------------------------
        KeyStroke f2 = KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0, false);
        Action f2Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                new almacen.Categorias(new JFrame(), true).setVisible(true);
            }
        };
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f2, "F2");
        this.getActionMap().put("F2", f2Action);

        //------------------------------------------------------------------------------
        KeyStroke f3 = KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0, false);
        Action f3Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                ImportarTabla();
            }
        };
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f3, "F3");
        this.getActionMap().put("F3", f3Action);

        //--------------------------------------------------------------------------------
        KeyStroke f4 = KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0, false);
        Action f4Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                generarExcel();
            }
        };
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f4, "F4");
        this.getActionMap().put("F4", f4Action);

        //--------------------------------------------------------------------------------
        KeyStroke f5 = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0, false);
        Action f5Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                new Impresion(new JFrame(), true).setVisible(true);
            }
        };
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f5, "F5");
        this.getActionMap().put("F5", f5Action);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new rojerusan.RSPopuMenu();
        pnlMenu = new javax.swing.JPanel();
        btnBorrar = new rojeru_san.RSButtonRiple();
        btnEditar = new rojeru_san.RSButtonRiple();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tabla = new rojerusan.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new rojeru_san.rsfield.RSTextMaterial();
        jPanel3 = new javax.swing.JPanel();
        btnCategoria = new rojeru_san.RSButtonRiple();
        btnImportar = new rojeru_san.RSButtonRiple();
        btnExportar = new rojeru_san.RSButtonRiple();
        btnPrint = new rojeru_san.RSButtonRiple();
        btnNuevo = new rojeru_san.RSButtonRiple();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));

        btnBorrar.setBackground(new java.awt.Color(69, 87, 252));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/btnEliminar.png"))); // NOI18N
        btnBorrar.setText("ELIMINAR");
        btnBorrar.setColorHover(new java.awt.Color(87, 103, 253));
        btnBorrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(69, 87, 252));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/btnEditar.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.setColorHover(new java.awt.Color(87, 103, 253));
        btnEditar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        scroll.setBorder(null);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoría", "Código de barras", "Descripción", "Precio compra", "Precio venta", "Existencias", "Ubicación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setToolTipText("");
        tabla.setAltoHead(30);
        tabla.setColorBackgoundHead(new java.awt.Color(69, 87, 252));
        tabla.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tabla.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tabla.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tabla.setColorHoverBackgound(new java.awt.Color(69, 87, 252));
        tabla.setColorSelBackgound(new java.awt.Color(69, 87, 252));
        tabla.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tabla.setFuenteHead(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabla.setGrosorBordeFilas(0);
        tabla.setHover(true);
        tabla.setMultipleSeleccion(false);
        tabla.setRowHeight(30);
        tabla.setSelectionBackground(new java.awt.Color(99, 70, 250));
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        scroll.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(1).setMaxWidth(1000);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(2).setMaxWidth(1000);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(4).setMaxWidth(1000);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(5).setMaxWidth(1000);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(6).setMaxWidth(1000);
            tabla.getColumnModel().getColumn(7).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(7).setMaxWidth(1000);
        }

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/label-buscar.png"))); // NOI18N

        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setColorMaterial(new java.awt.Color(69, 87, 252));
        txtBuscar.setPlaceholder("Buscar");
        txtBuscar.setSelectionColor(new java.awt.Color(220, 23, 111));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCategoria.setBackground(new java.awt.Color(69, 87, 252));
        btnCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/btn-categorias-menu.png"))); // NOI18N
        btnCategoria.setText("CATEGORÍAS(F2)");
        btnCategoria.setColorHover(new java.awt.Color(173, 187, 194));
        btnCategoria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });
        jPanel3.add(btnCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 184, 42));

        btnImportar.setBackground(new java.awt.Color(69, 87, 252));
        btnImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/btnExcel.png"))); // NOI18N
        btnImportar.setText("IMPORTAR (F3)");
        btnImportar.setColorHover(new java.awt.Color(173, 187, 194));
        btnImportar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnImportar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });
        jPanel3.add(btnImportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 0, 166, 42));

        btnExportar.setBackground(new java.awt.Color(69, 87, 252));
        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/btnExcel.png"))); // NOI18N
        btnExportar.setText("EXPORTAR(F4)");
        btnExportar.setColorHover(new java.awt.Color(173, 187, 194));
        btnExportar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExportar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });
        jPanel3.add(btnExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 170, 42));

        btnPrint.setBackground(new java.awt.Color(69, 87, 252));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/btn-imprimirMenu.png"))); // NOI18N
        btnPrint.setText(" (F5)");
        btnPrint.setColorHover(new java.awt.Color(173, 187, 194));
        btnPrint.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel3.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 99, 42));

        btnNuevo.setBackground(new java.awt.Color(69, 87, 252));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen/btn-agregar-menu.png"))); // NOI18N
        btnNuevo.setText("NUEVO (F1)");
        btnNuevo.setColorHover(new java.awt.Color(173, 187, 194));
        btnNuevo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(247, 247, 247));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel4.setText("ALMACÉN Y CONFIGURACIÓN DE PRODUCTOS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int row = tabla.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.tabla.setRowSelectionInterval(row, row);
            PosicionMouse = evt.getY() / 16;
            menu.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.tabla.setRowSelectionInterval(row, row);
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        Operaciones.setListar(this.txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (privilegios.Operaciones.EliminarProducto(principal.Principal.lblID.getText())) {
            this.menu.setVisible(false);
            int fila = this.tabla.getSelectedRow();
            int id = Integer.parseInt(this.tabla.getValueAt(fila, 0).toString());

            String producto = this.tabla.getValueAt(fila, 2).toString();

            WarningAlert w = new WarningAlert(new JFrame(), true);
            w.msj1.setText("Se eliminara el producto");
            w.msj2.setText("(" + producto + ")");
            w.msj3.setText("de manera permanente del sistema.");
            w.setVisible(true);

            if (w.hecho) {
                if (isEliminado(id)) {
                    id = Operaciones.extraerIDMax();
                    Operaciones.setListar("");

                    SuccessAlert s = new SuccessAlert(new JFrame(), true);
                    s.msj1.setText("Producto eliminado con éxito");
                    s.msj2.setText("");
                    s.msj3.setText("");
                    s.setVisible(true);
                } else {
                    ErrorAlert e = new ErrorAlert(new JFrame(), true);
                    e.msj1.setText("Algo salio mal. No fue posible");
                    e.msj2.setText("continuar con esta acción.");
                    e.msj3.setText("");
                    e.setVisible(true);
                }
            }
        } else {
            ErrorAlert e = new ErrorAlert(new JFrame(), true);
            e.msj1.setText("No cuentas con los privilegios");
            e.msj2.setText("para acceder a esta opción.");
            e.msj3.setText("");
            e.setVisible(true);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (privilegios.Operaciones.EditarProducto(principal.Principal.lblID.getText())) {
            this.menu.setVisible(false);
            ModalEditar m = new ModalEditar(new JFrame(), true);
            int fila = this.tabla.getSelectedRow();

            int id = Integer.parseInt(this.tabla.getValueAt(fila, 0).toString());
            Operaciones.extraerDatos(m, String.valueOf(id));
            m.setVisible(true);
        } else {
            ErrorAlert e = new ErrorAlert(new JFrame(), true);
            e.msj1.setText("No cuentas con los privilegios");
            e.msj2.setText("para acceder a esta opción.");
            e.msj3.setText("");
            e.setVisible(true);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        if (privilegios.Operaciones.ImportarAlmacen(principal.Principal.lblID.getText())) {
            new almacen.Categorias(new JFrame(), true).setVisible(true);
        } else {
            ErrorAlert e = new ErrorAlert(new JFrame(), true);
            e.msj1.setText("No cuentas con los privilegios");
            e.msj2.setText("para acceder a esta opción.");
            e.msj3.setText("");
            e.setVisible(true);
        }
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        if (privilegios.Operaciones.ImportarAlmacen(principal.Principal.lblID.getText())) {
            ImportarTabla();
        } else {
            ErrorAlert e = new ErrorAlert(new JFrame(), true);
            e.msj1.setText("No cuentas con los privilegios");
            e.msj2.setText("para acceder a esta opción.");
            e.msj3.setText("");
            e.setVisible(true);
        }
    }//GEN-LAST:event_btnImportarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        if (privilegios.Operaciones.ExportarAlmacen(principal.Principal.lblID.getText())) {
            generarExcel();
        } else {
            ErrorAlert e = new ErrorAlert(new JFrame(), true);
            e.msj1.setText("No cuentas con los privilegios");
            e.msj2.setText("para acceder a esta opción.");
            e.msj3.setText("");
            e.setVisible(true);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        if (privilegios.Operaciones.ImprimirAlmacen(principal.Principal.lblID.getText())) {
            new Impresion(new JFrame(), true).setVisible(true);
        } else {
            ErrorAlert e = new ErrorAlert(new JFrame(), true);
            e.msj1.setText("No cuentas con los privilegios");
            e.msj2.setText("para acceder a esta opción.");
            e.msj3.setText("");
            e.setVisible(true);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if (privilegios.Operaciones.RegistrarProducto(principal.Principal.lblID.getText())) {
            new ModalRegistrar(new JFrame(), true).setVisible(true);
        } else {
            ErrorAlert e = new ErrorAlert(new JFrame(), true);
            e.msj1.setText("No cuentas con los privilegios");
            e.msj2.setText("para acceder a esta opción.");
            e.msj3.setText("");
            e.setVisible(true);
        }
    }//GEN-LAST:event_btnNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnBorrar;
    private rojeru_san.RSButtonRiple btnCategoria;
    private rojeru_san.RSButtonRiple btnEditar;
    private rojeru_san.RSButtonRiple btnExportar;
    private rojeru_san.RSButtonRiple btnImportar;
    private rojeru_san.RSButtonRiple btnNuevo;
    private rojeru_san.RSButtonRiple btnPrint;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private rojerusan.RSPopuMenu menu;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JScrollPane scroll;
    public static rojerusan.RSTableMetro tabla;
    public static rojeru_san.rsfield.RSTextMaterial txtBuscar;
    // End of variables declaration//GEN-END:variables

    private boolean isEliminado(int id) {
        Sentencias s = new Sentencias();
        s.setId(id);

        if (Operaciones.isEliminado(s)) {
            return true;
        } else {
            return false;
        }
    }

    private void generarExcel() {
        HSSFWorkbook workbook = new excel.ExcelGenerator().generateExcel();
        RSFileChooser fileChooser = new RSFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Excel (*.xls)", "xls");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("GUARDAR ARCHIVO");
        if (fileChooser.showSaveDialog(this) == RSFileChooser.APPROVE_OPTION) {

            System.out.println(fileChooser.getSelectedFile().getAbsolutePath());

            File archivo = new File(fileChooser.getSelectedFile().getAbsolutePath());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    c.setVisible(true);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        OutputStream out = null;
                        if (getFileExtension(archivo)) {
                            out = new FileOutputStream(fileChooser.getSelectedFile().getAbsolutePath());
                        } else {
                            out = new FileOutputStream(fileChooser.getSelectedFile().getAbsolutePath() + ".xls");
                        }
                        workbook.write(out);
                        workbook.close();
                        out.flush();
                        out.close();

                        c.dispose();
                        SuccessAlert s = new SuccessAlert(new JFrame(), true);
                        s.msj1.setText("Archivo guardado con éxito");
                        s.msj2.setText("");
                        s.msj3.setText("");
                        s.setVisible(true);
                    } catch (FileNotFoundException ex) {
                        c.dispose();
                        ErrorAlert e = new ErrorAlert(new JFrame(), true);
                        e.msj1.setText("Algo salio mal. El archivo que intenta sobreescribir");
                        e.msj2.setText("se encuentra abierto, cierre el archivo");
                        e.msj3.setText("e intentelo de nuevo.");
                        e.setVisible(true);

//                        Logger.getLogger(pnlAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        c.dispose();
                        ErrorAlert e = new ErrorAlert(new JFrame(), true);
                        e.msj1.setText("Algo salio mal. No fue posible");
                        e.msj2.setText("generar el archivo.");
                        e.msj3.setText("");
                        e.setVisible(true);

//                        Logger.getLogger(pnlAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }).start();
        }
    }

    public static alertas.Cargando c = new Cargando(new JFrame(), true);

    private void ImportarTabla() {
        RSFileChooser fileChooser = new RSFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Excel (*.xls)", "xls");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("BUSCAR ARCHIVO");
        if (fileChooser.showOpenDialog(this) == RSFileChooser.APPROVE_OPTION) {

            System.out.println(fileChooser.getSelectedFile().getAbsolutePath());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    c.setVisible(true);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    String valor = excel.toMySQL.importarTabla(fileChooser.getSelectedFile().getAbsolutePath());
                    if (valor.equals("hecho")) {
                        c.dispose();
                        Operaciones.setListar("");

                        SuccessAlert s = new SuccessAlert(new JFrame(), true);
                        s.msj1.setText("Datos cargados a la tabla con éxito.");
                        s.msj2.setText("");
                        s.msj3.setText("");
                        s.setVisible(true);
                    }

                    if (valor.equals("error")) {
                        c.dispose();
                        Operaciones.setListar("");

                        ErrorAlert e = new ErrorAlert(new JFrame(), true);
                        e.msj1.setText("Algo salio mal. No fue posible importar todos los datos.");
                        e.msj2.setText("Verifique que todos los registros de la tabla esten");
                        e.msj3.setText("estructurados correctamente.");
                        e.setVisible(true);
                    }
                }
            }).start();
        }
    }

    private boolean getFileExtension(File file) {
        String ext = null;
        String s = file.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }

        if (ext != null) {
            return true;
        } else {
            return false;
        }
    }
}