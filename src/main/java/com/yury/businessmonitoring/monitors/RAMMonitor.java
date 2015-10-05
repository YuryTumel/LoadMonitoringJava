/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.businessmonitoring.monitors;

import com.sun.management.OperatingSystemMXBean;
import com.yury.businessmonitoring.interfaces.IMonitor;
import com.yury.businessmonitoring.interfaces.IDumper;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.yury.businessmonitoring.models.RAMModel;
import java.lang.management.ManagementFactory;

/**
 *
 * @author Юрий
 */
public class RAMMonitor extends IMonitor {

    public RAMMonitor(IDumper dumper) {
        super(dumper);
    }

    @Override
    protected void doMonitoring() {
        try {
            while (!monitoringThread.isInterrupted()) {

                int freeSize = ((Long) (ManagementFactory.
                        getPlatformMXBean(OperatingSystemMXBean.class).
                        getFreePhysicalMemorySize() / 1024 / 1024)).intValue();
                RAMModel ram = new RAMModel(freeSize);
                dumper.write(ram);
                Thread.sleep(1000);

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(RAMMonitor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dumper.close();
        }
    }
}
