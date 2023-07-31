package com.project.onlyForKoreans.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public Country(String name){
        this.name = name;
    }

//    @JsonCreator
//    public Country(@JsonProperty("name") String name){
//        this.name = name;
//    }

//    @ManyToOne
//    @JoinColumn(name="boardId")
//    private Board board;
//
//    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
//    @JoinColumn(name="userId")
//    private User user;

}
