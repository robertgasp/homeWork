package Lesson_5;

public class Person {
    protected String fio;
    public String dolzhnost;
    protected String email;
    public String tel;
    public int salary;
    private int age;

    Person (String fio, String dolzhnost, String email, String tel, int salary, int age){
        this.fio=fio;
        this.dolzhnost=dolzhnost;
        this.email=email;
        this.tel=tel;
        this.salary=salary;
        this.age=age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printinfo() {

        System.out.println(this);
    }

    @Override
    public String toString() {
        return  "ФИО:'" + fio + '\'' +
                ", должность:'" + dolzhnost + '\'' +
                ", email:'" + email + '\'' +
                ", телефон:" + tel +
                ", зарплата:" + salary +
                ", возраст:" + age +
                '}';
    }
}
