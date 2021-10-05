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
@Table(name="cigs")
public class Cigs {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CIGS_SEQ")
    @SequenceGenerator(name = "CIGS_SEQ", sequenceName = "CIGS_SEQ", allocationSize = 1)
    private long id;

    @Basic
    @Column(name = "name")
    private String name;

    public Cigs(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Cigs(String name) {
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
