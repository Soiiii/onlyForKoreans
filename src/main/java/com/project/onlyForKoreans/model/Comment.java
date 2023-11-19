package com.project.onlyForKoreans.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Lob
    private String content;

    @CreationTimestamp
    private Timestamp create_at;

    @ManyToOne
    @JoinColumn(name="boardId")
    @OnDelete(action= OnDeleteAction.CASCADE)

    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    @OnDelete(action= OnDeleteAction.CASCADE)
    private User user;
}
