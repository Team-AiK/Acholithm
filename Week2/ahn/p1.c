#include<stdio.h>

int paren_count = 0;

void print_paren(int* arr, int arr_size){
	for (int i = 0; i < arr_size; i++){
		if(arr[i] == '(')
			printf("(");
		else
			printf(")");
		}
	printf("\n");
}

void paren(int* arr, int arr_size, int open_paren, int close_paren){
	if (open_paren == 0 && close_paren == 0){
		print_paren(arr, arr_size);
		paren_count++;
		return;
	}

	if (open_paren > 0){
		arr[arr_size] = '(';
		paren(arr, arr_size + 1, open_paren -1, close_paren + 1);
	}

	if (close_paren > 0){
		arr[arr_size] = ')';
		paren(arr, arr_size + 1, open_paren, close_paren -1);
	}
}

int main(){
	printf("Problem 1\n");
	
	int arr[100];
	int num = 0;
	
	printf("Input number of parentheses :");
	scanf("%d", &num);
	paren(arr, 0, num, 0);
	printf("Count : %d\n", paren_count);

	return 0;
}
