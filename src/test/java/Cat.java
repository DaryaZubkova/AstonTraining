public class Cat extends Animal {
    public Cat(String name){
        super (name, 200, 0, false);
        this.isFull = false;
        allCats++;
    }
    private boolean isFull;

    public void eat(Bowl bowl, int amount){
        if (bowl.minusFood(amount)){
            isFull = true;
            System.out.println(name + " поел и теперь сыт ");
        }
        else {
            System.out.println(name + " не поел, в миске мало еды ");
        }
    }

    public boolean isFull(){
        return isFull;
    }
}
