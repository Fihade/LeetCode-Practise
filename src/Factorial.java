public class Factorial
    {
        static int a[] = new int [10000000];
        static void factorial(int n)
        {
            for(int i=2; i< a.length; i++)
                a[i] = 0;               //将数组元素初始化
            a[0] = 1;                   //用数组的一项存放计算结果的位数
            a[1] = 1;                   //将第一项为一
            for(int j= 2; j <= n; j++)
            {

                int i=1;
                int c = 0;              //c表示向高位的进位
                for(; i <= a[0]; i++)
                {
                    a[i] = a[i] * j + c;//将来自低位的计算结果和本位的结果相加
                    c = a[i] / 10;
                    a[i] = a[i] % 10;
                }
                for(; c != 0; i++)
                {
                    a[i] = c%10;
                    c = c / 10;
                }
                a[0] = i - 1;
            }
        }
        public static void main(String[] args)
        {
            int count = 0;
            factorial(100000);
            for(int i= a[0]; i>0; i--)
            {
                count++;
                System.out.print(a[i]);
            }

            System.out.println("/n"+count);
        }
    }

