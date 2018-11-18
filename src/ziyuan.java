public class ziyuan {
    public static void main(String[] args){
        int[] weight = {3,4,6,2,5};
        int[] val = {6,8,7,5,9};
        int maxw = 10;
        int m = 20;
        int[] f = new int[maxw+1];
        for(int i=0;i<f.length;i++){
            f[i] = 0;
        }
        for(int i=0;i<val.length;i++){
            for(int j=weight[i];j<f.length;j++){
                f[j] = Math.max(f[j], f[j-weight[i]]+val[i]);
//                if (f[j] > m )
//                    System.out.println(j);
            }
        }
        System.out.println(f[maxw]);
    }

}
