
/*
 * 模拟小球和墙发生弹性碰撞运动
 */
public class BouncingBalls {
	public static void main(String[] args) {
		int N = 1;
		Ball[] balls = new Ball[N];
		for(int i=0;i<N;i++)
			balls[i] = new Ball();
		while(true)
		{
			StdDraw.clear();
			for (int i = 0; i < balls.length; i++) {
				balls[i].move(0.5);
				balls[i].draw();
			}
			StdDraw.show(50);
		}
		
	}
}

class Ball {
	private double rx,ry;
	private double vx,vy;
	private final double radius = 0.01;
	public Ball()
	{
		rx = 0.5;
		ry = 0.5;
		vx = 0.05;
		vy = 0.02;
	}
	public void move(double dt) {
		if ((rx + vx*dt < radius) || (rx + vx*dt > 1.0 - radius)) { vx = -vx; }
		if ((ry + vy*dt < radius) || (ry + vy*dt > 1.0 - radius)) { vy = -vy; }
		rx = rx + vx*dt;
		ry = ry + vy*dt;
	}
	
	public void draw()
	{
		StdDraw.filledCircle(rx, ry, radius);
	}
	
}
