package com.example.bookapp.service;

import com.example.bookapp.dto.request.CreateBookRequestDto;
import com.example.bookapp.dto.response.BookResponseDto;
import java.util.List;

public interface BookService {
    BookResponseDto save(CreateBookRequestDto createBookRequestDto);

    BookResponseDto getById(Long id);

    BookResponseDto update(Long id, CreateBookRequestDto createBookRequestDto);

    List<BookResponseDto> getAll();

    void deleteById(Long id);
}
