package com.example.springdemojpa.controller;

import com.example.springdemojpa.dto.NoteDto;
import com.example.springdemojpa.entity.Note;
import com.example.springdemojpa.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    public List<NoteDto> findAllNoteDto() {
        return noteService.findAll();
    }

    @GetMapping("/pagination")
    public Page<Note> findAllNoteDto(Pageable pageable) {
        return noteService.findAll(pageable);
    }

}
