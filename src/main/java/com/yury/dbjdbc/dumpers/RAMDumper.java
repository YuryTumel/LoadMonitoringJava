/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.dbjdbc.dumpers;

import com.yury.businessmonitoring.interfaces.IRAMDumper;
import com.yury.businessmonitoring.interfaces.IStorage;
import com.yury.businessmonitoring.models.RAMModel;

/**
 *
 * @author Юрий
 */
public class RAMDumper implements IRAMDumper{
    private final IStorage storage;
    
    public RAMDumper(IStorage storage) {
        this.storage = storage;
    }
    
    @Override
    public void write(RAMModel model) {
        storage.add(model);
    }

    @Override
    public void close() {
        storage.close();
    }
}
