package com.distributedsystems.zookeeper;
import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * The LeaderElection class manages connections to ZooKeeper, volunteers for leadership,
 * elects a leader based on node IDs, and manages disconnections.
 * @author Tejas
 * @author Daivik
 * @author Pruthviraj
 */
public class LeaderElection implements Watcher{
    private static final String ZOOKEEPER_ADDRESS = "http://localhost:2181";
    private static final int SESSION_TIMEOUT = 3000;
    private ZooKeeper zooKeeperObj;
    private String currentZnode;
    /**
     * Connects to the ZooKeeper server.
     * @throws IOException If an I/O error occurs when connecting to ZooKeeper.
     */
    public void connectToZookeeper() throws IOException {
        this.zooKeeperObj = new ZooKeeper(ZOOKEEPER_ADDRESS, SESSION_TIMEOUT, this);
    }
    /**
     * Volunteers the current instance for leadership by creating a znode under the /election namespace.
     * @throws KeeperException If the ZooKeeper server signals an error.
     * @throws InterruptedException If the current thread is interrupted while waiting.
     */
    public void volunteerForLeadership() throws KeeperException, InterruptedException{
        String znodePrefix = "/election/c_";
        String znodeFullPath = zooKeeperObj.create(znodePrefix, new byte[]{}, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        this.currentZnode = znodeFullPath.replace("/election/", "");
    }
    /**
     * Elects a leader among the instances.
     * @throws KeeperException If the ZooKeeper server signals an error.
     * @throws InterruptedException If the current thread is interrupted while waiting.
     */
    public void electLeader() throws KeeperException, InterruptedException{
        List<String> children = zooKeeperObj.getChildren("/election", false);
        Collections.sort(children);
        String smallestChild = children.get(0);

        if (smallestChild.equals(currentZnode)) {
            System.out.println("I am the leader");
            return;
        }

        System.out.println("I am not the leader, " + smallestChild + " is the leader");
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
    public void process(WatchedEvent event){
        switch (event.getType()) {
            case None:
                if (event.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println("Successfully connected to ZooKeeper");
                } else {
                    synchronized (zooKeeperObj) {
                        System.out.println("Disconnected from ZooKeeper event received");
                        zooKeeperObj.notifyAll();
                    }
                }
        }
    }

}
