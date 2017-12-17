
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        this.pack();
        setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jf_file = new javax.swing.JFrame();
        jp_file = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jf_field = new javax.swing.JFrame();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_fieldname = new javax.swing.JTextField();
        tf_fieldtype = new javax.swing.JTextField();
        jb_addfield = new javax.swing.JButton();
        tf_fieldsize = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cb_fieldkey = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_fields = new javax.swing.JTable();
        jf_record = new javax.swing.JFrame();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jp_fields = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cb_fields = new javax.swing.JComboBox<>();
        jb_addfieldtotable = new javax.swing.JButton();
        jb_addrecord = new javax.swing.JButton();
        jp_add = new javax.swing.JPanel();
        jp_modify = new javax.swing.JPanel();
        jp_find = new javax.swing.JPanel();
        jp_list = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_records = new javax.swing.JTable();
        jb_deleterecord = new javax.swing.JButton();
        jf_index = new javax.swing.JFrame();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jp_createindex = new javax.swing.JPanel();
        jp_reindexfiles = new javax.swing.JPanel();
        pop_table = new javax.swing.JPopupMenu();
        mi_deletefield = new javax.swing.JMenuItem();
        mi_modifyfield = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_menu = new javax.swing.JMenu();
        jm_file = new javax.swing.JMenu();
        mi_newfile = new javax.swing.JMenuItem();
        mi_savefile = new javax.swing.JMenuItem();
        mi_closefile = new javax.swing.JMenuItem();
        mi_logout = new javax.swing.JMenuItem();
        mi_fields = new javax.swing.JMenuItem();
        mi_records = new javax.swing.JMenuItem();
        mi_index = new javax.swing.JMenuItem();
        jm_standarization = new javax.swing.JMenu();
        mi_exportexcel = new javax.swing.JMenuItem();
        mi_exportxml = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jf_file.setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Archivo");

        javax.swing.GroupLayout jp_fileLayout = new javax.swing.GroupLayout(jp_file);
        jp_file.setLayout(jp_fileLayout);
        jp_fileLayout.setHorizontalGroup(
            jp_fileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_fileLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel1)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jp_fileLayout.setVerticalGroup(
            jp_fileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_fileLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jf_fileLayout = new javax.swing.GroupLayout(jf_file.getContentPane());
        jf_file.getContentPane().setLayout(jf_fileLayout);
        jf_fileLayout.setHorizontalGroup(
            jf_fileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_file, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jf_fileLayout.setVerticalGroup(
            jf_fileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_file, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Campo");

        jLabel3.setText("Nombre");

        jLabel4.setText("Tipo");

        jb_addfield.setText("Agregar");
        jb_addfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_addfieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Longitud");

        jLabel8.setText("¿Es llave?");

        cb_fieldkey.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Sí" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_fieldtype, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_fieldname, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_fieldsize, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_fieldkey, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jb_addfield)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_fieldname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_fieldtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_fieldsize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cb_fieldkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jb_addfield)
                .addGap(46, 46, 46))
        );

        jTabbedPane1.addTab("Crear", jPanel6);

        jt_fields.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tipo", "Longitud", "¿Es llave?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jt_fields.setComponentPopupMenu(pop_table);
        jScrollPane2.setViewportView(jt_fields);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Listar/Eliminar/Modificar", jPanel7);

        javax.swing.GroupLayout jf_fieldLayout = new javax.swing.GroupLayout(jf_field.getContentPane());
        jf_field.getContentPane().setLayout(jf_fieldLayout);
        jf_fieldLayout.setHorizontalGroup(
            jf_fieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jf_fieldLayout.setVerticalGroup(
            jf_fieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Agregar");

        jLabel6.setText("Campos");

        jb_addfieldtotable.setText("Agregar Campo");
        jb_addfieldtotable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_addfieldtotableActionPerformed(evt);
            }
        });

        jb_addrecord.setText("Agregar Registro");
        jb_addrecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_addrecordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_fieldsLayout = new javax.swing.GroupLayout(jp_fields);
        jp_fields.setLayout(jp_fieldsLayout);
        jp_fieldsLayout.setHorizontalGroup(
            jp_fieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_fieldsLayout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(165, 165, 165))
            .addGroup(jp_fieldsLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(cb_fields, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jp_fieldsLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jb_addfieldtotable)
                .addGap(55, 55, 55)
                .addComponent(jb_addrecord)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_fieldsLayout.setVerticalGroup(
            jp_fieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_fieldsLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel5)
                .addGap(55, 55, 55)
                .addGroup(jp_fieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cb_fields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jp_fieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_addfieldtotable)
                    .addComponent(jb_addrecord))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Campos", jp_fields);

        javax.swing.GroupLayout jp_addLayout = new javax.swing.GroupLayout(jp_add);
        jp_add.setLayout(jp_addLayout);
        jp_addLayout.setHorizontalGroup(
            jp_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 435, Short.MAX_VALUE)
        );
        jp_addLayout.setVerticalGroup(
            jp_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Agregar", jp_add);

        javax.swing.GroupLayout jp_modifyLayout = new javax.swing.GroupLayout(jp_modify);
        jp_modify.setLayout(jp_modifyLayout);
        jp_modifyLayout.setHorizontalGroup(
            jp_modifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 435, Short.MAX_VALUE)
        );
        jp_modifyLayout.setVerticalGroup(
            jp_modifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Modificar", jp_modify);

        javax.swing.GroupLayout jp_findLayout = new javax.swing.GroupLayout(jp_find);
        jp_find.setLayout(jp_findLayout);
        jp_findLayout.setHorizontalGroup(
            jp_findLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 435, Short.MAX_VALUE)
        );
        jp_findLayout.setVerticalGroup(
            jp_findLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Buscar", jp_find);

        jt_records.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jt_records);

        jb_deleterecord.setText("Eliminar");

        javax.swing.GroupLayout jp_listLayout = new javax.swing.GroupLayout(jp_list);
        jp_list.setLayout(jp_listLayout);
        jp_listLayout.setHorizontalGroup(
            jp_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_listLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jp_listLayout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jb_deleterecord)
                .addContainerGap(187, Short.MAX_VALUE))
        );
        jp_listLayout.setVerticalGroup(
            jp_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_listLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jb_deleterecord)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Listar", jp_list);

        javax.swing.GroupLayout jf_recordLayout = new javax.swing.GroupLayout(jf_record.getContentPane());
        jf_record.getContentPane().setLayout(jf_recordLayout);
        jf_recordLayout.setHorizontalGroup(
            jf_recordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jf_recordLayout.setVerticalGroup(
            jf_recordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        javax.swing.GroupLayout jp_createindexLayout = new javax.swing.GroupLayout(jp_createindex);
        jp_createindex.setLayout(jp_createindexLayout);
        jp_createindexLayout.setHorizontalGroup(
            jp_createindexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jp_createindexLayout.setVerticalGroup(
            jp_createindexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Crear Índices", jp_createindex);

        javax.swing.GroupLayout jp_reindexfilesLayout = new javax.swing.GroupLayout(jp_reindexfiles);
        jp_reindexfiles.setLayout(jp_reindexfilesLayout);
        jp_reindexfilesLayout.setHorizontalGroup(
            jp_reindexfilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jp_reindexfilesLayout.setVerticalGroup(
            jp_reindexfilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Re-Indexar Archivos", jp_reindexfiles);

        javax.swing.GroupLayout jf_indexLayout = new javax.swing.GroupLayout(jf_index.getContentPane());
        jf_index.getContentPane().setLayout(jf_indexLayout);
        jf_indexLayout.setHorizontalGroup(
            jf_indexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jf_indexLayout.setVerticalGroup(
            jf_indexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        mi_deletefield.setText("Eliminar");
        mi_deletefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_deletefieldActionPerformed(evt);
            }
        });
        pop_table.add(mi_deletefield);

        mi_modifyfield.setText("Modificar");
        mi_modifyfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_modifyfieldActionPerformed(evt);
            }
        });
        pop_table.add(mi_modifyfield);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
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

        jm_menu.setText("Menú");

        jm_file.setText("Archivo");

        mi_newfile.setText("Nuevo Archivo");
        mi_newfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_newfileActionPerformed(evt);
            }
        });
        jm_file.add(mi_newfile);

        mi_savefile.setText("Salvar Archivo");
        mi_savefile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_savefileActionPerformed(evt);
            }
        });
        jm_file.add(mi_savefile);

        mi_closefile.setText("Cerrar Archivo");
        jm_file.add(mi_closefile);

        mi_logout.setText("Salir");
        mi_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_logoutActionPerformed(evt);
            }
        });
        jm_file.add(mi_logout);

        jm_menu.add(jm_file);

        mi_fields.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        mi_fields.setText("Campos");
        mi_fields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_fieldsActionPerformed(evt);
            }
        });
        jm_menu.add(mi_fields);

        mi_records.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mi_records.setText("Registros");
        mi_records.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_recordsActionPerformed(evt);
            }
        });
        jm_menu.add(mi_records);

        mi_index.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        mi_index.setText("Índices");
        mi_index.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_indexActionPerformed(evt);
            }
        });
        jm_menu.add(mi_index);

        jm_standarization.setText("Estandarización");

        mi_exportexcel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mi_exportexcel.setText("Exportar Excel");
        mi_exportexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_exportexcelActionPerformed(evt);
            }
        });
        jm_standarization.add(mi_exportexcel);

        mi_exportxml.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        mi_exportxml.setText("Exportar XML con Schema");
        mi_exportxml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_exportxmlActionPerformed(evt);
            }
        });
        jm_standarization.add(mi_exportxml);

        jm_menu.add(jm_standarization);

        jMenuBar1.add(jm_menu);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mi_newfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_newfileActionPerformed
        String personName, personAge;
        int randomName, randomLastName;

        String[] names = {"Juan", "Diego", "Carlos", "Alejandra", "Diana", "Kimberly", "Miguel", "Mario", "Tania", "Luis", "Dinora", "Lucas", "María", "José", "Blanca", "Nicole", "Cristina", "Julio", "César", "Berta", "Marcos", "Liliana", "Iris", "Katherine", "Christian", "Ángel", "Andrés", "Antonia", "Lesly", "Karina"};
        String[] lastNames = {"Murillo", "Umanzor", "Zúniga", "Pérez", "Martínez", "Mendoza", "Domínguez", "Morales", "López", "García", "Espinoza", "Chávez", "Andino", "Tróchez", "Gutiérrez", "Medina", "Acosta", "Sánchez", "Canales", "Aguilera", "Padilla", "Ramos", "Cruz", "Aguilar", "Castillo", "Barahona", "Pineda", "Reyes", "Mejía", "Flores"};

        fields.add(new FieldDefinition("PersonId", "INT", 6, true));
        fields.add(new FieldDefinition("PersonName", "INT", 3, false));
        fields.add(new FieldDefinition("PersonAge", "INT", 3, false));
        fields.add(new FieldDefinition("CityId", "INT", 2, false));

        for (int i = 0; i < 5000; i++) {
            ArrayList<String> values = new ArrayList();

            randomName = (int) (Math.random() * 29);
            randomLastName = (int) (Math.random() * 29);
            personAge = Integer.toString((int) (Math.random() * 100) + 1);
            personName = names[randomName];

            values.add(Integer.toString(i));
            values.add(Integer.toString(i));
            values.add(personAge);
            values.add(Integer.toString(i));

            records.add(new Record(31, values));
        }
        
        if (fileManager.newFile("PersonFile", fields)) {
            System.out.println("Escribió en el archivo");

            try {
                fileManager.saveFile(records);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        JOptionPane.showMessageDialog(this, "¡Archivo de prueba creado!");
    }//GEN-LAST:event_mi_newfileActionPerformed

    private void mi_savefileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_savefileActionPerformed
        /*String aux1 = "Ciudad";
        String aux3 = "Nombre";
        String aux4 = "Apellido";
        String aux5 = "Carrera";

        recordFields.add("11611303");
        recordFields.add("15");
        recordFields.add(aux3);
        recordFields.add(aux4);
        recordFields.add(aux5);

        fields.add(new FieldDefinition("ID", "INT", 20, true));
        fields.add(new FieldDefinition(aux1, "CHAR", 20, false));
        fields.add(new FieldDefinition(aux3, "CHAR", 20, false));
        fields.add(new FieldDefinition(aux4, "CHAR", 20, false));
        fields.add(new FieldDefinition(aux5, "CHAR", 20, false));

        for (int i = 0; i < 2500; i++) {
            records.add(new Record(15, recordFields));
        }

        if (fileManager.newFile("PersonFile", fields)) {
            System.out.println("Escribió en el archivo");

            try {
                fileManager.saveFile(records);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                fileManager.loadFile("PersonFile");
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/

        JOptionPane.showMessageDialog(this, "Archivo guardado correctamente");
    }//GEN-LAST:event_mi_savefileActionPerformed

    private void mi_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_logoutActionPerformed
        System.exit(0);
        this.dispose();
    }//GEN-LAST:event_mi_logoutActionPerformed

    private void mi_fieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_fieldsActionPerformed
        jf_field.setVisible(true);
        jf_field.pack();
        jf_field.setLocationRelativeTo(null);
        jf_field.setResizable(false);
    }//GEN-LAST:event_mi_fieldsActionPerformed

    private void mi_recordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_recordsActionPerformed
        jf_record.setVisible(true);
        jf_record.pack();
        jf_record.setLocationRelativeTo(null);
        jf_record.setResizable(false);

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        cb_fields.setModel(model);

        model = (DefaultComboBoxModel) cb_fields.getModel();

        for (int i = 0; i < fields.size(); i++) {
            model.addElement(fields.get(i));
        }

        cb_fields.setModel(model);
        cb_fields.updateUI();
    }//GEN-LAST:event_mi_recordsActionPerformed

    private void mi_indexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_indexActionPerformed
        jf_index.setVisible(true);
        jf_index.pack();
        jf_index.setLocationRelativeTo(null);
        jf_index.setResizable(false);
    }//GEN-LAST:event_mi_indexActionPerformed

    private void mi_exportexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_exportexcelActionPerformed
        JOptionPane.showMessageDialog(this, "¡Exportado exitosamente a Excel!");
    }//GEN-LAST:event_mi_exportexcelActionPerformed

    private void mi_exportxmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_exportxmlActionPerformed
        JOptionPane.showMessageDialog(this, "¡XML exportado exitosamente con Schema!");
    }//GEN-LAST:event_mi_exportxmlActionPerformed

    private void jb_addfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_addfieldActionPerformed
        String name, type;
        int size;
        boolean isKey;

        name = tf_fieldname.getText();
        type = tf_fieldtype.getText();
        size = Integer.parseInt(tf_fieldsize.getText());

        if (name.equals("") || type.equals("") || tf_fieldsize.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "¡Por favor ingrese la información necesaria!");
        } else {
            isKey = cb_fieldkey.getSelectedIndex() != 0;

            FieldDefinition field = new FieldDefinition(name, type, size, isKey);

            fields.add(field);
            JOptionPane.showMessageDialog(this, "¡Campo agregado a la lista exitosamente!");
            tf_fieldname.setText("");
            tf_fieldsize.setText("");
            tf_fieldtype.setText("");
        }
    }//GEN-LAST:event_jb_addfieldActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jt_fields.getModel();
        int rows = model.getRowCount();

        for (int i = rows - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        for (int i = 0; i < fields.size(); i++) {
            Object[] newRow = new Object[]{fields.get(i).getName(), fields.get(i).getType(), fields.get(i).getSize(), fields.get(i).isKey()};
            model.addRow(newRow);
            jt_fields.setModel(model);
        }

        jt_fields.updateUI();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void mi_deletefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_deletefieldActionPerformed
        DefaultTableModel model = (DefaultTableModel) jt_fields.getModel();

        if (jt_fields.getSelectedRow() >= 0) {
            fields.remove(jt_fields.getSelectedRow());
            model.removeRow(jt_fields.getSelectedRow());

            JOptionPane.showMessageDialog(this, "¡Campo eliminado exitosamente!");
        } else {
            JOptionPane.showMessageDialog(this, "¡Seleccione un campo primero!");
        }
    }//GEN-LAST:event_mi_deletefieldActionPerformed

    private void mi_modifyfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_modifyfieldActionPerformed
        DefaultTableModel model = (DefaultTableModel) jt_fields.getModel();
        int size;

        size = Integer.parseInt((String) model.getValueAt(jt_fields.getSelectedRow(), 2));

        if (jt_fields.getSelectedRow() >= 0) {
            fields.get(jt_fields.getSelectedRow()).setName((String) model.getValueAt(jt_fields.getSelectedRow(), 0)); // Seteando nombre.
            fields.get(jt_fields.getSelectedRow()).setType((String) model.getValueAt(jt_fields.getSelectedRow(), 1)); // Seteando tipo.
            fields.get(jt_fields.getSelectedRow()).setSize(size); // Seteando longitud.

            JOptionPane.showMessageDialog(this, "¡Campo modificado exitosamente!");
        } else {
            JOptionPane.showMessageDialog(this, "¡Seleccione un campo primero!");
        }
    }//GEN-LAST:event_mi_modifyfieldActionPerformed

    private void jb_addfieldtotableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_addfieldtotableActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) jt_records.getModel(); // modelo
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) cb_fields.getModel();
        String columnName = ((FieldDefinition) comboBoxModel.getSelectedItem()).getName(); // Nombre de la columna de la tabla.
        boolean exists = false; // Si el campo ya existe en la tabla.
        FieldDefinition field = (FieldDefinition) comboBoxModel.getSelectedItem();

        if (tableModel.getColumnCount() == 0) { // Si es el primer campo que agrega...
            tableModel.addColumn(field.getName());
        } else {
            for (int i = 0; i < tableModel.getColumnCount(); i++) {
                if (columnName.equals(tableModel.getColumnName(i))) { // Si el campo ya existe en la tabla...
                    JOptionPane.showMessageDialog(this, "¡Este campo ya existe!");
                    exists = true;
                    break;
                }
            }

            if (!exists) { // Si el campo no existe en la tabla...
                tableModel.addColumn(((FieldDefinition) comboBoxModel.getSelectedItem()).getName()); // Agrega el campo a la tabla.
                JOptionPane.showMessageDialog(this, "¡Campo agregado exitosamente a la tabla!");
            }
        }

        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            System.out.println(tableModel.getColumnName(i));
        }
    }//GEN-LAST:event_jb_addfieldtotableActionPerformed

    private void jb_addrecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_addrecordActionPerformed
        jb_addfieldtotable.setEnabled(false);
        DefaultTableModel tableModel = (DefaultTableModel) jt_records.getModel();
        Object[] newRow = null;

        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            String value = JOptionPane.showInputDialog("Ingrese " + tableModel.getColumnName(i).toLowerCase() + ": ");
            newRow = new Object[]{value};

            if (i == 0) {
                tableModel.addRow(newRow);
            } else {
                recordFields.add(value); // Agrega el campo a la lista de campos del registro.
                tableModel.setValueAt(value, tableModel.getRowCount() - 1, i);
            }
        }
    }//GEN-LAST:event_jb_addrecordActionPerformed

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
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_fieldkey;
    private javax.swing.JComboBox<String> cb_fields;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JButton jb_addfield;
    private javax.swing.JButton jb_addfieldtotable;
    private javax.swing.JButton jb_addrecord;
    private javax.swing.JButton jb_deleterecord;
    private javax.swing.JFrame jf_field;
    private javax.swing.JFrame jf_file;
    private javax.swing.JFrame jf_index;
    private javax.swing.JFrame jf_record;
    private javax.swing.JMenu jm_file;
    private javax.swing.JMenu jm_menu;
    private javax.swing.JMenu jm_standarization;
    private javax.swing.JPanel jp_add;
    private javax.swing.JPanel jp_createindex;
    private javax.swing.JPanel jp_fields;
    private javax.swing.JPanel jp_file;
    private javax.swing.JPanel jp_find;
    private javax.swing.JPanel jp_list;
    private javax.swing.JPanel jp_modify;
    private javax.swing.JPanel jp_reindexfiles;
    private javax.swing.JTable jt_fields;
    private javax.swing.JTable jt_records;
    private javax.swing.JMenuItem mi_closefile;
    private javax.swing.JMenuItem mi_deletefield;
    private javax.swing.JMenuItem mi_exportexcel;
    private javax.swing.JMenuItem mi_exportxml;
    private javax.swing.JMenuItem mi_fields;
    private javax.swing.JMenuItem mi_index;
    private javax.swing.JMenuItem mi_logout;
    private javax.swing.JMenuItem mi_modifyfield;
    private javax.swing.JMenuItem mi_newfile;
    private javax.swing.JMenuItem mi_records;
    private javax.swing.JMenuItem mi_savefile;
    private javax.swing.JPopupMenu pop_table;
    private javax.swing.JTextField tf_fieldname;
    private javax.swing.JTextField tf_fieldsize;
    private javax.swing.JTextField tf_fieldtype;
    // End of variables declaration//GEN-END:variables
    ArrayList<FieldDefinition> fields = new ArrayList();
    ArrayList<String> recordFields = new ArrayList();
    ArrayList<Record> records = new ArrayList();
    FileManager fileManager = new FileManager();
    int FIELDS = 0;
}
