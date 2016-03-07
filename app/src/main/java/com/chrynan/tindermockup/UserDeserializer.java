package com.chrynan.tindermockup;

import com.chrynan.tindermockup.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by chRyNaN on 3/6/2016.
 */
public class UserDeserializer implements JsonDeserializer<User> {

    @Override
    public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement jsonUser = json.getAsJsonObject().get("user");
        return new Gson().fromJson(jsonUser, User.class);
    }

}
