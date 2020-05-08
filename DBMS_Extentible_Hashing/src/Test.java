import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JFra extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
        for(int q=0;q<(int)(Math.pow(2,Test.globalDepth));q++)
		{
			g.drawLine(70, 50+30*q, 155, 50+30*Test.arr[q]);	
		}
	}
	JFra(){
		new JPanel();
	}
}

public class Test{
	public static int globalDepth = 2;
	public static int arr[] = new int[100];
	public static int noofbuckets = (int)(Math.pow(2,globalDepth));
	public static Bucket[] bucks = new Bucket[100];
	public static int ent=1;
	public static String txt="";
	public static int check=-1;
	public static String lastSearch = "";
	// we have considered bfr for each bucket = 2
	// we have considered hash function to be K mod 10
	
		Test()
		{
			JFrame frame = new JFrame("Extendible Hashing");
			GridLayout layout = new GridLayout(1,3,3,3);
			frame.getContentPane().setLayout(layout);
			
			JPanel subPanel = new JPanel();
			JFra leftPanel = new JFra();
			JPanel rightPanel = new JPanel();
			
			leftPanel.setLayout(null);
			rightPanel.setLayout(null);
			subPanel.setLayout(null);
			
			JTextField jtf = new JTextField(20);
			jtf.setBounds(25, 13, 180, 31);
			JButton submit = new JButton("Submit");
			submit.setBounds(62, 57, 108, 40);
			JButton exit = new JButton("Exit");
			exit.setBounds(71, 400, 99, 40);
			JTextField stf = new JTextField(20);
			stf.setBounds(25, 140, 180, 31);
			JButton search = new JButton("Search");
			search.setBounds(62, 200, 105, 40);
			
			stf.setText(lastSearch);
			
			JLabel keys = new JLabel("KEYS");
			keys.setFont(new Font("Dialog", Font.PLAIN, 15));
			keys.setBounds(43, 13, 45, 16);
			
			JLabel b = new JLabel("BUCKETS");
			b.setFont(new Font("Dialog", Font.PLAIN, 15));
			b.setBounds(133, 13, 85, 16);
			
			JLabel bucs = new JLabel("DATA");
			bucs.setFont(new Font("Dialog", Font.PLAIN, 15));
			bucs.setBounds(37, 13, 45, 16);
			
			JLabel bb = new JLabel("LOCAL DEPTH");
			bb.setFont(new Font("Dialog", Font.PLAIN, 15));
			bb.setBounds(124, 13, 106, 16);
			
			JLabel answer = new JLabel("");
			answer.setFont(new Font("Dialog", Font.PLAIN, 15));
			answer.setBounds(62, 240, 180, 31);
			
			if(check==1)
			{
				answer.setText("It exists");
			}
			else
			{
				if(check==0)
				{
					answer.setText("It doesn't exist");
				}
			}
			
			leftPanel.add(keys);
			leftPanel.add(b);
			rightPanel.add(bucs);
			rightPanel.add(bb);
			leftPanel.setVisible(true);
			rightPanel.setVisible(true);
			
			
			for(int q=0;q<(int)(Math.pow(2,globalDepth));q++)
			{
				JLabel x = new JLabel(String.valueOf(q));
				x.setFont(new Font("Dialog", Font.PLAIN, 15));
				x.setBounds(60, 40+30*q, 148, 16);
				leftPanel.add(x);
			}
			
			for(int q=0;q<Test.noofbuckets;q++)
			{
				JLabel x = new JLabel(String.valueOf(q));
				x.setFont(new Font("Dialog", Font.PLAIN, 15));
				x.setBounds(160, 40+30*q, 148, 16);
				leftPanel.add(x);
			}
			
			for(int q=0;q<Test.noofbuckets;q++)
			{
				JLabel x = new JLabel();
				x.setFont(new Font("Dialog", Font.PLAIN, 15));
				x.setBounds(10, 40+30*q, 148, 16);
				String txt="";
					int flag=0;
					if(bucks[q].getElemOne().getIsFull())
					{
						txt= txt+"1)-> " + bucks[q].getElemOne().getValue();
						flag++;
					}
					if(bucks[q].getElemTwo().getIsFull())
					{
						txt = txt+"  2)-> " + bucks[q].getElemTwo().getValue();
						flag++;
					}
					if(flag==0)
						txt=" ";
					JLabel y = new JLabel(String.valueOf(bucks[q].getLocalDepth()));
					y.setFont(new Font("Dialog", Font.PLAIN, 15));
					y.setBounds(180, 40+30*q, 148, 16);
					x.setText(txt);
					rightPanel.add(x);
					rightPanel.add(y);
			}
			
			leftPanel.setVisible(true);
			rightPanel.setVisible(true);
			
			submit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					System.out.println("It worked");
					int temp= Integer.parseInt(jtf.getText());
					bucks = Functions.addElement(temp, bucks);
					System.out.println("Entry "+ ent + " : "+temp);
					Functions.printAllStoredData(globalDepth, bucks);
					System.out.println("---------------------------");
					ent++;
					new Test();
				}
			});
			
			exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					System.exit(0);
				}
			});
			
			search.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					check = Functions.search(Integer.parseInt(stf.getText()), bucks);
					lastSearch=stf.getText();
					new Test();
				}
			});
			
			subPanel.add(jtf);
			subPanel.add(submit);
			subPanel.add(stf);
			subPanel.add(search);
			subPanel.add(answer);
			subPanel.add(exit);
			subPanel.setVisible(true);
			
			frame.getContentPane().add(leftPanel, BorderLayout.WEST);
			frame.getContentPane().add(rightPanel, BorderLayout.EAST);
			frame.getContentPane().add(subPanel);
			
			//frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(750,500);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        for(int q=0; q<100; q++){bucks[q]=new Bucket();}
        for(int i=0;i<(int)(Math.pow(2,globalDepth));i++) {
        	arr[i]=i;
        }
