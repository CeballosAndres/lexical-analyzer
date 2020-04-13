
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class app extends javax.swing.JFrame {

    int[][] matriz = {
        {2, 7, -1, 8, 5, 3, 10, 9, 6, 12, 8, 11, -1, 4, 3, 1, 1, 1},
        {2, 7, -1, 8, 5, 3, 10, 9, 6, 12, 8, 11, -1, 4, 3, 1, 1, 1},
        {2, 2, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 13},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 14},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, 15, -1, -1, 14},
        {-1, -1, -1, -1, 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 17},
        {-1, -1, -1, -1, -1, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, 7, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22},
        {-1, -1, -1, -1, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23},
        {11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 24, 11, 11, 11, 11, 11, 11},
        {-1, -1, -1, -1, 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 25},
        {2, 7, -1, 8, 5, 3, 10, 9, 6, 12, 8, 11, -1, 4, 3, 1, 1, 1},
        {2, 7, -1, 8, 5, 3, 10, 9, 6, 12, 8, 11, -1, 4, 3, 1, 1, 1},
        {15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 26, 15, 15, 15},
        {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 27, 16, 16},
        {2, 7, -1, 8, 5, 3, 10, 9, 6, 12, 8, 11, -1, 4, 3, 1, 1, 1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 25},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23},
        {2, 7, -1, 8, 5, 3, 10, 9, 6, 12, 8, 11, -1, 4, 3, 1, 1, 1},
        {-1, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {2, 7, -1, 8, 5, 3, 10, 9, 6, 12, 8, 11, -1, 4, 3, 1, 1, 1},
        {2, 7, -1, 8, 5, 3, 10, 9, 6, 12, 8, 11, -1, 4, 3, 1, 1, 1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 29},
        {2, 7, -1, 8, 5, 3, 10, 9, 6, 12, 8, 11, -1, 4, 3, 1, 1, 1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 27, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 30},
        {-1, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 31},
        {2, 7, -1, 8, 5, 3, 10, 9, 6, 12, 8, 11, -1, 4, 3, 1, 1, 1},
        {2, 7, -1, 8, 5, 3, 10, 9, 6, 12, 8, 11, -1, 4, 3, 1, 1, 1},
        {2, 7, -1, 8, 5, 3, 10, 9, 6, 12, 8, 11, -1, 4, 3, 1, 1, 1}};
    String letras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String numeros = "0123456789";
    String aritmeticos = "+-^";
    String relacionales = "<>";
    String separadores = ":;(){}[],";

    public app() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tEditor = new javax.swing.JTextArea();
        btnLeer = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLexemas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAnalisis = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();
        btnCreditos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador léxico");

        tEditor.setColumns(20);
        tEditor.setRows(5);
        jScrollPane1.setViewportView(tEditor);

        btnLeer.setText("Leer");
        btnLeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeerActionPerformed(evt);
            }
        });

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tblLexemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Componente Léxico"
            }
        ));
        jScrollPane2.setViewportView(tblLexemas);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tec.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tecnm.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel1.setText("Analizador Léxico");
        jLabel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel4.setText("Lenguajes y Autómatas I");

        btnAnalisis.setText("Análisis Léxico");
        btnAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisisActionPerformed(evt);
            }
        });

        btnAyuda.setText("Ayuda");
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        btnCreditos.setText("Créditos");
        btnCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(35, 35, 35))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnLeer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGrabar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAyuda)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCreditos)
                .addContainerGap())
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btnAnalisis)
                        .addContainerGap(91, Short.MAX_VALUE))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addComponent(jLabel3)))
                    .addComponent(jLabel2))
                .addGap(15, 15, 15)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnalisis)
                        .addGap(14, 14, 14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLeer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGrabar)
                        .addComponent(btnLimpiar))
                    .addComponent(btnAyuda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreditos)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerActionPerformed
        JFileChooser fileChooser = new JFileChooser("f:");
        fileChooser.setDialogTitle("Seleccione archivo a leer:");
        int response = fileChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File fi = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                String s1 = "", sl = "";
                BufferedReader br = new BufferedReader(new FileReader(fi));
                sl = br.readLine();
                while ((s1 = br.readLine()) != null) {
                    sl = sl + "\n" + s1;
                }
                tEditor.setText(sl);
            } catch (Exception ev) {
                JOptionPane.showMessageDialog(null, ev.getMessage());
            }
        }
    }//GEN-LAST:event_btnLeerActionPerformed


    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        JFileChooser fileChooser = new JFileChooser("f:");
        fileChooser.setDialogTitle("Seleccione dónde grabar el archivo:");
        int response = fileChooser.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File fi = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                BufferedWriter w = new BufferedWriter(new FileWriter(fi, false));
                w.write(tEditor.getText());
                w.flush();
                w.close();
            } catch (Exception ev) {
                JOptionPane.showMessageDialog(null, ev.getMessage());
            }
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.tEditor.setText("");
        this.tEditor.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisisActionPerformed
        String texto = this.tEditor.getText();
        if (texto.equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Ingrese algún código para ser\nanalizado en el cuadro de texto.",
                    "Falta de código para analizar", JOptionPane.ERROR_MESSAGE);
        } else {
            this.validarCadenas(texto);
        }
    }//GEN-LAST:event_btnAnalisisActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        JOptionPane.showMessageDialog(null,
                "Las siguientes son las opciones disponibles:\n\n"
                + "* Leer: abre cuadro de dialogo para seleccionar archivo a modificar.\n"
                + "* Grabar: abre cuadro de dialogo para seleccionar el nombre\n"
                + "  con el que se desea guardar el archivo.\n"
                + "* Limpiar: partmite eliminar el contenido del cuadro de texto.\n"
                + "* Análisis léxico: realiza el analisis léxico del código fuete.",
                "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditosActionPerformed
        JOptionPane.showMessageDialog(null,
                "Tecnológico Nacional de México Campus Colima\n"
                + "Lenguajes y Autómatas I\n\n"
                + "Programa: analizador léxico\n\n"
                + "José Andrés Ceballos Vadillo\n"
                + "17460386",
                "Créditos", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnCreditosActionPerformed

    private void jLabel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel1AncestorAdded
    }//GEN-LAST:event_jLabel1AncestorAdded

    private void validarCadenas(String texto) {
        DefaultTableModel modelo = this.initializeModel(new String[]{"Léxema", "Componente lexico"});
        int position = 0;
        int estado = 0;
        String lexema = "";
        int transition = 0;
        int oldTransition = 0;
        
        do {
            oldTransition = transition;
            transition = getTransitionNumber(String.valueOf(texto.charAt(position)));
            //Consumir sin agregar espacios, enter y tabulaciones
            if (transition < 15 || estado == 11 || estado == 15 || estado == 16) {
                lexema += texto.charAt(position);
            }
            if (transition == -1) {
                // Manejo error de caracter invalido
                if (estado == 11 || estado == 15 || estado == 16) {
                    // Ajuste: cometarios y literales pueden contener cualquier simbolo
                    transition = oldTransition;
                } else {
                    modelo = this.addRowToModel(modelo, lexema, "Caracter invalido");
                    lexema = "";
                }
            } else {
                estado = this.matriz[estado][transition];
                if (estado == -1) {
                    // Manejo error léxico
                    modelo = this.addRowToModel(modelo, lexema, "Error léxico");
                    lexema = "";
                    estado = 0;
                } else if (!this.getComponentName(estado).equals("")) {
                    modelo = this.addRowToModel(modelo, lexema, this.getComponentName(estado));
                    lexema = "";
                }
            }
            position++;
        } while (position < texto.length());
        this.tblLexemas.setModel(modelo);
    }

    private DefaultTableModel initializeModel(String[] titles) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(titles);
        return modelo;
    }

    private DefaultTableModel addRowToModel(DefaultTableModel modelo, String lexema, String componente) {
        modelo.addRow(new Object[]{lexema, componente});
        return modelo;
    }

    // Metodo que regresa el nombre del componente léxico del estado recibido
    private String getComponentName(int estado) {
        String componente = "";
        switch (estado) {
            case 13:
                componente = "Identificador";
                break;
            case 14:
                componente = "Operador aritmetico";
                break;
            case 17:
                componente = "Asignación";
                break;
            case 20:
                componente = "Número entero";
                break;
            case 22:
                componente = "Separador";
                break;
            case 23:
                componente = "Operador lógico";
                break;
            case 24:
                componente = "Literal";
                break;
            case 25:
                componente = "Operador relacional";
                break;
            case 30:
                componente = "Comentario";
                break;
            case 31:
                componente = "Número decimal";
                break;
        }
        return componente;
    }

    // Metodo para regresar la posición entera del caracter en el alfabeto
    private int getTransitionNumber(String caracter) {
        int indice = -1;
        switch (caracter) {
            case "_":
                indice = 2;
                break;
            case ".":
                indice = 3;
                break;
            case "=":
                indice = 4;
                break;
            case "!":
                indice = 6;
                break;
            case "&":
                indice = 7;
                break;
            case "|":
                indice = 8;
                break;
            case "\"":
                indice = 11;
                break;  
            case "/":
                indice = 13;
                break;
            case "*":
                indice = 14;
                break;
            case "\n":
                indice = 15;
                break;
            case "\t":
                indice = 16;
                break;
            case " ":
                indice = 17;
                break;
            default:
                if (this.letras.contains(caracter)) {
                    indice = 0;
                } else if (this.numeros.contains(caracter)) {
                    indice = 1;
                } else if (this.aritmeticos.contains(caracter)) {
                    indice = 5;
                } else if (this.relacionales.contains(caracter)) {
                    indice = 9;
                } else if (this.separadores.contains(caracter)) {
                    indice = 10;
                }
                break;
        }
        return indice;
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
            java.util.logging.Logger.getLogger(app.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(app.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(app.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(app.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new app().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalisis;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnCreditos;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLeer;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel;
    private javax.swing.JTextArea tEditor;
    private javax.swing.JTable tblLexemas;
    // End of variables declaration//GEN-END:variables
}
