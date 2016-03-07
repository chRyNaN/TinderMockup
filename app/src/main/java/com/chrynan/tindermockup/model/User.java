package com.chrynan.tindermockup.model;

/**
 * Created by chRyNaN on 3/6/2016.
 */
public class User {
    private String gender;
    private Name name;
    private String email;
    private String username;
    private Picture picture;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public static class Name{
        private String title;
        private String first;
        private String last;

        public Name(){

        }

        public Name(String title, String first, String last){
            this.title = title;
            this.first = first;
            this.last = last;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

    }

    public static class Picture{
        private String large;
        private String medium;
        private String thumbnail;

        public Picture(){

        }

        public Picture(String large, String medium, String thumbnail){
            this.large = large;
            this.medium = medium;
            this.thumbnail = thumbnail;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

    }


}
