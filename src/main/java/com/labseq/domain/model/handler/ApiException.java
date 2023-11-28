package com.labseq.domain.model.handler;

import lombok.*;
import org.springframework.http.ResponseEntity;

@Builder(builderMethodName = "newBuilder")
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiException{
        private String message;
        private int status;

}