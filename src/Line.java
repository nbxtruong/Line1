import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

public class Line extends JComponent implements MouseInputListener {

	private Point p1 = null;
	private Point p2 = null;

	public Line() {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(300, 300));
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());

		g.setColor(getForeground());
		if (p1 != null)
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (p1 == null) {
			p1 = new Point(x, y);
			p2 = new Point(x, y);
		} else {
			p1.setLocation(x, y);
			setEndLine(e);
		}
	}

	private void setEndLine(MouseEvent e) {
		p2.setLocation(e.getX(), e.getY());
		repaint();
	}

	public void mouseReleased(MouseEvent e) {
		setEndLine(e);
	}

	public void mouseDragged(MouseEvent e) {
		setEndLine(e);
	}

	public void mouseMoved(MouseEvent e) {
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Line");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Line());
		frame.pack();
		frame.setVisible(true);
	}
}
