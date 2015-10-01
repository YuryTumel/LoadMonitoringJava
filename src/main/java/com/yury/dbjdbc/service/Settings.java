/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.dbjdbc.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

//Singleton
public class Settings {
    private static final Settings INSTANCE = new Settings();
    private final Properties properties = new Properties();
    
    private Settings() {
        try {
            properties.load(new FileInputStream(this.getClass().
                    getClassLoader().getResource("jdbc_config.properties").getFile()));
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Settings getInstance() { return INSTANCE; }
    
    public String getDriver() { return this.properties.getProperty("jdbc.driver"); }
    
    public String getURL() { return this.properties.getProperty("jdbc.url"); }
    
    public String getUser() { return this.properties.getProperty("jdbc.user"); }
    
    public String getPassword() { return this.properties.getProperty("jdbc.password"); }
}
