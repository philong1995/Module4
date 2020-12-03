package com.codegym.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBook;
    private String name;
    private String writer;
    private int amount;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_card",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "card_id")}
    )
    private List<LibraryCard> cardList;

    public Book() {
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<LibraryCard> getCardList() {
        return cardList;
    }

    public void setCardList(List<LibraryCard> cardList) {
        this.cardList = cardList;
    }
}