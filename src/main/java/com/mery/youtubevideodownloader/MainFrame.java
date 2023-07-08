package com.mery.youtubevideodownloader;

import com.mery.youtubevideodownloader.core.Config;
import com.mery.youtubevideodownloader.core.IPage;
import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author emirs
 */
public class MainFrame extends javax.swing.JFrame {

    public static MainFrame instance; 
    private final DownloadPanel downloadPanel;
    
    private Config config;
    private String videoUrl;

    public MainFrame() {
        initComponents();
        
        downloadPanel = new DownloadPanel();
        
        config = new Config("", System.getProperty("user.dir") + "\\PythonDownloder\\", "E:\\Anaconda\\python.exe");
        this.add(mainPanel);
        setPage(downloadPanel);        
        
        this.setPreferredSize(new Dimension(1200, 600));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        ImageIcon icon = new ImageIcon("C:\\Users\\emirs\\Desktop\\pics\\appIcons\\logo.png");
        this.setIconImage(icon.getImage());
    }
    
    public DownloadPanel getDownloadPanel(){
        return downloadPanel;
    }
    
    public String getVideoUrl(){
        return videoUrl;
    }
    public void setVideoUrl(String videoUrl){
        this.videoUrl = videoUrl;
    }
    
    public Config getConfig(){
        return config;
    }
    public void setConfig(Config config){
        this.config = config;
    }
    
    public final void setPage(JPanel page) {
        mainPanel.removeAll();
        mainPanel.add(page);
        mainPanel.revalidate();
        mainPanel.repaint();
        System.out.println("Page Setted!");

        if (page instanceof IPage) {
            IPage iPage = (IPage) page;
            iPage.onPageSetted();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // ---------------- SINGLETON -----------------
                instance = new MainFrame();
                instance.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
