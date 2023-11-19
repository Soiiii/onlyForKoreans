package com.project.onlyForKoreans.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
    private Long commentId;
    private String content;
    private Long board_id;
    private Long user_id;
}
