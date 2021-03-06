package fr.mapifi;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import fr.mapifi.NetworkMapper;

/**
 * Created by user on 22/06/2016.
 */
public class SecondActivity extends  MainActivity{
    ImageView imgView;
    ListView listView;
    List<networkObject> wifiList;
    NetworkMapper Mapper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        imgView = (ImageView) findViewById(R.id.img);
        listView = (ListView) findViewById(R.id.list);
        wifiList = new ArrayList<networkObject>();
        Mapper = new NetworkMapper();
        this.launchScan();
    }

    public List launchScan(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Mapper.WifiManager();
                ArrayList<networkObject> wifiList = Mapper.getWifiList();
                for (int i = 0; i<wifiList.size(); i++) {
                    Log.i("Member name: ", wifiList.get(i).getIpName());
                    Log.i("Member name: ", wifiList.get(i).getIpAddress());
                    wifiList.get(i);
                }
            }
        }).start();
        networkObjectAdapter adbPerson;
        ArrayList<networkObject> myListItems  = new ArrayList<networkObject>();

//then populate myListItems

        adbPerson= new networkObjectAdapter (SecondActivity.this, 0, (ArrayList<networkObject>) wifiList);
        listView.setAdapter(adbPerson);
        return wifiList;
    }
}
