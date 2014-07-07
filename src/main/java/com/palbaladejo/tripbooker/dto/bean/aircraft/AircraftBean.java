package com.palbaladejo.tripbooker.dto.bean.aircraft;

import java.util.Date;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class AircraftBean implements IAircraftBean{
    
    private String manufacter;
    private String model;
    private Date date;
    private int seats;

    @Override
    public String getManufacter() {
        return manufacter;
    }

    @Override
    public void setManufacter(String manufacter) {
        this.manufacter = manufacter;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int getSeats() {
        return seats;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "AircraftBean{" + "manufacter=" + manufacter + ", model=" + model + ", date=" + date + ", seats=" + seats + '}';
    }
}
