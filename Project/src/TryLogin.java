import iceworld.given.ICEWorldImmigration;
import iceworld.given.IcetizenLook;


public class TryLogin {
	public static void main(String []args){
		//create a dummy icetizen
		MyIcetizenP3V tester = new MyIcetizenP3V();
		
		String username = "Veeriya.R";
		String password = "7987020";
		
		//set the information for the icetizen
		tester.setIcePortID(250);
		tester.setUsername(username);
		tester.setListeningPort(12345);
		
		//set the look for our icetizen
		IcetizenLook look = new IcetizenLook();
		//number can be checked at gresources with uid  = 0 
		look.gidB = "B005";
		look.gidS = "S022";
		look.gidH = "H017";
		look.gidW = "W077";
		
		//initiate the instance to connect to ICEWorld
		ICEWorldImmigration immigration = new ICEWorldImmigration(tester);
		
		//try logging in
		if (immigration.login(password)){
			System.out.println("Logging in as : "+username+" success.");
			//change our icetizen to the according look
			if(immigration.customization(look)){
				System.out.println("Look has been customized.");
			}else{
				System.out.println("Look hasn't been customized.");
			}
		}else{
			System.out.println("Could not login");
		}
	}
}
