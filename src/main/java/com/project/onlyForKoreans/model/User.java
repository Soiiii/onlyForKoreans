package com.project.onlyForKoreans.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(nullable=false, length=30)
    private String username;

    @Column(nullable=false, length=200)
    private String email;

    @Column(nullable=false, length=100)
    private String password;

    private int gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="countryId")
    private Country country;

    private int status;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @CreationTimestamp
    private Timestamp create_at;

}
