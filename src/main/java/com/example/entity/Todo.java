package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity(name = "todos")
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int id;

  public String title;
  public Boolean isCompleted;

}
