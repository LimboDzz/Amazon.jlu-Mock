package com.amz.entity;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String password;
    private boolean admin;
}
