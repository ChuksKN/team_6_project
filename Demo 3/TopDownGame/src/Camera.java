
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
