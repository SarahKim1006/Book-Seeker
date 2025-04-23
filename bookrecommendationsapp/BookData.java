package com.example.bookrecommendationsapp;

public class BookData {
    private int id;
    private String title;
    private String author;
    private String genre;
    private double rating;
    private int literatureLevel;
    private int coverImage;

    public BookData(int id, String title, String author, String genre, double rating, int literatureLevel, int coverImage) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.literatureLevel = literatureLevel;
        this.coverImage = coverImage;
    }

    // Getters and setters for all fields, including literatureLevel

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }
    public int getLiteratureLevel() {return literatureLevel; }
    public int getCoverImageUrl() {return coverImage; }
}
