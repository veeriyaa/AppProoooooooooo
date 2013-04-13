import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TestState {
	private boolean connection;

	public TestState() {
		connection = false;
	}

	public static void main(String[] args) {
		TestState c = new TestState();
		System.out.println("--ICE World Peek--\n");
		if (c.isConnected()) {
			System.out.println("ICE World is connected.\n");

			/*
			 * Scanner kb = new Scanner (System.in); String http = kb.next();
			 */
			c.getRequest();
		}
	}

	public boolean isConnected() {
		try {
			URL myURL = new URL("http://iceworld.sls-atl.com/api/explore");
			URLConnection myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			connection = true;

		} catch (MalformedURLException e) {
			// connection = true;
			System.out.println("Invalid URL");
			System.out.println("Please try again");
		} catch (IOException e) {
			// openConnection() failed
			// ...
			System.out.println("ICE World cannot be reached");
			System.out.println("Please try again");
		}
		return connection;
	}

	public void getRequest() {

		try {

			Scanner kb = new Scanner(System.in);
			System.out.print("Enter: ");

			String requestName = kb.next();

			URL request;

			if (requestName.equals("time")) {
				request = new URL("http://iceworld.sls-atl.com/api/&cmd=time");
			} else if (requestName.equals("state")) {
				request = new URL("http://iceworld.sls-atl.com/api/&cmd=states");
			} else if (requestName.equals("actions")) {
				System.out.print("from: ");
				String from = kb.next();
				request = new URL(
						"http://iceworld.sls-atl.com/api/&cmd=actions&from="
								+ from);
			} else if (requestName.equals("gresources")) {
				System.out.print("uid: ");
				String uid = kb.next();
				request = new URL(
						"http://iceworld.sls-atl.com/api/&cmd=gresources&uid="
								+ uid);
			} else if (requestName.equals("gurl")) {
				System.out.print("gid: ");
				String gid = kb.next();
				request = new URL(
						"http://iceworld.sls-atl.com/api/&cmd=gurl&gid=" + gid);
			} else {
				System.out.println("Invalid request");
				request = null;
			}
			if (request != null) {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						request.openStream()));

				String inputLine;
				while ((inputLine = in.readLine()) != null)
					System.out.println(inputLine);
				in.close();
			}
			System.out.println("--------------------------");
			getRequest();

		} catch (MalformedURLException e) {
			System.out.println("Cannot get request");
			System.out.println("--------------------------");
			getRequest();
			// new URL() failed
			// ...
		} catch (IOException e) {
			System.out.println("Cannot get request");
			System.out.println("--------------------------");
			getRequest();
			// openConnection() failed
			// ...
		}

		/*
		 * URL oracle = new URL("http://www.oracle.com/"); URLConnection yc =
		 * oracle.openConnection(); BufferedReader in = new BufferedReader(new
		 * InputStreamReader( yc.getInputStream())); String inputLine; while
		 * ((inputLine = in.readLine()) != null) System.out.println(inputLine);
		 * in.close();
		 */
	}

	public static String getAdd(String s) {
		String inputLine = "";
		String output = "";
		try {

			URL request;
			
			request = new URL("http://iceworld.sls-atl.com/api/&cmd=gurl&gid="
					+ s);

			if (request != null) {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						request.openStream()));

				while ((inputLine = in.readLine()) != null){
					System.out.println(inputLine);
					output+=inputLine;
					}
				in.close();
			}
		} catch (MalformedURLException e) {
			System.out.println("Cannot get request");
			System.out.println("--------------------------");
			//getAdd("Error");
			// new URL() failed
			// ...
		} catch (IOException e) {
			System.out.println("Cannot get request");
			System.out.println("--------------------------");
			//getAdd("error");
		}
		return output;

	}
}
