/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.businessmonitoring.interfaces;

/**
 *
 * @author Юрий
 */
public abstract class IMonitor {
    protected IDumper dumper;
    protected Thread monitoringThread;
    
    protected abstract void doMonitoring();
    
    public IMonitor (IDumper dumper) {
        this.dumper = dumper;
    }
    
    public void start() {
        if (monitoringThread == null) {
            monitoringThread = new Thread(this::doMonitoring);
            monitoringThread.start();
        }
    }
    
    public void stop() { monitoringThread.interrupt(); }
    
    public Thread getMonitoringThread() { return monitoringThread; }
}
