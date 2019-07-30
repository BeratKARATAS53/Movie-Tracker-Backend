package com.obss.movieTracker.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Director {

    Director() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String directorName;
    @Column
    private String directorSurname;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthDate;
    @Column
    private String birthPlace;

    @OneToMany
    @JoinColumn(name = "director_id")
    @JsonIgnore
    public Set<Movie> movies = new HashSet<>();

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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Director [id=" + id + "birthDate=" + birthDate + ", birthPlace=" + birthPlace + ", directorName="
                + directorName + ", directorSurname=" + directorSurname + "]";
    }

}