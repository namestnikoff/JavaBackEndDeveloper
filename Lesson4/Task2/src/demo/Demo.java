package demo;
import observer.*;

public class Demo {
    public static void main(String[] args) {
        ObservableStringBuilder osb = new ObservableStringBuilder();
        
        osb.addObserver(new Observer() {
            public void onStringChanged() {
                System.out.println(osb.toString());
            }
        });
        
        osb.append("Hello");
        osb.append(" World");
    }
}