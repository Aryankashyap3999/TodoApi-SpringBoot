package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // from this annotation u can tell program this class will be controller of this project, controller is like an entry point.
public class TodoController {

    private static List<Todo> todoList;

    public TodoController() {
        todoList = new ArrayList<>();
        todoList.add(new Todo(1,1,"Todo 1", false ));
        todoList.add(new Todo(2,2,"Todo 2", true));
    }

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoList;
    }

}
