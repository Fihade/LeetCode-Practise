public class customSortString {
    public static String customSortString(String S, String T) {
        int[] find=new int[26];
        for(int i=0;i<S.length();i++){
            find[S.charAt(i)-'a']=i+1;
        }
        int max;
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for(int i=0;i<T.length();i++){
            if(find[T.charAt(i)-'a']==0)
                sb2.append(T.charAt(i));
            else
                sb1.append(T.charAt(i));
        }
        for(int i=0;i<sb1.length();i++){
            for(int j=0;j<sb1.length()-i-1;j++){
                if(find[sb1.charAt(j)-'a']>find[sb1.charAt(j+1)-'a']){
                    char temp=sb1.charAt(j);
                    sb1.setCharAt(j,sb1.charAt(j+1));
                    sb1.setCharAt(j+1,temp);
                }

            }
        }
        sb1.append(sb2);
        return sb1.toString();
    }

    public static void main(String[] args){
        String a = "asdffg";
        String b = "jhasdfsjaddfskj";
        System.out.println(customSortString(a,b));
    }
    //ashdkajhsldhajkshdasjdkl;asjdkl;sajdl;j
}
