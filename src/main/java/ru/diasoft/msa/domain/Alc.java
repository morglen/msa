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
@Table(name="alc")
public class Alc {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ALC_SEQ")
    @SequenceGenerator(name = "ALC_SEQ", sequenceName = "ALC_SEQ", allocationSize = 1)
    private long id;

    @Basic
    @Column(name = "name")
    private String name;

    public Alc(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Alc(String name) {
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
