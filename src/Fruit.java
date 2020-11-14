public class Fruit<T extends Number> {
    T[]  fruits;

    Fruit(T[] fruits){
        this.fruits = fruits;
    }
     double getWeight(T weight){
        double fruitWeight = 0;
         for (int i = 0; i < fruits.length; i++) {
             fruits[i] = weight;
             fruitWeight += fruits[i].doubleValue();
         } return fruitWeight;
    }
    public T[] getFruit(){
        return fruits;
    }
    public T[] setFruit(T[] fruits){
        return fruits;
    }
    public T clear(){
        return null;
    }

}
