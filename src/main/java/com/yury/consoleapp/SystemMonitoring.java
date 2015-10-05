/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.consoleapp;

import com.yury.businessmonitoring.dumpers.HDDDumper;
import com.yury.businessmonitoring.dumpers.RAMDumper;
import com.yury.businessmonitoring.monitors.HDDMonitor;
import com.yury.businessmonitoring.monitors.RAMMonitor;
import com.yury.dbhibernate.storage.HibernateStorage;
import java.util.Scanner;

/**
 *
 * @author Юрий
 */
public class SystemMonitoring {
    public static void main(String[] args) throws InterruptedException {
        System.out.print("Wecome to monitoring! Press any key to stop: ");
        HibernateStorage storage = new HibernateStorage();
        RAMMonitor ramMonitor = new RAMMonitor(new RAMDumper(storage));
        HDDMonitor hddMonitor = new HDDMonitor(new HDDDumper(storage));
        //RAMMonitor ramMonitor = new RAMMonitor(new RAMDumper(new JdbcStorage()));
        ramMonitor.start();
        hddMonitor.start();
        Scanner sc = new Scanner(System.in);
        sc.next();
        ramMonitor.stop();
        hddMonitor.stop();
        ramMonitor.getMonitoringThread().join();
        hddMonitor.getMonitoringThread().join();
        System.out.println("Monitoring is being terminated.");
    }
}
