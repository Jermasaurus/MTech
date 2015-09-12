/*
 * caesar.c
 *
 * Contains the implementation of a caesar cypher
 * Prototypes for all of these functions are contained in caesar.h
 *
 * DO NOT INCLUDE THIS FILE DIRECTLY! Instead, just include caesar.h
 *
 * CREATED - Jerry Sommerfeld - 2014-11-30
 */
#include <ctype.h>	/* isalpha() lives here */

#include "caesar.h"

/*
 * This function encrypts a char based on the offset passed to it.
 */
char encrypt(char c, int offset) {
	/* Check to see if c is a letter, if not, no conversion is necessary */
	if(isalpha(c)) {
		/* If uppercase: */
		if(isupper(c)) {
			c = (((c - 'A') + offset) % 26) + 'A';
		}
		/* If lowercase */
		else {
			c = (((c - 'a') + offset) % 26) + 'a';
		}
	}
	return c;
}

