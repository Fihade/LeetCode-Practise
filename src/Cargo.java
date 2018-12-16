public class Cargo {

    //总数量和总价值
    private double totalWeight;
    private double totalNum;
    private Cargo(){
        totalNum = 0;
        totalWeight = 0;
    }
    //进货
    private void buyGoods(goods good, int num){
        totalWeight += (good.weight * num);
        totalNum += num;
    }
    //卖货
    private void sellGoods(goods good, int num){
        totalWeight -= (good.weight * num);
        totalNum -= num;
    }

    public static void main(String[] args){
        goods good1 = new goods();
        good1.id = 1;
        good1.name = "banana";
        good1.price = 3.5;
        good1.weight = 23.8;

        Cargo cargo = new Cargo();
        cargo.buyGoods(good1,14);
        System.out.println("总数量："+cargo.totalNum);
        System.out.println("总质量："+cargo.totalWeight);
        cargo.sellGoods(good1,3);
        System.out.println("总质量："+cargo.totalWeight);
        System.out.println("总数量："+cargo.totalNum);
    }

}
