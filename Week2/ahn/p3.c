#include<stdio.h>
#include<limits.h>

int check(int num);

int main(){
	printf("Problem 3\nInput(only integer) : \n");
	printf("NOTE : This system's INT_MAX is %d and INT_MIN is %d.\n", INT_MAX, INT_MIN);
	int num = 0;
	scanf("%d", &num);
	printf("Number is %d\n", num);
	printf("Output : %s\n", check(num) ? "True" : "False");

	return 0;
}

int check(int num){
	if( num < 0 )
		return 0;
	
	int a = 0;
	int b[10];
	while(num > 0){
		b[a] = num % 10;
		num /= 10;
		a++;
	}
	
	printf("digit = %d\n", a);
	
	for( int i = 0 ; (a/2)>=i ; i++){
		if( b[i] == b[a-1-i])
			continue;
		else return 0;
	}

	return 1;
}
