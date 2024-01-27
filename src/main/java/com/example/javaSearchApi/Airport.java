package com.example.javaSearchApi;



import jakarta.persistence.*;


@Entity
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String city;

    // Constructors, getters, and setters

    public Airport(Integer id, String city) {
        this.id = id;
        this.city = city;
    }

    public Airport() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}