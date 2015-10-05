package com.yury.businessmonitoring.models;

import com.yury.businessmonitoring.interfaces.IModel;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hdd")
public class HDDModel extends IModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drive")
    private DriveModel drive;
        
    @Column(name = "written", nullable = false)
    private LocalDateTime date;

    public HDDModel() {
    }

    public HDDModel(DriveModel drive, LocalDateTime date) {
        this.drive = drive;
        this.date = date;
    }

    public HDDModel(int ID, DriveModel drive, LocalDateTime date) {
        this.ID = ID;
        this.drive = drive;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public DriveModel getDrive() {
        return drive;
    }

    public void setDrive(DriveModel drive) {
        this.drive = drive;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
