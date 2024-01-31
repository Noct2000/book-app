package com.example.bookapp.mapper;

import com.example.bookapp.dto.request.BookRequestDto;
import com.example.bookapp.dto.response.BookResponseDto;
import com.example.bookapp.model.Book;

public interface BookMapper {
    Book toModel(BookRequestDto bookRequestDto);

    Book toModel(BookRequestDto bookRequestDto, Long id);

    BookResponseDto toResponse(Book book);
}
