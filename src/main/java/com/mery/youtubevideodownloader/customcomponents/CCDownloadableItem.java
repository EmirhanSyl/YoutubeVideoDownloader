package com.mery.youtubevideodownloader.customcomponents;

import com.mery.youtubevideodownloader.MainFrame;
import com.mery.youtubevideodownloader.core.Config;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emirs
 */
public class CCDownloadableItem extends javax.swing.JPanel {

    private final int itag;
    private final String res;
    private final String fileType;

    private String link;

    public CCDownloadableItem(String res, String fileType, int itag) {
        initComponents();
        this.res = res;
        this.fileType = fileType;
        this.itag = itag;
        //link = MainFrame.instance.getVideoUrl();

        videoResLabel.setText(res);
        fileTypeLabel.setText(fileType);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        downloadButton = new com.mery.youtubevideodownloader.customcomponents.CCRoundedButton();
        videoResLabel = new javax.swing.JLabel();
        fileTypeLabel = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        downloadButton.setForeground(new java.awt.Color(51, 51, 51));
        downloadButton.setBorderColor(new java.awt.Color(238, 174, 255));
        downloadButton.setColor(new java.awt.Color(255, 204, 255));
        downloadButton.setColorClick(new java.awt.Color(255, 102, 255));
        downloadButton.setColorOver(new java.awt.Color(255, 102, 204));
        downloadButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        downloadButton.setLabel("DOWNLOAD");
        downloadButton.setRadius(10);
        downloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadButtonActionPerformed(evt);
            }
        });
        jPanel1.add(downloadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 168, 40));

        videoResLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        videoResLabel.setForeground(new java.awt.Color(0, 0, 0));
        videoResLabel.setText("1080P HD");
        videoResLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel1.add(videoResLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 12, 150, 33));

        fileTypeLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        fileTypeLabel.setForeground(new java.awt.Color(0, 0, 0));
        fileTypeLabel.setText("MP4");
        jPanel1.add(fileTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 15, 160, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void downloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadButtonActionPerformed
        executeDownloadCommand();
    }//GEN-LAST:event_downloadButtonActionPerformed

    private void executeDownloadCommand() {
        Config conf = MainFrame.instance.getConfig();
        
        try {
            String command = conf.interpreterLocation + " mainDownloader.py --videourl \"" + link + "\"" + " --Download + --location \"" + conf.downloadLocation + "\" --itag " + itag;
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
    private com.mery.youtubevideodownloader.customcomponents.CCRoundedButton downloadButton;
    private javax.swing.JLabel fileTypeLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel videoResLabel;
    // End of variables declaration//GEN-END:variables
}
