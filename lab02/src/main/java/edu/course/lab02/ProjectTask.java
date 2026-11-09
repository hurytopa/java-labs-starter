package edu.course.lab02;

public class ProjectTask {
    private final String id;
    private final String title;
    private TaskStatus status;
    private int estimatedHours;

    public ProjectTask(String id, String title, TaskStatus status, int estimatedHours) {
    if (id == null || id.isBlank()) {
    throw new IllegalArgumentException("Идентификатор не должен быть пустым");
    }
    if (title == null || title.isBlank()) {
        throw new IllegalArgumentException("Название задачи не должно быть пустым");
    }
    if (status == null) {
        throw new IllegalArgumentException("Статус не должен быть null");
    }
    if (estimatedHours <= 0) {
        throw new IllegalArgumentException("Оценка трудоемкости должна быть положительной");
    }

    this.id = id;
    this.title = title;
    this.status = status;
    this.estimatedHours = estimatedHours;
    }

    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Новый статус не должен быть null");
        }
        this.status = newStatus;
    }

    public boolean isCompleted() {
        return status == TaskStatus.DONE;
    }

    public void increaseEstimatedHours(int additionalHours) {
        if (additionalHours <= 0) {
            throw new IllegalArgumentException("Дополнительные часы должны быть положительными");
        }
        if (additionalHours > Integer.MAX_VALUE - estimatedHours) {
            throw new IllegalArgumentException("Оценка трудоёмкости слишком велика");
        }
        estimatedHours += additionalHours;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

}