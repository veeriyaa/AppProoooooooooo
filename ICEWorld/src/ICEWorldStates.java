import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;


import iceworld.given.*;

import org.json.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class ICEWorldStates {

	ICEWorldPeek ice = new ICEWorldPeek();
	LinkedList<MyIcetizen> userList= new LinkedList<MyIcetizen>();
	String condition;
	long last_change;
	String current_time;

	public String getTime(){
		return current_time;
	}
	public String getWeatherCondition(){
		return condition;
	}
	public long getWeatherLastChange(){
		return last_change;
	}public LinkedList<MyIcetizen> getUserList(){
		return userList;
	}
	
	public void setTime() throws MalformedURLException{
		String time = ice.getRequest(new URL("http://iceworld.sls-atl.com/api/&cmd=time"));
		JSONObject jtime = (JSONObject)JSONValue.parse(time);
		current_time = (String) jtime.get("data");
	}
	public void setWeather() throws MalformedURLException{
		String states = ice.getRequest(new URL("http://iceworld.sls-atl.com/api/&cmd=states"));
		JSONObject jstates = (JSONObject) JSONValue.parse(states);
		JSONObject data = (JSONObject) jstates.get("data");
		JSONObject weather = (JSONObject) data.get("weather");
		condition =  weather.get("condition").toString();
		//System.out.println("Weather condition:"+condition);
		last_change = (Long)weather.get("last_change");
		//System.out.println("Last Weather Change:"+last_change);
	}
	public void setUser() throws MalformedURLException{
		String states = ice.getRequest(new URL("http://iceworld.sls-atl.com/api/&cmd=states"));
		JSONObject jstates = (JSONObject) JSONValue.parse(states);
		JSONObject data = (JSONObject) jstates.get("data");
		JSONObject icetizen = (JSONObject) data.get("icetizen");
		Set keys = icetizen.keySet();
		for(Object key: keys){
			JSONObject userid = (JSONObject) icetizen.get(key);
			JSONObject last_known_destinantion = (JSONObject) userid.get("last_known_destination");
			try{
				//if(!last_known_destinantion.get("timestamp").equals(null) && !last_known_destinantion.get("position").equals(null)){

				String timestampString = ""+last_known_destinantion.get("timestamp");
				String stringPosition = (String) last_known_destinantion.get("position");
				long timestamp = Long.parseLong(timestampString);

				int beginIndexX = 1;
				int endIndexX = stringPosition.indexOf(",");
				int beginIndexY = endIndexX+1;
				int endIndexY = stringPosition.indexOf(")");


				int x = Integer.parseInt(stringPosition.substring(beginIndexX, endIndexX));

				int y = Integer.parseInt(stringPosition.substring(beginIndexY, endIndexY));


				Point position = new Point(x , y);
				JSONObject user = (JSONObject) userid.get("user");
				/*
				System.out.println("==========================");
				System.out.println(stringPosition);

				System.out.println("UserID:"+ Integer.parseInt((String) key));
				System.out.println("username:" + user.get("username"));
				System.out.println("type:" + user.get("type"));
				System.out.println("ip:" + user.get("ip"));
				System.out.println("port:" + user.get("port"));
				System.out.println("pid:" + user.get("pid"));
				System.out.println("stringpositon:"+stringPosition);
				System.out.println("postion:"+position);
				System.out.println("timestamp:"+timestamp);
				*/
				//int d = user.get("type");
				
				//System.out.println("==========================");
				int uid = Integer.parseInt((String)key);
				//System.out.println("uid: "+uid);
				String username = (String) user.get("username");
				//System.out.println("username: "+username);
				long type = (Long) user.get("type");
				//System.out.println("type: "+type);
				String ip = (String) user.get("ip");
				//System.out.println("ip: "+ip);
				
				/*if(username.equals("SivaGod")||username.equals("EtherealProgrammer")){
					long port = (Long)user.get("port");
					System.out.println("port: "+port);
					long pid = (Long)user.get("pid");
					System.out.println("pid: "+pid);
				}else{
					Object listeningPort =  user.get("port");
					int port = Integer.parseInt((String)listeningPort);
					System.out.println("port: "+port);
					Object portID =  user.get("pid");
					int pid = Integer.parseInt((String)portID);
					System.out.println("pid: "+pid);
				}*/
				int pid;
				int port;
				if(username.equals("SivaGod")||username.equals("EtherealProgrammer")){
					pid = 0;
					port = 0;
				}else{
					Object listeningPort =  user.get("port");
					port = Integer.parseInt((String)listeningPort);
					//System.out.println("port: "+port);
					Object portID =  user.get("pid");
					pid = Integer.parseInt((String)portID);
					//System.out.println("pid: "+pid);
				}
					//long port = Integer.parseInt((String)user.get("port"));
				//Object listeningPort =  user.get("port");
				//int port = Integer.parseInt((String)listeningPort);
				//System.out.println("port: "+port);
				//long pid = (Long)user.get("pid");
				//Object portID =  user.get("pid");
				//int pid = Integer.parseInt((String)portID);
				//System.out.println("pid: "+pid);
				
				//System.out.println(timestamp);
				//System.out.println(position);
				//System.out.println(uid);
				//System.out.println(username);
				//System.out.println(type);
				//System.out.println(ip);
				//System.out.println(port);
				//System.out.println(pid);
				//System.out.println("==========================");
				MyIcetizenP3V myIcetizen = new MyIcetizenP3V();
				myIcetizen.setIcePortID(pid);
				myIcetizen.setListeningPort(port);
				myIcetizen.setUsername(username);
				myIcetizen.setUserID(uid);
				myIcetizen.setIPAdress(ip);
				myIcetizen.setType(type);
				myIcetizen.setPosition(position);
				myIcetizen.setTimestamp(timestamp);
				userList.add(myIcetizen);

				//}else{

				//}
			}catch(Exception e){
				System.out.println();
				System.out.println("error");
			}
		}
	}
	/*public void setAction() throws MalformedURLException{
		int userNumber = userList.size();
		String action = ice.getRequest(new URL("http://iceworld.sls-atl.com/api/&cmd=actions&from="+current_time));
		JSONObject jaction = (JSONObject) JSONValue.parse(action);
		
		JSONObject data = (JSONObject) jaction.get("data");
		Set keys = data.keySet();
		for(Object key:keys)
		System.out.println((String)key);
	}
	public static void main(String[] args){
		ICEWorldStates states = new ICEWorldStates();
		try {
			states.setAction();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public IcetizenLook getLook(int uid) throws MalformedURLException{
		String looks = ice.getRequest(new URL("http://iceworld.sls-atl.com/api/&cmd=gresources&uid="+uid));
		JSONObject jlooks = (JSONObject) JSONValue.parse(looks);
		JSONArray d = (JSONArray) jlooks.get("data");
		JSONObject data = (JSONObject) d.get(0);
		IcetizenLook f = new IcetizenLook();
		f.gidB = (String) data.get("B");
		f.gidH =(String) data.get("H");
		f.gidS = (String) data.get("S");
		f.gidW = (String) data.get("W");
		
		System.out.println("B: "+f.gidB+"   H: "+f.gidH+"   S:"+f.gidS+"    W:"+f.gidW);
		return f;
	}
	public String getLink(String s) throws MalformedURLException{
		String g = ice.getRequest(new URL("http://iceworld.sls-atl.com/api/&cmd=gurl&gid="+s));
		JSONObject jLink = (JSONObject) JSONValue.parse(g);
		JSONObject data = (JSONObject) jLink.get("data");
		String address = (String) data.get("location");
		System.out.println(address);
		return address;
	}
	public BufferedImage getPic(IcetizenLook look) throws IOException{
		BufferedImage b = ImageIO.read(new URL("http://iceworld.sls-atl.com/"+getLink(look.gidB)));
		BufferedImage h = ImageIO.read(new URL("http://iceworld.sls-atl.com/"+getLink(look.gidH)));
		BufferedImage s = ImageIO.read(new URL("http://iceworld.sls-atl.com/"+getLink(look.gidS)));
		BufferedImage w = ImageIO.read(new URL("http://iceworld.sls-atl.com/"+getLink(look.gidW)));
		
		BufferedImage avatar = new BufferedImage(1000,1000,BufferedImage.TYPE_INT_ARGB);
		Graphics g = avatar.getGraphics();
		g.drawImage(b, 0, 0, null);
		g.drawImage(h, 0, 0, null);
		g.drawImage(s, 0, 0, null);
		g.drawImage(w, 0, 0, null);
		
		return avatar;
	}
	
	//for testing out the method getPic()
/*	public static void main(String[] args){
		ICEWorldStates states = new ICEWorldStates();
		JFrame frame = new JFrame();
		IcetizenLook look = new IcetizenLook();
		BufferedImage img;
		
		try {
			look = states.getLook(37);
			img = states.getPic(look);
			Image i = new Image(img);
			frame.setContentPane(i);
			frame.pack();
			frame.setLocationByPlatform(true);
			frame.setVisible(true);
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}class Image extends JPanel{
		BufferedImage image;
		public Image(BufferedImage img){
			setOpaque(true);
			setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
			this.image = img;
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		}
	}*/
}