/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.consoleapp;

import com.yury.businessmonitoring.monitors.RAMMonitor;
import com.yury.dbjdbc.dumpers.RAMDumper;
import com.yury.dbjdbc.storages.JdbcStorage;
import java.util.Scanner;

/**
 *
 * @author Юрий
 */
public class SystemMonitoring {
    public static void main(String[] args) throws InterruptedException {
        System.out.print("Wecome to monitoring! Press any key to stop: ");
        RAMMonitor ramMonitor = new RAMMonitor(new RAMDumper(new JdbcStorage()));
        ramMonitor.start();
        Scanner sc = new Scanner(System.in);
        sc.next();
        ramMonitor.stop();
        ramMonitor.getMonitoringThread().join();
        System.out.println("Monitoring is being terminated.");
    }
}