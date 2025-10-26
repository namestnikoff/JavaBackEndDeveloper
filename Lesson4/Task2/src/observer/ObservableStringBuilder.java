package observer;
import java.util.ArrayList;
import java.util.List;

public class ObservableStringBuilder {
    private StringBuilder stringBuilder = new StringBuilder();
    private List<Observer> observers = new ArrayList<>();
    
     
    public void addObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }
    
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.onStringChanged();
        }
    }
    
    // добавление строки в stringBuilder и нотифакаця наблюдателей
    public ObservableStringBuilder append(String str) {
        stringBuilder.append(str);
        notifyObservers();
        return this;
    }
    
    // toString чтобы видеть результат
    public String toString() {
        return stringBuilder.toString();
    }
}