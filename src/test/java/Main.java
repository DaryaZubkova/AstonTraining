public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Принц");
        Cat cat1 = new Cat("Комок");
        Cat cat2 = new Cat("Бантик");

        System.out.println(" Всего животных: " + Animal.getAllAnimals());
        System.out.println(" Собак: " + Animal.getAllDogs());
        System.out.println(" Кошек: " + Animal.getAllCats());

        dog1.run(500);
        dog1.run(501);
        dog1.run(-150);

        cat1.run(200);
        cat1.run(201);
        cat2.run(-100);

        dog1.swim(10);
        dog1.swim(11);
        dog1.swim(-10);

        cat1.swim(0);
        cat2.swim(-1);

        Bowl bowl = new Bowl(100);
        Cat[] cats = {
                new Cat("Миша"),
                new Cat("Коша"),
                new Cat("Шиша"),
                new Cat("Гоша")
        };
        for (Cat cat : cats) {
            cat.eat(bowl, 30);
        }
        System.out.println("Остаток еды в миске: " + bowl.getFood());
        bowl.addFood(20);
        System.out.println("Теперь в миске: " + bowl.getFood() + " еды.");

        Shapes circle = new Circle(2, "Красный", "Черный");
        Shapes rectangle = new MyRectangle(5, 6, "Розовый", "Белый");
        Shapes triangle = new Triangle(5, 5, 5, "Голубой", "Синий");

        System.out.println("Круг");
        circle.printInfo();
        System.out.println("Прямоугольник");
        rectangle.printInfo();
        System.out.println("Треугольник");
        triangle.printInfo();
    }
}