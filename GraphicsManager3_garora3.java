package Practise;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;



public class GraphicsManager3_garora3 extends JFrame implements ActionListener, MouseListener{

	JPanel panel1=new JPanel();
	JPanel panel2=new JPanel();
	JPanel panel3=new JPanel(); //for polygons and 2 buttons
	JPanel panel4;
	JPanel panel5=new JPanel(); //nested in panle3 for 2 buttons
	
	
	JButton LoadFile=new JButton("Load File");
	JButton SaveFile=new JButton("Save File");
	JButton Create=new JButton("Create");
	JButton Scrap=new JButton("Scrap");
	JButton Keep=new JButton("Keep");
	JButton prev=new JButton("<");
	JButton next=new JButton(">");
	
	
	private Polygon3[] shapes;
	private Polygon3[] p;
	private int arraySize;
	private int sides;
	
	Polygon3 po=new Polygon3();
	int count=-1;
	Graphics g;
	
	
	public static void main(String[] args) 
	{
		
	GraphicsManager3_garora3 gm=new GraphicsManager3_garora3();

	}

	//Constructor
	GraphicsManager3_garora3()
	{
		shapes = new Polygon3[0];
		p = new Polygon3[1];
		arraySize=0;
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(1000, 1000);
		
		
		panel1.setLayout(new GridLayout(1, 2));
		panel1.setBorder(BorderFactory.createLineBorder(Color.black,4));
		Border border1 = panel1.getBorder();
		Border margin1 = new EmptyBorder(6,6,6,6);
		panel1.setBorder(new CompoundBorder(margin1, border1));
		
		panel2.setBorder(BorderFactory.createLineBorder(Color.red,4));
		Border border2 = panel2.getBorder();
		Border margin2 = new EmptyBorder(6,6,6,6);
		panel2.setBorder(new CompoundBorder(margin2, border2));
		
		//adding buttons in panel2
		panel2.setLayout(null);
		LoadFile.setBounds(170, 125, 100, 50);
		SaveFile.setBounds(170, 180, 100, 50);
		Create.setBounds(170, 235, 100, 50);
		Scrap.setBounds(170, 290, 100, 50);
		Keep.setBounds(170, 345, 100, 50);
		panel2.add(LoadFile);
		panel2.add(SaveFile);
		panel2.add(Create);
		panel2.add(Scrap);
		panel2.add(Keep);
		
		panel1.add(panel2);
		
		panel3.setBorder(BorderFactory.createLineBorder(Color.GREEN,4));
		Border border3 = panel3.getBorder();
		Border margin3 = new EmptyBorder(6,6,6,6);
		panel3.setBorder(new CompoundBorder(margin3, border3));
		
		//panel3 displaying polygon and 2buttons
		
		panel3.setLayout(new GridLayout(2, 1));
		
		panel4=new JPanel(){
			public void paint(Graphics g)
			{
				super.paint(g);
				if(!(po == null))
				{
					Dimension[] di = po.getD(); 
					for(int i=0; i<po.getSides() - 1; i++)
					{
						g.setColor(Color.blue);
						
						g.drawLine(di[i].width,di[i].height, di[i+1].width, di[i+1].height);
					}
					
					if(po.getSides() > 2)
					{
						g.setColor(Color.red);
						g.drawLine(di[0].width,di[0].height, di[di.length-1].width, di[di.length-1].height);
					}
				}
			}

		};
		panel4.setBorder(BorderFactory.createLineBorder(Color.pink,4));
		Border border4 = panel4.getBorder();
		Border margin4 = new EmptyBorder(6,6,6,6);
		panel4.setBorder(new CompoundBorder(margin4, border4));
		
		panel5.setBorder(BorderFactory.createLineBorder(Color.YELLOW,4));
		Border border5 = panel5.getBorder();
		Border margin5 = new EmptyBorder(6,6,6,6);
		panel5.setBorder(new CompoundBorder(margin5, border5));
		panel5.setLayout(null);
		prev.setBounds(150, 120, 100, 50);
		next.setBounds(260, 120, 100, 50);
		panel5.add(prev);
		panel5.add(next);
		
		panel3.add(panel4);
		panel3.add(panel5);
		panel1.add(panel3);
		
		this.add(panel1);

	//setting actionListeners for the buttons and panels
		
		LoadFile.addActionListener(this);
		SaveFile.addActionListener(this);
		Create.addActionListener(this);
		Scrap.addActionListener(this);
		Keep.addActionListener(this);
		prev.addActionListener(this);
		next.addActionListener(this);
		panel4.addMouseListener(this);
		
		//coz most important
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		 //Load File actions
		if(e.getSource() == LoadFile)
		{
			try 
			{
				Scanner scanner = new Scanner(new File("src/shapes.dat"));
				shapes=new Polygon3[scanner.nextInt()];
		        for(int i=0;i<shapes.length;i++)
		        {
		        	shapes[i]=new Polygon3();
		        	if(scanner.hasNextInt()){
		        		shapes[i].setSides(scanner.nextInt());
		        	}
	        		Dimension d1[]=new Dimension[shapes[i].getSides()];
		        	for(int j=0;j<shapes[i].getSides();j++){
		        		if(scanner.hasNextInt()){
			        		d1[j]=new Dimension(scanner.nextInt(),scanner.nextInt());
			        	}	
		        	}
		        	shapes[i].setD(d1);
		        }
		        scanner.close();
		        
			} 
			
			catch (FileNotFoundException e1) 
			{
				// TODO Auto-generated catch block
				System.out.println("Data was written as bytes as per problm statement we need to read as int");
			}
			catch(InputMismatchException e3)
			{
				System.out.println("Data was written as bytes as per problm statement we need to read as int");
			}
		}
		
		//Save File actions
		if(e.getSource() == SaveFile)
		{	
			DataOutputStream output;
			try 
			{
				output = new DataOutputStream(new FileOutputStream("src/shapes.dat"));
				output.writeInt(shapes.length);
				 for (int i = 0; i < shapes.length; i++) 
				 {
			            output.writeInt(shapes[i].getSides());
			            Dimension d2[]=shapes[i].getD();
			            for(int j=0; j<shapes[i].getSides(); j++)
			            {
			            	output.writeInt(d2[j].width);
			            	output.writeInt(d2[j].height);
			            }
			      }
			     output.close();
			     
			} 
			catch (FileNotFoundException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			catch (IOException ie) 
			{
				// TODO Auto-generated catch block
				ie.printStackTrace();
			}
	       
		}
		
		//Create polygon listener
		if(e.getSource()==this.Create)
		{
			
			this.panel4.setBackground(Color.WHITE);
			this.panel4.setEnabled(true);
			po= null;
			po= new Polygon3();
			this.panel4.repaint();
			revalidate();
		
	   }
		
		if(e.getSource()==this.Scrap)
		{
			this.panel4.setBackground(Color.gray);
			this.panel4.setEnabled(false);
			po = null;
			po= new Polygon3();
			this.panel4.repaint();
			revalidate();
			
		}
		if(e.getSource()==this.Keep)
		{
			this.panel4.removeAll();
			this.panel4.setBackground(Color.WHITE);
			this.panel4.setEnabled(true);
			
			
			add(po);
			po = null;
			po= new Polygon3();
			this.panel4.repaint();
			revalidate();
		
		}
		
		if(e.getSource()==this.prev)
		{
			if((shapes == null)||(shapes.length == 0))
				System.out.println("No Polygon3s to view!");
	        else
	        {
		         count--;
		         if(count<0)
		         {
		          count= shapes.length-1;
		          po= shapes[count];
		          this.panel4.paint(g);
		         }
		     
		         else 
		         {
		           po= shapes[count];
		           this.panel4.paint(g);
		      
		          }
		         
	        }	
		}
		
		if(e.getSource()==this.next)
		{
			if((shapes == null)||(shapes.length == 0) || count == shapes.length )System.out.println("No Polygon3s to view!");
		     else
		     {
		      count++;
		      if (count > shapes.length-1)
		       { 
		       count=0;
		       po= shapes[count];
		       this.panel4.paint(g);
		       }
		      else 
		       {
		       po= shapes[count];
		       this.panel4.paint(g);
		       }
		      
		     }
		}
	
	}
	
	//for adding new polygons to shapes array
	void add(Polygon3 polygon)
	{
		Polygon3[] shapes2 = new Polygon3[shapes.length+1];
		for(int i=0; i<shapes.length; i++)
		{
			shapes2[i] = shapes[i];
		}
		shapes2[shapes.length] = polygon;
		shapes = new Polygon3[shapes2.length];
		for(int i=0; i<shapes2.length; i++)
		{
		    shapes[i] = shapes2[i];
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == this.panel4)
		{
				if(panel4.getBackground() == Color.WHITE)
				{
					po.extend(new Dimension(e.getX(),e.getY()));
					
				}
				
		}
			g = panel4.getGraphics();
			if(po.getSides() > 1)
			{
				panel4.paint(g);
			
		    }
	}

	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	}


class Polygon3 {
	private int id;
	private int sides;
	private Dimension[] d=new Dimension[0];
	
	void clear()
	{
		this.sides = 0;
		this.d = new Dimension[this.sides];
	}
	
	void extend(Dimension nextD)
	{
		this.sides++;
		Dimension[] d2 = new Dimension[this.sides];
		int loop = 0;
		for (; loop < d.length; loop++)
		{
			d2[loop] = d[loop];
		}
		d2[loop] = nextD;
		d = d2;
	}
	
	
	
	Dimension[] getD()
	{
		return this.d;
	}
	
	int getId()
	{
		return this.id;
	}
	
	int getSides()
	{
		return this.sides;
	}
	
	void retract()
	{
		this.sides--;
		Dimension[] d2 = new Dimension[this.sides];
		int loop = 0;
		for (; loop < d2.length; loop++)
		{
			d2[loop] = d[loop];
		}
		d = d2;
	}
	
	void setD(Dimension[] d) {
		this.d = d;
	}
	
	void setId(int id) {
		this.id = id;
	}
	
	void setSides(int sides)
	{
		this.sides = sides;
	}
}
