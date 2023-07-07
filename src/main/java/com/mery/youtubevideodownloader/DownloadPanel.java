package com.mery.youtubevideodownloader;

import com.mery.youtubevideodownloader.core.Config;
import com.mery.youtubevideodownloader.customcomponents.CCDownloadableItem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emirs
 */
public class DownloadPanel extends javax.swing.JPanel {

    public DownloadPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cCGradientPanel1 = new com.mery.youtubevideodownloader.customcomponents.CCGradientPanel();
        linkTextField = new javax.swing.JTextField();
        downloadButton = new com.mery.youtubevideodownloader.customcomponents.CCButtonGradient();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cCGradientPanel1.setFlipColor(true);
        cCGradientPanel1.setGradientEndd(new java.awt.Color(255, 255, 255));
        cCGradientPanel1.setGradientStart(new java.awt.Color(255, 255, 255));

        downloadButton.setText("DOWNLOAD");
        downloadButton.setColor1(new java.awt.Color(255, 51, 51));
        downloadButton.setColor2(new java.awt.Color(255, 0, 0));
        downloadButton.setMargin(new java.awt.Insets(2, 14, 3, 10));
        downloadButton.setSizeSpeed(3.0F);
        downloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadButtonActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Video URL:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout cCGradientPanel1Layout = new javax.swing.GroupLayout(cCGradientPanel1);
        cCGradientPanel1.setLayout(cCGradientPanel1Layout);
        cCGradientPanel1Layout.setHorizontalGroup(
            cCGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cCGradientPanel1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(cCGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cCGradientPanel1Layout.createSequentialGroup()
                        .addComponent(linkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(downloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        cCGradientPanel1Layout.setVerticalGroup(
            cCGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cCGradientPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cCGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(downloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        add(cCGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void downloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadButtonActionPerformed
        MainFrame.instance.setVideoUrl(linkTextField.getText());
        
        executeDownloadCommand();
    }//GEN-LAST:event_downloadButtonActionPerformed

     private void executeDownloadCommand() {
        Config conf = MainFrame.instance.getConfig();
        String link = linkTextField.getText();
        
        try {
            String command = conf.interpreterLocation + " mainDownloader.py --videourl \"" + link + "\"";
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(command);
            
            // Read the output from the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            // Wait for the process to finish
            try {
                int exitCode = process.waitFor();
                System.out.println("Exit Code: " + exitCode);
                
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
            Logger.getLogger(CCDownloadableItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mery.youtubevideodownloader.customcomponents.CCGradientPanel cCGradientPanel1;
    private com.mery.youtubevideodownloader.customcomponents.CCButtonGradient downloadButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField linkTextField;
    // End of variables declaration//GEN-END:variables
}
