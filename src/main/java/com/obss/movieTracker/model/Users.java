package com.obss.movieTracker.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "username", "email" }))
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true, length = 50)
    private String username;
    @Column(unique = true, length = 100)
    private String email;
    @Column(length = 75)
    private String firstName;
    @Column(length = 75)
    private String lastName;
    @Column(length = 200)
    private String password;
    @Column
    private String role;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_movies", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "movie_id", referencedColumnName = "id") })
    private Set<Movie> movies = new HashSet<>();

    /**
     * @param username
     * @param email
     * @param firstName
     * @param lastName
     * @param password
     */

    public Users(String username, String email, String firstName, String lastName, String password) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public Users(String username, String email, String firstName, String lastName, String password, String role) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Users [email=" + email + ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName
                + ", movies=" + movies + ", password=" + password + ", role=" + role + ", username=" + username + "]";
    }

    /**
     * @param id
     * @param username
     * @param email
     * @param firstName
     * @param lastName
     * @param password
     * @param role
     * @param movies
     */
}