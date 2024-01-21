package com.example.bookapp.service.impl;

import com.example.bookapp.dto.request.CreateBookRequestDto;
import com.example.bookapp.dto.request.UpdateBookRequestDto;
import com.example.bookapp.dto.response.BookResponseDto;
import com.example.bookapp.mapper.BookMapper;
import com.example.bookapp.model.Book;
import com.example.bookapp.repository.BookRepository;
import com.example.bookapp.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookResponseDto save(CreateBookRequestDto createBookRequestDto) {
        Book savedBook = bookRepository.save(bookMapper.toModel(createBookRequestDto));
        return bookMapper.toResponse(savedBook);
    }

    @Override
    public BookResponseDto getById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No book by id: " + id));
        return bookMapper.toResponse(book);
    }

    @Override
    public BookResponseDto update(Long id, UpdateBookRequestDto updateBookRequestDto) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("No book for update by id: " + id);
        }
        Book book = bookMapper.toModel(updateBookRequestDto, id);

        return bookMapper.toResponse(bookRepository.save(book));
    }

    @Override
    public List<BookResponseDto> getAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toResponse)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
