
import Tube.Product;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Tube.SetUp;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

//Class for the first sheet
public class feluletJFrame extends javax.swing.JFrame {
    
    //creating a conf object
    
    
    /**
     * Creates new form feluletJFrame
     */
    //method that runs when opening the sheet
    public feluletJFrame() {
        initComponents();
        setdata();
        check();
    }
    //method for setting the conf, pcb instances and the booleans to default
    private void changed(){
        SplashScreen.conf.setM(0);
        SplashScreen.conf.setH(0);
        SplashScreen.conf.setN(0);
        SplashScreen.conf.setA(0);
        SplashScreen.conf.setF(0);
        SplashScreen.conf.setC(null);
        SplashScreen.conf.setAn(null);
        SplashScreen.conf.setNh(null);
        SplashScreen.conf.setTpp(null);
        SplashScreen.conf.setTtr(null);
        SplashScreen.conf.setW(null);
        SplashScreen.pcb.setB(0);
        SplashScreen.pcb.setP(null);
        SplashScreen.pcb.setR(null);
        SplashScreen.pcbloaded = false;
        SplashScreen.confloaded = false;
        SplashScreen.pcbsaved = false;
        SplashScreen.confsaved = false;
    }
    
    //method for setting up the values of the conf instance
    private void getdata(){
        SplashScreen.conf.setM(Integer.parseInt(mTextfield.getText()));
        SplashScreen.conf.setH(Integer.parseInt(hTextfield.getText()));
        SplashScreen.conf.setN(Integer.parseInt(nTextfield.getText()));
        SplashScreen.conf.setA(Integer.parseInt(aTextfield.getText()));
        SplashScreen.conf.setF(Integer.parseInt(fTextfield.getText()));
        //m = modules, h = set of head types, n = set of nozzles, a = set of component types
        //f = feeder capacity
    }
    //method for reading values from the conf instance and placing them into the sheet
    private void setdata(){
        mTextfield.setText(Integer.toString(SplashScreen.conf.getM()));
        if(Integer.parseInt(mTextfield.getText()) == 0){
            mTextfield.setText("");
        }
        hTextfield.setText(Integer.toString(SplashScreen.conf.getH()));
        if(Integer.parseInt(hTextfield.getText()) == 0){
            hTextfield.setText("");
        }
        nTextfield.setText(Integer.toString(SplashScreen.conf.getN()));
        if(Integer.parseInt(nTextfield.getText()) == 0){
            nTextfield.setText("");
        }
        aTextfield.setText(Integer.toString(SplashScreen.conf.getA()));
        if(Integer.parseInt(aTextfield.getText()) == 0){
            aTextfield.setText("");
        }
        fTextfield.setText(Integer.toString(SplashScreen.conf.getF()));
        if(Integer.parseInt(fTextfield.getText()) == 0){
            fTextfield.setText("");
        }
        
        //m = modules, h = set of head types, n = set of nozzles, a = set of component types
        //f = feeder capacity
    }
    //method for checking the textfields if they contain any values
    //if they are empty then it colors them to red and also disables the headnozzles, generate and component buttons
    private void check(){
        //check every textfield. If the textfield is empty it will change its color to red
        
        //mTextField
        if(mTextfield.getText().isEmpty()){
            mTextfield.setBackground(Color.RED);
        }else{
            mTextfield.setBackground(Color.WHITE);
        }
        //hTextfield
        if(hTextfield.getText().isEmpty()){
            hTextfield.setBackground(Color.RED);
        }else{
            hTextfield.setBackground(Color.WHITE);
        }
        //nTextfield
        if(nTextfield.getText().isEmpty()){
            nTextfield.setBackground(Color.RED);
        }else{
            nTextfield.setBackground(Color.WHITE);
        }
        //aTextfield
        if(aTextfield.getText().isEmpty()){
            aTextfield.setBackground(Color.RED);
        }else{
            aTextfield.setBackground(Color.WHITE);
        }
        //fTextfield
        if(fTextfield.getText().isEmpty()){
            fTextfield.setBackground(Color.RED);
        }else{
            fTextfield.setBackground(Color.WHITE);
        }
        //enabling disabling buttons
        if(mTextfield.getText().isEmpty() || hTextfield.getText().isEmpty() || nTextfield.getText().isEmpty() || aTextfield.getText().isEmpty() || fTextfield.getText().isEmpty()){
            headnozzlesButton.setEnabled(false);
            generalButton.setEnabled(false);
            componentButton.setEnabled(false);
        }else{
            headnozzlesButton.setEnabled(true);
            generalButton.setEnabled(true);
            componentButton.setEnabled(true);
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

        jPanel2 = new javax.swing.JPanel();
        newButton = new javax.swing.JButton();
        headnozzlesButton = new javax.swing.JButton();
        generalButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        componentButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        hTextfield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        aTextfield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        mTextfield = new javax.swing.JTextField();
        fTextfield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nTextfield = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Főmenü - Alap adatok megadása");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newButton.setText("Restore");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        jPanel2.add(newButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 110, -1));

        headnozzlesButton.setText("Head-Nozzle");
        headnozzlesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                headnozzlesButtonActionPerformed(evt);
            }
        });
        jPanel2.add(headnozzlesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, -1));

        generalButton.setText("Generate");
        generalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generalButtonActionPerformed(evt);
            }
        });
        jPanel2.add(generalButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, -1));

        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });
        jPanel2.add(loadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, -1));

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel2.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 110, -1));

        componentButton.setText("Component");
        componentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                componentButtonActionPerformed(evt);
            }
        });
        jPanel2.add(componentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/left menu bar2.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 290));

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel1.setText("Assembly line moduls (m):");

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel2.setText("Set of head types (H):");

        hTextfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                hTextfieldFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel3.setText("Set of nozzles (N):");

        aTextfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                aTextfieldFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel4.setText("Set of component types (A):");

        mTextfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mTextfieldFocusLost(evt);
            }
        });

        fTextfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fTextfieldFocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel5.setText("Feederek capacity (F):");

        nTextfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nTextfieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(hTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(aTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //method for constructing and opening the tablazatJFrame sheet, also closes the current sheet after running the getdata() method
    private void headnozzlesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_headnozzlesButtonActionPerformed
      //set the head nozzle window button
        getdata();
      this.dispose();
      new tablazatJFrame().setVisible(true);
        
        
    }//GEN-LAST:event_headnozzlesButtonActionPerformed
    //method for closing the program
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        //set the exit button
        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed
    //method for opening the feluletJFrame sheet, it is used to reset the values to default
    //Note: if there were any files loaded, it resets the values to the state after loading
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        //set the restrore button 
        this.dispose();
        feluletJFrame f= new feluletJFrame();
        f.setVisible(true);
    }//GEN-LAST:event_newButtonActionPerformed
    //method for constructiong and opening the termekekJFrame sheet, also closes the current sheet after running getdata() method
    private void componentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_componentButtonActionPerformed
        //set the component window button
        getdata();
        this.dispose();
        termekekJFrame termek= new termekekJFrame();
        termek.setVisible(true);
        
    }//GEN-LAST:event_componentButtonActionPerformed
    //sets the icon of the sheet
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //set the icon
        ImageIcon icon = new ImageIcon("material/icon.png");
        setIconImage(icon.getImage());
    }//GEN-LAST:event_formWindowActivated
    //generates both the conf and pcb files
    private void generalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalButtonActionPerformed
        //set up the general button
        final ImageIcon icon = new ImageIcon("icon_small.png");
        try {
            getdata();
            //opens a filechooser window where the user can name and save the txt files where they want to
            JFileChooser fcconf=new JFileChooser();
            fcconf.setDialogTitle("Save setup configuration");
            int retconf=fcconf.showSaveDialog(this);
            if(retconf==JFileChooser.APPROVE_OPTION)
            {
                String fnameconf=fcconf.getSelectedFile().getPath();
                Genconf.saveconf(SplashScreen.conf, fnameconf);
                JOptionPane.showMessageDialog(null,"Succesfull Save! \n "
                                                   + "Save path: "+fnameconf, "---Save---",JOptionPane.INFORMATION_MESSAGE, icon);
            }
            
            JFileChooser fcpcb=new JFileChooser();
            fcpcb.setDialogTitle("Save pcb configuration");
            int retpcb=fcpcb.showSaveDialog(this);
            if(retpcb==JFileChooser.APPROVE_OPTION)
            {
                String fnamepcb=fcpcb.getSelectedFile().getPath();
                Genpcb.savepcb(SplashScreen.pcb, SplashScreen.conf, fnamepcb);
                JOptionPane.showMessageDialog(null,"Succesfull Save! \n "
                                                   + "Save path: "+fnamepcb, "---Save---",JOptionPane.INFORMATION_MESSAGE, icon);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(feluletJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_generalButtonActionPerformed
    //the following methods run once the user clicked outside of a textfield
    //they check if there are values in the textfields and resets the values of the other sheets to avoid future conflicts
    private void mTextfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mTextfieldFocusLost
       //check
        check();
       changed();
    }//GEN-LAST:event_mTextfieldFocusLost
    
    private void hTextfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hTextfieldFocusLost
        //check
        check();
        changed();
    }//GEN-LAST:event_hTextfieldFocusLost

    private void nTextfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nTextfieldFocusLost
        //check
        check();
        changed();
    }//GEN-LAST:event_nTextfieldFocusLost

    private void aTextfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aTextfieldFocusLost
        //check
        check();
        changed();
    }//GEN-LAST:event_aTextfieldFocusLost

    private void fTextfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fTextfieldFocusLost
        //check
        check();
        changed();
    }//GEN-LAST:event_fTextfieldFocusLost
    //method for loading values from the text files and placing them into the sheets
    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        //set up the load button
        final ImageIcon icon = new ImageIcon("icon_small.png");
        JFileChooser fcconf=new JFileChooser();
        fcconf.setDialogTitle("Load setup configuration");
        int retconf=fcconf.showOpenDialog(this);
        if(retconf==JFileChooser.APPROVE_OPTION)
        {
            try {
                String fnameconf=fcconf.getSelectedFile().getPath();
                SplashScreen.conf = Genconf.loadconf(fnameconf);
                JOptionPane.showMessageDialog(null,"Succesfull Load! \n "
                                                   + "Load path: "+fnameconf, "---Load---",JOptionPane.INFORMATION_MESSAGE, icon);
                SplashScreen.confloaded = true;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(feluletJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JFileChooser fcpcb=new JFileChooser();
        fcpcb.setDialogTitle("Load pcb configuration");
        int retpcb=fcpcb.showOpenDialog(this);
        if(retpcb==JFileChooser.APPROVE_OPTION)
        {
            try {
                String fnamepcb=fcpcb.getSelectedFile().getPath();
                SplashScreen.pcb = Genpcb.loadpcb(fnamepcb, SplashScreen.conf);
                JOptionPane.showMessageDialog(null,"Succesfull Load! \n "
                                                   + "Load path: "+fnamepcb, "---Load---",JOptionPane.INFORMATION_MESSAGE, icon);
                SplashScreen.pcbloaded = true;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(feluletJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setdata();
        check();
    }//GEN-LAST:event_loadButtonActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(feluletJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(feluletJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(feluletJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(feluletJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aTextfield;
    private javax.swing.JButton componentButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField fTextfield;
    private javax.swing.JButton generalButton;
    private javax.swing.JTextField hTextfield;
    private javax.swing.JButton headnozzlesButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loadButton;
    public static javax.swing.JTextField mTextfield;
    private javax.swing.JTextField nTextfield;
    private javax.swing.JButton newButton;
    // End of variables declaration//GEN-END:variables
}
