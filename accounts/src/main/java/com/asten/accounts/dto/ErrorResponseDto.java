package com.asten.accounts.dto;

import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public class ErrorResponseDto {
    public ErrorResponseDto(String apiPart, HttpStatus errorCode, String errorMessage, LocalDateTime errorTime) {
        this.apiPart = apiPart;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorTime = errorTime;
    }

    private String apiPart;

    private HttpStatus errorCode;

    private String errorMessage;

    private LocalDateTime errorTime;

    public String getApiPart() {
        return apiPart;
    }

    public void setApiPart(String apiPart) {
        this.apiPart = apiPart;
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(LocalDateTime errorTime) {
        this.errorTime = errorTime;
    }


}
