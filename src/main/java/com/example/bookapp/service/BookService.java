package com.example.bookapp.service;

import com.example.bookapp.dto.request.BookRequestDto;
import com.example.bookapp.dto.response.BookResponseDto;
import java.util.List;

public interface BookService {
    BookResponseDto save(BookRequestDto bookRequestDto);

    BookResponseDto getById(Long id);

    BookResponseDto update(Long id, BookRequestDto bookRequestDto);

    List<BookResponseDto> getAll();

    void deleteById(Long id);
}
