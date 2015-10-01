/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.businessmonitoring.interfaces;

import java.util.Collection;

/**
 *
 * @author Юрий
 */
public interface IStorage {
    public <T extends IModel> int add(T model);
    public <T extends IModel> void edit(T model);
    public <T extends IModel> void delete(T model);
    public <T extends IModel> T get(final int id);
    public <T extends IModel> Collection<T> getList();
    public void close();
}
