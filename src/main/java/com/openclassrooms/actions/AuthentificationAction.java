package com.openclassrooms.actions;

import com.openclassrooms.biblioback.ws.test.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class AuthentificationAction extends ActionSupport implements SessionAware{

    private static final Logger log = LoggerFactory.getLogger(AuthentificationAction.class);


    TestPortService service = new TestPortService();
    TestPort testPort = service.getTestPortSoap11();

    String firstName;
    String name;
    String email;
    String password;
    String hashedPassword;
    AppUser appUser;

    public String execute(){
        return SUCCESS;
    }

    public String newAppUser(){
        AppUserAddRequest request = new AppUserAddRequest();
        request.setFirstName(firstName);
        request.setName(name);
        request.setEmail(email);
        request.setPassword(toHashPassword(password));
        if(testPort.appUserAdd(request).isConfirmation())
            return SUCCESS;
        else
            return INPUT;

    }

    public String checkUserValidity(){

        AppUserValidityCheckRequest request = new AppUserValidityCheckRequest();
        request.setEmail(email);
        request.setPassword(toHashPassword(password));
        try {
            System.out.println(testPort.appUserValidityCheck(request).getUser().getEmail());
            setAppUser(testPort.appUserValidityCheck(request).getUser());
            log.info("L'utilisateur est bien enregistré");
        }catch (NullPointerException e){
            addActionError("Il n'y a pas d'user");
            System.out.println("pas d'utilisateur");
        }


        if (appUser == null) {
            addActionError("il n'y a pas d'utilisateur");
            return ERROR;
        }

        if (appUser.getEmail().equals(email) && appUser.getPassword().equals(password))
            return SUCCESS;
        else
            return INPUT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSession(Map<String, Object> session) {

    }

    private String toHashPassword(String password){
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashed;
    }


}
