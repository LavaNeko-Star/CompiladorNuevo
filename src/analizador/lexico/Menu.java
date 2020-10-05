package analizador.lexico;
import static analizador.lexico.Globales.LL;
import static analizador.lexico.Globales.LU;
import static analizador.lexico.Globales.LS;
import static analizador.lexico.Globales.LNU;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
                                                                                  


public class Menu extends javax.swing.JFrame {
int codigo=0;
int codigova=99;
int codigode=999;
int codigonu=1999;   
int verificar=0;
int filas=0;
int variableif=0;



    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.LEFT);
        tabla.getColumnModel().getColumn(0).setCellRenderer(modelocentrar); 
        tabla.getColumnModel().getColumn(1).setCellRenderer(modelocentrar); 
          Globales.LeerVariables();
          Globales.Leerreservada();
          Globales.LeerDelimitadores();
          Globales.Leernu();
          codigova=(int)LU.devuelID();
          codigo=(int)LS.devuelID();
          System.out.println(""+codigo);
          codigode=(int)LL.devuelID();
          codigonu=(int)LNU.devuelID();   
          System.out.println(""+codigonu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        areasintactico = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnlexico = new javax.swing.JButton();
        btnsintactico = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areacadena = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador Lexicografico");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        areasintactico.setEditable(false);
        areasintactico.setColumns(20);
        areasintactico.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        areasintactico.setRows(5);
        areasintactico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                areasintacticoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(areasintactico);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 160, 380, 340));

        jLabel2.setForeground(new java.awt.Color(51, 255, 255));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "TOKENS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tabla);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 380, 340));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizador/lexico/label_new red.png"))); // NOI18N
        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 560, 140, 30));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnlexico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizador/lexico/analyze.png"))); // NOI18N
        btnlexico.setText("Analizador Lexico");
        btnlexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlexicoActionPerformed(evt);
            }
        });
        getContentPane().add(btnlexico, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, -1, -1));

        btnsintactico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizador/lexico/analyze.png"))); // NOI18N
        btnsintactico.setText("Analizador Sintactico");
        btnsintactico.setEnabled(false);
        btnsintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsintacticoActionPerformed(evt);
            }
        });
        getContentPane().add(btnsintactico, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 510, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("INGRESAR CADENA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("RESULTADO ANALIZADOR SINTACTICO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, -1, -1));

        areacadena.setColumns(20);
        areacadena.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        areacadena.setRows(5);
        areacadena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                areacadenaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(areacadena);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 380, 340));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("RESULTADO ANALIZADOR LEXICO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizador/lexico/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1240, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void areasintacticoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areasintacticoKeyReleased

    }//GEN-LAST:event_areasintacticoKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
areacadena.setText("");
areacadena.requestFocus();     
DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
  for (int i = 0; i < tabla.getRowCount(); i++) {
           modelo.removeRow(i);
           i-=1;
  }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnlexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlexicoActionPerformed
        try {
        btnsintactico.setEnabled(true);//Habilita el boton Analizador sintactico
        verificar=1;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        Object[] fila=new Object[3];       
        String cadena=("(while|for|int|if|else|public|static|private|String|Double|println|boolean|char|class|this|void|return|System|do)|([a-zA-Z]+)|([0-9]+)|([{|}|>|<|=|-|+|/|*|;|.|,])");       
        Pattern p=Pattern.compile(cadena);
        Matcher matcher= p.matcher(areacadena.getText());
        while(matcher.find()){
            String token1=matcher.group(1);
            if (token1 !=null) {
                if (LS.BuscarNom(token1)==1) {   
                fila[0]=LS.BuscarID(token1);
                fila[1]=token1;
                fila[2]="PALABRA RESERVADA";
                modelo.addRow(fila);
                }else{
                codigo++;    
                fila[0]=codigo;
                fila[1]=token1;
                fila[2]="PALABRA RESERVADA";
                modelo.addRow(fila);
                tabla.setModel(modelo);
                Tablasimbolosreservada r=new Tablasimbolosreservada(codigo, token1,"PALABRA RESERVADA");
                LS.agregar(r);
                Globales.Grabarreservada();
                }

            }

            String token2=matcher.group(2);
            if (token2 !=null) {
                if (LU.BuscarNom(token2)==1) {   
                fila[0]=LU.BuscarID(token2);
                fila[1]=token2;
                fila[2]="VARIABLE";
                modelo.addRow(fila);
                }else{
                codigova++;    
                fila[0]=codigova;
                fila[1]=token2;
                fila[2]="VARIABLE";
                modelo.addRow(fila);
                tabla.setModel(modelo);
                Tablasimbolos s=new Tablasimbolos(codigova, token2,"VARIABLE");
                LU.agregar(s);
                Globales.GrabarVariables();
                }
            }

            String token3=matcher.group(3);
            if (token3 !=null) {
                if (LNU.BuscarNom(token3)==1) {   
                fila[0]=LNU.BuscarID(token3);
                fila[1]=token3;
                fila[2]="NUMEROS";
                modelo.addRow(fila);
                }else{
                codigonu++;    
                fila[0]=codigonu;
                fila[1]=token3;
                fila[2]="NUMEROS";
                modelo.addRow(fila);
                tabla.setModel(modelo);
                Tablanumeros n=new Tablanumeros(codigonu, token3,"NUMEROS");
                LNU.agregar(n);
                Globales.Grabarnu();
                }
            }

            String token4=matcher.group(4);
            if (token4 !=null) {
                if (LL.BuscarNom(token4)==1) {   
                fila[0]=LL.BuscarID(token4);
                fila[1]=token4;
                fila[2]="DELIMITADORES";
                modelo.addRow(fila);
                }else{
                codigode++;    
                fila[0]=codigode;
                fila[1]=token4;
                fila[2]="DELIMITADORES";
                modelo.addRow(fila);
                tabla.setModel(modelo);
                Tabladelimitadores d=new Tabladelimitadores(codigode, token4,"DELIMITADORES");
                LL.agregar(d);
                Globales.Grabardelimitadores();
                }
            }

        }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btnlexicoActionPerformed

    private void btnsintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsintacticoActionPerformed
        if (verificar==1) {
            System.out.println("11");
            if (variableif==9) {
                System.out.println("holaa");
            }
        }else{
        
        }
    }//GEN-LAST:event_btnsintacticoActionPerformed

    private void areacadenaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areacadenaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_areacadenaKeyReleased

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areacadena;
    private javax.swing.JTextArea areasintactico;
    private javax.swing.JButton btnlexico;
    private javax.swing.JButton btnsintactico;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
