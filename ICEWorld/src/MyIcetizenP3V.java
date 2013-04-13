import java.awt.Point;

import iceworld.given.IcetizenLook;
import iceworld.given.MyIcetizen;


public class MyIcetizenP3V implements MyIcetizen {
	
	
	int IcePortID;//pid
	IcetizenLook look;
	int ListeningPort;//port
	String username;
	
	int userID;
	String ipAdress;//ip
	long type;
	
	Point position;//ex. (x,y)
	long timestamp;
	
	@Override
	public int getIcePortID() {
		
		return IcePortID;
	}

	@Override
	public IcetizenLook getIcetizenLook() {
		// TODO Auto-generated method stub
		return look;
	}

	@Override
	public int getListeningPort() {
		// TODO Auto-generated method stub
		return ListeningPort;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	public int getUserID(){
		return userID;
	}
	
	public String getIPAdress(){
		return ipAdress;
	}
	
	public long getType(){
		return type;
	}
	
	public Point getPosition(){
		return position;
	}
	
	public long getTimestamp(){
		return timestamp;
	}
	
	@Override
	public void setIcePortID(int pid) {
		// TODO Auto-generated method stub
		IcePortID = pid;
	}

	@Override
	public void setIcetizenLook(IcetizenLook l) {
		// TODO Auto-generated method stub
		look = l;
	}

	@Override
	public void setListeningPort(int port) {
		// TODO Auto-generated method stub
		ListeningPort = port;
	}

	@Override
	public void setUsername(String name) {
		// TODO Auto-generated method stub
		username = name;
	}
	
	public void setUserID(int uid){
		userID = uid;
	}
	
	public void setIPAdress(String ip){
		ipAdress = ip;
	}
	
	public void setType(long t){
		type=t;
	}
	
	public void setPosition(Point p){
		position = p;
	}
	
	public void setTimestamp(long ts){
		timestamp = ts;
	}

}
