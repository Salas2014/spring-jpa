package com.example.springdemojpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notes")
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@ToString
public class Note {
    @Id
    @GeneratedValue
    private Long id;
    private String body;

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "FK_notes_person"))
    private Person person;

}
