package com.chrynan.tindermockup;

import com.chrynan.tindermockup.model.UserResult;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by chRyNaN on 3/6/2016.
 */
public interface UserService {
    @GET("?results=amount")
    UserResult getUsers(@Query("results") int amount);
}
