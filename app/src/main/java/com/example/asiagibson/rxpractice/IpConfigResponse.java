package com.example.asiagibson.rxpractice;

/**
 * Created by asiagibson on 5/14/17.
 */

public class IpConfigResponse {

    private String ip_decimal;

    private String hostname;

    private String city;

    private String country;

    private String ip;

    public String getIp_decimal ()
    {
        return ip_decimal;
    }

    public void setIp_decimal (String ip_decimal)
    {
        this.ip_decimal = ip_decimal;
    }

    public String getHostname ()
    {
        return hostname;
    }

    public void setHostname (String hostname)
    {
        this.hostname = hostname;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getIp ()
    {
        return ip;
    }

    public void setIp (String ip)
    {
        this.ip = ip;
    }
}