/*
        bucks = Functions.addElement(32, bucks);
        System.out.println("Entry 1 : ");
        Functions.printAllStoredData(globalDepth, bucks);
        bucks = Functions.addElement(28, bucks);
        System.out.println("---------------------------------------------");
        System.out.println("Entry 2 : ");
        Functions.printAllStoredData(globalDepth, bucks);
        bucks = Functions.addElement(43, bucks);
        System.out.println("---------------------------------------------");
        System.out.println("Entry 3 : ");
        Functions.printAllStoredData(globalDepth, bucks);
        bucks = Functions.addElement(15, bucks);
        System.out.println("---------------------------------------------");
        System.out.println("Entry 4 : ");
        Functions.printAllStoredData(globalDepth, bucks);
        bucks = Functions.addElement(66, bucks);
        System.out.println("---------------------------------------------");
        System.out.println("Entry 5 : ");
        Functions.printAllStoredData(globalDepth, bucks);
        bucks = Functions.addElement(27, bucks);
        System.out.println("---------------------------------------------");
        System.out.println("Entry 6 : ");
        Functions.printAllStoredData(globalDepth, bucks);
        bucks = Functions.addElement(86, bucks);
        System.out.println("---------------------------------------------");
        System.out.println("Entry 7 : ");
        Functions.printAllStoredData(globalDepth, bucks);
        bucks = Functions.addElement(54, bucks);
        System.out.println("---------------------------------------------");
        System.out.println("Entry 8 : ");
        Functions.printAllStoredData(globalDepth, bucks);
        System.out.println("---------------------------------------------");
        bucks = Functions.addElement(35, bucks);
        System.out.println("Final hashing scheme : ");
        Functions.printAllStoredData(globalDepth, bucks);
        System.out.println("---------------------------------------------");
 */    	
        SwingUtilities.invokeLater(new Runnable() {
        	
        	public void run() {
        		new Test();
        	}
        });
	}
}
