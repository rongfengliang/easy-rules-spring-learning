package com.appdemo.demo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Map;

public class User implements  Serializable {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", uniqueId='" + uniqueId + '\'' +
                ", userinfo=" + userinfo +
                '}';
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    @JsonIgnore
    private transient String uniqueId;

    public Map<Object, Object> getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Map<Object, Object> userinfo) {
        this.userinfo = userinfo;
    }

    private Map<Object, Object> userinfo;

    public String getName() {
        return name;
    }

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
