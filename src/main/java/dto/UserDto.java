package dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserDto {
    private Integer id;
    private String name;
    private String surname;
    private Map<String,Integer> skills;
    private Boolean onWork;
    private Integer taskID;
    private Date taskStartTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Map<String,Integer> getSkills() {
        return skills;
    }

    public void setSkills(Map<String,Integer> skills) {
        this.skills = skills;
    }

    public Boolean getOnWork() {
        return onWork;
    }

    public void setOnWork(Boolean onWork) {
        this.onWork = onWork;
    }

    public Integer getTaskID() {
        return taskID;
    }

    public void setTaskID(Integer taskID) {
        this.taskID = taskID;
    }

    public Date getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(Date taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", skills=" + skills +
                ", onWork=" + onWork +
                ", taskID=" + taskID +
                ", taskStartTime=" + taskStartTime +
                '}';
    }
}
