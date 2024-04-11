package com.kk22.crudemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "role_name")
    private String roleName;
    @OneToMany(mappedBy = "role",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<UserHasRole> userHasRoles;
    public Role(){

    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserHasRole> getUserHasRoles() {
        return userHasRoles;
    }

    public void setUserHasRoles(List<UserHasRole> userHasRoles) {
        this.userHasRoles = userHasRoles;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", userHasRoles=" + userHasRoles +
                '}';
    }
}
