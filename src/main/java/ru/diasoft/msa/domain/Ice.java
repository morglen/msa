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
@Table(name="ice")
public class Ice {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ICE_SEQ")
    @SequenceGenerator(name = "ICE_SEQ", sequenceName = "ICE_SEQ", allocationSize = 1)
    private long id;

    @Basic
    @Column(name = "name")
    private String name;

    public Ice(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Ice(String name) {
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
