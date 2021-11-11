package com.example.model;

public class Book {
    private String bookName, bookAuthor,bookPage, ebookPrice,bookPrice,bookPublisher, dateTime,loaiBia, bookSize;
    private int bookCategory, bookImage,bookSummary, bookFavorite;
    private float  bookStar;

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookPage(String bookPage) {
        this.bookPage = bookPage;
    }

    public void setEbookPrice(String ebookPrice) {
        this.ebookPrice = ebookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setLoaiBia(String loaiBia) {
        this.loaiBia = loaiBia;
    }

    public void setBookSize(String bookSize) {
        this.bookSize = bookSize;
    }

    public void setBookCategory(int bookCategory) {
        this.bookCategory = bookCategory;
    }

    public void setBookImage(int bookImage) {
        this.bookImage = bookImage;
    }

    public void setBookSummary(int bookSummary) {
        this.bookSummary = bookSummary;
    }

    public void setBookFavorite(int bookFavorite) {
        this.bookFavorite = bookFavorite;
    }

    public void setBookStar(float bookStar) {
        this.bookStar = bookStar;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookPage() {
        return bookPage;
    }

    public String getEbookPrice() {
        return ebookPrice;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getLoaiBia() {
        return loaiBia;
    }

    public String getBookSize() {
        return bookSize;
    }

    public int getBookCategory() {
        return bookCategory;
    }

    public int getBookImage() {
        return bookImage;
    }

    public int getBookSummary() {
        return bookSummary;
    }

    public int getBookFavorite() {
        return bookFavorite;
    }

    public float getBookStar() {
        return bookStar;
    }

    public Book(String bookName, String bookAuthor, String bookPage, String ebookPrice, String bookPrice, String bookPublisher, String dateTime, String loaiBia, String bookSize, int bookCategory, int bookImage, int bookSummary, int bookFavorite, float bookStar) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPage = bookPage;
        this.ebookPrice = ebookPrice;
        this.bookPrice = bookPrice;
        this.bookPublisher = bookPublisher;
        this.dateTime = dateTime;
        this.loaiBia = loaiBia;
        this.bookSize = bookSize;
        this.bookCategory = bookCategory;
        this.bookImage = bookImage;
        this.bookSummary = bookSummary;
        this.bookFavorite = bookFavorite;
        this.bookStar = bookStar;
    }
}
