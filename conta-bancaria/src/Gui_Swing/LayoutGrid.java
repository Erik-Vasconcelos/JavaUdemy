package Gui_Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LayoutGrid extends JFrame implements MouseListener{
	Label l =new Label();
	public LayoutGrid() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 300);
		
//		setLayout(new BorderLayout());
		l.setPreferredSize(new Dimension(400,100));
		
		JButton b= new  JButton();
		b.setBackground(Color.GRAY);
		b.addActionListener(c ->l.setText(l.getText()+"Clicou "));
		addMouseListener(this);
		b.setPreferredSize(new Dimension(400, 200));
		add(l, BorderLayout.NORTH);
		add(b, BorderLayout.SOUTH);
		
		
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new LayoutGrid();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() ==1) {
			l.setText("Botão esquerdo!! ");
		}else {
			l.setText("Outro Botão");
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
