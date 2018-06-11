package org.ignite.dataload;

import java.io.File;
import java.util.*;

import java.util.concurrent.TimeUnit;
import org.apache.ignite.*;

import java.io.IOException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class FCSTAvroLoader2 {
    /**
     * Cache name.
     */
    private static final String CACHE_NAME = "FCSTEmbeded";

    /**
     * @param args Command line arguments,  config file, data dir, number of threads.
     * @throws IgniteException If example execution failed.
     */
    public static void main(String[] args) throws IgniteException, IOException, InterruptedException {

        int numberOfThreadPools = 1;

        //LOGGER.info("Loading Started...");
        // Get a Collection of files in a directory without looking in subdirectories
//        Collection<File> files = FileUtils.listFiles(new File(dirName), FileFilterUtils.trueFileFilter(), null);
        Collection<File> files = Collections.emptyList();
        //Ignite ignite = Ignition.start(conFileName);
        Ignition.setClientMode(true);
        Ignite ignite = Ignition.start();

        //System.out.println("Loading Startedzzz");
        long startTime = System.currentTimeMillis();
        System.out.println("Load Started @milliseconds:" + startTime);


        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreadPools);
        for (File f : files) {

            Runnable worker = new FcstWorkers(ignite, CACHE_NAME, "", f.getName());
            executor.execute(worker);
        }
        executor.shutdown();

        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
//
//        while (!executor.isTerminated()) {
//        }
        //LOGGER.info("Loading done");
        //System.out.println("Loading done");
        long endTime = System.currentTimeMillis();
        System.out.println("Load done @milliseconds:" + endTime);
        System.out.println("Total in milliseconds " + (startTime - endTime));
        Ignition.stop(true);
    }
}