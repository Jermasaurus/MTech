#include <stdio.h>
#include <stdlib.h>

#define LIMIT (20)

int main (void) {
	int i, j, x, y;

	srand(time(NULL));	// Plant a random number seed
	for (j = 1; j <= LIMIT; j++) {
		x = rand()/10;	// Get a Random number and scale
		for (i = 1; i <= x; i++) {
			y = rand();	// Just waste some CPU time
		}
		printf("Hi, A here! Random number = %d\n", x);
	}
	printf("A completes...\n");
}