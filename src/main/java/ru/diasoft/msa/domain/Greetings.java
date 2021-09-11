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
@Table(name="greetings")
public class Greetings {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "GREETINGS_SEQ")
    @SequenceGenerator(name = "GREETINGS_SEQ", sequenceName = "GREETINGS_SEQ", allocationSize = 1)
    private long id;

    @Basic
    @Column(name = "content")
    private String content;

    public Greetings(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Greetings(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
