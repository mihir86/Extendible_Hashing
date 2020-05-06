import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test {
	public static int globalDepth = 2;
	public static int localDepthlow = 2;
	public static int arr[] = new int[100];
	public static int noofbuckets = 4;
	public static Bucket[] bucks = new Bucket[100];
	public static int ent=1;
	public static String txt="";
	// we have considered bfr for each bucket = 2
	// we have considered hash function to be K mod 10
	
	public static class SwingDemo{
		public static JLabel[] createLabels(){
			JLabel[] labels= new JLabel[100];
			int w=25;
			for(int q=0;q<(int)(Math.pow(2,globalDepth));q++)
			{
				txt=q+"                                 ";
				labels[q]= new JLabel(txt);
				Dimension size = labels[q].getPreferredSize();
				//labels[q].setBounds(25,w*(q+1), 10, 10);
				//labels[q].setLocation(50,(q+1)*w);
				txt="";
			}
			return labels;
		}
		
		public static JLabel[] createBuckets(){
			txt="";
			JLabel[] buckets = new JLabel[100];
			for(int q=0; q<(int)(Math.pow(2,globalDepth)); q++)
			{
				int flag=0;
				
				if(bucks[q].getElemOne().getIsFull())
				{
					txt= txt+ q + "             1)-> " + bucks[q].getElemOne().getValue();
					flag++;
				}
				if(bucks[q].getElemTwo().getIsFull())
				{
					txt = txt + " 2)-> " + bucks[q].getElemTwo().getValue();
					flag++;
				}
				if(flag==0)
				{
					txt=" ";
				}
				else
				{
					txt=txt+"                       " + bucks[q].getLocalDepth();
				}
				buckets[q] = new JLabel(txt);
				txt="";
			}
			return buckets;
		}
		
		SwingDemo()
		{
			JFrame frame = new JFrame("Extendible Hashing");
			frame.setLayout(new GridLayout(1,3,3,3));
			
			JPanel subPanel = new JPanel();
			Box leftPanel = new Box(BoxLayout.Y_AXIS);
			Box rightPanel = new Box(BoxLayout.Y_AXIS);
			
			JTextField jtf = new JTextField(20);
			JButton submit = new JButton("Submit");
			JButton exit = new JButton("Exit");
			
			JLabel keys = new JLabel("Keys");
			JLabel bucs = new JLabel("Buckets  Data               Local Depth");
			
			leftPanel.add(keys);
			rightPanel.add(bucs);
			
			
			JLabel[] klabels = createLabels();
			JLabel[] blabels = createBuckets();
			
			for(int q=0;q<(int)(Math.pow(2,globalDepth));q++)
			{
				leftPanel.add(klabels[q]);
			}
			
			for(int q=0;q<(int)(Math.pow(2,globalDepth));q++)
			{
				rightPanel.add(blabels[q]);
			}
			
			leftPanel.setBackground(Color.gray);
			leftPanel.setVisible(true);
			
			rightPanel.setBackground(Color.gray);
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
					new SwingDemo();
				}
			});
			
			exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					System.exit(0);
				}
			});
			
			subPanel.add(jtf);
			subPanel.add(submit);
			subPanel.add(exit);
			
			frame.add(leftPanel, BorderLayout.WEST);
			frame.add(rightPanel, BorderLayout.EAST);
			frame.add(subPanel);
			
			
			//frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(750,500);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        for(int q=0; q<100; q++){bucks[q]=new Bucket();}
        arr[0]=0;
        arr[1]=1;
        arr[2]=2;
        arr[3]=3;
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
        		new SwingDemo();
        	}
        });
        
	}

}
