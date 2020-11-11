package net.thumbtack.school.figures.v2;

public class CircleFactory {

    private static int sum;

    //Создает Circle по координатам центра и значению радиуса.
    public static Circle createCircle(Point center, int radius) {
        sum++;
        return new Circle(center, radius);
    }

    //Возвращает количество Circle, созданных с помощью метода createCircle.
    public static int getCircleCount() {
        return sum;
    }

    //Устанавливает количество Circle, созданных с помощью метода createCircle, равным 0 (иными словами, реинициализирует фабрику).
    public static void reset() {
        sum = 0;
    }


}
