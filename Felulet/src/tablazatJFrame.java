
import Tube.Product;
import Tube.SetUp;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tanulo
 */
public class tablazatJFrame extends javax.swing.JFrame {
    
    private SetUp conf;
    private Product pcb;
    /**
     * Creates new form tablazatJFrame
     */
    
    public tablazatJFrame() {
        initComponents();
    }
    
   public tablazatJFrame(SetUp configuration, Product prod){
        initComponents();
        //C table
        DefaultTableModel modelc = (DefaultTableModel)cTable.getModel();  
        for(int i = 0; i < configuration.getH(); i++){
        modelc.addRow(new Object[]{"", "", ""});
        System.out.println(i);
        }
        
        
        
        for(int i = 0; i < configuration.getH(); i++){
                cTable.setValueAt((Object)(i+1), i, 0);
                for(int j = 0 ;j < configuration.getH(); j++){
                    String s = "0";
                     cTable.setValueAt((Object)s, j, 1);
                } 
        }
        //TPP table
        DefaultTableModel modeltpp = (DefaultTableModel)tppTable.getModel();  
        for(int i = 0; i < configuration.getH(); i++){
        modeltpp.addRow (new Object[]{"", "", ""});
        }
        for(int i = 0; i < configuration.getH(); i++){
                tppTable.setValueAt((Object)(i+1), i, 0);
                for(int j = 0 ;j < configuration.getH(); j++){
                    String s = "0";
                     tppTable.setValueAt((Object)s, j, 1);
                } 
        }
        //HN table
        DefaultTableModel modelhn = (DefaultTableModel)hnTable.getModel();
        modelhn.setColumnCount(1);
        modelhn.setRowCount(1);
        int temp = 0;
        for(int i = 0; i < configuration.getN()-1; i++){
            modelhn.addRow(new Object[]{"", "", ""});
            temp++;
        }
        for(int i = 0; i<configuration.getH(); i++){
            modelhn.addColumn(i+1,new Object[]{"","",""});
        } 
        
        
        for(int i = 0; i < configuration.getN(); i++){
                hnTable.setValueAt((Object)(i+1), i, 0);
                for(int j = 1 ;j < configuration.getH()+1; j++){
                    String s = "0";
                     hnTable.setValueAt((Object)s, i, j);
                } 
        }
        modelhn.setRowCount(temp+1);
        
        
        
        
        
        //W table
        DefaultTableModel modela = (DefaultTableModel)wTable.getModel();
        
        for(int i = 0; i < configuration.getA(); i++){
        modela.addRow(new Object[]{"", "", ""});
        }
        for(int i = 0; i < configuration.getA(); i++){
                wTable.setValueAt((Object)(i+1), i, 0);
                for(int j = 1 ;j < 2; j++){
                    String s = "0";
                     wTable.setValueAt((Object)s, i, j);
                } 
        }
        //AN table
        DefaultTableModel modelan = (DefaultTableModel)anTable.getModel();
        modelan.setColumnCount(1);
        modelan.setRowCount(1);
        temp = 0;
        for(int i = 0; i < configuration.getA()-1; i++){
            modelan.addRow(new Object[]{"", "", ""});
            temp++;
        }
        for(int i = 0; i<configuration.getN(); i++){
            modelan.addColumn(i+1,new Object[]{"","",""});
        } 
        for(int i = 0; i < configuration.getA(); i++){
            anTable.setValueAt((Object)(i+1), i, 0);
            for(int j = 1 ;j < configuration.getN()+1; j++){
                String s = "0";
                anTable.setValueAt((Object)s, i, j);
            } 
        }
        modelan.setRowCount(temp+1);
        //TTR table
        DefaultTableModel modelttr = (DefaultTableModel)ttrTable.getModel();  
        for(int i = 0; i < configuration.getH(); i++){
        modelttr.addRow(new Object[]{"", "", ""});
        }
        for(int i = 0; i < configuration.getH(); i++){
                ttrTable.setValueAt((Object)(i+1), i, 0);
                for(int j = 1 ;j < 2; j++){
                    String s = "0";
                     ttrTable.setValueAt((Object)s, i, j);
                } 
        }
        
        conf = configuration;
        pcb = prod;
    }
    
    
    private void gettables(){
        
        //grabs the h n a variables from the conf object
        int h = conf.getH();
        int n = conf.getN();
        int a = conf.getA();
        
        //arrays for the tables:
        //c = head capacity, tpp = pick and place time, w = component width,
        //hn = heads and nozzles compatibility, an = components and nozzles compatibility
        Object[] c = new Object[h];
        Object[] tpp = new Object[h];
        Object[] ttr = new Object[h];
        Object[] w = new Object[a];
        Object[][] nh = new Object[n][h];
        Object[][] an = new Object[a][n];
        //getting values from tables and placing them into arrays
        //note: getValueAt() returns an object, not an int!
        for(int i=0; i<c.length; i++){
            c[i]= cTable.getValueAt(i, 1);
        }
        for(int i=0; i<tpp.length; i++){
            tpp[i]= tppTable.getValueAt(i, 1);
        }
        for(int i=0; i<w.length; i++){
            w[i]= wTable.getValueAt(i, 1);
        }
        for(int i=0; i<ttr.length; i++){
            ttr[i]= ttrTable.getValueAt(i, 1);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<h; j++){
                nh[i][j]=hnTable.getValueAt(i, j+1);
            }
        }
        for(int i=0; i<a; i++){
            for(int j=0; j<n; j++){
                an[i][j]=anTable.getValueAt(i, j+1);
            }
        }
        
