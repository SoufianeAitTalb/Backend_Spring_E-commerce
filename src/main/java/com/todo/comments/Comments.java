package com.todo.comments;

import com.todo.Task.TaskItem;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialBlob;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String text;

    private String uname;

    private String idP;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getIdP() {
        return idP;
    }

    public void setIdP(String idP) {
        this.idP = idP;
    }
    public Comments() {

    }

    public Comments(String text, String uname, String idP) {
        this.text = text;
        this.uname = uname;
        this.idP = idP;
    }
}

