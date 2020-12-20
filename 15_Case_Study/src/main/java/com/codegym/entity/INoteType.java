package com.codegym.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inote_type")
public class INoteType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inote_type")
    private Integer id;

    @Column(name = "name_inote_type")
    private String name;

    @Column(name = "description_inote_type")
    private String description;

    @OneToMany(mappedBy = "iNoteType",cascade = CascadeType.ALL)
    private List<INote> INotes;

    public INoteType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<INote> getINotes() {
        return INotes;
    }

    public void setINotes(List<INote> INotes) {
        this.INotes = INotes;
    }
}
