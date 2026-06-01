package com.register.code;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "userinfo")
public class userEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Nullable Integer id;

    private String name;
    private String password;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

}
