package com.lucasmonteiro.shoppingapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucasmonteiro.shoppingapi.entities.enums.UserLevel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Integer userLevel;
    private boolean login = false;

    //---------------------------------------Associations------------------------------------------

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    //----------------------------------------------------------------------------------------------

    public User() {
    }

    public User(Long id, String name, String email, String password, UserLevel userLevel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        setUserLevel(userLevel);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password; }

    public UserLevel getUserLevel() {
        return UserLevel.valueOf(userLevel);
    }

    public void setUserLevel(UserLevel userLevel) {
        if (userLevel != null) {
            this.userLevel = userLevel.getCode();
        }
    }

    public List<Order> getOrders() {
        return orders;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
