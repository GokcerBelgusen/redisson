/**
 * Copyright 2016 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.config;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.redisson.misc.URLBuilder;

/**
 * Configuration for an AWS ElastiCache replication group. A replication group is composed
 * of a single master endpoint and multiple read slaves.
 *
 * @author Steve Ungerer
 * @author Nikita Koksharov
 */
public class ElasticacheServersConfig extends BaseMasterSlaveServersConfig<ElasticacheServersConfig> {

    /**
     * Replication group node urls list
     */
    private List<URL> nodeAddresses = new ArrayList<URL>();

    /**
     * Replication group scan interval in milliseconds
     */
    private int scanInterval = 1000;

    /**
     * Database index used for Redis connection
     */
    private int database = 0;

    public ElasticacheServersConfig() {
    }

    ElasticacheServersConfig(ElasticacheServersConfig config) {
        super(config);
        setNodeAddresses(config.getNodeAddresses());
        setScanInterval(config.getScanInterval());
        setDatabase(config.getDatabase());
    }

    /**
     * Add Redis cluster node address. Use follow format -- <code>host:port</code>
     *
     * @param addresses in <code>host:port</code> format
     * @return config
     */
    public ElasticacheServersConfig addNodeAddress(String ... addresses) {
        for (String address : addresses) {
            nodeAddresses.add(URLBuilder.create(address));
        }
        return this;
    }
    public List<URL> getNodeAddresses() {
        return nodeAddresses;
    }
    void setNodeAddresses(List<URL> nodeAddresses) {
        this.nodeAddresses = nodeAddresses;
    }

    public int getScanInterval() {
        return scanInterval;
    }
    /**
     * Elasticache node scan interval in milliseconds
     *
     * @param scanInterval in milliseconds
     * @return config
     */
    public ElasticacheServersConfig setScanInterval(int scanInterval) {
        this.scanInterval = scanInterval;
        return this;
    }

    /**
     * Database index used for Redis connection
     * Default is <code>0</code>
     *
     * @param database number
     * @return config
     */
    public ElasticacheServersConfig setDatabase(int database) {
        this.database = database;
        return this;
    }
    public int getDatabase() {
        return database;
    }

}
