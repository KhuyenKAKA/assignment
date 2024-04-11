package com.kk22.crudemo.entity;

import jakarta.persistence.*;
import org.hibernate.service.spi.InjectService;

import java.time.format.DateTimeFormatter;

@Entity
@Table(name="user_has_role")
public class UserHasRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "role_id")
    private Role role;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;
    @Column(name="role_start_time")
    private DateTimeFormatter roleStartTime;
    @Column(name="role_end_time")
    private DateTimeFormatter getRoleEndTime;
    public UserHasRole(){}

    public UserHasRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public DateTimeFormatter getRoleStartTime() {
        return roleStartTime;
    }

    public void setRoleStartTime(DateTimeFormatter roleStartTime) {
        this.roleStartTime = roleStartTime;
    }

    public DateTimeFormatter getGetRoleEndTime() {
        return getRoleEndTime;
    }

    public void setGetRoleEndTime(DateTimeFormatter getRoleEndTime) {
        this.getRoleEndTime = getRoleEndTime;
    }

    @Override
    public String toString() {
        return "UserHasRole{" +
                "id=" + id +
                ", role=" + role +
                ", userAccount=" + userAccount +
                ", roleStartTime=" + roleStartTime +
                ", getRoleEndTime=" + getRoleEndTime +
                '}';
    }
}
