public class Triangle implements Shapes {
    private double sideA;
    private double sideB;
    private double sideC;
    private String backgroundColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String backgroundColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        return (sideA + sideB) / 2;
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
