package com.example.bookapp.service;

import com.example.bookapp.dto.request.CreateBookRequestDto;
import com.example.bookapp.dto.request.UpdateBookRequestDto;
import com.example.bookapp.dto.response.BookResponseDto;
import java.util.List;

public interface BookService {
    BookResponseDto save(CreateBookRequestDto createBookRequestDto);

    BookResponseDto getById(Long id);

    BookResponseDto update(Long id, UpdateBookRequestDto updateBookRequestDto);

    List<BookResponseDto> getAll();

    void deleteById(Long id);
}
