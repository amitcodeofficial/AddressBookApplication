package com.bridgelab.addressbookapp.user.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class CustomError {
    private String message;
    private HttpStatus httpStatus;
    private String timeStamp;
}
