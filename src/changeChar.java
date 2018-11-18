public class changeChar {
    public static int changeChar(String a){
        char[] aa = a.toCharArray();
        int n = aa.length;
        int i = 0;
        int j = n-1;
        int count = 0;
        while (i<j){
            if (aa[i] != '*' && aa[j] != '*'){
                j--;
            }
            if (aa[i] != '*' && aa[j] == '*'){
                char tmp = aa[i];
                aa[i] = aa[j];
                aa[j] = tmp;
                i++;
                j--;
                count++;
            }
            if (aa[i] == '*' && aa[j] == '*'){
                i++;
                count ++;
            }
            if (aa[i] == '*' && aa[j] != '*'){
                i++;
                j--;
                count ++;
            }
        }
        for (char num:aa){
            System.out.println(num);
        }
        return count;
    }

    public static void main(String[] args){
        String m = "ab**cd**e*12";
        System.out.println(changeChar(m));
    }
}
