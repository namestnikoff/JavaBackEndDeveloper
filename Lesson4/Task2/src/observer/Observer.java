package observer;

/*
 * Простой интерфейс наблюдателя
 */
public interface Observer {
    // Всего один метод - вызывается когда строка меняется
    void onStringChanged();
}