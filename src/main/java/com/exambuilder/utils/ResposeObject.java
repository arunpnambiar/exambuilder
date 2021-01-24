package com.exambuilder.utils;

import lombok.*;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public @Data class ResposeObject {

    private String statusCode;
    private String token;
    private String info;
    private HashMap<String,Object> result;
}
