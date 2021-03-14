package com.example.youtube.demo.exception;

public class YoutubeMailException extends RuntimeException {
    public YoutubeMailException(String exception_while_sending_mail) {
        super(exception_while_sending_mail);
    }
}
