import java.util.*;

public class Main {
    public static boolean check = false;
    public static int count = 1;


    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Smirnov", "899212312331");
        phonebook.add("Smirnov", "899831231231");
        phonebook.add("Kotov", "8992123123123");
        phonebook.add("Belousov", "89961231411");
        phonebook.add("Smirnov", "899232131231");
        phonebook.add("Belyaev", "8996123412312");


        phonebook.get("Smirnov");
        phonebook.get("Kotov");
        phonebook.get("Belyaev");



        ArrayList<String> arrayList= new ArrayList<>();
        arrayList.add("Дом");
        arrayList.add("Кот");
        arrayList.add("Машина");
        arrayList.add("Собака");
        arrayList.add("Дом");
        arrayList.add("Дом");
        arrayList.add("Машина");
        arrayList.add("Самолет");
        arrayList.add("Дом");
        arrayList.add("Самолет");
        arrayList.add("Дом");
        arrayList.add("Стол");
        arrayList.add("Стул");
        arrayList.add("Стул");
        arrayList.add("Дом");
        Collections.sort(arrayList);

        for (int i = 1;i < arrayList.size();i++) {
            if (i == 1) {
                System.out.print(arrayList.get(1) + " ");
            }

            if (!arrayList.get(i).equals(arrayList.get(i - 1))) {
                System.out.println(" Встречается " + count + " раз/раза");
                System.out.print(arrayList.get(i));
                check = true;
            }
            if (arrayList.get(i).equals(arrayList.get(i - 1))) {
                check = false;
            }
            if (!check) {
                count = count + 1;
            }
            if (check) {
                count = 1;
                check = false;
            }
            if (i + 1 == arrayList.size()) {
                System.out.println(" Встречается " + count + " раз/раза");
            }
        }

    }

}


