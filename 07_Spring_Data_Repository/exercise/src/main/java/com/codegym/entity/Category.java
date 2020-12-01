package com.codegym.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "my_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<MyBlog> myBlogList;

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MyBlog> getMyBlogList() {
        return myBlogList;
    }

    public void setMyBlogList(List<MyBlog> myBlogList) {
        this.myBlogList = myBlogList;
    }
}
