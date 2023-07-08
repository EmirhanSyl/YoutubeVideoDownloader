package com.mery.youtubevideodownloader;

import com.mery.youtubevideodownloader.core.Config;
import com.mery.youtubevideodownloader.core.IPage;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author emirs
 */
public class SettingsPanel extends javax.swing.JPanel implements IPage{

    public SettingsPanel() {
        initComponents();
        
        ImageIcon imgIcon = new ImageIcon(System.getProperty("user.dir") + "\\assets\\icons\\settings.png");
        Image imgFit = imgIcon.getImage().getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING);
        ImageIcon icon = new ImageIcon(imgFit);
        settingsButton.setIcon(icon);
        
        ImageIcon imgIcon2 = new ImageIcon(System.getProperty("user.dir") + "\\assets\\icons\\folder.png");
        Image imgFit2 = imgIcon2.getImage().getScaledInstance(45, 45, Image.SCALE_AREA_AVERAGING);
        ImageIcon icon2 = new ImageIcon(imgFit2);
        downloadLocBtn.setIcon(icon2);
        interpreterLocBtn.setIcon(icon2);
        pyModuleLocBtn.setIcon(icon2);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        downloadLocField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        settingsButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        interpreterLocField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pyModuleLocField = new javax.swing.JTextField();
        pyModuleLocBtn = new javax.swing.JButton();
        downloadLocBtn = new javax.swing.JButton();
        interpreterLocBtn = new javax.swing.JButton();
        saveButton = new com.mery.youtubevideodownloader.customcomponents.CCButtonGradient();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        downloadLocField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        downloadLocField.setToolTipText("File directory of the video to download");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Download Location:");
        jLabel1.setToolTipText("File directory of the video to download");

        settingsButton.setBackground(new java.awt.Color(255, 255, 255));
        settingsButton.setForeground(new java.awt.Color(255, 255, 255));
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Interpreter Location:");
        jLabel2.setToolTipText("It is important to ");

        interpreterLocField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("PyModule Location");

        pyModuleLocField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        pyModuleLocBtn.setBackground(new java.awt.Color(255, 255, 255));
        pyModuleLocBtn.setForeground(new java.awt.Color(255, 255, 255));
        pyModuleLocBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pyModuleLocBtnActionPerformed(evt);
            }
        });

        downloadLocBtn.setBackground(new java.awt.Color(255, 255, 255));
        downloadLocBtn.setForeground(new java.awt.Color(255, 255, 255));
        downloadLocBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadLocBtnActionPerformed(evt);
            }
        });

        interpreterLocBtn.setBackground(new java.awt.Color(255, 255, 255));
        interpreterLocBtn.setForeground(new java.awt.Color(255, 255, 255));
        interpreterLocBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interpreterLocBtnActionPerformed(evt);
            }
        });

        saveButton.setText("SAVE SETTINGS");
        saveButton.setColor1(new java.awt.Color(255, 51, 51));
        saveButton.setColor2(new java.awt.Color(255, 0, 0));
        saveButton.setMargin(new java.awt.Insets(2, 14, 3, 10));
        saveButton.setSizeSpeed(3.0F);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(457, 457, 457)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(downloadLocField)
                            .addComponent(interpreterLocField)
                            .addComponent(pyModuleLocField, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pyModuleLocBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(interpreterLocBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(downloadLocBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(241, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(settingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(settingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(downloadLocBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(downloadLocField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(interpreterLocField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(interpreterLocBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pyModuleLocField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pyModuleLocBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
             MainFrame.instance.setPage(MainFrame.instance.getDownloadPanel());
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void pyModuleLocBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pyModuleLocBtnActionPerformed
        String path = getChosenFilePath();
        if (!"".equals(path)) {
            Path file = Paths.get(path + "\\mainDownloader.py");
            if(Files.exists(file) && Files.isExecutable(file)){
                 pyModuleLocField.setText(path);
            }
            else{
                JOptionPane.showMessageDialog(this, "The required Python modules are not found or required privilages are not provided!", "File Path Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_pyModuleLocBtnActionPerformed

    private void downloadLocBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadLocBtnActionPerformed
        downloadLocField.setText(getChosenFilePath());
    }//GEN-LAST:event_downloadLocBtnActionPerformed

    private void interpreterLocBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interpreterLocBtnActionPerformed
        String path = getChosenFilePath();
        if (!"".equals(path)) {
            Path file = Paths.get(path + "\\python.exe");
            if(Files.exists(file) && Files.isExecutable(file)){
                 interpreterLocField.setText(path + "\\python.exe");
            }
            else{
                JOptionPane.showMessageDialog(this, "The required python.exe file not found!", "File Path Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_interpreterLocBtnActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Config.updateConfigFile(downloadLocField.getText(), pyModuleLocField.getText(), interpreterLocField.getText());
    }//GEN-LAST:event_saveButtonActionPerformed

    private String getChosenFilePath(){
        String fileLocation = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int userChoice = fileChooser.showSaveDialog(null);

        if (userChoice == JFileChooser.APPROVE_OPTION) {
            fileLocation = fileChooser.getSelectedFile().getPath();                
        } else if (userChoice == JFileChooser.CANCEL_OPTION) {
            System.out.println("Operation canceled by the user.");
        }
        
        return fileLocation;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton downloadLocBtn;
    private javax.swing.JTextField downloadLocField;
    private javax.swing.JButton interpreterLocBtn;
    private javax.swing.JTextField interpreterLocField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton pyModuleLocBtn;
    private javax.swing.JTextField pyModuleLocField;
    private com.mery.youtubevideodownloader.customcomponents.CCButtonGradient saveButton;
    private javax.swing.JButton settingsButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onPageSetted() {
        interpreterLocField.setText(Config.interpreterLocation);
        pyModuleLocField.setText(Config.pyModuleLocation);
        downloadLocField.setText(Config.downloadLocation);
    }
}
