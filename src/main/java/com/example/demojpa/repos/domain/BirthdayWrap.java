package com.example.demojpa.repos.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class BirthdayWrap {
    private LocalDate date;
}
