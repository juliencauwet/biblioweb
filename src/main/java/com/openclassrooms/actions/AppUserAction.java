package com.openclassrooms.actions;

import com.openclassrooms.biblioback.ws.appuser.AppUser;
import com.openclassrooms.biblioback.ws.appuser.AppUserGetAllRequest;
import com.openclassrooms.biblioback.ws.appuser.AppUsersPort;
import com.openclassrooms.biblioback.ws.appuser.AppUsersPortService;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class AppUserAction extends ActionSupport{

    AppUsersPortService service = new AppUsersPortService();
    AppUsersPort port = service.getAppUsersPortSoap11();

    List<AppUser> appUsers = null;

    @Override
    public String execute() throws Exception {

       return SUCCESS;
    }

    public String getAllAppUsers(){
        setAppUsers(port.appUserGetAll(new AppUserGetAllRequest()).getGetAllAppUsers());
        return SUCCESS;
    }

    public List<AppUser> getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(List<AppUser> appUsers) {
        this.appUsers = appUsers;
    }
}
