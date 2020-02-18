
import Tube.Product;
import Tube.SetUp;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nimrod
 */
public class termekekJFrame extends javax.swing.JFrame {

    /**
     * Creates new form termekekJFrame
     */
    private static int a=0;
    private SetUp conf;
    private Product pcb;
    
    public termekekJFrame() {
         initComponents();
         
        
    }
   
    public termekekJFrame(SetUp configuration, Product prod){
            initComponents();
            a += configuration.getA();
            conf = configuration;
            System.out.println(configuration.getA());
            aTextfield.setEnabled(false);
            aTextfield.setText(Integer.toString(conf.getA()));
            pcb = prod;
        }
    
    private void getproducts(){
                
        pcb.setB(Integer.parseInt(bTextfield.getText()));
        Object[] p = new Object[pcb.getB()];
        Object[][] r = new Object[pcb.getB()][conf.getA()];
        
        //getting values from tables and placing them into arrays
        //note: getValueAt() returns an object, not an int!
        for(int i=0; i<p.length; i++){
            p[i]= pTable.getValueAt(i, 1);
        }
        
        for(int i=0; i<pcb.getB(); i++){
            
            for(int j=0; j<conf.getA(); j++){
                r[i][j]=rTable.getValueAt(i, j+1);
            }
        }
        
        pcb.setP(p);
        pcb.setR(r);
    }
       
             
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        newButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        generateButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        headnozzlesButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bTextfield = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        aTextfield = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        rTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Komponensek beállítása");
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        jPanel1.add(newButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, -1));

        loadButton.setText("Load");
        jPanel1.add(loadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, -1));

        generateButton.setText("Generate");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });
        jPanel1.add(generateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, -1));

        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 100, -1));

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 100, -1));

        headnozzlesButton.setText("Head-Nozzle");
        headnozzlesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                headnozzlesButtonActionPerformed(evt);
            }
        });
        jPanel1.add(headnozzlesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/left menu bar karfej.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        bTextfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bTextfieldFocusLost(evt);
            }
        });
        bTextfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bTextfieldMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bTextfieldMouseExited(evt);
            }
        });

        jScrollPane1.setViewportView(aTextfield);

        jLabel2.setText("Number of PCB (B):");

        jLabel3.setText("Set of component types (A):");

        pTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null}
            },
            new String [] {
                "ID", "1"
            }
        ));
        pTable.setFocusTraversalPolicyProvider(true);
        pTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(pTable);
        if (pTable.getColumnModel().getColumnCount() > 0) {
            pTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            pTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        rTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "ID", "1"
            }
        ));
        rTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        rTable.setRowSelectionAllowed(false);
        rTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(rTable);
        if (rTable.getColumnModel().getColumnCount() > 0) {
            rTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            rTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jLabel4.setText("Components (R)");

        jLabel5.setText("Batch size of each PCB type (P)");

        jLabel6.setText("B");

        jLabel7.setText("A");

        jLabel8.setText("B");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel4)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(bTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel6)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        
        this.dispose();
        termekekJFrame termek= new termekekJFrame(conf,pcb);
        termek.setVisible(true);
        
    }//GEN-LAST:event_newButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        getproducts();
        this.dispose();
        feluletJFrame f= new feluletJFrame(conf,pcb);
        f.setVisible(true);
        
    }//GEN-LAST:event_homeButtonActionPerformed

    private void headnozzlesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_headnozzlesButtonActionPerformed
        getproducts();
        this.dispose();
        tablazatJFrame t= new tablazatJFrame(conf,pcb);
        t.setVisible(true);
        
    }//GEN-LAST:event_headnozzlesButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ImageIcon icon = new ImageIcon("material/icon.png");
        setIconImage(icon.getImage());
    }//GEN-LAST:event_formWindowActivated

    private void bTextfieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bTextfieldMouseExited
        
    }//GEN-LAST:event_bTextfieldMouseExited

    private void bTextfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bTextfieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bTextfieldMouseClicked

    private void bTextfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bTextfieldFocusLost
        int b = Integer.parseInt(bTextfield.getText());
        DefaultTableModel modelr = (DefaultTableModel)rTable.getModel(); 
        
        
        
        //R táblázat
        modelr.setColumnCount(1);
        modelr.setRowCount(1);
        int temp = 0;
        for(int i = 0; i < a; i++){
                 modelr.addColumn(i+1,new Object[]{"", "", ""});
        }
        
        for(int i = 0; i < b-1; i++){
                 modelr.addRow(new Object[]{"", "", ""});
                 temp++;
        }
        for(int i = 0; i < b; i++){
            rTable.setValueAt((Object)(i+1), i, 0);
            for(int j = 1 ; j < a+1; j++){
                
                
                String s = "0";
            rTable.setValueAt((Object)s, i, j);

            }
        }
        modelr.setRowCount(temp+1);
        
        
        
        
        //P table
        DefaultTableModel modelp = (DefaultTableModel)pTable.getModel();
        modelp.setRowCount(1);
        for(int i = 0; i < b-1; i++){
                 modelp.addRow(new Object[]{"", "", ""});
        }
        for(int i = 0; i < b; i++){
                pTable.setValueAt((Object)(i+1), i, 0);
                for(int j = 1 ;j < 2; j++){
                    String s = "0";
                     pTable.setValueAt((Object)s, i, j);
                } 
        }
        
      // 
        
        
       
        
    }//GEN-LAST:event_bTextfieldFocusLost

    private void rTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rTableMouseClicked
       
        int row = rTable.rowAtPoint(evt.getPoint());
        int col = rTable.columnAtPoint(evt.getPoint());
        if (rTable.getModel().getValueAt(row, col) == "1" && col != 0) {
           rTable.setValueAt("0", row, col);
        }else if ( col != 0){
            rTable.setValueAt("1", row, col);
        }

        
    
    }//GEN-LAST:event_rTableMouseClicked

    private void pTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pTableMouseClicked
        
    }//GEN-LAST:event_pTableMouseClicked

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        try {
            getproducts();
            Genconf.saveconf(conf, "conf.txt");
            Genpcb.savepcb(pcb, conf, "pcb.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(feluletJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_generateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(termekekJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(termekekJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(termekekJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(termekekJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
               new termekekJFrame().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextPane aTextfield;
    public javax.swing.JTextField bTextfield;
    public javax.swing.JButton exitButton;
    public javax.swing.JButton generateButton;
    public javax.swing.JButton headnozzlesButton;
    public javax.swing.JButton homeButton;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JButton loadButton;
    public javax.swing.JButton newButton;
    public javax.swing.JTable pTable;
    public javax.swing.JTable rTable;
    // End of variables declaration//GEN-END:variables
}
