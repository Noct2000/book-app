package com.example.bookapp.mapper.impl;

import com.example.bookapp.dto.request.CreateBookRequestDto;
import com.example.bookapp.dto.response.BookResponseDto;
import com.example.bookapp.mapper.BookMapper;
import com.example.bookapp.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements BookMapper {
    @Override
    public Book toModel(CreateBookRequestDto createBookRequestDto) {
        return getBook(new Book(), createBookRequestDto);
    }

    @Override
    public Book toModel(CreateBookRequestDto createBookRequestDto, Long id) {
        return getBook(new Book().setId(id), createBookRequestDto);
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

    private Book getBook(Book book, CreateBookRequestDto createBookRequestDto) {
        return book
                .setAuthor(createBookRequestDto.getAuthor())
                .setCoverImage(createBookRequestDto.getCoverImage())
                .setIsbn(createBookRequestDto.getIsbn())
                .setPrice(createBookRequestDto.getPrice())
                .setDescription(createBookRequestDto.getDescription())
                .setTitle(createBookRequestDto.getTitle());
    }
}
