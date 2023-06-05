package com.kurimaw.sbtester.managers;


import com.kurimaw.sbtester.services.services.OsService;
import com.kurimaw.sbtester.services.services.impl.OsServiceLinuxImpl;
import com.kurimaw.sbtester.services.services.impl.OsServiceWindowsImpl;

public class OsManager {

    public static OsService getOsService(String os) {
        if(os == "Windows") {
            return new OsServiceWindowsImpl();
        } else {
            return new OsServiceLinuxImpl();
        }
    }
}
