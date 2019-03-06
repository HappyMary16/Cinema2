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

    private String describe;

    private Integer minAge;

    private List<Genre> genres;

    private List<Person> directors;

    private List<Person> actors;

    private List<Studio> studios;

    private List<Country> countries;

    private Integer duration;

    private Language language;

    private Date firstSeance;

    private Date lastSeance;

    private File smallPoster;

    private File bigPoster;

    private String trailerLink;

    private int year;

}

