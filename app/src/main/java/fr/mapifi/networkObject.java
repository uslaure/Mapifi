package fr.mapifi;

import android.os.Bundle;

/**
 * Created by root on 26/06/16.
 */
public class networkObject {

    String ipAddress;
    String ipName;
    String MACAddress;

    public void onCreate(String ipAddress, String ipName){
        this.ipName = ipName;
        this.ipAddress = ipAddress;
    }

    public void setIpAddress(String ipAddress){
        this.ipAddress = ipAddress;
    }

    public void setIpName(String ipName){
        this.ipName = ipName;
    }

    public String getIpName(){
        return this.ipName;
    }

    public String getIpAddress() {
        return ipAddress;
    }
}
