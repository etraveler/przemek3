package com.example.traveler.przemek1;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 3/14/2017.
 */

public class Wiersz22ListAdapter extends ArrayAdapter<Wiersz12> {

    private static final String TAG = "Wiersz12ListAdapter";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {
        TextView name;
        TextView birthday;
        TextView sex;
        TextView sex2;
    }

    /**
     * Default constructor for the Wiersz12ListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public Wiersz22ListAdapter(Context context, int resource, ArrayList<Wiersz12> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the persons information
        String name = getItem(position).getLewydol();
        String birthday = getItem(position).getPrawyGora();
        String sex = getItem(position).getPrawyDol();
        String sex2 = getItem(position).getLewygora();

        //Create the wiersz12 object with the information
        Wiersz12 wiersz12 = new Wiersz12(name,birthday,sex,sex2);


            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

TextView tvName = (TextView) convertView.findViewById(R.id.textView1);
TextView tvBirthday = (TextView) convertView.findViewById(R.id.textView2);
TextView tvSex = (TextView) convertView.findViewById(R.id.textView3);
TextView tvSex2 = (TextView) convertView.findViewById(R.id.textView4);


        tvName.setText(name);
        tvBirthday.setText(birthday);
        tvSex.setText(sex);
        tvSex2.setText(sex2);

        return convertView;
    }
}