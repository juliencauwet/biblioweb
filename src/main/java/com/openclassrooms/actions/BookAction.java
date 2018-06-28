package com.openclassrooms.actions;


import com.openclassrooms.biblioback.ws.test.*;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class BookAction extends ActionSupport{

    TestPortService service = new TestPortService();
    TestPort testPort = service.getTestPortSoap11();

    private List<Book> books = null;
    private Book book;

    private String title;
    private String authorFirstName;
    private String authorName;
    private int number;



    @Override
    public String execute() throws Exception {

        return SUCCESS;
    }

    public String getBookByTitle(){
        BookGetRequest request = new BookGetRequest();
        request.setTitle(title);
        book = testPort.bookGet(request).getBook();
        setTitle(book.getTitle());
        setAuthorFirstName(book.getAuthorFirstName());
        setAuthorName(book.getAuthorName());
        return SUCCESS;
    }

    public String getAllBooks(){
        setBooks(testPort.bookGetAll(new BookGetAllRequest()).getBookGetAll());
        return SUCCESS;
    }

    public String addBook() throws Exception {


        BookAddRequest request = new BookAddRequest();
        request.setAuthorFirstName(authorFirstName);
        request.setAuthorName(authorName);
        request.setTitle(title);
        request.setAvailableNumber(number);

        testPort.bookAdd(request);
        return "success";
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
