package com.chrynan.tindermockup.model;

import java.util.List;

/**
 * Created by chRyNaN on 3/6/2016.
 */
public class UserResult {
    private List<User> results;

    public UserResult(){

    }

    public UserResult(List<User> results){
        this.results = results;
    }

    public List<User> getResults() {
        return results;
    }

    public void setResults(List<User> results) {
        this.results = results;
    }

}
