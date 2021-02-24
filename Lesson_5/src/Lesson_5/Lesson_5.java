package Lesson_5;

public class Lesson_5 {

    public static void main(String[] args) {

        Person []arrPers = new Person[5];

        arrPers[0]=new Person("Петров Иван","инженер","petrov@mail.ru","89115553322", 125000, 33);
        arrPers[1]=new Person("Иванов Петр","инженер-проектировщик","ivanov@mail.ru","89251112233",150000,37);
        arrPers[2]=new Person("Сидоров Василий","главный инженер","sidorov@mail.ru", "892744455566", 350000,56);
        arrPers[3]=new Person("Спиридонов Игорь","зам. главного инженера","spiridonov@mail.ru","89412257895", 270000,50);
        arrPers[4]=new Person("Веселова Ирина","секретарша","veselova@mail.ru", "89214475689",100000,34);

        for (int i=0;i<=4;i++){
            if (arrPers[i].getAge()>40){
                arrPers[i].printinfo();
            }
        }
    }
}
