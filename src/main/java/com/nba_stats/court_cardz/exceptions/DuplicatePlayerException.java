package com.nba_stats.court_cardz.exceptions;

public class DuplicatePlayerException extends RuntimeException {

    public DuplicatePlayerException(String message){
        super(message);
    }
}
