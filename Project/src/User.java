
public class User {
	MyIcetizenP3V charac;
	int type,X,Y,uid;
	
	//constructor with info of how u look like 
	public User(){
		charac = new MyIcetizenP3V();
	}
	public User(String username,int type,int portID,int posX,int posY,int uid){
		charac = new MyIcetizenP3V();
		charac.setUsername(username);
		charac.setIcePortID(portID);
		this.type = type;
		X=posX;
		Y=posY;
		this.uid = uid;
	}
}
