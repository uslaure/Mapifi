package fr.mapifi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 26/06/2016.
 */
public class networkObjectAdapter extends ArrayAdapter<networkObject> {
    private Activity activity;
    private ArrayList<networkObject> lNetworkObject;
    private static LayoutInflater inflater = null;

    public networkObjectAdapter (Activity activity, int textViewResourceId,ArrayList<networkObject> _lNetworkObject) {
        super(activity, textViewResourceId, _lNetworkObject);
        try {
            this.activity = activity;
            this.lNetworkObject = _lNetworkObject;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e) {

        }
    }

    public int getCount() {
        return lNetworkObject.size();
    }

    public networkObject getItem(networkObject position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView display_ip;
        public TextView display_name;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.second_activity, null);
                holder = new ViewHolder();

                holder.display_name = (TextView) vi.findViewById(R.id.display_name);
                holder.display_ip = (TextView) vi.findViewById(R.id.display_ip);


                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }



            holder.display_name.setText(lNetworkObject.get(position).ipAddress);
            holder.display_ip.setText(lNetworkObject.get(position).ipName);


        } catch (Exception e) {


        }
        return vi;
    }
}
