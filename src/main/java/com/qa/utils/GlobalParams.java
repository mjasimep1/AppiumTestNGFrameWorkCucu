package com.qa.utils;

public class GlobalParams {
    private static ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static ThreadLocal<String> udid = new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
    private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();
    private static ThreadLocal<String> avd = new ThreadLocal<String>();
    private static ThreadLocal<String> avdLaunchTimeout = new ThreadLocal<String>();

public void setPlatformName(String platformName1){
    platformName.set(platformName1);
}
public String getPlatformName(){
    return platformName.get();
}
    public void setUdid(String udid1){
        udid.set(udid1);
    }
    public String getUdid(){
        return udid.get();
    }
    public void setDeviceName(String deviceName1){
        deviceName.set(deviceName1);
    }
    public String getDeviceName(){
        return deviceName.get();
    }
    public void setSystemPort(String systemPort1){
        systemPort.set(systemPort1);
    }
    public String getSystemPort(){
        return systemPort.get();
    }
    public void setChromeDriverPort(String chromeDriverPort1){
        chromeDriverPort.set(chromeDriverPort1);
    }
    public String getChromeDriverPort(){
        return chromeDriverPort.get();
    }
    public void setAvd(String avd1){
        avd.set(avd1);
    }
    public String getAvd(){
        return avd.get();
    }
   /* public void setAvdLaunchTimeout(String avdLaunchTimeout1){
        avdLaunchTimeout.set(avdLaunchTimeout1);
    }
    public String getAvdLaunchTimeout(){
        return avdLaunchTimeout.get();
    }*/
    public void initializeGlobalParams(){
        GlobalParams params = new GlobalParams();
        params.setPlatformName(System.getProperty("platformName", "Android"));
        params.setUdid(System.getProperty("udid", "emulator-5554"));
        params.setDeviceName(System.getProperty("deviceName", "Pixel_6"));
        params.setSystemPort(System.getProperty("systemPort", "10000"));
        params.setChromeDriverPort(System.getProperty("chromeDriverPort", "11000"));
        params.setAvd(System.getProperty("avd","Pixel_6"));
        //params.setAvdLaunchTimeout(System.getProperty("avdLaunchTimeout","180000"));

        switch(params.getPlatformName()){
            case "Android":
               // params.setSystemPort(System.getProperty("systemPort", "10000"));
               // params.setChromeDriverPort(System.getProperty("chromeDriverPort", "11000"));
                break;
            case "iOS":
                System.out.println("ios not configured in this system");
                break;
            default:
                throw new IllegalStateException("Invalid Platform Name!");
        }
    }
}
