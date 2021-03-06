package com.example.minhao.walknlearn;

/*
    Created by Niko Li
    Date: 25/10/2018
 */

/*
    Forum class, used for creating object into adapter
 */

public class ForumVar {
    private String name;
    private String email;
    private String content;

    public ForumVar(String name, String email, String content) {
        this.name = name;
        this.email = email;
        this.content = content;
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
