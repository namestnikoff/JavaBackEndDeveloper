
public class App {
    public static class Student {
        private String name;
        private int age;
          
        public Student(String name, int age){
        this.name = name;
        this.age = age;    
    }
    public void introduce() {
        System.out.println("Привет,я " + name + ",мне " + age + "лет");
    }   
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";

    }
    
    public static void main(String[] args) {
        Student student = new Student("Анна",22);
        System.out.println(student.toString());
        System.out.println(student.hashCode());
        student.introduce();      
    }        
    }
}

collection


        

