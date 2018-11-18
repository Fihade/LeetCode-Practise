public class plusone {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int k = 0;
        while(i >= 0){
            if (i == digits.length-1) {
                if (digits[i] + 1 + k >= 10) {
                    digits[i] = (digits[i] + 1) % 10;
                    k = 1;
                }
                else digits[i] = digits[i] + 1;
            }else {
                if (digits[i] + k >= 10) {
                    digits[i] = (digits[i] + k) % 10;
                    k = 1;
                }else digits[i] = digits[i] + k;
            }
            i--;

        }
        return digits;
    }


}
