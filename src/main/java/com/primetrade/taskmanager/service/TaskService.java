package com.primetrade.taskmanager.service;

import com.primetrade.taskmanager.dto.TaskDto;
import com.primetrade.taskmanager.entity.Task;
import com.primetrade.taskmanager.entity.User;
import com.primetrade.taskmanager.exception.ForbiddenException;
import com.primetrade.taskmanager.exception.ResourceNotFoundException;
import com.primetrade.taskmanager.repository.TaskRepository;
import com.primetrade.taskmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    private User getCurrentUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public List<TaskDto> getAllTasksForCurrentUser(String email) {
        User user = getCurrentUser(email);

        List<Task> tasks;
        if (user.getRole().name().equals("ADMIN")) {
            tasks = taskRepository.findAll(); // admin sees everything
        } else {
            tasks = taskRepository.findByUserId(user.getId());
        }
        return tasks.stream().map(TaskDto::fromEntity).toList();
    }

    public TaskDto getTaskById(String email, Long taskId) {
        User user = getCurrentUser(email);
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));

        checkOwnershipOrAdmin(user, task);
        return TaskDto.fromEntity(task);
    }

    public TaskDto createTask(String email, TaskDto dto) {
        User user = getCurrentUser(email);

        Task task = Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(dto.getStatus() != null ? dto.getStatus() : Task.TaskStatus.PENDING)
                .userId(user.getId())
                .build();

        return TaskDto.fromEntity(taskRepository.save(task));
    }

    public TaskDto updateTask(String email, Long taskId, TaskDto dto) {
        User user = getCurrentUser(email);
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));

        checkOwnershipOrAdmin(user, task);

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        if (dto.getStatus() != null) {
            task.setStatus(dto.getStatus());
        }

        return TaskDto.fromEntity(taskRepository.save(task));
    }

    public void deleteTask(String email, Long taskId) {
        User user = getCurrentUser(email);
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));

        checkOwnershipOrAdmin(user, task);
        taskRepository.delete(task);
    }

    private void checkOwnershipOrAdmin(User user, Task task) {
        boolean isOwner = task.getUserId().equals(user.getId());
        boolean isAdmin = user.getRole().name().equals("ADMIN");
        if (!isOwner && !isAdmin) {
            throw new ForbiddenException("You do not have permission to access this task");
        }
    }
}
