package com.openclassrooms.actions;

import com.openclassrooms.biblioback.ws.test.AppUserAddRequest;
import com.openclassrooms.biblioback.ws.test.TestPort;
import com.openclassrooms.biblioback.ws.test.TestPortService;
import com.openclassrooms.config.PropSource;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;
import java.util.List;


import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;


@Conversion()
public class IndexAction extends ActionSupport {

    TestPortService service = new TestPortService();
    TestPort port = service.getTestPortSoap11();

    private static Boolean firstTime = true;
    private Date now = new Date(System.currentTimeMillis());

    private PropSource propSource = new PropSource();

    private static final Logger log = Logger.getLogger(IndexAction.class);
    
    @TypeConversion(converter = "com.openclassrooms.DateConverter")
    public Date getDateNow() { return now; }
    
    public String execute(){

     //  if (firstTime == true){
     //      log.info("Entrée de nouveaux utilisateurs");
     //      AppUserAddRequest request = new AppUserAddRequest();

     //      request.setFirstName("Julien");
     //      request.setName("Cauwet");
     //      request.setEmail("juliencauwet@yahoo.fr");
     //      request.setPassword(toHashPassword("12345"));
     //      request.setIsAdmin(true);

     //      System.out.println("conf: " + port.appUserAdd(request).isConfirmation());


     //      firstTime = false;
     //  }
        log.info("Paramétrage des emprunts");
        propSource.setProp("4","4");
        return SUCCESS;
    }

    private String toHashPassword(String password){
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashed;
    }

}
