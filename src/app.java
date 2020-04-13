
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
    
Proyecto: Analizador léxico
Asignatura: Lenguajes y Autómatas I
Alumno: José Andrés Ceballos Vadillo
No. Ctrl: 17460386

Descripción: Programa para realizar un análisis léxico de un código con 
java simplificado.

 */
public class app extends javax.swing.JFrame {

    // Tabla de transiciones usada para identificar los 10 diferentes componentes
    // léxicos de java simplificado. 
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
    // Variables para definir la transición para cada una de las categorías
    String letras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String numeros = "0123456789";
    String aritmeticos = "+-^";
    String relacionales = "<>";
    String separadores = ":;(){}[],";
    // Titulos de tabla de analizador léxico
    String[] titles = {"Lexema", "Componente léxico"};

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
        lblImgItcolima = new javax.swing.JLabel();
        lblImgTecnm = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblMateria = new javax.swing.JLabel();
        btnAnalisis = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();
        btnCreditos = new javax.swing.JButton();
        lblAlumno = new javax.swing.JLabel();

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

        lblImgItcolima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tec.png"))); // NOI18N

        lblImgTecnm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tecnm.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        lblTitulo.setText("Analizador Léxico");

        lblMateria.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        lblMateria.setText("Lenguajes y Autómatas I");

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

        lblAlumno.setFont(new java.awt.Font("Arial", 3, 10)); // NOI18N
        lblAlumno.setText("José Andrés Ceballos Vadillo - 17460386");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblImgTecnm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblMateria)
                    .addComponent(lblTitulo)
                    .addComponent(lblAlumno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblImgItcolima)
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
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(lblImgItcolima)
                        .addGap(15, 15, 15))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(lblTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMateria))
                            .addComponent(lblImgTecnm))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAlumno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
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
        // Método para leer cualquier archivo
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
        // Método para guardar cambios
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
        // Método para limpiar cuadro de texto
        this.tEditor.setText("");
        this.tEditor.requestFocus(); // Redirige el foco al cuadro de texto
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisisActionPerformed
        // Método para inicial análisis léxico. Valida que exista código en 
        // cuadro de texto.
        String texto = this.tEditor.getText();
        if (texto.equals("")) {
            // Si el cuadro de texto está vacio limpia tabla y muestra mensaje.
            this.tblLexemas.setModel(this.initializeModel(this.titles));
            JOptionPane.showMessageDialog(null,
                    "Ingrese algún código para ser\nanalizado en el cuadro de texto.",
                    "Falta de código para analizar", JOptionPane.ERROR_MESSAGE);
        } else {
            this.validarCadenas(texto);
        }
    }//GEN-LAST:event_btnAnalisisActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        // Método para desplegar ayuda del programa
        JOptionPane.showMessageDialog(null,
                "Con este programa se puede realizar un análisis léxico de un código\n"
                + "para una versión simplificada del lenguaje Java.\n\n"
                + "Las siguientes son las opciones disponibles:\n\n"
                + "* Leer: abre cuadro de dialogo para seleccionar archivo a modificar.\n"
                + "* Grabar: abre cuadro de dialogo para seleccionar el nombre\n"
                + "  con el que se desea guardar el archivo.\n"
                + "* Limpiar: partmite eliminar el contenido del cuadro de texto.\n"
                + "* Análisis léxico: realiza el analisis léxico del código fuete.\n\n"
                + "Para su ejecución ingrese en el cuadro de texto el código a analizar\n"
                + "o lea un archivo con la opción leer. Después, ejecute el análisis con\n"
                + "el boton Análisis léxico.\n\n"
                + "Ejemplo: Ingrese String cadena = \"Hola mundo\" ;      (Es necesario introducir un espacio como separador)\n"
                + "Se desplegará en la tabla: \n"
                + "  Lexema            Componente léxico\n"
                + "  String               Identificador\n"
                + "  cadena            Identificador\n"
                + "  =                    Asignación\n"
                + "  \"Hola mundo\"   Literal\n"
                + "  ;                     Separador\n\n"
                + "Fuentes de consulta: \n"
                        + "JTable - http://www.chuidiang.org/java/tablas/tablamodelo/tablamodelo.php \n"
                        + "Leer archivo en Java - https://geekytheory.com/como-leer-un-fichero-en-java \n"
                        + "Switch con if anidados - https://stackoverflow.com/questions/8088370/using-regex-for-switch-statement-in-java",
                "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditosActionPerformed
        // Método para desplegar creditos del programa
        JOptionPane.showMessageDialog(null,
                "Tecnológico Nacional de México Campus Colima\n"
                + "Lenguajes y Autómatas I\n\n"
                + "Programa: analizador léxico\n\n"
                + "José Andrés Ceballos Vadillo\n"
                + "17460386",
                "Créditos", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnCreditosActionPerformed

    private void validarCadenas(String texto) {
        // Método para analizar lexicamente código de cuadro de texto
        // Se crea un modelo que será pasado al JTable
        DefaultTableModel modelo = this.initializeModel(this.titles);
        int position = 0;
        int estado = 0;
        String lexema = "";
        int transition = 0;
        int oldTransition = 0;
        // Inicia recorrido por todo el contenido del cuadro de texto.
        do {
            oldTransition = transition;
            transition = getTransitionNumber(String.valueOf(texto.charAt(position)));
            //Consumir sin agregar espacios, enter y tabulaciones al lexema
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
        // Se pasa el modelo al Jtable para ser desplegado
        this.tblLexemas.setModel(modelo);
    }

    // Método para inicializar modelo de tabla
    private DefaultTableModel initializeModel(String[] titles) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(titles);
        return modelo;
    }

    // Método para agregar registro a modelo de tabla
    private DefaultTableModel addRowToModel(DefaultTableModel modelo, String lexema, String componente) {
        modelo.addRow(new Object[]{lexema, componente});
        return modelo;
    }

    // Metodo que regresa el nombre del componente léxico del estado recibido
    private String getComponentName(int estado) {
        // Cada case hace referencia a un estado que será tratado para desplegarse
        // en pantalla. Ej. en caso de que el estado sea 13 se sabrá que se trata
        // de un componente léxico valido tipo identificador.
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAlumno;
    private javax.swing.JLabel lblImgItcolima;
    private javax.swing.JLabel lblImgTecnm;
    private javax.swing.JLabel lblMateria;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panel;
    private javax.swing.JTextArea tEditor;
    private javax.swing.JTable tblLexemas;
    // End of variables declaration//GEN-END:variables
}
