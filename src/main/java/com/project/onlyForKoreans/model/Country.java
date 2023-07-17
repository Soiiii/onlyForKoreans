package com.project.onlyForKoreans.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;


//    @ManyToOne
//    @JoinColumn(name="boardId")
//    private Board board;
//
//    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
//    @JoinColumn(name="userId")
//    private User user;

}
