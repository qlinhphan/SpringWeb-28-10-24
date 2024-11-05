package com.example.springWEB.domain.toDel;

import com.example.springWEB.domain.Roles;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "People")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String pass;
    private String image;

    // people n ->1 roles
    @ManyToOne
    @JoinColumn(name = "roless_id")
    private Roless roless;

    public Roless getRoless() {
        return roless;
    }

    public void setRoless(Roless roless) {
        this.roless = roless;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "People [id=" + id + ", name=" + name + ", pass=" + pass + ", image=" + image + ", roless=" + roless
                + "]";
    }

}
