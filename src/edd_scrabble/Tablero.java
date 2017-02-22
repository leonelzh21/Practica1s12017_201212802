/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_scrabble;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Alejandro
 */
public class Tablero extends javax.swing.JFrame {

    /**
     * Creates new form Tablero
     */
    public Tablero() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        labelfichas = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        labelusuarios = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        labelmano = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        labeldiccionario = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        labelmatriz = new javax.swing.JLabel();
        txtnuevapalabra = new javax.swing.JTextField();
        btnagregarpalabra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jScrollPane1.setViewportView(labelfichas);

        jTabbedPane1.addTab("Fichas en Cola", jScrollPane1);

        jScrollPane2.setViewportView(labelusuarios);

        jTabbedPane1.addTab("Usuarios", jScrollPane2);

        jScrollPane3.setViewportView(labelmano);

        jTabbedPane1.addTab("Fichas en Mano", jScrollPane3);

        jScrollPane4.setViewportView(labeldiccionario);

        jTabbedPane1.addTab("Diccionario", jScrollPane4);

        jScrollPane5.setViewportView(labelmatriz);

        jTabbedPane1.addTab("Matriz", jScrollPane5);

        txtnuevapalabra.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        btnagregarpalabra.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnagregarpalabra.setText("Agregar");
        btnagregarpalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarpalabraActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setText("Nueva Palabra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(409, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtnuevapalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnagregarpalabra)
                        .addGap(86, 86, 86))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnuevapalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnagregarpalabra)
                    .addComponent(jLabel1))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        int cambiopestaño = jTabbedPane1.getSelectedIndex();
        try {
            switch(cambiopestaño){
                case 0:
                    //aqui se le dice que la seleccionar la pestaña se refresque la imagen del label
                    labelfichas.setIcon(new ImageIcon(ImageIO.read(new File ("src\\Imagenes\\fichas.jpg"))));
                break;
                case 1:
                    labelusuarios.setIcon(new ImageIcon(ImageIO.read(new File ("src\\Imagenes\\listausuarios.jpg"))));
                break;
                case 2:
                    labelmano.setIcon(new ImageIcon(ImageIO.read(new File ("src\\Imagenes\\lista.jpg"))));
                break;
                case 3:
                    InicioScrabble.diccionarioglobal.graficarDiccionario();
                    labeldiccionario.setIcon(new ImageIcon(ImageIO.read(new File ("src\\Imagenes\\lista.jpg"))));
                break;
                case 4:
                   labelmatriz.setIcon(new ImageIcon(ImageIO.read(new File ("src\\Imagenes\\matriz.jpg"))));
                break;
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void btnagregarpalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarpalabraActionPerformed
        // aqui vamos agregar una nueva palabra al diccionario
        String nuevapalabra = txtnuevapalabra.getText();
        InicioScrabble.diccionarioglobal.insertarPalabrafinal(nuevapalabra);
        InicioScrabble.diccionarioglobal.graficarDiccionario();
    }//GEN-LAST:event_btnagregarpalabraActionPerformed

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
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregarpalabra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labeldiccionario;
    private javax.swing.JLabel labelfichas;
    private javax.swing.JLabel labelmano;
    private javax.swing.JLabel labelmatriz;
    private javax.swing.JLabel labelusuarios;
    private javax.swing.JTextField txtnuevapalabra;
    // End of variables declaration//GEN-END:variables
}
