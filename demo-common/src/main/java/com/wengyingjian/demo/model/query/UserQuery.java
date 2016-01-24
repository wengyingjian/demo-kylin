package com.wengyingjian.demo.model.query;

import java.io.Serializable;

/**
 * Created by wengyingjian on 16/1/24.
 */
public class UserQuery implements Serializable {
    private Integer id;
    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
