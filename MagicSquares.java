/*
* Copyright (c) 2021
*
* The program MagicSquares.java uses recursion to solve the 3x3 magic square 
* puzzle.
*
* @author  Wajd Mariam
* @version 1.0
* @since   2021/01/09
*/


public class MagicSquares {
  
  /**
   * This function prints the squares.
   */ 
  static void printSquare(int[] printList) {
    for (int printCounter = 0; printCounter < printList.length; printCounter++) {
      System.out.print(printList[printCounter] + " ");
      if ((printCounter + 1) % 3 == 0) {
        System.out.println("");
      } else {
        continue;
      }
    }
    System.out.println("-----");
  }
  
  /**
   * The magicSquareSolver function uses recursion to solve 3x3 magic squares.
   */ 
  static void magicSquareSolver(int[] listNumbers, int[] index, int indexNum) {
    // Entering a loop to add numbers to the square.
    for (int counter = 0; counter < listNumbers.length; counter++) { 
      if (index[counter] == 0) {
        listNumbers[counter] = indexNum; 
        index[counter] = 1;
        
        if (indexNum < 9) {
          magicSquareSolver(listNumbers, index, indexNum + 1);
        } else {
          // Calling "magicSquareValidity" to check if it's valid or not.
          // Proceeding 
          if (horizontalValidity(listNumbers) == true
              && verticalValidity(listNumbers) == true
              && diagonalValidity(listNumbers) == true) {
            // Print the square if all are true.
            printSquare(listNumbers);
          } 
        }
        // If one of the checks is false. Redo the square.
        index[counter] = 0;
      }
    }
  }
    
  /**
   * This function checks the horizontal validity of Magic Square. 
   */ 
  public static boolean horizontalValidity(int[] list) {
    // Horizontal Check
    int horizontalCheck1 = list[0] + list[1] + list[2];
    int horizontalCheck2 = list[3] + list[4] + list[5];
    int horizontalCheck3 = list[6] + list[7] + list[8]; 
    if (horizontalCheck1 != 15 || horizontalCheck2 != 15 || horizontalCheck3 != 15) {
      return false;
    }
    return true;
  }
  
  /**
   * This function checks the vertical validity of Magic Square. 
   */ 
  public static boolean verticalValidity(int[] list) {
    // Vertical Check
    int verticalCheck1 = list[0] + list[3] + list[6];
    int verticalCheck2 = list[1] + list[4] + list[7];
    int verticalCheck3 = list[2] + list[5] + list[8];
    if (verticalCheck1 != 15 || verticalCheck2 != 15 || verticalCheck3 != 15) {
      return false;
    }
    return true;
  }
  
  /**
   * This function checks the diagonal validity of Magic Square. 
   */      
  public static boolean diagonalValidity(int[] list) {
    // Diagonal Check
    int diagonalCheck1 = list[0] + list[4] + list[8];
    int diagonalCheck2 = list[2] + list[4] + list[6];
    if (diagonalCheck1 != 15 || diagonalCheck2 != 15) {
      return false;
    }
    return true;
  }
    
  /**
   * The main function passes values to the "magicSquareSolver" function.
   */ 
  public static void main(String[] args) {
    // Defining lists variables:
    int[] list1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] list2 = {0, 0, 0, 0, 0, 0, 0, 0, 0}; 
    
    // Calling function "magicSquareSolver".
    magicSquareSolver(list1, list2, 1);
  }
}


    