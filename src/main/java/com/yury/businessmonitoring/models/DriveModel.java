/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.businessmonitoring.models;

import com.yury.businessmonitoring.interfaces.IModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Юрий
 */
@Entity
@Table(name = "drives")
public class DriveModel extends IModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;
    
    @Column(name = "label", nullable = false)
    private String label;
    
    @Column(name = "description")
    private String description;
    
    public DriveModel(int ID, String label, String description) {
        this.ID = ID;
        this.label = label;
        this.description = description;
    }

    public DriveModel(String label, String description) {
        this.label = label;
        this.description = description;
    }

    public DriveModel() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
