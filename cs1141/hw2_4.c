#include <stdio.h>

int main() {
	int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	int *p = &a[0], *q = &a[9], temp;

	while (p < q) {
		temp = *p;
		*p++ = *q;
		*q-- = temp;
	}
	printf("%d\n", a[0]);
	printf("%d\n", a[1]);
	printf("%d\n", a[2]);
	printf("%d\n", a[3]);
	printf("%d\n", a[4]);
	printf("%d\n", a[5]);
	printf("%d\n", a[6]);
	printf("%d\n", a[7]);
	printf("%d\n", a[8]);
	printf("%d\n", a[9]);
}

