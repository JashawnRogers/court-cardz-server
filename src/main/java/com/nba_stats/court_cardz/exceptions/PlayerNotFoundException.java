package com.nba_stats.court_cardz.exceptions;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(String message){
        super(message);
    }
}
