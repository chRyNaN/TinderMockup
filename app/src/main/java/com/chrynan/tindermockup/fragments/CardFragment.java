package com.chrynan.tindermockup.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andtinder.model.Orientations;
import com.andtinder.view.CardContainer;
import com.chrynan.tindermockup.R;
import com.chrynan.tindermockup.adapters.UserCardAdapter;
import com.getbase.floatingactionbutton.FloatingActionButton;

/**
 * Created by chRyNaN on 3/6/2016.
 */
public class CardFragment extends Fragment {
    private com.andtinder.view.CardContainer cardContainer;
    private UserCardAdapter adapter;
    private FloatingActionButton dislike;
    private FloatingActionButton superlike;
    private FloatingActionButton like;

    public static CardFragment newInstance(){
        return new CardFragment();
    }

    @Override
    @SuppressWarnings("deprecation")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.from(container.getContext()).inflate(R.layout.card_fragment, container, false);
        cardContainer = (CardContainer) v.findViewById(R.id.card_container);
        cardContainer.setOrientation(Orientations.Orientation.Disordered);
        //adapter = new UserCardAdapter(getContext());
        //cardContainer.setAdapter(adapter);
        dislike = (FloatingActionButton) v.findViewById(R.id.dislike);
        superlike = (FloatingActionButton) v.findViewById(R.id.superlike);
        like = (FloatingActionButton) v.findViewById(R.id.like);
        //set up these fields in code because the library doesn't properly handle the xml custom attributes
        dislike.setColorNormal(getContext().getResources().getColor(R.color.tinder_red));
        dislike.setColorPressed(getContext().getResources().getColor(R.color.tinder_red));
        dislike.setIconDrawable(getContext().getResources().getDrawable(R.drawable.tinder_dislike));
        superlike.setColorNormal(getContext().getResources().getColor(R.color.tinder_blue));
        superlike.setColorPressed(getContext().getResources().getColor(R.color.tinder_blue));
        superlike.setIconDrawable(getContext().getResources().getDrawable(R.drawable.superlike));
        like.setColorNormal(getContext().getResources().getColor(R.color.tinder_green));
        like.setColorPressed(getContext().getResources().getColor(R.color.tinder_green));
        like.setIconDrawable(getContext().getResources().getDrawable(R.drawable.tinder_like));
        return v;
    }

}
