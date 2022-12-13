package com.example.day3todolist;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Task {

    int id;
    String title,dec,status;
}
