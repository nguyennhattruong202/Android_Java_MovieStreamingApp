package com.movie.moviestreamingapp.model;

public class BannerMovies {
    Integer id;
    String movieName;
    String imageUrl;
    String fileUrl;

    public BannerMovies(Integer id, String movieName, String imageUrl, String fileUrl) {
        this.id = id;
        this.movieName = movieName;
        this.imageUrl = imageUrl;
        this.fileUrl = fileUrl;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }
}
