package com.developer.dinhduy.javaot;

public class Movie {
    private String TopMovie;
    private int Picture;
    private String Title;

    public Movie(String topMovie, int picture, String title) {
        TopMovie = topMovie;
        Picture = picture;
        Title = title;
    }

    public String getTopMovie() {
        return TopMovie;
    }

    public void setTopMovie(String topMovie) {
        TopMovie = topMovie;
    }

    public int getPicture() {
        return Picture;
    }

    public void setPicture(int picture) {
        Picture = picture;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
