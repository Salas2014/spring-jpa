package com.example.springdemojpa.service;

import com.example.springdemojpa.dto.NoteDto;
import com.example.springdemojpa.entity.Note;
import com.example.springdemojpa.repo.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoteService {
    private final NoteRepository noteRepository;

    public List<NoteDto> findAll() {
        return noteRepository.findAllNoteDto();
    }

    public Page<Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }
}
