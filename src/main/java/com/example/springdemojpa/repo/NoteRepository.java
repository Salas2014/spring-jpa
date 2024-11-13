package com.example.springdemojpa.repo;

import com.example.springdemojpa.dto.NoteDto;
import com.example.springdemojpa.entity.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("select new com.example.springdemojpa.dto.NoteDto(n.body, p.firstName, p.lastName) from Note n inner join n.person p")
    List<NoteDto> findAllNoteDto();

    Page<Note> findAll(Pageable pageable);
}


