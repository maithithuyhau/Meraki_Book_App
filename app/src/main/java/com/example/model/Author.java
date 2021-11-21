package com.example.model;

import java.util.Date;

public class Author {
    private String authorName, authorPlaceOfBirth, authorTotalBook;
    private Date authorBirth, authorDeath;
    private int authorImage, authorSummary;

    public Author(String authorName, String authorPlaceOfBirth, String authorTotalBook, Date authorBirth, Date authorDeath, int authorImage, int authorSummary) {
        this.authorName = authorName;
        this.authorPlaceOfBirth = authorPlaceOfBirth;
        this.authorTotalBook = authorTotalBook;
        this.authorBirth = authorBirth;
        this.authorDeath = authorDeath;
        this.authorImage = authorImage;
        this.authorSummary = authorSummary;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorPlaceOfBirth() {
        return authorPlaceOfBirth;
    }

    public void setAuthorPlaceOfBirth(String authorPlaceOfBirth) {
        this.authorPlaceOfBirth = authorPlaceOfBirth;
    }

    public String getAuthorTotalBook() {
        return authorTotalBook;
    }

    public void setAuthorTotalBook(String authorTotalBook) {
        this.authorTotalBook = authorTotalBook;
    }

    public Date getAuthorBirth() {
        return authorBirth;
    }

    public void setAuthorBirth(Date authorBirth) {
        this.authorBirth = authorBirth;
    }

    public Date getAuthorDeath() {
        return authorDeath;
    }

    public void setAuthorDeath(Date authorDeath) {
        this.authorDeath = authorDeath;
    }

    public int getAuthorImage() {
        return authorImage;
    }

    public void setAuthorImage(int authorImage) {
        this.authorImage = authorImage;
    }

    public int getAuthorSummary() {
        return authorSummary;
    }

    public void setAuthorSummary(int authorSummary) {
        this.authorSummary = authorSummary;
    }
}
