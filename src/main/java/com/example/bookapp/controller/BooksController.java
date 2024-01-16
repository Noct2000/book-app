package com.example.bookapp.controller;

import com.example.bookapp.dto.request.CreateBookRequestDto;
import com.example.bookapp.dto.request.UpdateBookRequestDto;
import com.example.bookapp.dto.response.BookResponseDto;
import com.example.bookapp.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BooksController {
    private final BookService bookService;

    @Operation(
            summary = "Create new book",
            description = "Create new book from given JSON"
    )
    @PostMapping
    public ResponseEntity<BookResponseDto> save(
            @RequestBody
            @Valid
            CreateBookRequestDto createBookRequestDto
    ) {
        return ResponseEntity.ok(bookService.save(createBookRequestDto));
    }

    @Operation(
            summary = "Get book by id",
            description = "Get book by id. If book is not present then error will be thrown"
    )
    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @Operation(
            summary = "Get all books",
            description = "Get list of all books"
    )
    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @Operation(
            summary = "Update book",
            description = "Update book if book is present"
    )
    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> update(
            @PathVariable
            Long id,
            @RequestBody
            @Valid
            UpdateBookRequestDto updateBookRequestDto
    ) {
        return ResponseEntity.ok(bookService.update(id, updateBookRequestDto));
    }

    @Operation(
            summary = "Delete book",
            description = "Delete book by id"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
