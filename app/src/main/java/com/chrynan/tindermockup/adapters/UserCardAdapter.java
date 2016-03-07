package com.chrynan.tindermockup.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andtinder.model.CardModel;
import com.andtinder.view.CardStackAdapter;
import com.chrynan.tindermockup.R;
import com.chrynan.tindermockup.UserDeserializer;
import com.chrynan.tindermockup.UserService;
import com.chrynan.tindermockup.model.ResultObject;
import com.chrynan.tindermockup.model.User;
import com.chrynan.tindermockup.model.UserResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by chRyNaN on 3/6/2016.
 */
public class UserCardAdapter extends CardStackAdapter {

    public UserCardAdapter(Context context) {
        super(context);
        loadUsers();
    }

    @SuppressWarnings("deprecation")
    private void loadUsers(){
        new AsyncTask<Void, Void, UserResult>(){
            @Override
            protected UserResult doInBackground(Void... params) {
                try {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://api.randomuser.me/")
                            .addConverterFactory(GsonConverterFactory.create()) //We're using Gson to deserialize our response
                            .build();
                    UserService service = retrofit.create(UserService.class); //Creates an implementation of our interface
                    Call<UserResult> call = service.getUsers(20); //Our method call returns our Call object of type UserResult
                    return call.execute().body();//execute our call object (blocking) and the body is our UserResult object
                }catch(Exception e){
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            public void onPostExecute(UserResult result){
                if(result != null) {
                    //Take the result and add the User information to cards that can be swiped
                    Drawable defaultDrawable = getContext().getResources().getDrawable(R.drawable.tinder_icon);
                    User u;
                    for (ResultObject r : result.getResults()) {
                        u = r.getUser();
                        add(new CardModel(u.getName().getFirst(), u.getPicture().getLarge(), defaultDrawable));
                    }
                }
            }
        }.execute();
    }

    @Override
    protected View getCardView(int i, CardModel cardModel, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.card, viewGroup, false);
        }
        cardModel.setOnClickListener(new CardModel.OnClickListener() {
            @Override
            public void OnClickListener() {
                //TODO Add logic
            }
        });
        cardModel.setOnCardDimissedListener(new CardModel.OnCardDimissedListener() {
            @Override
            public void onLike() {
                //TODO Add logic
            }

            @Override
            public void onDislike() {
                //TODO Add logic
            }
        });
        Picasso.with(getContext()).load(cardModel.getDescription()).fit().into((ImageView) view.findViewById(R.id.image));
        ((TextView) view.findViewById(R.id.name)).setText(cardModel.getTitle());
        return view;
    }

}
