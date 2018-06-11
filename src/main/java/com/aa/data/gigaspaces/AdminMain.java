package com.aa.data.gigaspaces;

import java.util.concurrent.TimeUnit;
import org.openspaces.admin.Admin;
import org.openspaces.admin.AdminFactory;

/**
 *
 */
public class AdminMain {
    public static void main(String[] args) {
        Admin admin = new AdminFactory().discoverUnmanagedSpaces()./*addLocator(locators).*/createAdmin();
        int partitionCount = admin.getSpaces().waitFor("test", 5, TimeUnit.SECONDS).getPartitions().length;

        System.out.println(partitionCount);
    }
}
