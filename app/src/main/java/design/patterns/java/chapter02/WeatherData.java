package design.patterns.java.chapter02;

import java.util.ArrayList;

import design.patterns.java.App;

public class WeatherData implements Subject {
    private ArrayList<Observer> observers;
    private float temperaters;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    @SuppressWarnings("unchecked")
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temperaters, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperaters, float humidity, float pressure) {
        this.temperaters = temperaters;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
