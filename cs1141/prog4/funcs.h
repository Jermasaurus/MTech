/*
 * funcs.h
 * Part of a radix trie implementation.
 * Contains function prototypes for functions contained in funcs.c
 *
 * Jeremy Sommerfeld
 * cs1141 - Fall 2014
 */

#ifndef FUNCS_H
#define FUNCS_H

/* Create a node structure for the nodes */

struct radixNode {
	void * payload;

	struct * radixNode left;
	struct * radixNode right;
};

/* Write function prototypes here... */

void insertTrie();

int searchTrie();

void emptyTrie();

void printWords();

void printNumNodes(int num);

void printNumWords(int num);

#endif