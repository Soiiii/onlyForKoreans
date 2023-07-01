package com.project.onlyForKoreans.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int book_num;

    private int status;

    @Column(nullable = false, length=100)
    private String title;

    @Lob
    private String content;

    private int count;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="countryId")
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="categoryId")
    private Category category;

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name="commentId")
//    private Comment comment;

    @OneToMany(mappedBy="board", fetch = FetchType.LAZY)
    private List<Comment> commentList;

    @OneToMany(mappedBy="board", fetch = FetchType.LAZY)
    private List<Bookmark> bookmarkList;

    @CreationTimestamp
    private Timestamp create_at;
    private Timestamp update_at;


}
