/*
 * func.c
 *
 * Contains the implementation of findSum() which has a prototype
 * in func.h
 *
 * Jeremy Sommerfeld
 * cs1141 - Fall 2014
 */

#include "func.h"

#ifndef STDIO_H
#define STDIO_H
#include <stdio.h>
#endif

#ifndef INF
#define INF 100000
#endif

unsigned int len(const char *s) {
    unsigned int n;
    for (n = 0; *s != '\0'; s++) {
        n++;
    }
    return n;
}

void solve(int l[], int n, int M, char words[][20]) {

    int extras[151][151], lc[151][151], c[151], p[151];
    int i, j;
    int cost = 0;

    for (i = 1; i <= n; i++) {
        extras[i][i] = M - l[i-1];
        for (j = i+1; j <= n; j++) {
            extras[i][j] = extras[i][j-1] - l[j-1] - 1;
        }
    }

    for (i = 1; i <= n; i++) {
        for (j = i; j <= n; j++) {
            if (extras[i][j] < 0) {
                lc[i][j] = INF;
            }
            else if (j == n && extras[i][j] >= 0) {
                lc[i][j] = 0;
            }
            else {
                lc[i][j] = extras[i][j]*extras[i][j]*extras[i][j];
            }
        }
    }

    c[0] = 0;
    for (j = 1; j <= n; j++) {
        c[j] = INF;
        for (i = 1; i <= j; i++) {
            if (c[i-1] != INF && lc[i][j] != INF && (c[i-1] + lc[i][j] < c[j])) {
                c[j] = c[i-1] + lc[i][j];
                p[j] = i;
            }
        }
    }
 
    printSolution(p, n, words);

    printf("\nTotal cost: %i\n", cost);
}

int printSolution(int p[], int n, char words[][20]) {
    int k, i;
    if (p[n] == 1) {
        k = 1;
    }
    else {
        k = printSolution (p, p[n]-1, words) + 1;
    }

    for(i = p[n]; i <= n; i++) {
    	printf("%s ", words[i]);
    }
    printf("\n");
    
    return k;
}

