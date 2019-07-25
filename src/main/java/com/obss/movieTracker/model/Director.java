package com.obss.movieTracker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Director {

    @Id
    private int id;
    @Column
    private String directorName;
    @Column
    private String directorSurname;
    @Column
    private Date birthDate;
    @Column
    private Double birthPlace;

    /**
     * @param directorName
     * @param directorSurname
     * @param birthDate
     * @param birthPlace
     */

    public Director(String directorName, String directorSurname, Date birthDate, Double birthPlace) {
        this.directorName = directorName;
        this.directorSurname = directorSurname;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
    }

}