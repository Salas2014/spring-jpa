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

    public <T> List<T> findAllBy(Class<T> clazz) {
        return noteRepository.findAllBy(clazz);
    }


    // этот код работает с большим количеством записей. смысл в том, что готовится preparedStatement на стороне базы
    // и в зависимости от драйвера выгружается по сети определенное количество рекордов (к примеру в постгресс выгружается сразу все, а если у нас их много?)
    // а так на preparedStatement вызывается next() и задается пропертя setFetchSize() в которой мы и укажем, какое количество передать за раз!
    public void processNoteStream(String start) {
        try (var noteStream = noteRepository.findAllByBodyStartsWith(start)) {
            noteStream
                    .forEach(this::doSomething);
        }
    }

    private void doSomething(Note note) {

    }
}
