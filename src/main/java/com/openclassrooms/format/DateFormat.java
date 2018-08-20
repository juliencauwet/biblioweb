package com.openclassrooms.format;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    public DateFormat(){
    }

    public String dateToString(Date date){

        SimpleDateFormat sdf= new SimpleDateFormat("dddd-MM-yyyy");
        return sdf.format(date);
    }
}
