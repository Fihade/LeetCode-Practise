public class yichuan {
    public static int change(String m){
        char[] mm = m.toCharArray();
        int len = mm.length;
        int firstY = 0;
        int count = 0;
        for (int i = 0; i<len; i++){
            if (mm[i] == 'Y'){
                firstY = i;
                break;
            }
        }
        System.out.println(firstY);
        for (int i = len-1;i>firstY;i--){
            if (mm[i] == 'X') count++;
        }
        for (int j = 0;j<firstY+1;j++){
            if (mm[j] == 'Y') count++;
        }

        return count;
    }

    public static int swap(String m){
        char[] mm = m.toCharArray();
        int len = mm.length;
        int count = 0;
        if (mm[0] == 'X' && mm[1] == 'Y')
            count =  0;
            mm[1] = 'Y';
        if (mm[0] == mm[1]) count = 0;
        if (mm[0] == 'Y' && mm[1] == 'x') count += 1;
        for (int i = 2;i<len-1;i++){
           if (mm[i] != mm[i-1]) count++;
        }
        return count;
    }

    public static int change1(String m){

        char[] mm = m.toCharArray();

        int mid = mm.length / 2;
        int countX = 0;
        int countY = 0;

        for (int i = 0;i<mid;i++){
            if (mm[i] == 'X') countX++;
        }
        for (int j = mm.length - 1;j>mid;j--){
            if (mm[j] == 'Y') countY++;
        }

        int count = 0;
        if (countX >= mid/2) {
            count += (mid - countX);
        }else count += countX;
        if (countY > (mm.length - mid)/2){
            count += (mm.length - mid - countY);
        }else count += countY;

        return count;
    }
    public static void main(String[] args){
//        System.out.println(Math.min(swap("XYXXYY"),change("XYXXYY")));
//        XYYYYY	XYXYXYXY	XXXYYY
        System.out.println(change1("YXXXXX"));
        System.out.println(change1("XYXYXYXY"));
        System.out.println(0);
    }
}