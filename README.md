# gigaspaces-test

To start Gigaspaces test:
1. Start agent and deploy space with 2 instaces, 1 instance per JVM. Min heap for GSC is 5Gb:
export XAP_GSC_OPTIONS='-Xmx5g'.
Load properties for space from space_config.properties. (I deployed with Management center).
2. Start org.ignite.data.gigaspaces.GSLoader.

To start Apache Ignite test:
1. Start two instances of org.ignite.data.ignite.IgniteClusterStart.
2. Start org.ignite.data.ignite.IgLoader.
