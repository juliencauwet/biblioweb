package com.openclassrooms.actions;

import com.openclassrooms.biblioback.ws.test.*;
import com.openclassrooms.config.PropSource;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.*;

public class BorrowingAction extends ActionSupport {

    private static final Logger log = LoggerFactory.getLogger(BorrowingAction.class);

    TestPortService service = new TestPortService();
    TestPort testPort = service.getTestPortSoap11();

    PropSource propSource = new PropSource();
    Properties props = propSource.getProps();

    Date startDate;
    String message = "";
    List<Borrowing> borrowings = null;
    Borrowing borrowing;

    HttpSession session = ServletActionContext.getRequest().getSession(false);
    private int id;
    private AppUser appUser = (AppUser)session.getAttribute("appUser");
    private Book book;
    private int bookId;


    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getBorrowingById(){
        BorrowingGetRequest request = new BorrowingGetRequest();
        request.setId(id);
        setBorrowing(testPort.borrowingGet(request).getBorrowing());
        return SUCCESS;
    }

    public String getCurrentBorrowings(){
        log.info("Entrée dans getCurrentBorrowings");
        BorrowingGetCurrentRequest request = new BorrowingGetCurrentRequest();
        AppUser appUser = (AppUser)session.getAttribute("appUser");
        // exemple à changer
        request.setUserId(appUser.getId());
        setBorrowings(testPort.borrowingGetCurrent(request).getBorrowingGetCurrent());
        return SUCCESS;
    }

    public String borrowThisBook() {

        if(session == null || session.getAttribute("appUser") == null)
            return LOGIN;

        BorrowingAddRequest request = new BorrowingAddRequest();
        XMLGregorianCalendar xmlCalendar = null;
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        xmlCalendar = toXmlGregorianCalendar(calendar);

        request.setStartDate(xmlCalendar);
        request.setAppUserId(appUser.getId());

        request.setBookId(bookId);

        if (testPort.borrowingAdd(request).isConfirmation())
            setMessage("L'emprunt a bien été enregistré. Veuillez s'il vous plait le retourner avant le " );
        else
            setMessage("L'emprunt n'a pas pu être effectué");

        return SUCCESS;
    }

    public String extend() {
        BorrowingExtendRequest request = new BorrowingExtendRequest();
        BorrowingGetRequest getRequest = new BorrowingGetRequest();

        //recherche l'emprunt par l'id
        getRequest.setId(id);
        Borrowing borrowing = testPort.borrowingGet(getRequest).getBorrowing();

        //Envoie les variables à la requête pour recevoir le code réponse
        request.setBorrowingId(id);
        request.setExtensionTime(7 * Integer.parseInt(props.getProperty("extension-duration")));
        int codeResp = testPort.borrowingExtend(request).getCodeResp();

        if(codeResp == 1 ) {
           message = "L'emprunt a été prolongé avec succès au ";
        }else if (codeResp == 2){
           message = "Le prolongement de l'emprunt n'a pas pu être effectué " ;
           return ERROR;
        }
        return SUCCESS;
    }

    public XMLGregorianCalendar toXmlGregorianCalendar(GregorianCalendar cal){
        try {
            DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();
            XMLGregorianCalendar calendar = dataTypeFactory.newXMLGregorianCalendar(cal);
            return calendar;
        } catch (Exception e) {
            log.error("Exception dans la conversion XMLGregorianCalendar \n" + e);
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int borrowingId) {
        this.id = borrowingId;
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

   // public String getStrStartDate() {
   //     return strStartDate;
   // }
//
   // public void setStrStartDate(String strStartDate) {
   //     this.strStartDate = strStartDate;
   // }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(List<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }

    public Borrowing getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(Borrowing borrowing) {
        this.borrowing = borrowing;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String changeDateFormat(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String newFormat = sdf.format(date);
        return newFormat;
    }

    public Date xmlGregToDate(XMLGregorianCalendar calendar){
        GregorianCalendar cal = calendar.toGregorianCalendar();
        Date date = cal.getTime();
        return date;
    }
    /*
     //convertit la date échéance de retour de xmlGregorianCal en GregorianCal puis ajoute la durée de l'extension dans
           GregorianCalendar calendar = borrowing.getDueReturnDate().toGregorianCalendar();
           calendar.add(Calendar.DAY_OF_MONTH,7 * (Integer.parseInt(props.getProperty("extension-duration"))));
           borrowing.setDueReturnDate(toXmlGregorianCalendar(calendar));
     */

}
