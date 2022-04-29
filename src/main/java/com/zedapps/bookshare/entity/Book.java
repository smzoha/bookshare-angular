package com.zedapps.bookshare.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Shamah M Zoha
 * @since 30-Apr-22
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "authors")
public class Book implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    private int pageNumber;

    @Temporal(TemporalType.DATE)
    private Date publishDate;

    @ElementCollection
    @Column(name = "tag")
    @CollectionTable(name = "book_tags", joinColumns = {@JoinColumn(name = "book_id")})
    private List<String> tags;

    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private List<Author> authors;

}
