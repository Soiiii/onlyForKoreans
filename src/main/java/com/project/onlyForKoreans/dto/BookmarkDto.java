package com.project.onlyForKoreans.dto;

import com.project.onlyForKoreans.model.Board;
import com.project.onlyForKoreans.model.Bookmark;
import com.project.onlyForKoreans.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookmarkDto {
    private Board board;
    private User user;
    private Bookmark bookmark;

    private Long user_id;
    private Long board_id;
    private Long book_num;
}