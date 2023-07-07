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
import com.mery.youtubevideodownloader.customcomponents.CCScrollBar;
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
        downloadableItemScrollPane = new javax.swing.JScrollPane();
        videoThumbLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        lengthLabel = new javax.swing.JLabel();

        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cCGradientPanel1.setGradientEndd(new java.awt.Color(255, 255, 255));
        cCGradientPanel1.setGradientStart(new java.awt.Color(255, 255, 255));

        linkTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(downloadableItemScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(downloadableItemScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
        );

        videoThumbLabel.setText("jLabel2");

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setText("Why is Steam BANNING Games with AI?");

        lengthLabel.setForeground(new java.awt.Color(51, 51, 51));
        lengthLabel.setText("06.58");

        javax.swing.GroupLayout cCGradientPanel1Layout = new javax.swing.GroupLayout(cCGradientPanel1);
        cCGradientPanel1.setLayout(cCGradientPanel1Layout);
        cCGradientPanel1Layout.setHorizontalGroup(
            cCGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cCGradientPanel1Layout.createSequentialGroup()
                .addGroup(cCGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cCGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cCGradientPanel1Layout.createSequentialGroup()
                            .addGap(147, 147, 147)
                            .addGroup(cCGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(videoThumbLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lengthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(cCGradientPanel1Layout.createSequentialGroup()
                            .addGap(755, 755, 755)
                            .addComponent(downloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(cCGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(linkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(179, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cCGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cCGradientPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(videoThumbLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lengthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
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
                
                analyseVideoInfo();
                analyseData();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
            Logger.getLogger(CCDownloadableItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void analyseData() {
        String location = MainFrame.instance.getConfig().interpreterLocation;
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
            resultConteiner.setSize(860, 100 * 5);
            GridLayout gridLayout = new GridLayout(onlyAudioStreamings.size() + onlyVideoStreamings.size() + progressiveStreamings.size(), 1);
            gridLayout.setVgap(5);
            resultConteiner.setLayout(gridLayout);

            for (JsonElement streamElement : onlyAudioStreamings) {
                JsonObject stream = streamElement.getAsJsonObject();
                int itag = stream.get("itag").getAsInt();
                String mimeType = stream.get("mime_type").getAsString();
                String abr = stream.get("abr").getAsString();

                resultConteiner.add(createDownloadElement(abr, mimeType, itag), 0);
            }

            for (JsonElement streamElement : onlyVideoStreamings) {
                JsonObject stream = streamElement.getAsJsonObject();
                int itag = stream.get("itag").getAsInt();
                String mimeType = stream.get("mime_type").getAsString();
                String resolution = stream.get("resolution").getAsString();
                int fps = stream.get("fps").getAsInt();

                resultConteiner.add(createDownloadElement(resolution + " & " + fps + " FPS", mimeType, itag), 0);
            }

            // Loop through progressiveStreamings array
            for (JsonElement streamElement : progressiveStreamings) {
                JsonObject stream = streamElement.getAsJsonObject();
                int itag = stream.get("itag").getAsInt();
                String mimeType = stream.get("mime_type").getAsString();
                String resolution = stream.get("resolution").getAsString();
                int fps = stream.get("fps").getAsInt();
                
                resultConteiner.add(createDownloadElement(resolution + " & " + fps + " FPS", mimeType, itag), 0);
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
    
    private void analyseVideoInfo(){
        String filePath = MainFrame.instance.getConfig().interpreterLocation + "\\videoInfo.txt";  // Replace with the actual file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
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
            System.out.println("Length: " + length);
            
            URL url = new URL(thumbnailUrl);
            Image thumbnail = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(thumbnail);
            videoThumbLabel.setIcon(icon);
            titleLabel.setText(title);
            lengthLabel.setText(length/60 + " Minute(s) " + length % 60 + " Second(s)");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CCDownloadableItem createDownloadElement(String res, String fileType, int itag){
        CCDownloadableItem downloadableItem = new CCDownloadableItem(res, fileType, itag);
        downloadableItem.setSize(860, 70);
        
        return downloadableItem;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mery.youtubevideodownloader.customcomponents.CCGradientPanel cCGradientPanel1;
    private com.mery.youtubevideodownloader.customcomponents.CCButtonGradient downloadButton;
    private javax.swing.JScrollPane downloadableItemScrollPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lengthLabel;
    private javax.swing.JTextField linkTextField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel videoThumbLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onPageSetted() {
        //String dir = System.getProperty("user.dir");
        //System.out.println(dir);
        //analyseData();
    }
}
