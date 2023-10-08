package com.entity;

public class Task {
    private int id;
    private int student;
    private String completionTime;
    private String path;
    private String title;
    private String content;
    private String dispatchTime;
    private String deadline;
    private int teacher;
    private int status;

    public Task(){

    }

    /**
     * 构造函数（教师获取任务）
     * @param title 任务标题
     * @param content 任务内容
     * @param dispatchTime 发布时间
     * @param deadline 结束时间
     * @param teacher 所属教师
     */
    public Task(String title,String content,String dispatchTime,String deadline,int teacher){
        this.title = title;
        this.content = content;
        this.dispatchTime = dispatchTime;
        this.deadline = deadline;
        this.teacher = teacher;
    }

    /**
     * 构造函数（学生获取任务）
     * @param id 任务编码
     * @param title 任务标题
     * @param content 任务内容
     * @param dispatchTime 发布时间
     * @param deadline 结束时间
     * @param teacher 所属教师
     */
    public Task(int id,String title,String content,String dispatchTime,String deadline,int teacher){
        this.id = id;
        this.title = title;
        this.content = content;
        this.dispatchTime = dispatchTime;
        this.deadline = deadline;
        this.teacher = teacher;
    }

    public Task(int id,int student,String completionTime,String path,String title,String content,String dispatchTime,String deadline,int teacher,int status){
        this.id = id;
        this.student = student;
        this.completionTime = completionTime;
        this.path = path;
        this.title = title;
        this.content = content;
        this.dispatchTime = dispatchTime;
        this.deadline = deadline;
        this.teacher = teacher;
        this.status = status;
    }





    public int getId() {
        return id;
    }

    public int getStudent() {
        return student;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    public String getPath() {
        return path;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDispatchTime() {
        return dispatchTime;
    }

    public String getDeadline() {
        return deadline;
    }

    public int getStatus() {
        return status;
    }

    public int getTeacher() {
        return teacher;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDispatchTime(String dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", student=" + student +
                ", completionTime='" + completionTime + '\'' +
                ", path='" + path + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", dispatchTime='" + dispatchTime + '\'' +
                ", deadline='" + deadline + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
