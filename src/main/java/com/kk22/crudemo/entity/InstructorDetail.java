package com.kk22.crudemo.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

@Entity
@Table(name= "instructorDetail")
public class InstructorDetail {
    //annotate the claas as an entity and map to db table
    //define the fields
    //annotate the fields with db column names

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="youtube_channel")
    private String youtubeChannel;
    @Column(name="hobby")
    private String hoppy;
    //add @OneToOne annotation
    @OneToOne(mappedBy = "instructorDetail",cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
            private Instructor instructor;

    //create constructors
    public InstructorDetail(){

    }
    public InstructorDetail(String youtubeChannel, String hoppy) {
        this.youtubeChannel = youtubeChannel;
        this.hoppy = hoppy;
    }
    //getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHoppy() {
        return hoppy;
    }

    public void setHoppy(String hoppy) {
        this.hoppy = hoppy;
    }
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    //toString

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hoppy='" + hoppy + '\'' +
                '}';
    }
}
