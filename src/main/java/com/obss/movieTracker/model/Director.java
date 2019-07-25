package com.obss.movieTracker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String directorName;
    @Column
    private String directorSurname;
    @Column
    private Date birthDate;
    @Column
    private String birthPlace;
    /*
     * @OneToMany(mappedBy = "owner") private Set<Movie> movies;
     */

    /**
     * @param directorName
     * @param directorSurname
     * @param birthDate
     * @param string
     */

    public Director(String directorName, String directorSurname, Date birthDate, String birthPlace) {
        this.directorName = directorName;
        this.directorSurname = directorSurname;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
    }

}