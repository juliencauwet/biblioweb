package com.openclassrooms.actions;


import com.openclassrooms.biblioback.ws.*;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class BookAction extends ActionSupport{


    BooksPortService booksPortService = new BooksPortService();
    BooksPort booksPort = booksPortService.getBooksPortSoap11();

    private List<Book> books = null;
    private Book book;
    private String title;



    @Override
    public String execute() throws Exception {

        return SUCCESS;
    }

    public String getBookByTitle(){
        BookGetRequest request = new BookGetRequest();
        request.setTitle(title);
        book = booksPort.bookGet(request).getBook();
        return SUCCESS;
    }

    public String getAllBooks(){
        setBooks(booksPort.bookGetAll(new BookGetAllRequest()).getBookGetAll());

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
