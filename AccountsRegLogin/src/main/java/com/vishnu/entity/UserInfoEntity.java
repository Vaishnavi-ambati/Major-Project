package src.main.java.com.vishnu.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Table(name="USER_INFO")
@Data
public class UserInfoEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private String email;
    private String pwd;
    private String gender;

    private LocalDate dob;
    private Long phone;

    private String userType;

    private boolean pwdChanged;


}
