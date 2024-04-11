package com.kk22.crudemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "setting")
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="update_account")
    private String updateAccount;
    @Column(name = "update_chat")
    private String updateChat;
    @Column(name="phone_number")
    private String phoneNumber;
    @OneToMany(mappedBy = "setting",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<UserAccount> userAccounts;
    public Setting(){

    }

    public Setting(String updateAccount, String updateChat, String phoneNumber) {
        this.updateAccount = updateAccount;
        this.updateChat = updateChat;
        this.phoneNumber = phoneNumber;
    }

    public List<UserAccount> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(List<UserAccount> userAccounts) {
        this.userAccounts = userAccounts;
    }

    public String getUpdateAccount() {
        return updateAccount;
    }

    public void setUpdateAccount(String updateAccount) {
        this.updateAccount = updateAccount;
    }

    public String getUpdateChat() {
        return updateChat;
    }

    public void setUpdateChat(String updateChat) {
        this.updateChat = updateChat;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "id=" + id +
                ", updateAccount='" + updateAccount + '\'' +
                ", updateChat='" + updateChat + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userAccounts=" + userAccounts +
                '}';
    }
}
