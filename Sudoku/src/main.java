import java.util.*;
import java.awt.*;
import javax.swing.*;
public class main extends JFrame{

	static grid grid1 = new grid();
	static int[][] arr2 = new int[9][9];
	
	
	
	//one correct suduko solution for reference
	public static int[][] arr1 = {
			   {2,9,5,7,4,3,8,6,1},
			   {4,3,1,8,6,5,9,2,7},
			   {8,7,6,1,9,2,5,4,3},
			   {3,8,7,4,5,9,2,1,6},
			   {6,1,2,3,8,7,4,9,5},
			   {5,4,9,2,1,6,7,3,8},
			   {7,6,3,5,2,4,1,8,9},
			   {9,2,8,6,7,1,3,5,4},
			   {1,5,4,9,3,8,6,7,2}
			   };
	
	
	
	
	
	public static void main(String[] args) {
		SetDifficulty(arr1);
	}
	
	
	
	//setting difficulty which means how random the game will be 
	//difficult will be the number as many times array will be shuffled.
	public static void SetDifficulty(int[][]a2)
	{
		int difficulty = RandomGenerator(30,40);
		
		for(int i = 0; i < difficulty;i++)
		{
			int num1 = RandomGenerator(1,9);
			int num2 = RandomGenerator(1,9);
			arr2 = swap(a2,num1,num2);
		}
		for(int q = 0; q <9; q++)
		{
			for(int l = 0;l < 9; l++)
			{
				System.out.print(arr2[q][l]);
			}
			System.out.println();
		}
		grid1.gamepad(arr2);
		
	}
	
	
	
	
	//Swapping according difficulty to generating random games everytime
	public static int[][] swap(int[][] a,int x, int y)
	{
		int index1 = 0;
		int index2 = 0;
		boolean flag1 = false;
		boolean flag2 = false;
		for(int i = 0; i < 9; i++)
		{
			 flag1 = false;
			 flag2 = false;
			for(int j = 0; j< a[i].length;j++)
			{
				if(a[i][j] == x)
				{
					flag1 = true;
					index1 = j;
				}
				if(a[i][j] == y)
				{
					flag2 = true;
					 index2 = j;
				}
				if(flag1 && flag2)
				{
					int temp = a[i][index1];
					a[i][index1] = a[i][index2];
					a[i][index2] = temp;
					flag1 = false;
					flag2 = false;
				}
			}
		}
		return a;
	}
	
	
	
	
	
	//random number generator
	public static int RandomGenerator(int l1, int l2)
	{
		Random rand = new Random();
		int x = rand.nextInt(l2)+l1;
		return x;
		
	}

	
	
}
