#include <stdio.h>

/*THIS IS THE TESTING CODE FOR HOMEWORK #3*/
#define PROBLEM_1 1
#define PROBLEM_2 1
#define PROBLEM_3 1
#define PROBLEM_4 1
#define PROBLEM_5 1
#define PROBLEM_6 1
#define PROBLEM_7 1

int main() {

	/*PROBELM 1*/
	#if PROBLEM_1
	char c = '1';
	short s = 2;
	int i = -3;
	long m = 5;
	float f = 6.5f;
	double d = 7.5;
	/*BEGIN PRINTF STUFF YO*/
	printf("(a) c * i = %d\n", c*i);
	printf("(b) i + m = %d\n", i+m);
	printf("(c) f/c = %f\n", f/c);
	printf("(d) d/s = %f\n", d/s);
	printf("(e) f - d = %f\n", f-d);
	printf("(f) (int)f = %d\n", (int)f);
	#endif

	/*PROBLEM 2*/
	#if PROBLEM_2
	printf("PROBLEM #2 is pretty much all theory\n");
	#endif

	/*PROBLEM 3*/
	#if PROBLEM_3
	#define CUBE_X(X) ((X)*(X)*(X))
	#define REMAINDER_DIV_4(n) (n%4)
	#define LESS_THAN(x, y) ((x*y) <= 100)
	#endif


	#if PROBLEM_6
	#define TOUPPER(c) ('a' <=(c)&&(c)<='z'?(c)-'a'+'A':(c))
	char s61[5];
	char s62[5];
	strcpy(s61, "abcd");
	i = 0;
	printf("PROBLEM #6.1 = %c\n", TOUPPER(s61[++i]));

	strcpy(s62, "0123");
	i = 0;
	printf("PROBLEM #6.1 = %c\n", TOUPPER(s62[++i]));
	#endif

	return 0;
}
