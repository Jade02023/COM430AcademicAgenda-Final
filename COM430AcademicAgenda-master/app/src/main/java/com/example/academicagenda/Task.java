package com.example.academicagenda;

import java.util.Date;

public class Task {
    private final int taskId;
    private final String taskName;
    private final Date dueDate;
    private final int courseId;

    public Task(int taskId, String taskName, Date dueDate, int courseId) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.courseId = courseId;
    }

    public static void add(Task Task) {
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public int getCourseId() {
        return courseId;
    }

    // You can add setter methods if needed

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", dueDate=" + dueDate +
                ", courseId=" + courseId +
                '}';
    }
}



