/*
 * caesar_driver.c
 * 
 * Contains a simple driver that gives the ability for users to manipulate
 * the caesar cypher implemented in caesar.c
 *
 * Created - Jerry Sommerfeld - 2014-11-30
 */
#include <stdlib.h>
#include <stdio.h>

#include "caesar.h"	/* All of the caesar cypher functionality lives here */

/*
 * Main driver function - AKA: "where the magic happens"
 */
int main( int argc, char *argv[] ) {
	FILE* fp;

	char c;
	int offset;

	if(argc < 3 || argc > 3) {
		/* Wrong number of arguments */
		printf("Error: Wrong number of arguments. Exiting...\n");
		return 1;
	}

	offset = atoi(argv[2]); /* use atoi so the passed ascii -> int  */

	/* Fix offset if it is larger than 26, or a negative number */
	offset = offset % 26;
	if(offset < 0) { /* If its a negative offset, shift it positive */
		offset = offset + 26;
	}

	fp = fopen(argv[1], "r"); /* Open the file specified by argument */

	/* Check to see if the file was opened properly */
	if(fp) {
		/* Loops through file, converts, and prints all in one fluid motion! */
		/* It works like an infomercial product essentially... */
		while ((c = fgetc(fp)) != EOF) { /* Loop until we hit an EOF */
			printf("%c", encrypt(c, offset));
		}
		printf("\n"); /* Print a newline after full conversion */

		/* We are done with the file, so close it */
		fclose(fp);
	}
	else {
		printf("Error: Could not open file. Exiting...\n");
		return 1;
	}

	return 0;
}

