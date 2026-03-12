#include <stdio.h>

unsigned long long operation(unsigned int x) 
{
    if(x == 0)
        return 0;
    else if (x == 1)
      return 1;
    else
      return (operation(x-1)+operation(x-2));
}

int main(void) 
{
    unsigned long long num;
    printf("Enter the input number: ");
    scanf("%llu", &num);
    printf("%llu\n", operation(num));
    return 0;
} 
