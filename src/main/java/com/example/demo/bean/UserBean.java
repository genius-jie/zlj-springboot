package com.example.demo.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class UserBean {
    private int id;
    private String name;
    private String password;
    private int count;

    public UserBean(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
