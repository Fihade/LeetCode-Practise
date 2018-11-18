import java.util.Arrays;
import java.util.Scanner;

public class crossRiver {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] out=new int[n];

            for (int i = 0; i < out.length; i++) {
                int t=sc.nextInt();
                int[] data=new int[t];
                for (int j = 0; j < data.length; j++) {
                    data[j]=sc.nextInt();
                }
                out[i]=f(data);
            }

            for (int i = 0; i < out.length; i++) {
                System.out.println(out[i]);
            }
        }
    }

    private static int f(int[] data) {

        Arrays.sort(data);

        int minD=data[0],ansD=0;
        for (int i = 1; i < data.length; i++) {
            if(i==data.length-1)
                ansD+=data[i];
            else
                ansD+=data[i]+minD;
        }

        int index=data.length-1;
        int ans=0;
        int counts=data.length;

        while(counts>=4){
            int Min=data[0];
            int eMin=data[1];

            int Max=data[index];

            ans+=eMin+Min+Max+eMin;

            index-=2;
            counts-=2;
        }

        if(counts==2){
            ans+=data[1];
        }
        if(counts==3){
            ans+=data[index]+data[0]+data[1];
        }
        return Math.min(ans,ansD);
    }
}
