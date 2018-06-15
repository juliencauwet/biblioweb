package com.openclassrooms.actions;


import com.opensymphony.xwork2.ActionSupport;
import wstarget.openclassrooms.biblioback.ws.*;

import java.util.List;

public class BookAction extends ActionSupport{


    BooksPortService booksPortService = new BooksPortService();
    BooksPort booksPort = booksPortService.getBooksPortSoap11();

    private List<Book> books = null;
    private Book book;


    @Override
    public String execute() throws Exception {

        return SUCCESS;
    }

    public String getBookByTitle(String title){
       // booksPort.getBook(new GetBookRequest().setTitle(title));
        return SUCCESS;
    }

    public String getAllBooks(){
        setBooks(booksPort.getAllBooks(new GetAllBooksRequest()).getGetAllBooks());

        return SUCCESS;
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
}
