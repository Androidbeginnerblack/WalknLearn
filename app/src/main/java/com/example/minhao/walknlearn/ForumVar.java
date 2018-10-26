package com.example.minhao.walknlearn;

public class ForumVar {
    private String name;
    private String birthday;
    private String sex;

    public ForumVar(String name, String birthday, String sex) {
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
