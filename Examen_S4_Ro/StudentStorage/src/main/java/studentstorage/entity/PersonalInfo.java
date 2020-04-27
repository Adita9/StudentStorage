package studentstorage.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.awt.*;

@Table
@Entity
public class PersonalInfo {

    @javax.persistence.Id
    private int id;
    private String name;
    private String barCode;
    private String dateOfBirth;
    private String placeOfBirth;
    private String address;
    private String city;
//    private Image image;
    private String phoneNumber;
    private String email;
    private double wallet;
}
