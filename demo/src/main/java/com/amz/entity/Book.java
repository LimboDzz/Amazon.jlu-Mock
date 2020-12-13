package com.amz.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Book {
    private String ISBN;
    private String name;
    private String author;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date pubDate;
    private int stock;
    private double cost;
}
