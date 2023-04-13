public class PairTwo<Type1,Type2> {
    Type1 first;
    Type2 second;

    public PairTwo(Type1 first, Type2 second) {
        this.first = first;
        this.second = second;
    }
    public Type1 getFirst() {
        return first;
    }

    public Type2 getSeconType() {
        return second;
    }
}
