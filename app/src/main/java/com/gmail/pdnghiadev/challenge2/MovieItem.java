package com.gmail.pdnghiadev.challenge2;

import java.util.Date;

/**
 * Created by PDNghia on 7/29/2015.
 */
public class MovieItem {
    private long id;
    private String title;
    private Date date;
    private String poster;
    private Float vote;
    private Boolean selected;

    public MovieItem(){
        selected = false;
    }

    public MovieItem(long id,String title, Date date, String poster, Float vote) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.poster = poster;
        this.vote = vote;
        selected = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Float getVote() {
        return vote;
    }

    public void setVote(Float vote) {
        this.vote = vote;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
