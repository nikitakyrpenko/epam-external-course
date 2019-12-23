package task3.task3;


import java.util.*;

public class CustomEnum implements Iterable, Comparable{

    private final String data;
    private static Map<String, CustomEnum> map = new HashMap<>();
    private static List<CustomEnum> list = new ArrayList<>();



    private CustomEnum(String data){
        this.data = data;
    }


    public static void init(String... values){
        for (String str: values) {
            CustomEnum customEnum = new CustomEnum(str.toUpperCase());
            map.put(str, customEnum);
            list.add(customEnum);
        }
    }

    public static CustomEnum[] values(){
        CustomEnum[] result = new CustomEnum[list.size()];
        int innerCounter = 0;
        for (CustomEnum customEnum : list)
            result[innerCounter++] = customEnum;
        return result;
    }

    public static CustomEnum valueOf(String name){
       for (CustomEnum customEnum: list)
           if (customEnum.data.equals(name))
               return customEnum;
       return null;
    }

    public  int ordinal(){
        return list.indexOf(this);
    }

    @Override
    public boolean equals(Object obj) {
        CustomEnum c1 = (CustomEnum) obj;
        return this.data.equals(c1.data);
    }

    @Override
    public String toString() {
        return data;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            private int currentPosition = 0;

            @Override
            public boolean hasNext() {
                return currentPosition < list.size();
            }

            @Override
            public Object next() {
                return list.get(currentPosition++);
            }

            @Override
            public void remove() {

            }
        };
    }

    @Override
    public int compareTo(Object o) {
        CustomEnum customEnum = (CustomEnum) o;
        return this.data.compareTo(customEnum.data);
    }
}
