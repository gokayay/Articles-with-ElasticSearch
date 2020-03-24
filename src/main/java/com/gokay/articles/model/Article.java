package com.gokay.articles.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "articles")
public class Article {

    public Article(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Column
    private Date date;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private Integer clap;

}