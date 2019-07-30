
public class Camera {
	
	private float x, y;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick(GameObjects camObject) {
		
		x += ((camObject.getX() - x) - 1000/2) * 0.05f;
		y += ((camObject.getY() - y) - (1000 * 4/7)/2) * 0.05f;
		
		// Consider creating bounds for how far the camera goes in relation to map border
		if (x <= 0) x = 0;
		if (x >= 1060) x = 1060;
		if (y <= 0) y = 0;
		if (y >= 680) y = 680;
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
