package com.chrynan.tindermockup.model;

/**
 * Created by chRyNaN on 3/7/2016.
 */
public class ResultObject {
    private User user;
    private String seed;

    public ResultObject(){

    }

    public ResultObject(User user, String seed){
        this.user = user;
        this.seed = seed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

}
