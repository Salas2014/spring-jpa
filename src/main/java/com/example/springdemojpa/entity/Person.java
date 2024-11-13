package com.example.springdemojpa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persons")
@NoArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    @JsonManagedReference
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "person")
    private List<Note> notes = new ArrayList<>();
}
