package com.chrynan.tindermockup.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.chrynan.tindermockup.model.User;
import com.chrynan.tindermockup.model.UserResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.List;

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
        Gson gson =
                new GsonBuilder()
                        .registerTypeAdapter(User.class, new UserDeserializer())
                        .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        UserService service = retrofit.create(UserService.class);
        UserResult result = service.getUsers(20);
        List<User> users = result.getResults();
        Drawable defaultDrawable = getContext().getResources().getDrawable(R.drawable.tinder_icon);
        for(User u : users){
            add(new CardModel(u.getName().getFirst(), u.getPicture().getLarge(), defaultDrawable));
        }
    }

    @Override
    protected View getCardView(int i, CardModel cardModel, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.std_card_inner, viewGroup, false);
            assert view != null;
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
        Picasso.with(getContext()).load(cardModel.getDescription()).into((ImageView) view.findViewById(R.id.image));
        ((TextView) view.findViewById(R.id.title)).setText(cardModel.getTitle());
        return view;
    }

}
