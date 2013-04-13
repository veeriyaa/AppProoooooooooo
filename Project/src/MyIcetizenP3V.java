import iceworld.given.IcetizenLook;
import iceworld.given.MyIcetizen;


public class MyIcetizenP3V implements MyIcetizen {
	int IcePortID;
	IcetizenLook look;
	int ListeningPort;
	String username;
	
	public MyIcetizenP3V(){
		
	}
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

	@Override
	public void setIcePortID(int a) {
		// TODO Auto-generated method stub
		IcePortID = a;
	}

	@Override
	public void setIcetizenLook(IcetizenLook arg0) {
		// TODO Auto-generated method stub
		look = arg0;
	}

	@Override
	public void setListeningPort(int arg0) {
		// TODO Auto-generated method stub
		ListeningPort = arg0;
	}

	@Override
	public void setUsername(String arg0) {
		// TODO Auto-generated method stub
		username = arg0;
	}

}
