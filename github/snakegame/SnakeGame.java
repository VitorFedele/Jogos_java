package snakegame;
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
 
import javax.swing.JFrame;
import javax.swing.Timer;
 
public class SnakeGame extends JFrame implements ActionListener, KeyListener{

	List<Point> snakePoints = new ArrayList<Point>();
	final static int width=420, height = 450, boxSize=7;
	static int direction =480;
 
	final static int LEFT = 1, RIGHT=2, TOP = 3, BOTTOM = 4;
	Timer timer;
	Point food = new Point();
	
	public SnakeGame(){
		addKeyListener(this);
		timer = new Timer(45, this);
		timer.setInitialDelay(30);
		timer.start();
		final Point point = new Point((width / boxSize) / 2, (height / boxSize) / 2);
		snakePoints.add(point);
		getNewFoodLocation();
	}

	@Override
	public void paint(final Graphics g) {
		final Graphics2D graficos2D = (Graphics2D) g;
		g.clearRect(0, 0, width, height);
		logic();
		drawSnake(graficos2D);
		drawFood(graficos2D);
	}

		private void drawSnake(final Graphics2D graficos2D) {
		graficos2D.setColor(Color.GREEN);
		for (final Point pt : snakePoints) {
			graficos2D.fillRect(pt.x * boxSize, pt.y * boxSize, boxSize, boxSize);
		}

	}

	private void drawFood(final Graphics2D graficos2D) {
		graficos2D.setColor(Color.RED);
		graficos2D.fillRect(food.x * boxSize, food.y * boxSize, boxSize, boxSize);

	}

	private void logic() {
		final Point head = snakePoints.get(0);
		if (food.x == head.x && food.y == head.y) {
			getNewFoodLocation();
			final Point lastPoint = snakePoints.get(snakePoints.size() - 1);
			snakePoints.add(new Point(lastPoint.x, lastPoint.y));
		}
		moveSnake();
	}
	
	public boolean getselfcollision(){
		return true;
	}
	private void moveSnake() {
		final Point head = snakePoints.get(0);
		final Point pt = new Point(head.x, head.y);
		int xMovement = 1;
		int yMovement = 0;
		switch (direction) {
		case LEFT:
			xMovement = -1;
			yMovement = 0;
			break;
		case RIGHT:
			xMovement = 1;
			yMovement = 0;
			break;
		case TOP:
			xMovement = 0;
			yMovement = -1;
			break;
		case BOTTOM:
			xMovement = 0;
			yMovement = 1;
			break;
		default:
			xMovement = yMovement = 0;
			break;
		}
		pt.setLocation(pt.x + xMovement, pt.y + yMovement);
		snakePoints.add(0, pt);
		snakePoints.remove(snakePoints.size() - 1);

		handleCrossBorder();
	
			
		}
	

	private void handleCrossBorder() {

		final Point head = snakePoints.get(0);
		double x = head.getX();
		double y = head.getY();

		if (x > width / boxSize && direction == RIGHT) {
			x = 350;
		}
		if (x < 1 && direction == LEFT) {
			x = 350;
		}
		if (y > height / boxSize && direction == BOTTOM) {
			y = 350;
		}
		if (y < 1 && direction == TOP) {
			y = 350;
		}
		head.setLocation(x, y);
	}

	private void getNewFoodLocation() {
		final Random rand = new Random();
		final int delta = boxSize * 1;
		food.setLocation(rand.nextInt(width / boxSize - 2 * delta) + delta,
				rand.nextInt(height / boxSize - 2 * delta) + delta);

	}

	public static void main(final String[] args) {
		final SnakeGame frame = new SnakeGame();
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void keyTyped(final KeyEvent e) {
	}

	@Override
	public void keyPressed(final KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if (direction != 4) {
				direction = 3;
			}
			break;
		case KeyEvent.VK_DOWN:
			if (direction != 3) {
				direction = 4;
			}
			;
			break;
		case KeyEvent.VK_LEFT:
			direction = (direction != 2) ? 1 : direction;
			break;
		case KeyEvent.VK_RIGHT:
			direction = (direction != 1) ? 2 : direction;
			break;
		case KeyEvent.VK_P:
			direction = 0;
			break;

		}
	}

	@Override
	public void keyReleased(final KeyEvent e) {
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		repaint();
	}

}