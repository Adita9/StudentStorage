package studentstorage.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.awt.*;

@Table
@Entity
@Builder
public class PersonalInfo {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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
