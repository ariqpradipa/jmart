package com.AriqJmartFA;

import com.AriqJmartFA.dbjson.Serializable;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Complaint extends Serializable {

    Date date;
    public String desc;

    /**
     * complaint the product that user buy
     *
     * @param desc complaint description
     */
    public Complaint(String desc) {

        this.date = new Date();
        this.desc = desc;

    }

    /**
     * convert Complaint object to String
     *
     * @return date complaint and complaint description
     */
    public String toString() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String deskripsi = this.desc;
        String tanggal = dateFormat.format(this.date);

        return ("date=" + tanggal + ", desc=" + deskripsi);
        
    }
}
