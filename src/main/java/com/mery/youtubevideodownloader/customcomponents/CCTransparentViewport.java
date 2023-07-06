
package com.mery.youtubevideodownloader.customcomponents;

/**
 *
 * @author emirs
 */
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JViewport;

public class CCTransparentViewport extends JViewport {

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(0, 0, 0, 0));
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
}