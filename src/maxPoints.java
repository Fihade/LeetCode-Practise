import java.util.*;

public class maxPoints {
    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
//    给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
    public int maxPoints(Point[] points) {
        int n = points.length;
//        Map<>
        Map<Double,Integer> map = new HashMap<>();
        double xie = 0;
        for (int i = 0;i<n;i++){
            for (int j = + 1;j<n;j++) {
                if (points[i].x != points[j].x) {
                    xie = (points[i].y - points[j].y) / (points[i].x - points[j].x);
                }
                if (map.isEmpty()) {
                    map.put(xie, map.getOrDefault(xie, 1) + 1);
                }

            }
        }
        Iterator iterator = map.values().iterator();
        int max = 0;
        for (int a : map.values()){
            if (a > max) max = a;
        }

        return max;

    }

        public static void main(String[] args){

        }


//    class Point {
//        int x;
//        int y;
//        Point() { x = 0; y = 0; }
//        Point(int a, int b) { x = a; y = b; }
//    }

//    static class Line{
//
//        Point p1;
//        Point p2;
//
//        int pointCount;
//
//        Line(Point p1, Point p2){
//            this.p1 = p1;
//            this.p2 = p2;
//
//            this.pointCount = 2;
//        }
//
//        boolean on(int x, int y){
//            return (x - p1.x) * (p2.y - p1.y) == (y - p1.y) * (p2.x - p1.x);
//        }
//
//        boolean on(Point p){
//            return on(p.x, p.y);
//        }
//    }
//
//    public int maxPoints(Point[] points) {
//
//        if(points.length < 2) return points.length;
//
//        ArrayList<Line> lines = new ArrayList<Line>();
//
//        lines.add(new Line(points[0], points[1]));
//
//        for(int i = 2; i < points.length; i++){
//            boolean on = false;
//            for(Line line : lines){
//                if(line.on(points[i])){
//                    line.pointCount++;
//                    on = true;
//                }
//            }
//
//            if(!on){
//                for(int j = 0; j < i; j++){
//                    Line l = new Line(points[j], points[i]);
//                    lines.add(l);
//
//                    for(int k = 0; k < i; k++){
//                        if(j != k && l.on(points[k])){
//                            l.pointCount++;
//                            break;
//                        }
//
//                    }
//                }
//            }
//        }
//        int max = Integer.MIN_VALUE;
//        for(Line line : lines){
//            if(line.pointCount > max) max = line.pointCount;
//        }
//        return max;
//
//    }
}