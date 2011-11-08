#include <stdio.h>

int main() {
	int A[8] = {3,6,4,1,3,4,1,4};
	int B[8];
	int k = 6;
	int i;
	int C[6] = {}; // zerowanie
	for (i=0;i<8;i++) C[A[i]-1]++;;
	for (i=1;i<k;i++) C[i] += C[i-1];
	for (i=8-1;i>=0;i--) {
 		B[C[A[i]-1]-1] = A[i];
  		C[A[i]-1]--;
 	}
	for (i=0;i<8;i++) printf("%i ",A[i]);
	printf("\npo sortowaniu\n");
	for (i=0;i<8;i++) printf("%i ",B[i]);
	printf("\n");

	return 0;
}
