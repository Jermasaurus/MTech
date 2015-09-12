/* A Dynamic programming solution for Word Wrap Problem */
#include <stdio.h>
#define INF 100000
#define DEBUG 1

unsigned int len(const char *s) {
    unsigned int n;
    for (n = 0; *s != '\0'; s++) {
        n++;
    }
    return n;
}

int printSolution (int p[], int n, char *words[]);

void solveWordWrap (int l[], int n, int M, char *words[])
{

    int extras[n+1][n+1];  
    int lc[n+1][n+1];
    int c[n+1];
    int p[n+1];
    int i, j;

    for (i = 1; i <= n; i++)
    {
        extras[i][i] = M - l[i-1];
        for (j = i+1; j <= n; j++)
            extras[i][j] = extras[i][j-1] - l[j-1] - 1;
    }

    for (i = 1; i <= n; i++)
    {
        for (j = i; j <= n; j++)
        {
            if (extras[i][j] < 0)
                lc[i][j] = INF;
            else if (j == n && extras[i][j] >= 0)
                lc[i][j] = 0;
            else
                lc[i][j] = extras[i][j]*extras[i][j];
        }
    }

    c[0] = 0;
    for (j = 1; j <= n; j++)
    {
        c[j] = INF;
        for (i = 1; i <= j; i++)
        {
            if (c[i-1] != INF && lc[i][j] != INF && (c[i-1] + lc[i][j] < c[j]))
            {
                c[j] = c[i-1] + lc[i][j];
                p[j] = i;
            }
        }
    }

    #if DEBUG
    for (i = 1; i <= n; i++) {
    printf("c = %i\n", c[i]);
    printf("p = %i\n", p[i]);
    }
    #endif
 
    printSolution(p, n, words);
}
 
int printSolution (int p[], int n, char *words[])
{
    int k, i;
    if (p[n] == 1)
        k = 1;
    else
        k = printSolution (p, p[n]-1, words) + 1;
    printf("Line number %d: From word no. %d to %d \n", k, p[n], n);
    /* printf("%s\n", words[n]); */
    return k;
}
 
/* Driver program to test above functions */
int main()
{

    int wrapCol, numWords, i;

    scanf("%d", &wrapCol);      /* Reads in the wrap column */
    scanf("%d", &numWords);     /* Reads in the number of words */

    char words[numWords + 1][20];
    int wordsLength[numWords + 1];

    for(i = 1; i <= numWords; i++) {
        scanf("%20s", words[i]);
        wordsLength[i - 1] = len(words[i]);
    }

    #if DEBUG   /* Test to make sure that the inputs are read correctly */
        printf("=====START DEBUG=====\n");
        printf("Line Length = %d\nNumber of Words = %d\n\nWords:\n", wrapCol, numWords);
        for(i = 1; i <= numWords; i++) {
            printf("%s %i\n", words[i], wordsLength[i - 1]);
        }
        printf("======END DEBUG======\n\n");
    #endif

    solveWordWrap(wordsLength, numWords, wrapCol, words);
    return 0;
}

