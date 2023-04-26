import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class grid implements ActionListener{

	static JFrame f1 = new JFrame("Demo panel");
	JPanel panel = new JPanel();
	
	int top = 10;
	int counter = 1;
	
	public static int gamecounter = 1;
	public static JButton game[][] = new JButton[9][9];
	public static int scoreSetter[][] = new int[9][9];
	
	JButton solve = new JButton("Solve");
	JButton regen = new JButton("Regen");
	
	JButton check = new JButton("Check");
	
	
	JLabel l1 = new JLabel("Instrutions: 1. Click empty boxes to fill in number");
	JLabel l2 = new JLabel("2. With each click, counter will run iteratively which will reset to 1 after 9");
	JLabel l3 = new JLabel("3. Use regen button to generate new random game.");
	JLabel l4 = new JLabel("4. Use Solve button to view solution of the current game");
	JLabel l5 = new JLabel("4. Use check button to check if current solution is correct or not");
	public boolean finalcheck = false;
	
	
	
	
	
	
	
	//Constructor to create grid and buttons
	public grid()
	{
		
		solve.setBounds(800,top,80,40);
		f1.add(solve);
		solve.addActionListener(this);
		
		//generate new pattern
		
		regen.setBounds(800,top+40,80,40);
		check.setBounds(800,top+80,80,40);
		
		
		l1.setBounds(10,10,800,800);
		l2.setBounds(10,40,800,800);
		l3.setBounds(10,70,800,800);
		l4.setBounds(10,100,800,800);
		l5.setBounds(10,130,800,800);
		f1.add(l1);
		f1.add(l2);
		f1.add(l3);
		f1.add(l4);
		f1.add(l5);
		f1.add(regen);	
		f1.add(check);
		check.addActionListener(this);
		//f1.add(panel);
		regen.addActionListener(this);
		f1.setSize(900,800);
		f1.setLayout(null);
		
		
	}

	
	
	
	//button events except for the 2d array button which were implemented exclusively.

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == check)
		{
			
			for(int i = 0; i < game.length;i++)
			{
				for(int j = 0; j < game[0].length;j++)
				{
					if(game[i][j].getText()=="") 
					{
						finalcheck = false;
						break;
					}
					else 
					{
						if(Integer.parseInt(game[i][j].getText()) == main.arr2[i][j])
						{
							finalcheck = true;
						}
						else
						{
							finalcheck = false;
							break;
						}
					}
				}
			}
			
			if(finalcheck == true)
			{
				JOptionPane.showMessageDialog(null, "you got it right");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "not quite right try again");
			} 
		}
		
		
		if(e.getSource() == regen)
		{
			for(int i = 0; i < game.length;i++)
			{
				for(int j = 0; j < game[0].length; j++)
				{
					scoreSetter[i][j] = 0;
				}
			}
			main.SetDifficulty(main.arr2);
			
		}
		if(e.getSource()==solve)
		{
			for(int q = 0; q <9; q++)
			{
				for(int l = 0;l < 9; l++)
				{
					game[q][l].setText("" + main.arr2[q][l]);
					scoreSetter[q][l] = 0;
				}
			}
			
		}
		
		for(int i = 0; i < game.length;i++)
		{
			for(int j = 0; j < game[0].length;j++)
			{
				
				if(e.getSource()==game[i][j])
				{
					game[i][j].setText(""+ counter);
					counter++;
				}
			}
		}
	}
	
	
	
	//creating buttons and assigning values and custom action event established
	public static void gamepad(int a[][])
	{
		
		for(int i = 0; i < game.length;i++)
		{
			for(int j = 0; j < game[0].length; j++)
			{
				scoreSetter[i][j] = 0;
			}
		}
		
		
		
		if(gamecounter == 1)
		{
			int rightshift = 20;
			int topshift = 10;
			for(int m = 0; m < 9;m++)
			{
				rightshift = 10;
				for(int n= 0; n < 9;n++)
				{
					game[m][n] = new JButton("" + (m+1)+ ""+(n+1));
					game[m][n].setBounds(rightshift,topshift,80,40);
					game[m][n].setBackground(Color.white);
					game[m][n].setText(""+a[m][n]);
					f1.add(game[m][n]);
					rightshift+=80;
				}
				topshift+=40;
				
			}
			f1.setVisible(true);
			gamecounter+=1;
			for(int i = 0; i < game.length;i++)
			{
				int g = i;
				for(int j = 0; j < game[0].length;j++)
				{
					int h = j;
					game[g][h].addActionListener(new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
							 game[g][h].setText("" + (scoreSetter[g][h]+1));
							 scoreSetter[g][h] +=1;
							 if(scoreSetter[g][h]==9)
							 {
								 scoreSetter[g][h] = 0;
							 }
						 }
					});
				}
			}
		}
		else
		{
			for(int m = 0; m < 9;m++)
			{
				for(int n= 0; n < 9;n++)
				{
					game[m][n].setText(""+a[m][n]);
				}
				
			}
		}
		for(int i = 0; i <game.length;i++)
		{
			for(int j = 0;j<game[0].length;j++)
			{
				game[i][j].setEnabled(true);
			}
		}
		
		
	    record();
	}
	

	//enabling disabling random buttons after generating random indexes throughout the 2d array.
	public static void record()
	{
		int gg1 = 0;
		while(gg1 < 50)
		{
			int firstnum = main.RandomGenerator(0,9);
			int secnum = main.RandomGenerator(0,9);
			for(int i = 0; i <game.length;i++)
			{
				for(int j = 0;j<game[0].length;j++)
				{
					if(firstnum == i && secnum == j)
					{
						game[firstnum][secnum].setText("");
					}
					
				}
			}
			
			gg1++;
		}
		for(int i = 0; i <game.length;i++)
		{
			for(int j = 0;j<game[0].length;j++)
			{
				if(game[i][j].getText()!="")
				{
					game[i][j].setEnabled(false);
				}
			}
		}
	}

	
}
