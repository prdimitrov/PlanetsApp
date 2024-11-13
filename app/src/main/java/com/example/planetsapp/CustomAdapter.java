package com.example.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.adapter.FragmentViewHolder;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Planet> {

    private ArrayList<Planet> planetsList;
    Context context;

    public CustomAdapter(ArrayList<Planet> planetsList, Context context) {
        super(context, R.layout.item_list_layout, planetsList);
        this.planetsList = planetsList;
        this.context = context;
    }

    // getView() is used to create and return a view for a
    // specific item in the list.


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //1 - Get the planet object for the current position
        Planet planet = getItem(position);
        //2 - Inflating the layout
        CustomViewHolder customViewHolder;
        final View result;

        if (convertView == null) {
            customViewHolder = new CustomViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false);

            //Finding Views
            customViewHolder.planetName = (TextView) convertView.findViewById(R.id.planetName);
            customViewHolder.moonNumber = (TextView) convertView.findViewById(R.id.moonsNumber);
            customViewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;
        }
        //        return super.getView(position, convertView, parent);
    }

    private static class CustomViewHolder {
        //Holds references to the views within an item layout
        ImageView imageView;
        TextView planetName, moonNumber;

    }
}
