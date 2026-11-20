
package com.taski.taski_api.service.tasks;

import com.taski.taski_api.generated.model.TaskResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final List<TaskResponse> tasks = new ArrayList<>(List.of(
            new TaskResponse()
                    .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440001"))
                    .title("Limpar a casa")
                    .description("Lavar a casa com sabão próprio")
                    .priority(TaskResponse.PriorityEnum.ALTA)
                    .idOwner(UUID.fromString("550e8400-e29b-41d4-a716-446655440010")),

            new TaskResponse()
                    .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440002"))
                    .title("Jogar videogame")
                    .description("Jogar por pelo menos uma hora")
                    .priority(TaskResponse.PriorityEnum.BAIXA)
                    .idOwner(UUID.fromString("550e8400-e29b-41d4-a716-446655440001")),

            new TaskResponse()
                    .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440003"))
                    .title("Estudar Java")
                    .description("Estudar Spring Boot e arquitetura")
                    .priority(TaskResponse.PriorityEnum.ALTA)
                    .idOwner(UUID.fromString("550e8400-e29b-41d4-a716-446655440010"))
    ));

    @Override
    public List<TaskResponse> getTasks(UUID userId) {
        return tasks.stream()
                .filter(task -> userId.equals(task.getIdOwner()))
                .toList();
    }
}
