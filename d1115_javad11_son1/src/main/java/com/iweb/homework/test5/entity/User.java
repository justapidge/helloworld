package com.iweb.homework.test5.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wmn
 * @date 2023/11/10 14:17
 */
@Data
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String pwd;

    public boolean equals(User anotherUser){
        if(this == anotherUser){
            return true;
        }
        if(anotherUser == null){
            return false;
        }
        if(!this.name.equals(anotherUser.name)){
            return false;
        }
        if(!this.pwd.equals(anotherUser.pwd)){
            return false;
        }
        return true;
    }
}
