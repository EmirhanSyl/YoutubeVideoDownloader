package com.mery.youtubevideodownloader.customcomponents;

import com.mery.youtubevideodownloader.MainFrame;
import com.mery.youtubevideodownloader.core.Config;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author emirs
 */
public class CCDownloadableItemForHR extends javax.swing.JPanel {

    private final int itagVideo;
    private final int itagAudio;
    private final String res;
    private final String fileType;

    private final String link;

    public CCDownloadableItemForHR(String res, String fileType, int itagVideo, int itagAudio) {
        initComponents();
        this.res = res;
        this.fileType = fileType;
        this.itagVideo = itagVideo;
        this.itagAudio = itagAudio;
        link = MainFrame.instance.getVideoUrl();

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
        loadingIconLabel = new javax.swing.JLabel();

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
        jPanel1.add(downloadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 10, 120, 40));

        videoResLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        videoResLabel.setForeground(new java.awt.Color(0, 0, 0));
        videoResLabel.setText("1080P HD");
        videoResLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel1.add(videoResLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 12, 150, 33));

        fileTypeLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        fileTypeLabel.setForeground(new java.awt.Color(0, 0, 0));
        fileTypeLabel.setText("MP4");
        jPanel1.add(fileTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 15, 120, 30));

        loadingIconLabel.setText(" ");
        jPanel1.add(loadingIconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 15, 30, 30));

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
        ImageIcon loading = new ImageIcon(System.getProperty("user.dir") + "\\assets\\icons\\spinning-wheel-mozo-little.gif");
        loadingIconLabel.setIcon(loading);
        loadingIconLabel.setVisible(true);
        downloadButton.setEnabled(false);

        executeDownloadCommand(itagAudio, false);
        executeDownloadCommand(itagVideo, true);

    }//GEN-LAST:event_downloadButtonActionPerformed

    private void mergeVideoAndAudio() {
        String[] paths = getAudioAndVideoPaths();

        File file = new File(paths[1]);
        String fileName = file.getName();
        String outputPath = "Merged_" + fileName.replace(".webm", ".mp4");

        JOptionPane.showMessageDialog(this, "Video And Audio Will Be Merging Now!", "Download Status Update", JOptionPane.INFORMATION_MESSAGE);
        try {
            String command = Config.interpreterLocation + " " + Config.pyModuleLocation
                    + "\\merger.py --videoPath \"" + paths[1] + "\" --audioPath \""
                    + paths[0] + "\" --outputPath \"" + Config.downloadLocation + "\\" + outputPath + "\"";

            Runtime runtime = Runtime.getRuntime();
            System.out.println("Merge Command: " + command);
            Process process = runtime.exec(command);

            readFile(new InputStreamReader(process.getInputStream()));
            readFile(new InputStreamReader(process.getErrorStream()));

            int exitCode = process.waitFor();
            System.out.println("Exit Code: " + exitCode);

            loadingIconLabel.setVisible(false);
            downloadButton.setEnabled(true);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(CCDownloadableItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String[] getAudioAndVideoPaths() {
        String[] result = new String[2];

        String filePath = Config.pyModuleLocation + "downloadedVideos.txt";

        ArrayList<String> lines = new ArrayList<>();
        try ( BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        result[0] = lines.get(lines.size() - 2);
        result[1] = lines.get(lines.size() - 1);
        return result;
    }

    private void executeDownloadCommand(int itag, boolean startMerge) {
        String command = Config.interpreterLocation + " " + Config.pyModuleLocation
                + "mainDownloader.py --videourl \"" + link + "\"" + " --download --itag " + itag
                + " --location \"" + Config.downloadLocation + "\"";

        Thread executionThread = new Thread(() -> {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(command.split("\\s+"));
                Process process = processBuilder.start();

                readFile(new InputStreamReader(process.getInputStream()));
                readFile(new InputStreamReader(process.getErrorStream()));

                // Wait for the process to finish
                int exitCode = process.waitFor();
                System.out.println("Exit Code: " + exitCode);

                if (exitCode == 0) {
                    JOptionPane.showMessageDialog(this, "Video/Audio Downloaded Successfully!", "Downloaded!", JOptionPane.INFORMATION_MESSAGE);

                    if (startMerge) {
                        mergeVideoAndAudio();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Something went wrong while downloading video/audio! See for more details in Error Log", "Download Error!", JOptionPane.ERROR_MESSAGE);
                    ImageIcon error = new ImageIcon(System.getProperty("user.dir") + "\\assets\\icons\\warning.png");
                    Image imgFit = error.getImage().getScaledInstance(350, 200, Image.SCALE_AREA_AVERAGING);
                    ImageIcon icon = new ImageIcon(imgFit);
                    loadingIconLabel.setIcon(icon);
                    downloadButton.setEnabled(true);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                Logger.getLogger(CCDownloadableItem.class.getName()).log(Level.SEVERE, null, e);
            }
        });
        executionThread.start();

    }

    private void readFile(Reader in) throws IOException {
        BufferedReader reader = new BufferedReader(in);
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mery.youtubevideodownloader.customcomponents.CCRoundedButton downloadButton;
    private javax.swing.JLabel fileTypeLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loadingIconLabel;
    private javax.swing.JLabel videoResLabel;
    // End of variables declaration//GEN-END:variables
}
