package com.chrynan.tindermockup.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chrynan.tindermockup.R;

/**
 * Created by chRyNaN on 3/6/2016.
 */
public class NavigationListAdapter extends ArrayAdapter<NavigationListAdapter.Item> {
    private String[] itemTitles;
    private String[] itemDescriptions;
    private Drawable[] itemIcons;

    public NavigationListAdapter(Context context){
        super(context, 0);
        itemTitles = context.getResources().getStringArray(R.array.navigation_drawer_titles);
        itemDescriptions = context.getResources().getStringArray(R.array.navigation_drawer_descriptions);
        for(int i = 0; i < itemTitles.length; i++){
            add(new Item(itemTitles[i], itemDescriptions[i], null));
        }
    }

    public NavigationListAdapter(Context context, String[] itemTitles, String[] itemDescriptions, Drawable[] itemIcons){
        super(context, 0);
        if(itemTitles == null || itemDescriptions == null || itemIcons == null){
            throw new IllegalArgumentException("itemTitles, itemDescriptions, and itemIcons parameters must not be null.");
        }
        if(itemTitles.length != itemDescriptions.length || itemTitles.length != itemIcons.length){
            throw new IllegalArgumentException("All array parameters must have the same length");
        }
        this.itemTitles = itemTitles;
        this.itemDescriptions = itemDescriptions;
        this.itemIcons = itemIcons;
        for(int i = 0; i < itemTitles.length; i++){
            add(new Item(itemTitles[i], itemDescriptions[i], itemIcons[i]));
        }
    }

    public String[] getItemTitles() {
        return itemTitles;
    }

    public String[] getItemDescriptions() {
        return itemDescriptions;
    }

    public Drawable[] getItemIcons() {
        return itemIcons;
    }

    public String getItemTitleAt(int position){
        return itemTitles[position];
    }

    public String getItemDescriptionAt(int position){
        return itemDescriptions[position];
    }

    public Drawable getItemDrawableAt(int position){
        return itemIcons[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if(convertView != null){
            holder = (ViewHolder) convertView.getTag();
            if(holder == null){
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            }
        }else{
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.navigation_list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        Item item = getItem(position);
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        holder.imageView.setImageDrawable(item.getIcon());
        return convertView;
    }

    public static class ViewHolder{
        ImageView imageView;
        TextView title;
        TextView description;

        public ViewHolder(View view){
            imageView = (ImageView) view.findViewById(R.id.icon);
            title = (TextView) view.findViewById(R.id.title);
            description = (TextView) view.findViewById(R.id.description);
        }

    }

    public static class Item{
        private String title;
        private String description;
        private Drawable icon;

        public Item(String title, String description, Drawable icon){
            this.title = title;
            this.description = description;
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public Drawable getIcon() {
            return icon;
        }

    }

}
