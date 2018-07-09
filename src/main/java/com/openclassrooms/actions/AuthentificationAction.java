package com.openclassrooms.actions;

import com.openclassrooms.biblioback.ws.test.AppUserValidityCheckRequest;
import com.openclassrooms.biblioback.ws.test.TestPort;
import com.openclassrooms.biblioback.ws.test.TestPortService;
import com.opensymphony.xwork2.ActionSupport;

public class AuthentificationAction extends ActionSupport {


    TestPortService service = new TestPortService();
    TestPort testPort = service.getTestPortSoap11();

    String email;
    String password;

    public String execute(){
        return SUCCESS;
    }

    public String checkUser(){

        AppUserValidityCheckRequest request = new AppUserValidityCheckRequest();
        testPort.appUserValidityCheck(request).getUser().setEmail(email);
        testPort.appUserValidityCheck(request).getUser().setPassword(email);

        return SUCCESS;
    }
}
