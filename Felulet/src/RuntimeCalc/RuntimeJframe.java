/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RuntimeCalc;

import Generator.Genconf;
import Generator.Genpcb;
import Generator.feluletJFrame;
import Generator.tablazatJFrame;
import Graphs.graphCreation;
import Graphs.graphJFrame;
import Graphs.graphLoad;
import Graphs.graphSave;
import Start.CommonMethods;
import Start.MainMenu;
import Start.SplashScreen;
import static Start.SplashScreen.g;
import Tube.Graph;
import Tube.Product;
import Tube.SetUp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nimrod
 */
public class RuntimeJframe extends javax.swing.JFrame {

    /**
     * Creates new form Runtime
     */
    
    protected ArrayList<ArrayList> graph = new ArrayList<ArrayList>();
    public static boolean checked = false;
    public static boolean save = false;
    
    public RuntimeJframe() {
        initComponents();
        saveMath.setEnabled(false);
    }
    
    public void setSelected(boolean selected) {
    this.checked = selected;
}

public boolean isSelected() {
    return checked;
}
    
 
    
  
    public static String res;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        timeLimit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ConfPath = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PcbPath = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        runButton = new javax.swing.JButton();
        elapsedTime = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        SuccessFail = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        graphPath = new javax.swing.JTextField();
        saveMath = new javax.swing.JCheckBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        Result = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        mathFormula = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Runtime calculator");
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, -1));

        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });
        jPanel1.add(loadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, -1));

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 100, -1));

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/left menu bar komponensek.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        timeLimit.setText("Time");
        timeLimit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                timeLimitKeyReleased(evt);
            }
        });

        jLabel2.setText("Set time limit:");

        ConfPath.setText("Configuration file path...");

        jLabel3.setText("Loaded Conf:");

        PcbPath.setText("Pcb file path...");
        PcbPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PcbPathActionPerformed(evt);
            }
        });

        jLabel4.setText("Loaded Pcb:");

        jTextField4.setText("MIPGap");

        jLabel5.setText("Set MIPGap:");

        runButton.setText("Run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Elapsed time:");

        SuccessFail.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        SuccessFail.setForeground(new java.awt.Color(51, 153, 255));
        SuccessFail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SuccessFail.setText("Running...");

        jLabel7.setText("Loaded Graph:");

        graphPath.setText("Graph file path...");

        saveMath.setText("Save math formula");
        saveMath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMathActionPerformed(evt);
            }
        });

        Result.setColumns(20);
        Result.setRows(5);
        jScrollPane1.setViewportView(Result);

        jTabbedPane1.addTab("Result", jScrollPane1);

        mathFormula.setColumns(20);
        mathFormula.setRows(5);
        jScrollPane2.setViewportView(mathFormula);

        jTabbedPane1.addTab("Math formula", jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(graphPath)
                            .addComponent(PcbPath)
                            .addComponent(ConfPath)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(elapsedTime))
                            .addComponent(SuccessFail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(runButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(saveMath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(timeLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PcbPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(graphPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(timeLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveMath)
                        .addGap(3, 3, 3)
                        .addComponent(runButton)
                        .addGap(55, 55, 55)
                        .addComponent(SuccessFail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(elapsedTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
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
                ConfPath.setText(fnameconf);
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
                PcbPath.setText(fnamepcb);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(feluletJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        graph = graphCreation.create(SplashScreen.conf, SplashScreen.pcb);
        
        JFileChooser gconf=new JFileChooser();
        fcconf.setDialogTitle("Load Graph");
        int graphconf=gconf.showOpenDialog(this);
        if(graphconf==JFileChooser.APPROVE_OPTION)
        {
            String fname=gconf.getSelectedFile().getPath();
            try {
                graph = graphLoad.loadGraph(fname);
                graphPath.setText(fname);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(graphJFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) { 
                Logger.getLogger(graphJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_loadButtonActionPerformed

    private void PcbPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PcbPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PcbPathActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        CommonMethods.changed();
        this.dispose();
        new MainMenu().setVisible(true);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void timeLimitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timeLimitKeyReleased
        
    }//GEN-LAST:event_timeLimitKeyReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ImageIcon icon = new ImageIcon("material/icon.png");
        setIconImage(icon.getImage());
    }//GEN-LAST:event_formWindowActivated

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        //loading indicator --NOT WORK--
        int time = Integer.parseInt(timeLimit.getText());
        if(SplashScreen.pcbloaded && SplashScreen.confloaded){
            
         // ---------------------------------------------------   

            //converting b to an array
            int boardNum = SplashScreen.pcb.getB();
            int[] boards = new int[boardNum];
            for(int j=0;j<boardNum;j++){
                boards[j] = j;
            }
            
            SolveIP solveIp = new SolveIP(SplashScreen.conf,SplashScreen.pcb,boards,SplashScreen.g);
            System.out.println(time);
            
           
            System.out.println("The result: " + solveIp.solve(time));
            res = valueOf(solveIp.solve(time));
            
        }
        

        double elapse = SolveIP.seconds;
        double timeD = time;
        //time to string
        String s=String.valueOf(elapse);  
        //cut string
        String a = s.substring(0, 6);
        //Success - Failed indicator
        Result.setText("");
        if(elapse > timeD || SolveIP.ok == false){
            Result.setText("");
            System.out.println("Nem sikerült");
            SuccessFail.setText("Failed!");
            SuccessFail.setForeground(Color.red);
            elapsedTime.setText(a + "s");
            elapsedTime.setForeground(Color.red);
            Result.append("Time limit: " + time);
            Result.append("\n");
            Result.append("_______");
            Result.append("\n");
            Result.append("Failed");
            Result.append("\n");
            Result.append("_______");
            Result.append("\n");
            Result.append("\n");
            Result.append("The result: " + res);
            Result.append("\n");
        }else{
            Result.setText("");
            System.out.println("Sikerült");
            SuccessFail.setText("Success!");
            SuccessFail.setForeground(Color.green);
            elapsedTime.setText(a + "s");
            Result.append("Time limit: " + time + "s");
            Result.append("\n");
            Result.append("_______");
            Result.append("\n");
            Result.append("Success");
            Result.append("\n");
            Result.append("_______");
            Result.append("\n");
            Result.append("The result: " + res);
            Result.append("\n");
        }
        
        Result.append("Elapsed time: " + a + "s");
        Result.append("\n");
        
        saveMath.setEnabled(true);
        
    }//GEN-LAST:event_runButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
    int retval = fileChooser.showSaveDialog(saveButton);
    if (retval == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();
      if (file == null) {
        return;
      }
      if (!file.getName().toLowerCase().endsWith(".txt")) {
        file = new File(file.getParentFile(), file.getName() + ".txt");
      }
      try {
        Result.write(new OutputStreamWriter(new FileOutputStream(file),
            "utf-8"));
        Desktop.getDesktop().open(file);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
        save = true;
    
    }//GEN-LAST:event_saveButtonActionPerformed

    private void saveMathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMathActionPerformed
        //saveMath.isSelected()
        if(checked){
            checked = false;
        }else{
            checked = true; 
             }
        
        try {
            File myObj = new File("model.lp");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
              
                String[] temp;
                String delimiter = "\\n";
                temp = data.split(delimiter);
                for(int i =0; i < temp.length ; i++)
                    mathFormula.append(temp[i]+ "\n");
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        
        
                       
        
       
    }//GEN-LAST:event_saveMathActionPerformed

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
            java.util.logging.Logger.getLogger(RuntimeJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RuntimeJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RuntimeJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RuntimeJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RuntimeJframe().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ConfPath;
    private javax.swing.JTextField PcbPath;
    private javax.swing.JTextArea Result;
    private javax.swing.JLabel SuccessFail;
    private javax.swing.JTextField elapsedTime;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField graphPath;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton loadButton;
    private javax.swing.JTextArea mathFormula;
    private javax.swing.JButton runButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JCheckBox saveMath;
    private javax.swing.JTextField timeLimit;
    // End of variables declaration//GEN-END:variables

}
