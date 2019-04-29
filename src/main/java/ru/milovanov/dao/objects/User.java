package ru.milovanov.dao.objects;

public class User {
    String username,password;
    User(String username,String password){
        this.username=username;
        this.password=password;
    }
    @Override
    public String toString(){
        return username+" "+password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
