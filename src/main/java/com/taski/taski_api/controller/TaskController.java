package com.taski.taski_api.controller;

import com.taski.taski_api.generated.api.TasksApi;
import com.taski.taski_api.generated.model.TaskResponse;
import com.taski.taski_api.service.tasks.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class TaskController implements TasksApi {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    public ResponseEntity<List<TaskResponse>> getTasks(UUID userID){
        List<TaskResponse> response = service.getTasks(userID);
        return ResponseEntity.ok(response);
    }

}
