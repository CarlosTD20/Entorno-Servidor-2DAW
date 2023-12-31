package com.fpmislata.movies.domain.entity;

import java.util.List;

public class Movie {
    private int id;
    private String title;
    private int year;
    private int runtime;
    //private List<Actor> actors;
    private Director director;
    private List<Character> characters;

    public Movie() {
    }


    public Movie(int id, String title, int year, int runtime) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.runtime = runtime;
    }

    public Movie(String title, int year, int runtime) {
        this.title = title;
        this.year = year;
        this.runtime = runtime;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getRuntime() {
        return runtime;
    }

    public Director getDirector() {
        return director;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", runtime=" + runtime +
                ", director=" + director +
                ", characters=" + characters +
                '}';
    }
}
