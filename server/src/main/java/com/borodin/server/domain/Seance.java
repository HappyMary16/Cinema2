package com.borodin.server.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seance extends Entity {

    private Film film;

    private Date dateAdnTime;

    private Hall hall;

    private int priceTicket;
}
