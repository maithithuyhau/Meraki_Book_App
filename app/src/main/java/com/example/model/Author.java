package com.example.model;

import java.util.Date;

public class Author {
    private String authorName, authorPlaceOfBirth, authorTotalBook, authorSummary, authorBirth, authorDeath;
    private int authorImage;

    public Author(String authorName, String authorPlaceOfBirth, String authorTotalBook, String authorBirth, String authorDeath, int authorImage, String authorSummary) {
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

    public void setAuthorName(String authorName1) {
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

    public String getAuthorBirth() {
        return authorBirth;
    }

    public void setAuthorBirth(String authorBirth) {
        this.authorBirth = authorBirth;
    }

    public String getAuthorDeath() {
        return authorDeath;
    }

    public void setAuthorDeath(String authorDeath) {
        this.authorDeath = authorDeath;
    }

    public int getAuthorImage() {
        return authorImage;
    }

    public void setAuthorImage(int authorImage) {
        this.authorImage = authorImage;
    }

    public String getAuthorSummary() {
        return authorSummary;
    }

    public void setAuthorSummary(String authorSummary) {
        this.authorSummary = authorSummary;
    }
}
