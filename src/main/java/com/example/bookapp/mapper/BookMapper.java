package com.example.bookapp.mapper;

import com.example.bookapp.dto.request.CreateBookRequestDto;
import com.example.bookapp.dto.request.UpdateBookRequestDto;
import com.example.bookapp.dto.response.BookResponseDto;
import com.example.bookapp.model.Book;

public interface BookMapper {
    Book toModel(CreateBookRequestDto createBookRequestDto);

    Book toModel(UpdateBookRequestDto updateBookRequestDto, Long id);

    BookResponseDto toResponse(Book book);
}
