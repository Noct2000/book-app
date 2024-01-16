package com.example.bookapp.mapper.impl;

import com.example.bookapp.dto.request.CreateBookRequestDto;
import com.example.bookapp.dto.request.UpdateBookRequestDto;
import com.example.bookapp.dto.response.BookResponseDto;
import com.example.bookapp.mapper.BookMapper;
import com.example.bookapp.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements BookMapper {
    @Override
    public Book toModel(CreateBookRequestDto createBookRequestDto) {
        return new Book()
                .setAuthor(createBookRequestDto.getAuthor())
                .setCoverImage(createBookRequestDto.getCoverImage())
                .setIsbn(createBookRequestDto.getIsbn())
                .setPrice(createBookRequestDto.getPrice())
                .setDescription(createBookRequestDto.getDescription())
                .setTitle(createBookRequestDto.getTitle());
    }

    @Override
    public Book toModel(UpdateBookRequestDto updateBookRequestDto, Long id) {
        return new Book()
                .setId(id)
                .setAuthor(updateBookRequestDto.getAuthor())
                .setCoverImage(updateBookRequestDto.getCoverImage())
                .setIsbn(updateBookRequestDto.getIsbn())
                .setPrice(updateBookRequestDto.getPrice())
                .setDescription(updateBookRequestDto.getDescription())
                .setTitle(updateBookRequestDto.getTitle());
    }

    @Override
    public BookResponseDto toResponse(Book book) {
        return new BookResponseDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPrice(),
                book.getDescription(),
                book.getCoverImage()
        );
    }
}
