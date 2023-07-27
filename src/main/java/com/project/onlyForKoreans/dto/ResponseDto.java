package com.project.onlyForKoreans.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto<T> {
    int status;
    T data;
    private String message;

    public ResponseDto(int status, String message){
        this.status= status;
        this.data=data;
    }

    public ResponseDto(int status, T data){
        this.status = status;
        this.data = data;
    }

}
