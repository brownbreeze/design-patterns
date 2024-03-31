package design.patterns.java.chapter02;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperatere;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperatere, float humidity, float pressure) {
        this.temperatere = temperatere;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("current coditions: " + temperatere + "F degrees and " + humidity + "% humidity");
    }

}
