package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // from this annotation u can tell program this class will be controller of this project, controller is like a entry point.
public class TodoController {

    private static List<Todo> todos;

    public TodoController() {
        todos = new ArrayList<>();
        todos.add(new Todo(1,1,"Todo 1", false ));
        todos.add(new Todo(2,2,"Todo 2", true));
    }

}
