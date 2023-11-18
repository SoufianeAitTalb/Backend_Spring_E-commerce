package com.e_commerce.Task;



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
public class TaskItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "title is required")
    private String title;


    @NotNull(message = "descreption is required")
    private String descreption;

    @NotNull(message = "price is required")
    private int price;

    @NotNull(message = "image is required")
    private Blob image;

    @NotNull(message = "size is required")
    private float size;




    @NotNull(message = "Type is required")
    private String type;
    @NotNull(message = "TB is required")
    private int tb;

    public int getTB() {
        return tb;
    }

    public void setTB(int tb) {
        this.tb = tb;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }




    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() throws SQLException {
//        System.out.println(image);
        int blobLength = (int) image.length();
        byte[] blobAsBytes = image.getBytes(1, blobLength);
        String sCert = javax.xml.bind.DatatypeConverter.printBase64Binary(blobAsBytes);
//        System.out.println(sCert);
        return sCert;
    }

    public void setImage(String image) throws SQLException {
        byte[] decodedByte = Base64.getDecoder().decode(image);
        Blob b = new SerialBlob(decodedByte);
        this.image = b;
    }

    public TaskItem() {
    }

    public TaskItem(String title,String descreption,String image,int price,float size, String color,String type,int tb) throws SQLException {
        this.title = title;
        this.descreption=descreption;
        this.price=price;
        this.tb = tb;
        byte[] decodedByte = Base64.getDecoder().decode(image);
        Blob b = new SerialBlob(decodedByte);
        this.image=b;

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

//    public boolean isDone() {
//        return done;
//    }
//
//    public void setDone(boolean done) {
//        this.done = done;
//    }
}
//
//package com.todo.Task;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.validation.constraints.NotNull;
//
//@Entity
//public class TaskItem {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    @NotNull(message = "title is required")
//    private String title;
//    private boolean done;
//
//    public TaskItem() {
//    }
//
//    public TaskItem(String title) {
//        this.title = title;
//        this.done = false;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public boolean isDone() {
//        return done;
//    }
//
//    public void setDone(boolean done) {
//        this.done = done;
//    }
//}
