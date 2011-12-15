#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TEMP 128

int znak(char **A, int wiersz, int kolumna) {
    if (strlen(A[wiersz]) <= kolumna) A[wiersz][kolumna] = ' ';
    return (int)A[wiersz][kolumna];
}

int main() {
    char **A, **B;
    int i,j,n,c;
    char temp[TEMP];
    int max = 0;

    printf("Ile wyrazow chcesz posortowac? "); scanf("%i",&n);
    A = (char**) malloc(n * sizeof(char*));
    B = (char**) malloc(n * sizeof(char*));

    for (i=0;i<n;i++) {
        printf("Podaj %i. wyraz: ",i+1); scanf("%s",temp);
        A[i] = (char*) malloc((strlen(temp)+1) * sizeof(char));
        strcpy(A[i],temp);
        if (strlen(temp) > max) max = strlen(temp);
    }

    printf("\nPRZED SORTOWANIEM:\n");
    for (i=0; i < n; i++) printf("   %s\n", A[i]);

    for (j = max-1; j >= 0; j--) {
        char C[TEMP];

        int k = znak(A, 0, j);

        for (i = 1; i < n; i++) if (znak(A,i,j) > k) k = znak(A,i,j);

        for (i = 0; i <= k; i++) C[i] = 0;
        for (i = 0; i < n; i++) C[znak(A,i,j)]++;
        for (i = 1; i <= k; i++) C[i] += C[i-1];
        for (i = n-1; i >= 0; i--) {
            c = znak(A, i, j);
            B[C[c]-1] = A[i];
            C[c]--;
        }

        char **T = B;
        B = A;
        A = T;
  }

    free(B);

    printf("\nPO SORTOWANIU:\n");
    for (i=0; i < n; i++) {
        printf("   %s\n", A[i]);
        free(A[i]);
    }

    free(A);

    return 0;
}
