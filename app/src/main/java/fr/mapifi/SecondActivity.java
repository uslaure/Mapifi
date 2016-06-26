package fr.mapifi;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import fr.mapifi.networkObject;

/**
 * Created by user on 22/06/2016.
 */
public class SecondActivity extends  MainActivity{
    ImageView imgView;
    WifiManager mainWifi;
    List<networkObject> wifiList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        imgView = (ImageView) findViewById(R.id.img);
        wifiList = new ArrayList<networkObject>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                testWifiManager();
            }
        }).start();

    }

    public List testWifiManager(){

        int timeout = 500;
        int port = 1234;
        networkObject NetworkObject = new networkObject();

        try {
            String currentIP = InetAddress.getLocalHost().toString();
            System.out.println(currentIP);
//            String subnet = getSubnet(currentIP);
            String subnet = "192.168.1.";
            System.out.println("subnet: " + subnet);


            for (int i=1;i<254;i++){

                String host = subnet + i;
                System.out.println("Checking :" + host);

                if (InetAddress.getByName(host).isReachable(timeout)){
                    System.out.println(host + " is reachable");
                    System.out.println(InetAddress.getByName(host).getHostName());
                    NetworkObject.setIpAddress(host);
                    NetworkObject.setipName(InetAddress.getByName(host).getHostName());
                    wifiList.add(NetworkObject);
                    try {
                        Socket connected = new Socket(subnet, port);
                    }
                    catch (Exception s) {
                        System.out.println(s);
                    }
                }
            }
        }
        catch(Exception e){
            System.out.print("error");
            System.out.println(e);
        }
        return wifiList;
    }

    public static String getSubnet(String currentIP) {
        int firstSeparator = currentIP.lastIndexOf("/");
        int lastSeparator = currentIP.lastIndexOf(".");
        return currentIP.substring(firstSeparator+1, lastSeparator+1);
    }
}
