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
@Table(name="auto")
public class Auto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "AUTO_SEQ")
    @SequenceGenerator(name = "AUTO_SEQ", sequenceName = "AUTO_SEQ", allocationSize = 1)
    private long id;

    @Basic
    @Column(name = "name")
    private String name;

    public Auto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Auto(String name) {
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
