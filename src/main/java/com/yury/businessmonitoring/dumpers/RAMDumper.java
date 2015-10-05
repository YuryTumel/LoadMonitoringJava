/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.businessmonitoring.dumpers;

import com.yury.businessmonitoring.interfaces.IDumper;
import com.yury.businessmonitoring.interfaces.IModel;
import com.yury.businessmonitoring.interfaces.IStorage;
import com.yury.businessmonitoring.models.RAMModel;

/**
 *
 * @author Юрий
 */
public class RAMDumper extends IDumper{

    public RAMDumper(IStorage storage) {
        super(storage);
    }
    
    @Override
    public int write(IModel model) {
        try {
            return storage.add((RAMModel) model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Couldn't write the entity " + model);
    }
}
