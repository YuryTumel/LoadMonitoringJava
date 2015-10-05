/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.businessmonitoring.dumpers;

import com.yury.businessmonitoring.interfaces.IHDDInfoDumper;
import com.yury.businessmonitoring.interfaces.IModel;
import com.yury.businessmonitoring.interfaces.IStorage;
import com.yury.businessmonitoring.models.DriveModel;
import com.yury.businessmonitoring.models.HDDModel;

/**
 *
 * @author Юрий
 */
public class HDDDumper extends IHDDInfoDumper {

    public HDDDumper(IStorage storage) {
        super(storage);
    }

    @Override
    public int write(IModel model) {
        try {
            return storage.add((HDDModel) model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Couldn't write the entity " + model);
    }

    @Override
    public DriveModel findDrive(String name) {
        return storage.get(DriveModel.class, name, "label");
    }
    
    @Override
    public int writeDrive(DriveModel model) {
        try {
            return storage.add(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Couldn't write the entity " + model);
    }
}
