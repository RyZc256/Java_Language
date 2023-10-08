package com.bean;

public class Book {
    private int id;
    private String bookname;
    private String author;
    private String press;
    private String pubdate;
    private float price;
    private String isbn;

    public int getId() {
        return id;
    }

    public String getBookname() {
        return bookname;
    }

    public String getAuthor() {
        return author;
    }

    public String getPress() {
        return press;
    }

    public String getPubdate() {
        return pubdate;
    }

    public float getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", pubdate='" + pubdate + '\'' +
                ", price=" + price +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
