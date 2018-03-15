#include<stdio.h>
#include<stdlib.h>

int main() {
	int i, j, sum, h;
	int **p;

	printf("This program is adding elements of pascal's triangle up to inputted height\n");
	printf("Input : ");
	scanf("%d", &h);

	p = (int**)malloc(sizeof(int*)*h);
	for (i = 0 ; i < h ; i++)
		p[i] = (int*)malloc(sizeof(int)*(i+1));

	sum = 0;
	for (i=0 ; i < h ; i++)
		for (j=0; j <= i ; j++){
			if( j == 0 )
				p[i][j] = 1;
			else if( j == i)
				p[i][i] = 1;
			else 
				p[i][j] = p[i-1][j-1] + p[i-1][j];

			sum += p[i][j];
		}
	
	printf("Sum : %d\n", sum); 

	for (i = 0; i < h ; i++)
		free(p[i]);
	free(p);
	
	return 0;
}
