package com.example.traveler.przemek1.Inne;



        import android.content.Context;
        import android.support.annotation.NonNull;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import com.example.traveler.przemek1.R;

        import java.util.ArrayList;

/**
 * Created by User on 3/14/2017.
 */

public class Wiersz12ListAdapter extends ArrayAdapter<Wiersz12> {

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
    }

    /**
     * Default constructor for the Wiersz12ListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public Wiersz12ListAdapter(Context context, int resource, ArrayList<Wiersz12> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the persons information
        String name = getItem(position).getLewy();
        String birthday = getItem(position).getPrawyGora();
        String sex = getItem(position).getPrawyDol();

        //Create the wiersz12 object with the information
        Wiersz12 wiersz12 = new Wiersz12(name,birthday,sex);


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