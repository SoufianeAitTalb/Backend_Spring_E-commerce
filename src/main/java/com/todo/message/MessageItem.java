package com.todo.message;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.sql.rowset.serial.SerialBlob;
import javax.validation.constraints.NotNull;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

@Entity
public class MessageItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


//    @NotNull(message = "title is required")
    private Blob message;

//    @NotNull(message = "title is required")
    private String content;

    private String per;

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    public MessageItem() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() throws SQLException {
//        System.out.println(image);
        int blobLength = (int) message.length();
        byte[] blobAsBytes = message.getBytes(1, blobLength);
        //        System.out.println(sCert);
        return javax.xml.bind.DatatypeConverter.printBase64Binary(blobAsBytes);
    }

    public void setMessage(String message) throws SQLException {
        byte[] decodedByte = Base64.getDecoder().decode(message);

        this.message = new SerialBlob(decodedByte);
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageItem( String message, String content,String per) throws SQLException {

        byte[] decodedByte = Base64.getDecoder().decode(message);
        this.message= new SerialBlob(decodedByte);
        this.content = content;
        this.per=per;
    }
}
