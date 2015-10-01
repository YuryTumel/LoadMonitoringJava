/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.businessmonitoring.interfaces;

import com.yury.businessmonitoring.models.RAMModel;

/**
 *
 * @author Юрий
 */
public interface IRAMDumper {
    public void write(RAMModel model);
    public void close();
}
