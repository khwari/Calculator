
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculate {
	
	
	public static int result = 0;
	public static int current = 0;
	public static int previous = 0;
	public static String sign = "";
	public Calculate() {
		// TODO Auto-generated constructor stub
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("Casio");
		jf.setSize(600,300);
		jf.setLayout(null);
		JButton dig[] = new JButton[10];
		
		for(int i=0;i<10;i++) {
			dig[i] = new JButton(String.valueOf(i));
			dig[i].setBackground(Color.DARK_GRAY);
			dig[i].setForeground(Color.WHITE);
			jf.add(dig[i]);
			dig[i].setBounds(i*50+20,40,50,50);
			
			
		}
		
		JTextField screen = new JTextField();
		jf.add(screen);
		screen.setBounds(50,220,500,30);
		
		JLabel numbers = new JLabel("digits");
		jf.add(numbers);
		numbers.setBounds(260,10,80,20);
		
		JLabel ar_op = new JLabel("arithmetic operations");
		jf.add(ar_op);
		ar_op.setBounds(200,110,200,20);
		
		JButton add = new JButton("+");
		jf.add(add);
		add.setBounds(100,150,50,50);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sign="+";
				previous+=current;
				current=0;
				screen.setText(screen.getText()+"+");
			}
		});
		
		JButton minus = new JButton("-");
		jf.add(minus);
		minus.setBounds(160,150,50,50);
		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sign="-";
				previous+=current;
				current=0;
				screen.setText(screen.getText()+"-");
			}
		});
		
		JButton multip = new JButton("*");
		jf.add(multip);
		multip.setBounds(220,150,50,50);
		multip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sign="*";
				previous+=current;
				current=0;
				screen.setText(screen.getText()+"*");
			}
		});
		
		JButton division = new JButton("/");
		jf.add(division);
		division.setBounds(280,150,50,50);
		division.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sign="/";
				previous+=current;
				current=0;
				screen.setText(screen.getText()+"/");
			}
		});
		
		JButton equal = new JButton("=");
		jf.add(equal);
		
		equal.setBounds(340,150,50,50);
		
		
		;
		
		equal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sign=="+") { screen.setText(String.valueOf(current+previous)); previous = current+previous; current = 0; }
				else if(sign=="-") { screen.setText(String.valueOf(previous-current));previous = previous-current; current = 0;}
				else if(sign=="*") {screen.setText(String.valueOf(current*previous));previous = current*previous; current = 0;}
				else if(sign=="/") {screen.setText(String.valueOf(previous/current));previous = previous/current; current = 0;}
				previous = current+previous;
				current = 0;
			}
		});
		int i;
		for( i=0;i<10;i++) {
			final int value = i; 
			dig[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					current*=10;
					current+=value;
					screen.setText(screen.getText()+value);
				}
			});
		}
		jf.setVisible(true);
		

	}

}
