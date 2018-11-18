import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0)
            return new ArrayList<>();
        HashMap<String,List<String>> maps = new HashMap<>();
        for(String s:strs)
        {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!maps.containsKey(key))
                maps.put(key,new ArrayList());
            maps.get(key).add(s);
        }
        return new ArrayList(maps.values());
    }

    public static List<List<String>> groupAnagrams1(String[] strs){
        HashMap<String,List<String>> map = new HashMap<>();
        for (int i = 0;i<strs.length;i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if (!map.containsKey(key)){
                map.put(key,new ArrayList());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams1(strs));
    }


}
