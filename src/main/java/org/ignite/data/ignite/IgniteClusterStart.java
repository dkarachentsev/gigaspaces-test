package org.ignite.data.ignite;

import java.util.Collections;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;

/**
 *
 */
public class IgniteClusterStart {
    public static void main(String[] args) {
        Ignition.start(config(false));
    }

    static IgniteConfiguration config(boolean client) {
        IgniteConfiguration cfg = new IgniteConfiguration();

        cfg.setClientMode(client);
        cfg.setLocalHost("127.0.0.1");

        TcpDiscoveryVmIpFinder finder = new TcpDiscoveryVmIpFinder();
        finder.setAddresses(Collections.singleton("127.0.0.1:47500..47509"));

        TcpDiscoverySpi disco = new TcpDiscoverySpi();

        disco.setIpFinder(finder);

        cfg.setDiscoverySpi(disco);

        CacheConfiguration ccfg = new CacheConfiguration("test");

        cfg.setCacheConfiguration(ccfg);

        return cfg;
    }
}
