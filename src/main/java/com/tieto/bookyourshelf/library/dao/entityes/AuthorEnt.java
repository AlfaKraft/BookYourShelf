package com.tieto.bookyourshelf.library.dao.entityes;

import javax.persistence.*;

@Entity
@Table(name = "AUTHORS", schema = "bys_db")
public class AuthorEnt {
    public long id;
    //public String firstName;
    //public String lastName;
    public String authorName;



    public AuthorEnt(){
    }

    public AuthorEnt(String authorName) {
        this.authorName = authorName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
