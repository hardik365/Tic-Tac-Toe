//Tic - Tac - Toe
//Hardik Shahu



import java.util.Scanner;
import java.util.Arrays;

public class TicTacToe 
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		
		//will make our empty board (numbers represent empty spaces)
		char[][] board = {{'0','1','2'},{ '3', '4', '5' }, { '6', '7', '8' }};

		int winner = 0; //used as flag to see if one won or not and to also see if we should end the game or not
		
		int placed = 0;//how many are placed on the board as of now
		
		
		System.out.print("Welcome to Tic Tac Toe!\nThe numbered spots represent empty spots ");
		
		
		view(board);
		
		for(;;)
		{
			
			//asks player 1 to enter an input
			System.out.print("Player 1: Enter a number to place 'X' on that spot: ");
			int position = input.nextInt();
			
			//checks if the inputed one is empty or not
			if(emptyOrNot(board,position) == 0)
			{
				System.out.print("Error Invalid input, program has ended");
				break;
			}
			
			markX(board,position);//will mark this spot for player 1
			placed++;
			
			view(board);//displays the board
			
			//checks the status of the board at the moment
			if(wonX(board) == 1)
			{
				System.out.print("Status: X Won!\n");
				break;
			}
			else
				System.out.print("Status: Unfinished!\n");

			
			
			if(placed == 9)//if it ends up with a draw
			{
				System.out.print("Draw, no winner!\n");	
				break;
			}
			
			

			//asks player 2 to enter an input
			System.out.print("Player 2: Enter a number to place 'O' on that spot: ");
			position = input.nextInt();
			
			//checks if the inputed one is empty or not
			if(emptyOrNot(board,position) == 0)
			{
				System.out.print("Error Invalid input, program has ended");
				break;
			}
			
			markO(board,position);//will mark this spot for player 2
			placed++;
			
			view(board); //will display the board		
			
			//checks the status of the board at the moment
			if(wonO(board) == 1)
			{
				System.out.print("Status: O Won!\n");
				break;
			}
			else
				System.out.print("Status: Unfinished!\n");
			
			if(placed == 9)//if it ends up with a draw
			{
				System.out.print("Draw, no winner!\n");	
				break;
			}
			
			

		}
		

		
	}
	
	//will print out the board
	public static void view(char[][] board)
	{
        System.out.println("\nThe board currently looks like:");
        
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
                System.out.print(board[i][j] + " ");
            System.out.println("");	
        }
        System.out.println("\n");
	}
	
	//will see if the spot they try to add is empty or not, if it's empty, it will return 1, if not then it will return 0
	public static int emptyOrNot(char[][] board, int spotNumb)
	{
		
		if(spotNumb <= -1|| spotNumb >= 9)
			return 0;
		
		//is the algorithm to find the row and column number of the array from the number they inputed
		int i = spotNumb/3;
		int j = spotNumb%3;
		
		//sees if that spot is empty
		if((board[i][j] == 'X') || (board[i][j] == 'O'))
			return 0;
		
		return 1;
	}
	
	//will mark the X (player 1)
	public static char[][] markX(char[][] board, int spotNumb)
	{
		//is the algorithm to find the row and column number of the array from the number they inputed
		int i = spotNumb/3;
		int j = spotNumb%3;
		
		board[i][j] = 'X';
		
		return board;
	}

	//will mark the O (player 2)
	public static char[][] markO(char[][] board, int spotNumb)
	{
		//is the algorithm to find the row and column number of the array from the number they inputed
		int i = spotNumb/3;
		int j = spotNumb%3;
		
		board[i][j] = 'O';
		
		return board;
	}	
	
	
	//will return 1 if X won and 0 if not
	public static int wonX(char[][] board)
	{
		//will check for the diagonals
		if((board[0][0] == 'X')&&(board[1][1] == 'X')&&(board[2][2] == 'X'))
			return 1;	
		if((board[0][2] == 'X')&&(board[1][1] == 'X')&&(board[2][0] == 'X'))
			return 1;			
		
		int counter = 0; //needed to find the row or column ones	
		
		for(int i = 0; i < 3; i++)
		{
			counter = 0;
			//will find for the rows
			for(int j = 0; j < 3; j++)
			{
				if(board[i][j] == 'X')
					counter++;
				if(counter == 3)
					return 1;
			}

			counter = 0;
			
			//will find for the column
			for(int j = 0; j < 3; j++)
			{
				if(board[j][i] == 'X')
					counter++;
				if(counter == 3)
					return 1;
			}			
		}
		return 0;
	}
	//will return 1 if X won and 0 if not
	
	public static int wonO(char[][] board)
	{
		//will check for the diagonals
		if((board[0][0] == 'O')&&(board[1][1] == 'O')&&(board[2][2] == 'O'))
			return 1;	
		if((board[0][2] == 'O')&&(board[1][1] == 'O')&&(board[2][0] == 'O'))
			return 1;			
		
		int counter = 0; //needed to find the row or column ones	
		
		for(int i = 0; i < 3; i++)
		{
			counter = 0;
			//will find for the rows
			for(int j = 0; j < 3; j++)
			{
				if(board[i][j] == 'O')
					counter++;
				if(counter == 3)
					return 1;
			}

			counter = 0;
			
			//will find for the column
			for(int j = 0; j < 3; j++)
			{
				if(board[j][i] == 'O')
					counter++;
				if(counter == 3)
					return 1;
			}			
		}
		return 0;
	}	
	
	
}
