#include <stdio.h>

int main() {
	int a[] = {5, 15, 34, 54, 14, 2, 52, 72};
	int *p = &a[1], *q = &a[5];

	int aVal = *(p+3);
	printf("A is %d", aVal);
	int bVal = *(q-3);
	printf("B is %d", bVal);
	int cVal = q - p;
	printf("C is %d", cVal);
	if(p < q) {
		printf("D is true");
	}
	if(*p < *q) {
		printf("E is true");
	}
}

