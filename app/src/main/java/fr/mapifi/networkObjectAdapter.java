package fr.mapifi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 26/06/2016.
 */
public class networkObjectAdapter extends ArrayAdapter<networkObject> {
    public networkObjectAdapter(SecondActivity secondActivity, int i, List<networkObject> networkObject) {
        super(secondActivity, i, networkObject);
        try {
            this.activity = activity;
            this.lPerson = _lPerson;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e) {

        }
    }
    public static class ViewHolder {
        public TextView display_name;
        public TextView display_number;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.yourlayout, null);
                holder = new ViewHolder();

                holder.display_name = (TextView) vi.findViewById(R.id.display_name);
                holder.display_number = (TextView) vi.findViewById(R.id.display_number);


                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }
}
