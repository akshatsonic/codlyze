package com.akshatsonic.codelyze.exceptions;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientErrorException extends RuntimeException {
    public ClientErrorException(String message){
        super(message);
    }
}
