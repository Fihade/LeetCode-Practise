public class repeatElement {
    public static void main(String[] args){
        int[] a = {123,10,3,5,199,77,99,8,5,10};
        int[] b = new int[200];
        int n = a.length;
        int i ;
        for (i = 0;i<n;i++){
            if (b[a[i]] == 0){
                b[a[i]] = 1;
            }
            else System.out.println("repeated");
            break;
        }
        System.out.println("No repeated");
    }
}
