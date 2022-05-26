package com.bridgelab.addressbookapp.user.common;

public class CustomException {
    public static class WrongIdException extends RuntimeException{
        public WrongIdException(String message){
            super(message);
        }
    }
}
