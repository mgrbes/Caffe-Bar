/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.SimpleDateFormat;
import java.util.Date;
import util.HibernateUtil;
import util.Pomocno;

/**
 *
 * @author marko
 */
public class Izbornik extends javax.swing.JFrame {

    /**
     * Creates new form Izbornik
     */
    public Izbornik() {
        initComponents();
        setTitle(Pomocno.getNazivAplikacije());
        
        Vrijeme v = new Vrijeme();
        
        v.start();
        
    }

    
    
    private class Vrijeme extends Thread{

        SimpleDateFormat df = new SimpleDateFormat("dd. MM. yyyy. HH:mm:ss");
        
        @Override
        public void run() {
            try {
                lblVrijeme.setText(df.format(new Date()));
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                
            }
            run();
        }
        
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        lblVrijeme = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAplikacija = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmProgram = new javax.swing.JMenu();
        jmZaposlenik = new javax.swing.JMenuItem();
        jmStavka = new javax.swing.JMenuItem();
        jmPice = new javax.swing.JMenuItem();
        jmRacun = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        lblVrijeme.setText("Vrijeme");
        jToolBar1.add(lblVrijeme);

        jmAplikacija.setText("Aplikacija");

        jMenuItem1.setText("Izlaz");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmAplikacija.add(jMenuItem1);

        jMenuBar1.add(jmAplikacija);

        jmProgram.setText("Program");

        jmZaposlenik.setText("jMenuItem2");
        jmZaposlenik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmZaposlenikActionPerformed(evt);
            }
        });
        jmProgram.add(jmZaposlenik);

        jmStavka.setText("jMenuItem3");
        jmStavka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmStavkaActionPerformed(evt);
            }
        });
        jmProgram.add(jmStavka);

        jmPice.setText("jMenuItem4");
        jmPice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPiceActionPerformed(evt);
            }
        });
        jmProgram.add(jmPice);

        jmRacun.setText("jMenuItem5");
        jmRacun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRacunActionPerformed(evt);
            }
        });
        jmProgram.add(jmRacun);

        jMenuBar1.add(jmProgram);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 252, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       HibernateUtil.getSessionFactory().close();
        dispose();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmZaposlenikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmZaposlenikActionPerformed
      new ViewZaposlenik().setVisible(true);
    }//GEN-LAST:event_jmZaposlenikActionPerformed

    private void jmStavkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmStavkaActionPerformed
      new ViewStavka().setVisible(true);
    }//GEN-LAST:event_jmStavkaActionPerformed

    private void jmPiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPiceActionPerformed
    new ViewPice().setVisible(true);
    }//GEN-LAST:event_jmPiceActionPerformed

    private void jmRacunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRacunActionPerformed
        new ViewRacun().setVisible(true);
    }//GEN-LAST:event_jmRacunActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu jmAplikacija;
    private javax.swing.JMenuItem jmPice;
    private javax.swing.JMenu jmProgram;
    private javax.swing.JMenuItem jmRacun;
    private javax.swing.JMenuItem jmStavka;
    private javax.swing.JMenuItem jmZaposlenik;
    private javax.swing.JLabel lblVrijeme;
    // End of variables declaration//GEN-END:variables
}