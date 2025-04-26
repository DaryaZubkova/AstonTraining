import org.w3c.dom.ls.LSOutput;

public class Park {
    public static void main(String[] args) {
        Park myPark = new Park();
        myPark.showAttraction();
    }

    public class Attractoin {
        private String name;
        private String workTime;
        private int price;

        public Attractoin(String name, String workTime, int price) {
            this.name = name;
            this.workTime = workTime;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Информация об аттракционе: ");
            System.out.println("Название: " + name);
            System.out.println("Часы работы: " + workTime);
            System.out.println("Цена: " + price);
        }
    }

    public void showAttraction() {
        Attractoin attractoin1 = new Attractoin("Американские горки", "10:00 - 20:00", 500);
        attractoin1.printInfo();
        Attractoin attractoin2 = new Attractoin("Колесо обозрения", "10:00 - 16:00", 450);
        attractoin2.printInfo();
        Attractoin attractoin3 = new Attractoin("Молот", "12:00 - 22:00", 650);
        attractoin3.printInfo();
    }
}
