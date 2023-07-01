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
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 120)
    private String physical_path;

    @Column(nullable = false, length = 50)
    private String file_name;

    @Column(nullable = false, length = 50)
    private String file_ori_name;

    @ManyToOne
    @JoinColumn(name="boardId")
    private Board board;
}
