/*
 * caesar.h
 *
 * Contains function prototypes, for the caesar cyper contained in caesar.c
 *
 * Include this file rather than caesar.c to access these functions.  There is
 * no reason to include caesar.c, as the linker can handle all that stuff.
 *
 * Created - Jerry Sommerfeld - 2014-11-30
 */
#ifndef CAESAR_H
#define CAESAR_H

/*
 * This function encrypts a char based on the offset passed to it.
 */
char encrypt(char c, int offset);

#endif

