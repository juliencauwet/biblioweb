package com.openclassrooms.actions;

import com.openclassrooms.config.PropSource;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;
import java.util.List;


import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;


@Conversion()
public class IndexAction extends ActionSupport {

    private Date now = new Date(System.currentTimeMillis());

    private PropSource propSource = new PropSource();
    
    @TypeConversion(converter = "com.openclassrooms.DateConverter")
    public Date getDateNow() { return now; }
    
    public String execute(){
        propSource.setProp("4","4");
        System.out.println(this.getClass().getClasses());
        return SUCCESS;
    }

}
