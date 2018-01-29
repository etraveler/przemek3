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

public class BusListAdapter extends ArrayAdapter<Autobus> {

    private static final String TAG = "BusListAdapter";

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
    }

    /**
     * Default constructor for the BusListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public BusListAdapter(Context context, int resource, ArrayList<Autobus> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the persons information
        String name = getItem(position).getMarka();
        String birthday = getItem(position).getIdentyfikator();
        String sex = getItem(position).getRejestracja();

        //Create the autobus object with the information
        Autobus autobus = new Autobus(name,birthday,sex);


            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

TextView tvName = (TextView) convertView.findViewById(R.id.textView1);
TextView tvBirthday = (TextView) convertView.findViewById(R.id.textView2);
TextView tvSex = (TextView) convertView.findViewById(R.id.textView3);



        tvName.setText(name);
        tvBirthday.setText(birthday);
        tvSex.setText(sex);


        return convertView;
    }
}