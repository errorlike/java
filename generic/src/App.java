public class App {
    public static void main(String[] args) throws Exception {
        Person person = new Person("first", "second");
        Person[] persons = { person };
        // Pair<String> pairs = new Pair<>(null, null);
        System.out.println(hasEqualElement(persons, person));
        // static checked
        // System.out.println(hasEqualElement(pairs, person));
        Integer[] array = { 1, 2, 3, 4, 5 };
        System.out.println(max(array));
        DynamicArray<Integer> ints = new DynamicArray<>();
        DynamicArray<? extends Number> numbers = ints;
        // Integer i1 = 1;
        // numbers.add(i1);
        // numbers.add((Number)i1);
    }

    public static <T> boolean hasEqualElement(T[] array, T element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public static <T extends Comparable<T>> T max(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }

    static void setSame(Pair<? super Integer> p, Integer n) {
        p.setFirst(n);
        p.setSecond(n);
        // Number n1 = p.getFirst();
        // Integer i1 = p.getFirst();
    }
}
