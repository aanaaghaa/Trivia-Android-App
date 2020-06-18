package com.example.trivia;

class TaskModel {
    private String task_name;
    private String  task_added_time;
    private String  task_added_date;

    public TaskModel() {
    }

    public TaskModel(String value, String date, String time) {
        this.task_name = value;
        this.task_added_date = date;
        this.task_added_time = time;
    }

    public String getTaskName() {
        return task_name;
    }

    public String getTaskAddedTime() {
        return task_added_time;
    }

    public String getTaskAddedDate() {return task_added_date;
    }
}
