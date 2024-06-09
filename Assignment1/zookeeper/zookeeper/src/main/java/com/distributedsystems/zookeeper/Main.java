package com.distributedsystems.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * The Main class is the entry point of the application.
 * It creates an instance of LeaderElection, connects it to ZooKeeper,
 * initiates the leadership volunteering process, and manages the disconnection from ZooKeeper.
 */
@SpringBootApplication
public class Main {

	/**
	 * The main method of the application.
	 * @param args Command-line arguments. Not used in this application.
	 * @throws IOException If an I/O error occurs when connecting to ZooKeeper.
	 * @throws InterruptedException If the current thread is interrupted while waiting.
	 * @throws KeeperException If the ZooKeeper server signals an error.
	 */
	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

//		SpringApplication.run(Main.class, args);
		LeaderElection leaderElection = new LeaderElection();
		leaderElection.connectToZookeeper();
		leaderElection.volunteerForLeadership();
		leaderElection.electLeader();
		leaderElection.run();
		leaderElection.close();
		System.out.println("Disconnected from ZooKeeper, exiting application");

	}
}
