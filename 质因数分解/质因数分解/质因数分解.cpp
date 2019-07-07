//所谓因子分解，就是把给定的正整数a，分解成若干个素数的乘积，即 a = a1 × a2 × a3 × ... × an, 
//并且 1 < a1 ≤ a2 ≤ a3 ≤ ... ≤ an。其中a1、a2、...、an均为素数。 先给出一个整数a，请输出分解后的因子。
//输入描述 :
//输入包含多组数据，每组数据包含一个正整数a（2≤a≤1000000）。
//输出描述 :
//对应每组数据，以“a = a1 * a2 * a3...”的形式输出因式分解后的结果。
//示例1
//输入
//10
//18
//输出
//10 = 2 * 5
//18 = 2 * 3 * 3

#include<stdio.h>
#include<math.h>
int main()
{
	int n;
	while (scanf("%d", &n) != EOF)
	{
		printf("%d =", n);
		int i;
		for (i = 2; i <= sqrt(n); i++)
		{
			while (n != i)
			{
				if (n%i == 0)
				{
					printf(" %d *", i);
					n /= i;
				}
				else
					break;              //否则就陷入死循环了
			}
		}
		printf(" %d\n", n);
	}
	return 0;
}