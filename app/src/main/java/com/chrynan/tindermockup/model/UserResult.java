package com.chrynan.tindermockup.model;

import java.util.List;

/**
 * Created by chRyNaN on 3/6/2016.
 */
public class UserResult {
    private List<ResultObject> results;

    public UserResult(){

    }

    public UserResult(List<ResultObject> results){
        this.results = results;
    }

    public List<ResultObject> getResults() {
        return results;
    }

    public void setResults(List<ResultObject> results) {
        this.results = results;
    }

}