        conf.setC(c);
        conf.setTpp(tpp);
        conf.setW(w);
        conf.setNh(nh);
        conf.setTtr(ttr);
        conf.setAn(an);
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        newButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        componentButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        generalButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        wTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        cTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tppTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        anTable = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        hnTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ttrTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fej - Karok beállítása");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        jPanel3.add(newButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, -1));

        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        jPanel3.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 100, -1));

        loadButton.setText("Load");
        jPanel3.add(loadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, -1));

        componentButton.setText("Component");
        componentButton.setToolTipText("");
        componentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                componentButtonActionPerformed(evt);
            }
        });
        jPanel3.add(componentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, -1));

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel3.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 100, -1));

        generalButton.setText("Generate");
        generalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generalButtonActionPerformed(evt);
            }
        });
        jPanel3.add(generalButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/left menu bar karfej.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        wTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Component Width (W)"
            }
        ));
        jScrollPane1.setViewportView(wTable);
        if (wTable.getColumnModel().getColumnCount() > 0) {
            wTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            wTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        cTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Head capacity (C)"
            }
        ));
        jScrollPane2.setViewportView(cTable);
        if (cTable.getColumnModel().getColumnCount() > 0) {
            cTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            cTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        tppTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Head time (Tpp)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tppTable);
        if (tppTable.getColumnModel().getColumnCount() > 0) {
            tppTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            tppTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        anTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID"
            }
        ));
        anTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        anTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(anTable);
        if (anTable.getColumnModel().getColumnCount() > 0) {
            anTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            anTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        hnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID"
            }
        ));
        hnTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        hnTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hnTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(hnTable);
        if (hnTable.getColumnModel().getColumnCount() > 0) {
            hnTable.getColumnModel().getColumn(0).setMinWidth(50);
            hnTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            hnTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jLabel1.setText("Head / Nozzles compatibility (NH)");

        jLabel3.setText("Component / Nozzles (AN)");

        ttrTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Time to travel (Ttr)"
            }
        ));
        jScrollPane6.setViewportView(ttrTable);
        if (ttrTable.getColumnModel().getColumnCount() > 0) {
            ttrTable.getColumnModel().getColumn(0).setMinWidth(50);
            ttrTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            ttrTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        this.dispose();
        tablazatJFrame t= new tablazatJFrame(conf,pcb);
        t.setVisible(true);
    }//GEN-LAST:event_newButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        gettables();
        this.dispose();
        feluletJFrame f= new feluletJFrame(conf,pcb);
        f.setVisible(true);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void componentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_componentButtonActionPerformed
        gettables();
        this.dispose();
        termekekJFrame termek= new termekekJFrame(conf,pcb);
        termek.setVisible(true);
    }//GEN-LAST:event_componentButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ImageIcon icon = new ImageIcon("material/icon.png");
        setIconImage(icon.getImage());
    }//GEN-LAST:event_formWindowActivated

    private void hnTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hnTableMouseClicked
       int row = hnTable.rowAtPoint(evt.getPoint());
        int col = hnTable.columnAtPoint(evt.getPoint());
        if (hnTable.getModel().getValueAt(row, col) == "1" && col !=0 ) {
           hnTable.setValueAt("0", row, col);
        }else if(col != 0){
            hnTable.setValueAt("1", row, col);
        }

        
    }//GEN-LAST:event_hnTableMouseClicked

    private void anTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anTableMouseClicked
        int row = anTable.rowAtPoint(evt.getPoint());
        int col = anTable.columnAtPoint(evt.getPoint());
        if (anTable.getModel().getValueAt(row, col) == "1" && col!=0) {
           anTable.setValueAt("0", row, col);
        }else if ( col != 0){
            anTable.setValueAt("1", row, col);
        }

        
    }//GEN-LAST:event_anTableMouseClicked

    private void generalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalButtonActionPerformed
        final ImageIcon icon = new ImageIcon("icon_small.png");
        try {
            gettables();
            JFileChooser fcconf=new JFileChooser();
            fcconf.setDialogTitle("Save setup configuration");
            int retconf=fcconf.showSaveDialog(this);
            if(retconf==JFileChooser.APPROVE_OPTION)
            {
                String fnameconf=fcconf.getSelectedFile().getPath();
                Genconf.saveconf(conf, fnameconf);
                JOptionPane.showMessageDialog(null,"Succesfull Sava! \n "
                                                   + "Save path: "+fnameconf, "---Save---",JOptionPane.INFORMATION_MESSAGE, icon);
            }
            
            JFileChooser fcpcb=new JFileChooser();
            fcpcb.setDialogTitle("Save pcb configuration");
            int retpcb=fcpcb.showSaveDialog(this);
            if(retpcb==JFileChooser.APPROVE_OPTION)
            {
                String fnamepcb=fcpcb.getSelectedFile().getPath();
                Genpcb.savepcb(pcb, conf, fnamepcb);
                JOptionPane.showMessageDialog(null,"Succesfull Sava! \n "
                                                   + "Save path: "+fnamepcb, "---Save---",JOptionPane.INFORMATION_MESSAGE, icon);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(feluletJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_generalButtonActionPerformed

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
            java.util.logging.Logger.getLogger(tablazatJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tablazatJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tablazatJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablazatJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tablazatJFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable anTable;
    private javax.swing.JTable cTable;
    private javax.swing.JButton componentButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton generalButton;
    private javax.swing.JTable hnTable;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton newButton;
    private javax.swing.JTable tppTable;
    private javax.swing.JTable ttrTable;
    private javax.swing.JTable wTable;
    // End of variables declaration//GEN-END:variables
}
