package com.todo.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.todo.domain.Todo;

@Stateless
public class TodoService {

        @PersistenceContext
        private EntityManager entityManager;


        public Todo create(Todo todo) {
                entityManager.persist(todo);
                return todo;
        }

        public Todo find(Long id) {
                Todo todo = entityManager.find(Todo.class, id);
                List<String> tags = todo.getTags();
                System.out.println("Tags : " + tags);
                return todo;
        }
}