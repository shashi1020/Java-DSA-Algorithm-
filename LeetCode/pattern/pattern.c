#include<stdio.h>


int main()
{
    int n=5;
    for(int i=0; i<n; i++)
        {
            printf("*", n);
            printf("*", n-i-1);
        }
}