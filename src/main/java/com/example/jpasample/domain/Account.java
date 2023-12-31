package com.example.jpasample.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@Data
@Entity(name = "users")
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    //@Column(nullable = false, unique = true)
    private String username;

    private String password;

    public void setSudies(Set<Study> sudies) {
        this.sudies = sudies;
    }

    //owner 가 관계 주라는걸 알려줘야 중복 코드를 방지할 수 있음
    @Getter
    @OneToMany(mappedBy = "owner")
    private Set<Study> sudies = new HashSet<>();

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

    public void addStudy(Study study){
        this.getSudies().add(study);
        study.setOwner(this);
    }

    public void removeStudy(Study study){
        this.getSudies().remove(study);
        study.setOwner(null);
    }
}
