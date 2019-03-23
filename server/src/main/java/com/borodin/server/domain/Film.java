package com.borodin.server.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film extends Entity {

    private String title;

    private String description;

    private Integer minAge;

    private List<Genre> genres;

    private List<Person> directors;

    private List<Person> actors;

    private List<Studio> studios;

    private List<Country> countries;

    private int duration;

    private Language language;

    private Date firstSeance;

    private Date lastSeance;

    private String smallPoster;

    private String bigPoster;

    private String trailerLink;

    private int year;

}

