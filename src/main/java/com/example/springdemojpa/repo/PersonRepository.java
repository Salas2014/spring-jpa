package com.example.springdemojpa.repo;

import com.example.springdemojpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Override
    @Query("select p from Person p left join fetch p.notes")
    List<Person> findAll();
}
