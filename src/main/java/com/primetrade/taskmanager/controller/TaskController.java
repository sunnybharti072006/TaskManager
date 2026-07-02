package com.primetrade.taskmanager.controller;

import com.primetrade.taskmanager.dto.TaskDto;
import com.primetrade.taskmanager.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@Tag(name = "Tasks", description = "CRUD APIs for tasks - protected by JWT")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    @Operation(summary = "Get all tasks for the current user (or all tasks if admin)")
    public ResponseEntity<List<TaskDto>> getAllTasks(Authentication authentication) {
        return ResponseEntity.ok(taskService.getAllTasksForCurrentUser(authentication.getName()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a single task by id")
    public ResponseEntity<TaskDto> getTaskById(Authentication authentication, @PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(authentication.getName(), id));
    }

    @PostMapping
    @Operation(summary = "Create a new task")
    public ResponseEntity<TaskDto> createTask(Authentication authentication, @Valid @RequestBody TaskDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(taskService.createTask(authentication.getName(), dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing task")
    public ResponseEntity<TaskDto> updateTask(Authentication authentication, @PathVariable Long id,
                                               @Valid @RequestBody TaskDto dto) {
        return ResponseEntity.ok(taskService.updateTask(authentication.getName(), id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a task")
    public ResponseEntity<Void> deleteTask(Authentication authentication, @PathVariable Long id) {
        taskService.deleteTask(authentication.getName(), id);
        return ResponseEntity.noContent().build();
    }
}
