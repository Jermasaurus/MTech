#include<stdio.h>

/*
 * @Author Jeremy Sommerfeld
 * CS1141 Fall 2014
 *
 * This is the main method for fib.c.  It prompts the user for a number n,
 * and prints out the nth Fibonaci Number in the sequence. 
 * 
 * If the user enters a negative number, it will immediately reprompt.  
 * If a zero is entered, the program will print the oth Fibonacci number, and exit.
 *
 * Compile using: gcc -ansi -pedantic
 */
int main( ) {

   int exit = 0, input = 1, first = 1, second = 1, next, i;

   while( exit == 0 ) {
      printf( "Value: " );
      scanf("%d", &input);
      if( input > 0 ) {
         for( i = 0; i < input; i++ ) {
            if( i < 2 ) {
               next = 1;
            }
            else {
            next = first + second;
            first = second;
            second = next;
            }
         }
         printf( "Fibonacci number %d is %d\n", input, next );
         next = 0;
         first = 1;
         second = 1;
      }
      else if ( input == 0 ) {
         printf( "Fibonacci number 0 is 0\n" );
         exit = 1;
      }
   }
return 0;
}
