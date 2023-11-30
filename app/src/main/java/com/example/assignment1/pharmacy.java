package com.example.assignment1;

import java.util.Date;

public class pharmacy {
    private String medicineTitle;
    private String description;
    private Date dueDate;
    private boolean completed;

    public pharmacy(String medicineTitle, String description, Date dueDate, boolean completed) {
        this.medicineTitle = medicineTitle;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public void setTaskTitle(String taskTitle) {
        this.medicineTitle = medicineTitle;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
