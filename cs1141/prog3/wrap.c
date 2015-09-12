/*
 * wrap.c
 *
 * Contains main() only. Function prototypes and implementations are
 * stored elsewhere.
 *
 * To compile: 
 *      make
 * To run: 
 *      make run
 *
 * Jeremy Sommerfeld
 * cs1141 - Fall 2014
 */
#ifndef STDIO_H
#define STDIO_H
#include <stdio.h>
#endif

#include "func.h"
#define INF 100000

int main() {

    int wrapCol, numWords, i;
    char words[151][20];
    int wordsLength[151];

    scanf("%d", &wrapCol);      /* Reads in the wrap column */
    scanf("%d", &numWords);     /* Reads in the number of words */

    for(i = 1; i <= numWords; i++) {
        scanf("%20s", words[i]);
        wordsLength[i - 1] = len(words[i]);
    }

    solve(wordsLength, numWords, wrapCol, words);
    return 0;
}

