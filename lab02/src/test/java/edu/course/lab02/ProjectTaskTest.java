package edu.course.lab02;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ProjectTaskTest {
    @Test
    void newTaskIsNotCompleted() {
        ProjectTask task = new ProjectTask(
            "TASK-1",
            "Добавить тесты",
            TaskStatus.TODO,
            4
        );

        assertFalse(task.isCompleted());
    }

    @Test
    void changeStatusToDoneMakesTaskCompleted() {
        ProjectTask task = new ProjectTask(
            "TASK-1",
            "Добавить тесты",
            TaskStatus.TODO,
            4
        );

        task.changeStatus(TaskStatus.DONE);

        assertTrue(task.isCompleted());
        assertEquals(TaskStatus.DONE, task.getStatus());
    }

    @Test
    void increaseEstimatedHoursAddsHours() {
        ProjectTask task = new ProjectTask(
            "TASK-1",
            "Добавить тесты",
            TaskStatus.TODO,
            4
        );

        task.increaseEstimatedHours(3);

        assertEquals(7, task.getEstimatedHours());
    }

    @Test
    void constructorShouldRejectNullId() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new ProjectTask(null, "Задача", TaskStatus.TODO, 4)
        );
    }

    @Test
    void constructorShouldRejectBlankId() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new ProjectTask(" ", "Задача", TaskStatus.TODO, 4)
        );
    }

    @Test
    void constructorShouldRejectNullTitle() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new ProjectTask("TASK-1", null, TaskStatus.TODO, 4)
        );
    }

    @Test
    void constructorShouldRejectBlankTitle() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new ProjectTask("TASK-1", " ", TaskStatus.TODO, 4)
        );
    }

    @Test
    void constructorShouldRejectNullStatus() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new ProjectTask("TASK-1", "Задача", null, 4)
        );
    }

    @Test
    void constructorShouldRejectZeroEstimatedHours() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new ProjectTask("TASK-1", "Задача", TaskStatus.TODO, 0)
        );
    }

    @Test
    void changeStatusShouldRejectNull() {
        ProjectTask task = new ProjectTask(
            "TASK-1",
            "Добавить тесты",
            TaskStatus.TODO,
            4
        );

        assertThrows(
            IllegalArgumentException.class,
            () -> task.changeStatus(null)
        );
        assertEquals(TaskStatus.TODO, task.getStatus());
    }

    @Test
    void increaseEstimatedHoursShouldRejectZero() {
        ProjectTask task = new ProjectTask(
            "TASK-1",
            "Добавить тесты",
            TaskStatus.TODO,
            4
        );

        assertThrows(
            IllegalArgumentException.class,
            () -> task.increaseEstimatedHours(0)
        );
        assertEquals(4, task.getEstimatedHours());
    }

    @Test
    void increaseEstimatedHoursShouldRejectOverflow() {
        ProjectTask task = new ProjectTask(
            "TASK-1",
            "Добавить тесты",
            TaskStatus.TODO,
            Integer.MAX_VALUE
        );

        assertThrows(
            IllegalArgumentException.class,
            () -> task.increaseEstimatedHours(1)
        );
        assertEquals(Integer.MAX_VALUE, task.getEstimatedHours());
    }
}