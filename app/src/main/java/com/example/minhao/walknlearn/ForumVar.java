package com.example.minhao.walknlearn;

public class ForumVar {
    private String name;
    private String email;
    private String content;

    public ForumVar(String name, String birthday, String sex) {
        this.name = name;
        this.email = birthday;
        this.content = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
