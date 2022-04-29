package com.zedapps.bookshare.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author Shamah M Zoha
 * @since 29-Apr-22
 */
@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "biography")
public class Author implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Temporal(TemporalType.DATE)
    private Date deathDate;

    private String biography;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

}
