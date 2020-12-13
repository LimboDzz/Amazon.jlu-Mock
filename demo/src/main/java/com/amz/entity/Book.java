package com.amz.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Book {
    private String ISBN;
    private String name;
    private String author;
    private Date pubDate;
    private int stock;
    private double cost;
}
