
package tic.tac.toe;

import java.util.Random;
import java.util.Scanner;

 class game
 {
   static char[][] board;
   public game()
   {
    board = new char[3][3];   
    initBoard();
   }
   void initBoard()
   {
     for(int i=0;i<board.length;i++)
     {
     for(int j=0;j<board.length;j++)
     {
      board[i][j]=' ';
     }
     }
   } 
   static void dispBoard()
    {
    System.out.println("-------------");    
    for(int i=0;i<board.length;i++)
     {
     System.out.print("| ");
     for(int j=0;j<board.length;j++)
     {
       System.out.print(board[i][j] + " | ");
     }
     System.out.println();
     System.out.println("-------------");    
     }
    }
   static void placemark(int row,int col,char mark)
    {
      if(row>=0 && row<=2 && col>=0 && col<=2)
      {
        board[row][col]=mark;
      }
      else
      {
        System.out.println("Invalid Input");
      }
    }  
   static boolean checkcolwin()
    {
     for(int j=0;j<2;j++)
     {
      if (board[0][j]!=' ' && board[0][j] == board[1][j] && board[1][j]==board[2][j])
      {
       return true;
      }
     }
     return false;
    
    }
     
 static boolean checkrowwin()
{
   for(int i=0;i<=2;i++)
   {
    if(board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2])
    {
      return true;
    }
   
   }
   return false;
}
static boolean checkdiagwin()
{
 if(board[0][0]!= ' ' &&  board[0][0]==board[1][1] && board[1][1]==board[2][2] ||board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0])
 {
  return true;
 }  
 else 
 {
   return false;
 }
}

static boolean checkdraw()
{
  for(int i=0;i<=2;i++)
  {
    for(int j=0;j<=2;j++)
    {
      if(board[i][j]== ' ')
      {
        return false;
      }
    }
  
  }
 return true; 

}

  }


abstract class player
{
 String name;
  char mark;
   
  abstract void makemove();
  
  boolean isvalidmove(int row , int col)
{
 if(row>=0 && row <=2 && col >=0 && col <=2)
 {
   if(game.board [row][col]==' ')  
   {
    return true;
   }
 }
 return false;
}
}

class humanplayer extends player
{
  
  humanplayer(String name, char mark)
  {
    this.name=name;
    this.mark=mark;
  
  }
 void makemove()
 {
 Scanner scan = new Scanner(System.in);
 int row;
 int col;

 do
 {
 System.out.println("Enter the row and col");
  row = scan.nextInt();
  col = scan.nextInt();
 } while(!isvalidmove(row , col));
   
  game.placemark(row,col,mark);
 }

}

class aiplayer extends player 
{
  String name;
  char mark;
    
  aiplayer(String name, char mark)
  {
    this.name=name;
    this.mark=mark;
  
  }
 void makemove()
 {
 Scanner scan = new Scanner(System.in);
 int row;
 int col;
 do
 {
 Random r = new Random();
 row = r.nextInt(3);
 col = r.nextInt(3);
 } while(!isvalidmove(row , col));
   
  game.placemark(row,col,mark);
 }

}





public class Tictactoe 
{

 
    public static void main(String[] args)
    {
         game g = new game(); 
        
       humanplayer p1 = new humanplayer("anshu",'X');
       aiplayer p2 = new aiplayer("Tai",'O');
       
       player cp;
       cp=p1;
       while(true)
       {     
       System.out.println(cp.name  +  "turn");
       cp.makemove();
       game.dispBoard();
       if(game.checkcolwin() || game.checkrowwin() || game.checkdiagwin())
       {
        System.out.println(cp.name + " has won");
        break;
       }
       else if(game.checkdraw())
       {
       System.out.println("Game is draw");
       break;
       }
       else
       {
         if (cp == p1)
        {
         cp = p2;
        }
        else
        {
         cp = p1;
        }
       }
       } 
    }
    
}
