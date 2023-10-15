package com.project.onlyForKoreans.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="boardId")
    private Board board;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @Override
    public String toString() {
        return "Bookmark{" +
                "id=" + id +
                '}';
    }
}
