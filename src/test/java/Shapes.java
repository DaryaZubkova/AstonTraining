public interface Shapes {
    double getPerimeter();
    double getArea();
    String getBackgroundColor();
    String getBorderColor();

    default void printInfo(){
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет фона: " + getBackgroundColor());
        System.out.println("Цвет границ: " + getBorderColor());
    }
}