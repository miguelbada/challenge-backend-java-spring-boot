package com.bada.miguel.challengebackendjavaspringboot.model.exception;

public class UsernameNotFoundException extends RuntimeException {

    public UsernameNotFoundException(String message) {
        super(message);
    }
}
