package com.example.jpasample;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

//@Data
@Entity(name = "users")
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    //@Column(nullable = false, unique = true)
    private String username;

    private String password;

    private String email;


    //Colum으로 매핑하지 않음
    @Transient
    private String no;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name ="street", column = @Column(name="home_street"))
    )
    private Address homeAddress;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
