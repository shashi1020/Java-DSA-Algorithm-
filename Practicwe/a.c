#include<stdio.h>


int main()
{
    int Num;
    printf("enter any number : ");
    scanf("%d",&Num);
     while(Num != 1)
        {
            if(Num%2 == 0)
            {
                Num = Num / 2;
                printf("%d", Num);
            }
            else{
                Num = (Num * 3) + 1;
                printf("%d", Num);
            }
        } 
    printf(" \n ");

    return 0;
}