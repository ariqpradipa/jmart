package com.AriqJmartFA;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * Shipment plan
 */
public class Shipment {

    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy");
    public static Plan INSTANT  = new Plan((byte)(0b00000001));
    public static Plan SAME_DAY = new Plan((byte)(0b00000010));
    public static Plan NEXT_DAY = new Plan((byte)(0b00000100));
    public static Plan REGULER  = new Plan((byte)(0b00001000));
    public static Plan KARGO    = new Plan((byte)(0b00010000));
    public String address;
    public int cost;
    public byte plan;
    public String receipt;

    /**
     * Shipment object
     *
     * @param address sent address
     * @param cost shipment cost
     * @param plan shipment plan
     * @param receipt shipment receipt
     */
    public Shipment(String address, int cost, byte plan, String receipt) {

        this.address = address;
        this.cost = cost;
        this.plan = plan;
        this.receipt = receipt;

    }

    /**
     * shipment estimated arrive time
     *
     * @param reference date reference
     * @return arrive date
     */
    public String getEstimatedArrival(Date reference) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(reference);
        String strDate;

        if(this.plan == 0b00000001 || this.plan == 0b00000010) {

            strDate = ESTIMATION_FORMAT.format(cal.getTime());
            return strDate;

        }
        else if(this.plan == 0b00000100) {

            cal.add(Calendar.DATE, 1);
            strDate = ESTIMATION_FORMAT.format(cal.getTime());
            return strDate;
        }
        else if(this.plan == 0b00001000) {

            cal.add(Calendar.DATE, 2);
            strDate = ESTIMATION_FORMAT.format(cal.getTime());
            return strDate;

        }
        else if(this.plan == 0b00010000) {

            cal.add(Calendar.DATE, 3);
            strDate = ESTIMATION_FORMAT.format(cal.getTime());
            return strDate;

        }
        else {

            return null;

        }
    }

    /**
     * Shipment duration
     *
     * @param reference plan reference
     * @return boolean is duration
     */
    public boolean isDuration(Plan reference) {

        return (this.plan & reference.bit) != 0;

    }

    /**
     * Plan class
     */
    public static class Plan {

        byte bit;

        private Plan(byte bit) {

        }
    }
}
