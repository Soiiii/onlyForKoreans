package com.project.onlyForKoreans.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private String email;
    private String password;
    private String country;
    private String name;
}
