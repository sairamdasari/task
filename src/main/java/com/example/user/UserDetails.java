package com.example.user;

import java.sql.Timestamp;
import java.util.Date;

public class UserDetails {
    static int count = 1;
    public int id;
    public String name;
    public String user_name;
    public Timestamp created_date;
    Date date = new Date();
    UserDetails(String name, String user_name, Timestamp created_date) {
        this.id = count;
        this.name = name;
        this.user_name = user_name;
        this.created_date = new Timestamp(date.getTime());
        count++;
    }


    public String toString() {
        String value = String.valueOf(this.id) + " " + this.user_name + " " + this.name;
        //System.out.println(String.valueOf(this.id) + " " + this.user_name + " " + this.name);
        return value;

    }
}
