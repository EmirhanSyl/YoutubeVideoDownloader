
package com.mery.youtubevideodownloader.core;

/**
 *
 * @author emirs
 */
public class Config {
    public String downloadLocation;
    public String pyModuleLocation;
    public String interpreterLocation;

    public Config(String downloadLocation, String pyModuleLocation, String interpreterLocation) {
        this.downloadLocation = downloadLocation;
        this.pyModuleLocation = pyModuleLocation;
        this.interpreterLocation = interpreterLocation;
    }
    
    
    
    
}
