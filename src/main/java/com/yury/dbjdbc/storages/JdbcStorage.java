/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.dbjdbc.storages;

import com.yury.businessmonitoring.interfaces.IModel;
import com.yury.businessmonitoring.interfaces.IStorage;
import com.yury.businessmonitoring.models.RAMModel;
import com.yury.dbjdbc.service.Settings;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Юрий
 */
public class JdbcStorage implements IStorage {
    private final Connection connection;
    
    private final String RAM_INSERT_QUERY = "INSERT INTO ram (free_memory, date) VALUES (?,?);"; 
    public JdbcStorage() {
        try {
            Settings settings = Settings.getInstance();
            Class.forName(settings.getDriver());
            connection = DriverManager.getConnection(settings.getURL(), settings.getUser(), settings.getPassword());
        } catch (Exception ex) {
            Logger.getLogger(JdbcStorage.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalStateException(ex);
        }
    }
    
    @Override
    public <T extends IModel> int add(T model) {
        PreparedStatement query = null;
        if (model instanceof RAMModel) {
            RAMModel ram = (RAMModel) model;
            try {
                query = connection.prepareStatement(RAM_INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
                query.setInt(1, ram.getFreeMemory());
                query.setTimestamp(2, new java.sql.Timestamp(ram.getDate().getTime()));
            } catch (SQLException ex) {
                Logger.getLogger(JdbcStorage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            query.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JdbcStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (ResultSet keys = query.getGeneratedKeys()) {            
            if (keys != null && keys.next())
                return keys.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(JdbcStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new IllegalStateException("Couldn't add a model");
    }

    @Override
    public <T extends IModel> void edit(T model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T extends IModel> void delete(T model) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public <T extends IModel> T get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public <T extends IModel> Collection<T> getList() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(JdbcStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
