package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // from this annotation u can tell program this class will be controller of this project, controller is like an entry point.
@RequestMapping("/api/v1/todos/")
public class TodoController {

//    @Autowired // this is used to handle the creation of object out of interface. but now a days it is not recommend to use autowired, it does field injection

    private TodoService todoService;

    private static List<Todo> todoList;

    public TodoController(@Qualifier("anotherTodoService") TodoService todoService) {
        // this.todoService = new TodoService() in this, I explicitly created the object but spring says you don't need to handle it, it provides @Component and you just need to inject the object on it.
        todoList = new ArrayList<>();
        this.todoService = todoService;
        todoList.add(new Todo(1,1,"Todo 1", false ));
        todoList.add(new Todo(2,2,"Todo 2", true));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok(todoList);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED) you can use it for status code
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
        todoList.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @GetMapping("{todoId}")
    public ResponseEntity<Todo> getTodo (@PathVariable Long todoId) {
        for(Todo todo : todoList) {
            if(todo.getId() == todoId) {
                return ResponseEntity.ok(todo);
            }
        }
        return ResponseEntity.notFound().build();
    }

}
