package com.example.bookapp.mapper.impl;

import com.example.bookapp.dto.request.BookRequestDto;
import com.example.bookapp.dto.response.BookResponseDto;
import com.example.bookapp.mapper.BookMapper;
import com.example.bookapp.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements BookMapper {
    @Override
    public Book toModel(BookRequestDto bookRequestDto) {
        return getBook(new Book(), bookRequestDto);
    }

    @Override
    public Book toModel(BookRequestDto bookRequestDto, Long id) {
        return getBook(new Book().setId(id), bookRequestDto);
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

    private Book getBook(Book book, BookRequestDto bookRequestDto) {
        return book
                .setAuthor(bookRequestDto.getAuthor())
                .setCoverImage(bookRequestDto.getCoverImage())
                .setIsbn(bookRequestDto.getIsbn())
                .setPrice(bookRequestDto.getPrice())
                .setDescription(bookRequestDto.getDescription())
                .setTitle(bookRequestDto.getTitle());
    }
}
