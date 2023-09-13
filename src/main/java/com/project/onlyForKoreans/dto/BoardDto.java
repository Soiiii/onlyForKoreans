package com.project.onlyForKoreans.dto;

import com.project.onlyForKoreans.model.Board;
import com.project.onlyForKoreans.model.Bookmark;
import com.project.onlyForKoreans.model.Category;
import com.project.onlyForKoreans.model.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
    private Board board;
    private String title;
    private String content;
    private int book_num;

    private Country country;
    private Category category;
    private Bookmark bookmark;


}
