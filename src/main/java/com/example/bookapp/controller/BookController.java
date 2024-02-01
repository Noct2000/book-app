package com.example.bookapp.controller;

import com.example.bookapp.dto.request.BookRequestDto;
import com.example.bookapp.dto.response.BookResponseDto;
import com.example.bookapp.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @Operation(
            summary = "Create new book",
            description = "Create new book from given JSON"
    )
    @PostMapping
    public ResponseEntity<BookResponseDto> save(
            @RequestBody
            @Valid
            BookRequestDto bookRequestDto
    ) {
        return ResponseEntity.ok(bookService.save(bookRequestDto));
    }

    @Operation(
            summary = "Get book by id",
            description = "Get book by id. If book is not present then error will be thrown"
    )
    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }

}
