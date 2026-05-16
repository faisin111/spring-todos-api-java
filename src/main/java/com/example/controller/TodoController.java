package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.TodoRequestDto;
import com.example.entity.Todo;
import com.example.repository.TodoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("todos")
public class TodoController {

    private TodoRepository repo;

    TodoController(TodoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Todo> getAllTodo() {

        return repo.findAll();
    }

    @PostMapping
    public String addTodo(@Valid @RequestBody TodoRequestDto todo) {
        Todo tod = new Todo();
        tod.title = todo.title;
        tod.isCompleted = todo.isComplete;
        repo.save(tod);
        return "Successfully added";
    }

    @GetMapping("/{id}")
    public Todo getById(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable int id, @Valid @RequestBody TodoRequestDto todo) {
        Todo oldTodo = repo.findById(id).orElse(null);
        if (oldTodo == null) {
            return null;
        }
        oldTodo.title = todo.title;
        oldTodo.isCompleted = todo.isComplete;

        repo.save(oldTodo);
        return oldTodo;
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable int id) {
        repo.deleteById(id);
        return "Success";
    }

    @DeleteMapping
    public String deleteAllTodo() {
        repo.deleteAll();
        return "All datas deleted";
    }
}
