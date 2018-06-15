package com.openclassrooms.actions;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;
import java.util.List;


import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import wstarget.openclassrooms.biblioback.ws.*;


@Conversion()
public class IndexAction extends ActionSupport {

    List<Book> books = null;

    private Date now = new Date(System.currentTimeMillis());
    
    @TypeConversion(converter = "com.openclassrooms.DateConverter")
    public Date getDateNow() { return now; }
    
    public String execute() throws Exception {

        BooksPortService booksPortService = new BooksPortService();
        BooksPort booksPort = booksPortService.getBooksPortSoap11();
        setBooks(booksPort.getAllBooks(new GetAllBooksRequest()).getGetAllBooks());

        return SUCCESS;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
