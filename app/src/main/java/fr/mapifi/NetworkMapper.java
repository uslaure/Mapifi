package fr.mapifi;

import android.os.AsyncTask;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 26/06/16.
 */
public class NetworkMapper extends Thread {

    ArrayList<networkObject> wifiList = new ArrayList<networkObject>();

    protected void onCreate(){
        wifiList = new ArrayList<networkObject>();
        this.WifiManager();
    }

    public void run(){
        WifiManager();
    }

    public ArrayList getWifiList(){
        return this.wifiList;
    }

    public List WifiManager(){

        int timeout = 50;
        int port = 1234;


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
                    networkObject NetworkObject = new networkObject();
                    NetworkObject.setIpAddress(host);
                    NetworkObject.setIpName(InetAddress.getByName(host).getHostName());
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