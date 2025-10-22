package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// if you give it to @Service then string throws error that as there a collision has occurred between TodoService and FakeTodoService then to avoid collision you can make one of them @primary that says that in case of collision it will get preference
@Service("anotherTodoService")
//@Primary // but it has problem that you may required multiple service that implements same interface to use. For that we can name the service like anotherTodoService
public class AnotherTodoService implements TodoService {

    public String doSomething() {
        return "Something from another to do service";
    }
}
