package com.aa.dataload;

import org.apache.ignite.Ignite;
import org.apache.ignite.lang.IgniteRunnable;
import com.aa.model.FcstRunnable;

public class FcstWorkers implements Runnable {

    //    private static final Logger LOGGER = Logger.getLogger(LoadFCSTToCacheFromFile.class);
    private Ignite ignite;
    private String cacheName;
    private String dirName;
    private String fileName;

    public FcstWorkers(Ignite ignite, String cacheName, String dirName, String fileName) {

        this.ignite = ignite;
        this.cacheName = cacheName;
        this.dirName = dirName;
        this.fileName = fileName;
    }

    @Override
    public void run() {

        processLoad();
        //LOGGER.info(this.fileName + "Done");

        System.out.println(this.fileName + "Done");
    }

    private void processLoad() {
        try {
            IgniteRunnable task = new FcstRunnable(cacheName, dirName, fileName);

            ignite.compute().run(task);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return (this.fileName + "_thread");
    }
}
