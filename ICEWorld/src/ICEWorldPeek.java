import java.net.*;
import java.io.*;
import java.util.Scanner;
public class ICEWorldPeek {
	private boolean connection;
	public ICEWorldPeek(){
		connection = false;
	}
	public static void main(String[] args){
		ICEWorldPeek c = new ICEWorldPeek();
		System.out.println("--ICE World Peek--\n");
		if(c.isConnected()){
			System.out.println("ICE World is connected.\n");
		}
		while(c.isConnected()){
			c.getRequest();
			System.out.println("--------------------------");
		}
	}
	
	public boolean isConnected(){
		try {
			URL myURL = new URL("http://iceworld.sls-atl.com/api/explore");
			URLConnection myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			connection = true;
			
		} 
		catch (MalformedURLException e) { 
			//connection = true;
			System.out.println("Invalid URL");
			System.out.println("Please try again");
		} 
		catch (IOException e) {   
			// openConnection() failed
			// ...
			System.out.println("ICE World cannot be reached");
			System.out.println("Please try again");
		}
		return connection;
	}
	
	public String getRequest(){
		try{
			Scanner kb = new Scanner (System.in);
			System.out.print("Enter: ");
			String requestName = kb.next();
			URL request = null;
			if(requestName.equals("time")){
				request = new URL("http://iceworld.sls-atl.com/api/&cmd=time");
			}else if(requestName.equals("state")){
				request = new URL("http://iceworld.sls-atl.com/api/&cmd=states");
			}else if (requestName.equals("actions")){
				System.out.print("from: ");
				String from = kb.next();
				request = new URL("http://iceworld.sls-atl.com/api/&cmd=actions&from="+from);
			}else if (requestName.equals("gresources")){
				System.out.print("uid: ");
				String uid = kb.next();
				request = new URL("http://iceworld.sls-atl.com/api/&cmd=gresources&uid="+uid);
			}else if( requestName.equals("gurl")){
				System.out.print("gid: ");
				String gid = kb.next();
				request = new URL("http://iceworld.sls-atl.com/api/&cmd=gurl&gid="+gid);
			}else{
				System.out.println("Invalid request");
				System.out.println("--------------------------");
				return getRequest();
				
			}
			/*if(request!=null){
				BufferedReader in = new BufferedReader(
						new InputStreamReader(request.openStream()));

				String inputLine;
				while ((inputLine = in.readLine()) != null)
					System.out.println(inputLine);
				in.close();
			}*/
			
			return getRequest(request);
			
		} catch (MalformedURLException e) {
			System.out.println("Cannot get request");
			System.out.println("--------------------------");
			return getRequest();
			// new URL() failed
			// ...
		}
	}
	public String getRequest(URL url){
		try {
			BufferedReader in;
			in = new BufferedReader(
					new InputStreamReader(url.openStream()));
			String inputLine="";
			String temp="";
			while ((temp = in.readLine()) != null)
				inputLine+=temp;
			in.close();
			return inputLine;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Cannot get request");
			System.out.println("--------------------------");
			return getRequest();
		}
		
	}
}
