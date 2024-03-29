package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Scanner;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Current;

public class LocationServer {
	static LinkedHashMap<String, String> table; // changed private -> none
	static Communicator communicator; // change private -> none - package-access

	public static class LocationWorkerI implements helper.LocationWorker {

		@Override
		public String locationMapping(String location, Current current) {
			return table.get(location);
		}

		@Override
		public void terminate(Current current) {
			communicator.shutdown();
			System.out.println("Location Server has terminated!");
		}

	}

	public static void main(String[] args) {
		table = readConfig();
		setupLocationWorker(args);
		communicator.waitForShutdown();
		System.exit(0);
	}

	static void setupLocationWorker(String args[]) { // change private to none - package-acess
		communicator = com.zeroc.Ice.Util.initialize(args);
		com.zeroc.Ice.ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("LocationWorker",
				"default -p 11111");
		adapter.add(new LocationWorkerI(), com.zeroc.Ice.Util.stringToIdentity("LocationWorker"));
		adapter.activate();
	}

	static LinkedHashMap<String, String> readConfig() { // changed private -> none
		File file = new File("LocationServerConfig");
		LinkedHashMap<String, String> result = new LinkedHashMap<>();
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String status = line.split(":")[0];
				String[] locations = line.split(":")[1].trim().split(",");
				for (String location : locations) {
					result.put(location, status);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

}
