package com.vue.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Book {
    String ISBN;
    String name;
    String genreid;
    String author;
    Date pubDate;
    int stock;
    double cost;
}
