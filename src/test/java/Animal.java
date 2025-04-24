public class Animal {
    protected String name;
    protected int maxRun;
    protected int maxSwim;
    protected boolean canSwim;

    protected static int allAnimals = 0;
    protected static int allDogs = 0;
    protected static int allCats = 0;

    public Animal (String name, int maxRun, int maxSwim, boolean canSwim){
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        this.canSwim = canSwim;
        allAnimals++;
    }

    public void run(int distance){
        if (distance < 0){
            System.out.println(name + " не может пробежать " + distance + " метров (дистанция не может быть отрицательной) ");
            return;
        }
        if (distance <= maxRun){
            System.out.println(name + " пробежал " + distance + " метров ");
        }
        else {
            System.out.println(name + " не может пробежать " + distance + " метров ");
        }
    }

    public void swim(int distance){
        if (distance <0 ){
            System.out.println(name + " не может проплыть " + distance + " метров (дистанция не может быть отрицательной)");
            return;
        }
        if (!canSwim){
            System.out.println(name + " не умеет плавать ");
            return;
        }
        if (distance <= maxSwim){
            System.out.println(name + " проплыл " + distance + " метров ");
        }
        else {
            System.out.println(name + " не может проплыть " + distance + " метров ");
        }
    }

    public static int getAllAnimals(){
        return allAnimals;
    }
    public static int getAllDogs(){
        return allDogs;
    }
    public static int getAllCats(){
        return allCats;
    }
}
