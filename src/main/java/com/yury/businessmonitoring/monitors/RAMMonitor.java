/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.businessmonitoring.monitors;

import com.sun.management.OperatingSystemMXBean;
import com.yury.businessmonitoring.interfaces.IMonitor;
import com.yury.businessmonitoring.interfaces.IRAMDumper;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.yury.businessmonitoring.models.RAMModel;
import java.lang.management.ManagementFactory;

/**
 *
 * @author Юрий
 */
public class RAMMonitor implements IMonitor {

    private boolean started;
    private final IRAMDumper dumper;
    private Thread monitoringThread;
    
    public RAMMonitor(IRAMDumper dumper) {
        this.dumper = dumper;
    }

    private void doMonitoring() {
        started = true;
        while (started) {
            try {
                int freeSize = ((Long) (ManagementFactory.
                        getPlatformMXBean(OperatingSystemMXBean.class).
                        getFreePhysicalMemorySize()/1024/1024)).intValue();
                RAMModel ram = new RAMModel(freeSize);
                dumper.write(ram);
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RAMMonitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void start() {
        monitoringThread = new Thread(this::doMonitoring);
        monitoringThread.start();
    }

    @Override
    public void stop() {
        started = false;
    }
    
    public Thread getMonitoringThread() {
        return monitoringThread;
    }
}
