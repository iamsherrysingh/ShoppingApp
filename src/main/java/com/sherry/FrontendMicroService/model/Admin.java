package com.sherry.FrontendMicroService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

    @Id
    @Column(name="admin_name")
    String adminName;

    @Column(name="password")
    String password;

    public Admin(){};

    public Admin(String adminName, String password) {
        this.adminName = adminName;
        this.password = password;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
