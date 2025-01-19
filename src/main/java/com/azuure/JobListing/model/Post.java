package com.azuure.JobListing.model;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Post")
public class Post {
    private String title;
    private String desc;
    private int exp;
    private String[] tech;

    public Post() {
    }

    public Post(String title, String desc, int exp, String[] tech) {
        this.title = title;
        this.desc = desc;
        this.exp = exp;
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", exp=" + exp +
                ", tech=" + Arrays.toString(tech) +
                '}';
    }

    public String getTitle() {
        return title;
    }


    public String getDesc() {
        return desc;
    }

    public int getExp() {
        return exp;
    }

    public String[] getTech() {
        return tech;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setTech(String[] tech) {
        this.tech = tech;
    }
}
