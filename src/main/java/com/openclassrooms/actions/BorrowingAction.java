package com.openclassrooms.actions;

import com.openclassrooms.biblioback.ws.test.*;
import com.openclassrooms.config.PropSource;
import com.opensymphony.xwork2.ActionSupport;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

public class BorrowingAction extends ActionSupport{

    TestPortService service = new TestPortService();
    TestPort testPort = service.getTestPortSoap11();

    private int borrowingId;
    private AppUser appUser;
    private Book book;

    PropSource propSource = new PropSource();

    Date startDate;
    String message= "";

    public int getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(int borrowingId) {
        this.borrowingId = borrowingId;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String borrowThisBook(){
        BorrowingAddRequest request = new BorrowingAddRequest();
        XMLGregorianCalendar xmlCalendar = null;
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        try {
            DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();
            xmlCalendar = dataTypeFactory.newXMLGregorianCalendar(calendar);
        }
        catch (Exception e) {
            System.out.println("Exception dans la conversion XMLGregorianCalendar" + e);
        }

        request.setStartDate(xmlCalendar);

        if(testPort.borrowingAdd(request).isConfirmation())
            setMessage("L'emprunt a bien été enregistré. Veuillez s'il vous plait le retourner avant le ");
       else
           setMessage("L'emprunt n'a pas être effectué car vous avez déjà prolongé une fois votre emprunt");

        return SUCCESS;
    }

    public String extend(){
        BorrowingExtendRequest request = new BorrowingExtendRequest();
        request.setId(getBorrowingId());

       // Properties props= propSource.getProp();
       // props.setProperty("extension-duration");

        return SUCCESS;
    }


}
