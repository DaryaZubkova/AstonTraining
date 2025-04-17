public class Bowl {
    private int food;

    public Bowl(int startFood){
        if (startFood < 0){
            System.out.println(" Еда в миске не может быть отрицательной ");
        }
        this.food = startFood;
    }

    public void addFood(int amount){
        if (amount < 0){
            System.out.println(" Нельзя добавить в миску отрицальное количество еды ");
            return;
        }
        food += amount;
        System.out.println("В миску добавлено " + amount + " еды. Количество еды в миске: " + food);
    }
    public boolean eatFood(int amount){
        if (amount <0) {
            System.out.println(" Нельзя съесть отрицательное количество еды ");
            return false;
        }
        if (food >= amount){
            food -= amount;
            return true;
        }
        else {
            return false;
        }
    }
    public boolean minusFood(int amount) {
        return eatFood(amount);
    }

    public int getFood(){
        return food;
    }
}
