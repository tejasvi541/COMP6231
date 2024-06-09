package com.distributedsystems.zookeeper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * The LeaderElection class manages connections to ZooKeeper, volunteers for leadership,
 * elects a leader based on node IDs, and manages disconnections.
 * @author Tejasvi
 * @author Daivik
 * @author Pruthviraj
 */
public class LeaderElection implements Watcher {
    private static final Logger logger = LogManager.getLogger(LeaderElection.class);
    private static final String ZOOKEEPER_ADDRESS = "localhost:2181";
    private static final int SESSION_TIMEOUT = 3000;
    private ZooKeeper zooKeeperObj;
    private String currentZnode;

    /**
     * Connects to the local ZooKeeper server.
     * @throws IOException If an I/O error occurs when connecting to ZooKeeper.
     */
    public void connectToZookeeper() throws IOException {
        this.zooKeeperObj = new ZooKeeper(ZOOKEEPER_ADDRESS, SESSION_TIMEOUT, this);
    }

    /**
     * Volunteers the current instance for leadership by creating a ephemerl sequential znode under the /election namespace.
     * @throws KeeperException If the ZooKeeper server signals an error.
     * @throws InterruptedException If the current thread is interrupted while waiting.
     */
    public void volunteerForLeadership() throws KeeperException, InterruptedException {
        String znodePrefix = "/election/c_";

        // Ensure the parent /election znode exists
        if (zooKeeperObj.exists("/election", false) == null) {
            zooKeeperObj.create("/election", new byte[]{}, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            logger.info("Created /election znode");
        }

        String znodeFullPath = zooKeeperObj.create(znodePrefix, new byte[]{}, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        this.currentZnode = znodeFullPath.replace("/election/", "");
        logger.info("Znode name: {}", this.currentZnode);
    }

    /**
     * The basic election algo which selects the leader on the basis of smallest sequential number
     * @throws KeeperException If the ZooKeeper server signals an error.
     * @throws InterruptedException If the current thread is interrupted while waiting.
     */
    public void electLeader() throws KeeperException, InterruptedException {
        List<String> children = zooKeeperObj.getChildren("/election", this);
        Collections.sort(children);
        String smallestChild = children.get(0);

        if (smallestChild.equals(currentZnode)) {
            logger.info("I am the leader");
        } else {
            logger.info("I am not the leader, {} is the leader", smallestChild);
        }
    }

    /**
     * Puts the main thread into a wait state.
     * @throws InterruptedException If the current thread is interrupted while waiting.
     */
    public void run() throws InterruptedException {
        synchronized (zooKeeperObj) {
            zooKeeperObj.wait();
        }
    }

    /**
     * Closes the connection to the ZooKeeper server.
     * @throws InterruptedException If the current thread is interrupted while waiting.
     */
    public void close() throws InterruptedException {
        zooKeeperObj.close();
    }

    /**
     * Called whenever a new event is received from the ZooKeeper server.
     * Handles connection and disconnection events.
     * @param event The event received from the ZooKeeper server.
     */
    @Override
    public void process(WatchedEvent event) {
        switch (event.getType()) {
            case None:
                if (event.getState() == Event.KeeperState.SyncConnected) {
                    logger.info("Successfully connected to ZooKeeper");
                } else {
                    synchronized (zooKeeperObj) {
                        logger.warn("Disconnected from ZooKeeper event received");
                        zooKeeperObj.notifyAll();
                    }
                }
                break;
            case NodeChildrenChanged:
                try {
                    electLeader();
                } catch (KeeperException | InterruptedException e) {
                    logger.error("Error while electing leader", e);
                }
                break;
        }
    }
}
