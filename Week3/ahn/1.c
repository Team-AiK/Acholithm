#include<stdio.h>

int main() {
	int p[8][8];
	int i, j, sum;

	sum = 0;
	for (i=0 ; i < 8 ; i++)
		for (j=0; j <= i ; j++){
			if( j == 0 )
				p[i][j] = 1;
			else if( j == i)
				p[i][i] = 1;
			else 
				p[i][j] = p[i-1][j-1] + p[i-1][j];

			sum += p[i][j];
		}
	
	printf("sum = %d\n", sum); 

	return 0;
}
