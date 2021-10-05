package ru.diasoft.msa.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="drink")
public class Drink {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "DRINK_SEQ")
    @SequenceGenerator(name = "DRINK_SEQ", sequenceName = "DRINK_SEQ", allocationSize = 1)
    private long id;

    @Basic
    @Column(name = "name")
    private String name;

    public Drink(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Drink(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
