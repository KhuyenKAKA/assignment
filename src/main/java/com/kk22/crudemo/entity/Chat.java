package com.kk22.crudemo.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "from_user_id")
    private int fromUserId;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;
    @Column(name = "content")
    private String content;
    @Column(name = "sent_datetime")
    private DateTimeFormatter sentDatetime;
    public Chat(){

    }

    public Chat(int fromUserId, UserAccount userAccount, String content, DateTimeFormatter sentDatetime) {
        this.fromUserId = fromUserId;
        this.content = content;
        this.sentDatetime = sentDatetime;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DateTimeFormatter getSentDatetime() {
        return sentDatetime;
    }

    public void setSentDatetime(DateTimeFormatter sentDatetime) {
        this.sentDatetime = sentDatetime;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", fromUserId=" + fromUserId +
                ", userAccount=" + userAccount +
                ", content='" + content + '\'' +
                ", sentDatetime=" + sentDatetime +
                '}';
    }
}
