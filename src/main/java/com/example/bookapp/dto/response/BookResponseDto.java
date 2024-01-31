package com.example.bookapp.dto.response;

import java.math.BigDecimal;

public record BookResponseDto(
        Long id,
        String title,
        String author,
        String isbn,
        BigDecimal price,
        String description,
        String coverImage
) { }
