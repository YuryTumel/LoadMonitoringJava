/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.businessmonitoring.interfaces;

/**
 *
 * @author Юрий
 */
public abstract class IDumper {
    protected IStorage storage;

    public IDumper(IStorage storage) {
        this.storage = storage;
    }
    
    public void close() { storage.close(); }
    
    public abstract int write(IModel model);
}
