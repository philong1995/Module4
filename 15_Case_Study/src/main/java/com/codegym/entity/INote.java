package com.codegym.entity;

import javax.persistence.*;

@Entity
public class INote {
    @Id
    @Column(name = "id_note")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tittle;

    private String content;

    @ManyToOne
    @JoinColumn(name = "id_inote_type",referencedColumnName = "id_inote_type")
    private INoteType iNoteType;

    public INote() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public INoteType getiNoteType() {
        return iNoteType;
    }

    public void setiNoteType(INoteType iNoteType) {
        this.iNoteType = iNoteType;
    }
}
