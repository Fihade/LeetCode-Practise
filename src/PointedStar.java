public class PointedStar {
    final int[] cycle = {1,6,3,8,5,2,7,4};

    public class PointedStart{

    }

    public int[] line(int start,int end){
        int[] lin = {start,end};
        return lin;
    }

    public int findNextPoint(int start,int self){
        int startFlag = 0;
        int selfFlag = 0;
        for (int i = 0; i < cycle.length; i++){
            if (cycle[i] == start){
                startFlag = i;
            }
            if (cycle[i] == self){
                selfFlag = i;
            }
        }
        if ((startFlag % cycle.length) < (selfFlag % cycle.length))
            return selfFlag+1;
        else return startFlag - 1;
    }

}

