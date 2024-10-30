package com.akshatsonic.codelyze.exceptions;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ClientErrorException extends RuntimeException {
    public ClientErrorException(String message){
        super(message);
    }
}
