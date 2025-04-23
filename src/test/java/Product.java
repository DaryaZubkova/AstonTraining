import java.time.LocalDate;

public class Product {
    public static void main(String[] args) {
        Product product1 = new Product("Телефон", LocalDate.of(2025, 3, 30), "Apple", "Китай", 120_000, "Забронирован");
        product1.printInfo();
        Product product2 = new Product("Ноутбук", LocalDate.of(2025, 1, 5), "HP", "Китай", 74_900, "В наличии");
        product2.printInfo();
        Product product3 = new Product("Телевизор", LocalDate.of(2007, 7, 25), "Philips", "Нидерланды", 52_999, "В наличии");
        product3.printInfo();
        Product product4 = new Product("Фен", LocalDate.of(2024, 6, 13), "Dyson", "England", 47_700, "Заброноирован");
        product4.printInfo();
        Product product5 = new Product("Пылесос", LocalDate.of(2017, 9, 9), "Xiaomi", "Китай", 17_500, "В наличии");
        product5.printInfo();
    }

    private String name;
    private LocalDate productionDate;
    private String manufacturer;
    private String country;
    private int price;
    private String status;

    public Product(String name, LocalDate productionDate, String manufacturer, String country, int price, String status) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.status = status;
    }

    public void printInfo() {
        System.out.println("Информация о товаре:");
        System.out.println("Название:" + name);
        System.out.println("Дата производства:" + productionDate);
        System.out.println("Производитель:" + manufacturer);
        System.out.println("Страна:" + country);
        System.out.println("Цена: " + price);
        System.out.println("Состояние бронирования покупателем:" + status);
    }
}
