/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.businessmonitoring.interfaces;

import java.util.List;

/**
 *
 * @author Юрий
 */
public interface IStorage {
    public <T extends IModel> int add(T model);
    public <T extends IModel> void edit(T model);
    public <T extends IModel> void delete(T model);
    public <T extends IModel> T get(Class modelClass, final int id);
    public <T extends IModel> T get(Class modelClass, final Object propertyValue, String propertyName);
    public <T extends IModel> List<T> getList(Class modelClass, int count);
    public void close();
}
