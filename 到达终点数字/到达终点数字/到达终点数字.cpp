#include<iostream>
using namespace std;

//在一根无限长的数轴上，你站在0的位置。终点在target的位置。
//每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
//返回到达终点需要的最小移动次数。
//  示例 1:
//  输入: target = 3
//	输出 : 2
//	解释 :
//	第一次移动，从 0 到 1 。
//	第二次移动，从 1 到 3 。
//	示例 2 :
//	输入 : target = 2
//	输出 : 3
//	解释 :
//	第一次移动，从 0 到 1 。
//	第二次移动，从 1 到 - 1 。
//	第三次移动，从 - 1 到 2 。


int reachNumber(int target) {
	int sum = 0;
	for (int i = 1; sum != abs(target); i++) {
		if (sum < abs(target)) {
			if ((sum + i) > abs(target)) {
				sum -= i;
			}
			else {
				sum += i;
			}
		}
		if (sum == abs(target)) {
			return i;
		}
	}
	return 0;
}
int main() {
	int n;
	cin >> n;
	cout << reachNumber(n) << endl;
	system("pause");
	return 0;
}