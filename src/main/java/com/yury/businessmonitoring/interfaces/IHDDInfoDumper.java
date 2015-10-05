/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.businessmonitoring.interfaces;

import com.yury.businessmonitoring.models.DriveModel;

/**
 *
 * @author Юрий
 */
public abstract class IHDDInfoDumper extends IDumper{

    public IHDDInfoDumper(IStorage storage) {
        super(storage);
    }
    
    public abstract DriveModel findDrive(String name);
    
    public abstract int writeDrive(DriveModel model);
}
