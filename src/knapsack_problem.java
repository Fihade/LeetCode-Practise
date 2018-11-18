public class knapsack_problem {
    static double[][] p;
    static int[] x;
    public static void main(String[] args){
        double[] w={2,2,6,5,4};
        double[] v={6,3,5,4,6};
        double c=10;
        p=new double[((1+(w.length+1))*(w.length+1))/2][2];
        x=new int[w.length+1];
        int[] head=new int[w.length+2];
        knapsack_problem pack =new knapsack_problem();
        System.out.println("具体实例为w={2,2,6,5,4};v={6,3,5,4,6};c=10时，有：");
        System.out.println("求得的最优值为："+pack.knapsack(w,v,c,p,head));
        pack.traceback(w,v,c,p,head,x);
        pack.show_traceback();
    }


    //求得最优值后，显示被放进背包的物品
    private void show_traceback() {
        System.out.print("装入背包分别为第");
        for(int i=0;i<x.length;i++){
            if(x[i]==1) System.out.print(i+" ");
        }
        System.out.println("个物品");
    }

    public double knapsack(double[] w,double[] v,double c,double[][] p,int[] head){
        int n=v.length-1;
        head[n+2] = 0; //
        p[0][0] = 0;
        p[0][1] =0;
        int left = 0,right = 0,
                next = 1;
        head[n+1] =1;
        for(int i=n;i>=0;i--){
            int k=left;
            for(int j=left;j<=right;j++){
                if(p[j][0]+w[i]>c) break;
                double y=p[j][0]+w[i],
                        m=p[j][1]+v[i];
                while(k<=right && p[k][0]<y){
                    p[next][0] = p[k][0];
                    p[next++][1] = p[k++][1];
                }
                if(k<=right && p[k][0]==y){
                    if(m<p[k][1]){
                        m = p[k][1];
                    }
                    k++;
                }
                if(m>p[next-1][1]){
                    p[next][0]=y;
                    p[next++][1]=m;
                }
                while(k<=right && p[k][1]<=p[next-1][1]){k++;}
            }
            while(k<=right){
                p[next][0] = p[k][0];
                p[next++][1] = p[k++][1];
            }
            left = right+1;
            right = next-1;
            head[i] = next;
        }
        return p[next-1][1];
    }

    //分别对每个物品是否在背包中
    public void traceback(double[] w,double[] v,double c,double[][] p,int[] head,int[] x){
        int n = w.length-1;
        double j = p[head[0]-1][0],
                m = p[head[0]-1][1];
        for(int i=1;i<=n+1;i++){
            x[i] = 0;
            for(int k = head[i+1];k<=head[i]-1;k++){
                if(p[k][0]+w[i-1]==j && p[k][1]+v[i-1]==m){
                    x[i]=1;
                    j = p[k][0];
                    m = p[k][1];
                    break;
                }
            }
        }
    }
}
