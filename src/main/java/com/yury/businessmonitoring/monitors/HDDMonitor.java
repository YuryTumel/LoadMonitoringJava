/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.businessmonitoring.monitors;

import com.sun.management.OperatingSystemMXBean;
import com.yury.businessmonitoring.interfaces.IDumper;
import com.yury.businessmonitoring.interfaces.IHDDInfoDumper;
import com.yury.businessmonitoring.interfaces.IMonitor;
import com.yury.businessmonitoring.models.DriveModel;
import com.yury.businessmonitoring.models.HDDModel;
import com.yury.businessmonitoring.models.RAMModel;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Юрий
 */
public class HDDMonitor extends IMonitor {

    public HDDMonitor(IDumper dumper) {
        super(dumper);
    }

    @Override
    protected void doMonitoring() {
        try {
            while (!monitoringThread.isInterrupted()) {
                FileSystemView fsv = FileSystemView.getFileSystemView();
                for (File path : File.listRoots()) {
                    if (path.getFreeSpace() > 0) {
                        DriveModel drive = ((IHDDInfoDumper) dumper).findDrive(path.toString());
                        if (drive == null) {
                            drive = new DriveModel(path.toString(), fsv.getSystemTypeDescription(path));
                            ((IHDDInfoDumper) dumper).writeDrive(drive);
                        }
                        HDDModel hdd = new HDDModel(drive, LocalDateTime.now());
                        dumper.write(hdd);
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(RAMMonitor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dumper.close();
        }
    }
}
