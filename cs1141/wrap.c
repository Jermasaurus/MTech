/* 
 * wrap.c
 * A simple word wrapping program.
 * 
 * To compile:
 *			gcc -ansi -pedantic wrap.c
 * To run:
 *			./a.out
 *
 * @Author - Jeremy Sommerfeld
 *	cs1141 - Fall 2014
 */

#include <stdio.h>
#define DEBUG 1
#define LARGE_NUM 10000

int findSum(int i, int j, int wordsLength[]) {
	int tmp = 0;
	while(i <=j) {
		tmp += wordsLength[i];
		i++;
	}
	return tmp;
}

/*
 * The main function of wrap.c
 */
int main( ) {
	int wrapCol, numWords, i, j;

	scanf("%d", &wrapCol);		/* Reads in the wrap column */
	scanf("%d", &numWords);		/* Reads in the number of words */

	char words[numWords + 1][20];
	int wordsLength[numWords + 1];

	for(i = 1; i < numWords; i++) {
		wordsLength[i] = scanf("%20s", words[i]);
	}

	#if DEBUG	/* Test to make sure that the inputs are read correctly */
		printf("=====START DEBUG=====\n");
		printf("Line Length = %d\nNumber of Words = %d\n\nWords:", wrapCol, numWords);
		for(i = 1; i <= numWords; i++) {
			printf("%s\n", words[i]);
		}
		printf("======END DEBUG======\n\n");
	#endif

	int lineCost[numWords + 1][numWords + 1], c[numWords + 1], p[numWords];
	int tmp, cost;

	for(i = 1; i <= numWords; i++) {
		for(j = 1; j <= numWords; j++) {
			tmp = wrapCol - j + i - findSum(i, j, wordsLength);

			if(tmp < 0) {
				lineCost[i][j] = LARGE_NUM;
			} else if(j == numWords && tmp >= 0) {
				lineCost[i][j] = 0;
			} else {
				lineCost[i][j] = tmp * tmp * tmp;	/* Raise it to the power of 3 (tmp^3) */
			}
			if( (1 <= i <= j) && (c[j] > (c[i - 1] + lineCost[i][j])) ) {
				c[j] = c[i - 1] + lineCost[i][j];
			}
		}
	}


	#if 0
	for(i = 0; i < numLines; i++) {
 		printf("%s\n", wrapped[i]);		/* Output the wrapped words line-by-line*/
 	}
 	printf("\nTotal cost: %d\n", cost);		/* Outputs the total cost */
 	#endif

 	return 0;
}

