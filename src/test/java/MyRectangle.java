public class MyRectangle implements Shapes {
    private double width;
    private double height;
    private String backgroundColor;
    private String borderColor;

    public MyRectangle(double width, double height, String backgroundColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}