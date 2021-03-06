package ru.prilepskiy.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Роль для доступа к web.
 *
 * Created by VLADIMIR on 10.04.2018.
 */
@Entity(name = "spc_gen_role")
public class Role implements GrantedAuthority {

    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String authority;

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
