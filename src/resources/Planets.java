package resources;

public enum Planets {
	TERRE(Constants.GRAVITY_EARTH),
	LUNE(Constants.GRAVITY_MOON),
	MARS(Constants.GRAVITY_MARS);
	
	
	double gravity;
	
	private Planets(double gravity) {
		// TODO Auto-generated constructor stub
		this.gravity = gravity;
	}
}
