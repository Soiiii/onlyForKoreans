package com.project.onlyForKoreans.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Board board;

    @ManyToOne
    @JoinColumn(name="userId")
    @OnDelete(action= OnDeleteAction.CASCADE)
    private User user;

    @Override
    public String toString() {
        return "Bookmark{" +
                "id=" + id +
                '}';
    }
}
