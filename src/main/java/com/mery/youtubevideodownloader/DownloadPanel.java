package com.mery.youtubevideodownloader;

import com.mery.youtubevideodownloader.core.Config;
import com.mery.youtubevideodownloader.core.IPage;
import com.mery.youtubevideodownloader.customcomponents.CCDownloadableItem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mery.youtubevideodownloader.customcomponents.CCDownloadableItemForHR;
import com.mery.youtubevideodownloader.customcomponents.CCScrollBar;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.FileReader;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

/**
 *
 * @author emirs
 */
public class DownloadPanel extends javax.swing.JPanel implements IPage {

    private final String ALL_FILTER = "All";
    private final String AUDIO_FILTER = "Audio";
    private final String VIDEO_FILTER = "Video";
    private final String PROGRESSIVE_FILTER = "Progressive";
    private final String HR_FILTER = "HighRes";

    private int highestQualityAudioItag = -1;

    public DownloadPanel() {
        initComponents();

        ImageIcon imgIcon = new ImageIcon(System.getProperty("user.dir") + "\\assets\\icons\\settings.png");
        Image imgFit = imgIcon.getImage().getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING);
        ImageIcon icon = new ImageIcon(imgFit);
        settingsButton.setIcon(icon);

        prepareDownloadGUI(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        cCGradientPanel1 = new com.mery.youtubevideodownloader.customcomponents.CCGradientPanel();
        linkTextField = new javax.swing.JTextField();
        downloadButton = new com.mery.youtubevideodownloader.customcomponents.CCButtonGradient();
        jLabel1 = new javax.swing.JLabel();
        downloadableElementsPanel = new javax.swing.JPanel();
        downloadableItemScrollPane = new javax.swing.JScrollPane();
        videoThumbLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        lengthLabel = new javax.swing.JLabel();
        settingsButton = new javax.swing.JButton();
        onlyAudioRB = new com.mery.youtubevideodownloader.customcomponents.CCRadioButton();
        onlyVideoRB = new com.mery.youtubevideodownloader.customcomponents.CCRadioButton();
        progressiveRB = new com.mery.youtubevideodownloader.customcomponents.CCRadioButton();
        highResolutionRB = new com.mery.youtubevideodownloader.customcomponents.CCRadioButton();
        filterText = new javax.swing.JLabel();

        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cCGradientPanel1.setGradientEndd(new java.awt.Color(255, 255, 255));
        cCGradientPanel1.setGradientStart(new java.awt.Color(255, 255, 255));
        cCGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        linkTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cCGradientPanel1.add(linkTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 105, 590, 54));

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
        cCGradientPanel1.add(downloadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 107, 256, 54));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Video URL:");
        cCGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 83, 272, -1));

        downloadableItemScrollPane.setForeground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout downloadableElementsPanelLayout = new javax.swing.GroupLayout(downloadableElementsPanel);
        downloadableElementsPanel.setLayout(downloadableElementsPanelLayout);
        downloadableElementsPanelLayout.setHorizontalGroup(
            downloadableElementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, downloadableElementsPanelLayout.createSequentialGroup()
                .addComponent(downloadableItemScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        downloadableElementsPanelLayout.setVerticalGroup(
            downloadableElementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(downloadableItemScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
        );

        cCGradientPanel1.add(downloadableElementsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 217, 510, -1));

        videoThumbLabel.setText(" ");
        cCGradientPanel1.add(videoThumbLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 217, 350, 200));

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setText(" ");
        cCGradientPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 167, 874, 38));

        lengthLabel.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lengthLabel.setForeground(new java.awt.Color(51, 51, 51));
        lengthLabel.setText(" ");
        cCGradientPanel1.add(lengthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 423, 358, 35));

        settingsButton.setBackground(new java.awt.Color(255, 255, 255));
        settingsButton.setForeground(new java.awt.Color(255, 255, 255));
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });
        cCGradientPanel1.add(settingsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1154, 6, 40, 40));

        onlyAudioRB.setBackground(new java.awt.Color(255, 102, 102));
        buttonGroup1.add(onlyAudioRB);
        onlyAudioRB.setText("Only Audio");
        onlyAudioRB.setContentAreaFilled(false);
        onlyAudioRB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        onlyAudioRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onlyAudioRBActionPerformed(evt);
            }
        });
        cCGradientPanel1.add(onlyAudioRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 502, 120, -1));

        onlyVideoRB.setBackground(new java.awt.Color(255, 102, 102));
        buttonGroup1.add(onlyVideoRB);
        onlyVideoRB.setText("Only Video");
        onlyVideoRB.setContentAreaFilled(false);
        onlyVideoRB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        onlyVideoRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onlyVideoRBActionPerformed(evt);
            }
        });
        cCGradientPanel1.add(onlyVideoRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 502, 120, -1));

        progressiveRB.setBackground(new java.awt.Color(255, 102, 102));
        buttonGroup1.add(progressiveRB);
        progressiveRB.setText("Progressive");
        progressiveRB.setContentAreaFilled(false);
        progressiveRB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        progressiveRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressiveRBActionPerformed(evt);
            }
        });
        cCGradientPanel1.add(progressiveRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 533, 120, -1));

        highResolutionRB.setBackground(new java.awt.Color(255, 102, 102));
        buttonGroup1.add(highResolutionRB);
        highResolutionRB.setText("High Resolution");
        highResolutionRB.setContentAreaFilled(false);
        highResolutionRB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        highResolutionRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highResolutionRBActionPerformed(evt);
            }
        });
        cCGradientPanel1.add(highResolutionRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 533, -1, -1));

        filterText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filterText.setForeground(new java.awt.Color(0, 0, 0));
        filterText.setText("Filters:");
        cCGradientPanel1.add(filterText, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 470, 147, 22));

        add(cCGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void downloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadButtonActionPerformed
        MainFrame.instance.setVideoUrl(linkTextField.getText());

        prepareDownloadGUI(true);
        executeDownloadCommand();
    }//GEN-LAST:event_downloadButtonActionPerformed

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        MainFrame.instance.setPage(MainFrame.instance.getSettingsPanel());
    }//GEN-LAST:event_settingsButtonActionPerformed


    private void onlyAudioRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onlyAudioRBActionPerformed
        analyseData(AUDIO_FILTER);
    }//GEN-LAST:event_onlyAudioRBActionPerformed

    private void onlyVideoRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onlyVideoRBActionPerformed
        analyseData(VIDEO_FILTER);
    }//GEN-LAST:event_onlyVideoRBActionPerformed

    private void progressiveRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressiveRBActionPerformed
        analyseData(PROGRESSIVE_FILTER);
    }//GEN-LAST:event_progressiveRBActionPerformed

    private void highResolutionRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highResolutionRBActionPerformed
        analyseData(HR_FILTER);
    }//GEN-LAST:event_highResolutionRBActionPerformed

    private void executeDownloadCommand() {
        String link = linkTextField.getText();

        try {
            String command = Config.interpreterLocation + " " + Config.pyModuleLocation + "mainDownloader.py --videourl \"" + link + "\"";
            Runtime runtime = Runtime.getRuntime();
            System.out.println(command);
            Process process = runtime.exec(command);

            Thread processOutputThread = new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(DownloadPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            processOutputThread.start();
            
            Thread processErrorThread = new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(DownloadPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            processErrorThread.start();
            
            try {
                int exitCode = process.waitFor();
                System.out.println("Exit Code: " + exitCode);

                processOutputThread.join();
                processErrorThread.join();
                
                analyseVideoInfo();
                analyseData(ALL_FILTER);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
            Logger.getLogger(CCDownloadableItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void analyseData(String filter) {
        String location = Config.pyModuleLocation;
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(location + "data.json")));
            //String jsonString = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "\\PythonDownloder\\data.json")));
            Gson gson = new Gson();

            // Parse the JSON string into a JsonElement
            JsonElement jsonElement = gson.fromJson(jsonString, JsonElement.class);

            // Convert the JsonElement to a JsonObject
            JsonObject jsonData = jsonElement.getAsJsonObject();

            // Access the data from the JSON object
            JsonArray onlyAudioStreamings = jsonData.getAsJsonArray("only_audio_Streamings");
            JsonArray onlyVideoStreamings = jsonData.getAsJsonArray("only_video_Streamings");
            JsonArray progressiveStreamings = jsonData.getAsJsonArray("progressive_Streamings");

            JPanel resultConteiner = new JPanel();
            resultConteiner.setBackground(new Color(245, 245, 245));
            resultConteiner.setSize(860, 100 * 5);
            GridLayout gridLayout = new GridLayout(onlyAudioStreamings.size() + onlyVideoStreamings.size() + progressiveStreamings.size(), 1);
            gridLayout.setVgap(5);
            resultConteiner.setLayout(gridLayout);

            if (filter.equals(ALL_FILTER) || filter.equals(AUDIO_FILTER)) {
                for (JsonElement streamElement : onlyAudioStreamings) {
                    JsonObject stream = streamElement.getAsJsonObject();
                    int itag = stream.get("itag").getAsInt();
                    String mimeType = stream.get("mime_type").getAsString();
                    String abr = stream.get("abr").getAsString();

                    resultConteiner.add(createDownloadElement(abr, mimeType, itag), 0);
                }
                gridLayout.setRows(onlyAudioStreamings.size() + 3);
            }

            if (filter.equals(ALL_FILTER) || filter.equals(VIDEO_FILTER)) {
                for (JsonElement streamElement : onlyVideoStreamings) {
                    JsonObject stream = streamElement.getAsJsonObject();
                    int itag = stream.get("itag").getAsInt();
                    String mimeType = stream.get("mime_type").getAsString();
                    String resolution = stream.get("resolution").getAsString();
                    int fps = stream.get("fps").getAsInt();

                    resultConteiner.add(createDownloadElement(resolution + " & " + fps + " FPS", mimeType, itag), 0);
                }
                gridLayout.setRows(onlyVideoStreamings.size() + 3);
            }

            if (filter.equals(HR_FILTER)) {
                int rowCount = 0;
                for (JsonElement streamElement : onlyVideoStreamings) {
                    JsonObject stream = streamElement.getAsJsonObject();
                    int itag = stream.get("itag").getAsInt();
                    String mimeType = stream.get("mime_type").getAsString();
                    String resolution = stream.get("resolution").getAsString();
                    int fps = stream.get("fps").getAsInt();

                    int res = Integer.parseInt(resolution.substring(0, resolution.length() - 1));
                    if (res > 720) {
                        rowCount++;

                        JsonObject highestAudioStream = onlyAudioStreamings.get(onlyAudioStreamings.size() - 1).getAsJsonObject();
                        highestQualityAudioItag = highestAudioStream.get("itag").getAsInt();
                        CCDownloadableItemForHR item = new CCDownloadableItemForHR(resolution + " & " + fps + " FPS", mimeType, itag, highestQualityAudioItag);
                        resultConteiner.add(item, 0);
                    }
                }
                gridLayout.setRows(rowCount + 3);
            }

            if (filter.equals(ALL_FILTER) || filter.equals(PROGRESSIVE_FILTER)) {
                for (JsonElement streamElement : progressiveStreamings) {
                    JsonObject stream = streamElement.getAsJsonObject();
                    int itag = stream.get("itag").getAsInt();
                    String mimeType = stream.get("mime_type").getAsString();
                    String resolution = stream.get("resolution").getAsString();
                    int fps = stream.get("fps").getAsInt();

                    resultConteiner.add(createDownloadElement(resolution + " & " + fps + " FPS", mimeType, itag), 0);
                }
                gridLayout.setRows(progressiveStreamings.size() + 3);
            }

            if (filter.equals(ALL_FILTER)) {
                gridLayout.setRows(onlyAudioStreamings.size() + onlyVideoStreamings.size() + progressiveStreamings.size());
            }

            downloadableItemScrollPane.setViewportView(resultConteiner);

            downloadableItemScrollPane.setVerticalScrollBar(new CCScrollBar());
            CCScrollBar sp = new CCScrollBar();
            sp.setOrientation(JScrollBar.HORIZONTAL);
            downloadableItemScrollPane.setHorizontalScrollBar(sp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void analyseVideoInfo() {
        String filePath = Config.pyModuleLocation + "videoInfo.txt";  // Replace with the actual file path

        try ( BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String thumbnailUrl = null;
            String title = null;
            int length = -1;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Thumbnail:")) {
                    thumbnailUrl = line.substring(line.indexOf(":") + 1).trim();
                } else if (line.startsWith("Title:")) {
                    title = line.substring(line.indexOf(":") + 1).trim();
                } else if (line.startsWith("Length:")) {
                    String lengthString = line.substring(line.indexOf(":") + 1).trim();
                    length = Integer.parseInt(lengthString);
                }
            }

            // Display the extracted information
            System.out.println("Thumbnail: " + thumbnailUrl);
            System.out.println("Title: " + title);
            MainFrame.instance.setTitle(title);
            System.out.println("Length: " + length);

            URL url = new URL(thumbnailUrl);
            Image thumbnail = ImageIO.read(url);
            Image imgFit = thumbnail.getScaledInstance(350, 200, Image.SCALE_AREA_AVERAGING);
            ImageIcon icon = new ImageIcon(imgFit);
            videoThumbLabel.setIcon(icon);
            titleLabel.setText(title);
            lengthLabel.setText(length / 60 + " Minute(s) " + length % 60 + " Second(s)");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CCDownloadableItem createDownloadElement(String res, String fileType, int itag) {
        CCDownloadableItem downloadableItem = new CCDownloadableItem(res, fileType, itag);
        downloadableItem.setSize(500, 70);

        return downloadableItem;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private com.mery.youtubevideodownloader.customcomponents.CCGradientPanel cCGradientPanel1;
    private com.mery.youtubevideodownloader.customcomponents.CCButtonGradient downloadButton;
    private javax.swing.JPanel downloadableElementsPanel;
    private javax.swing.JScrollPane downloadableItemScrollPane;
    private javax.swing.JLabel filterText;
    private com.mery.youtubevideodownloader.customcomponents.CCRadioButton highResolutionRB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lengthLabel;
    private javax.swing.JTextField linkTextField;
    private com.mery.youtubevideodownloader.customcomponents.CCRadioButton onlyAudioRB;
    private com.mery.youtubevideodownloader.customcomponents.CCRadioButton onlyVideoRB;
    private com.mery.youtubevideodownloader.customcomponents.CCRadioButton progressiveRB;
    private javax.swing.JButton settingsButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel videoThumbLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onPageSetted() {
        //String dir = System.getProperty("user.dir");
        //System.out.println(dir);
        //analyseData();
    }

    private void prepareDownloadGUI(boolean state) {
        titleLabel.setVisible(state);
        videoThumbLabel.setVisible(state);
        lengthLabel.setVisible(state);
        filterText.setVisible(state);
        onlyAudioRB.setVisible(state);
        onlyVideoRB.setVisible(state);
        progressiveRB.setVisible(state);
        highResolutionRB.setVisible(state);
        downloadableElementsPanel.setVisible(state);
    }
}
