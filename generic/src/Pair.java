public class Pair<Type> {
    Type first;
    Type second;

    public Pair(Type first, Type second) {
        this.first = first;
        this.second = second;
    }
    public Type getFirst() {
        return first;
    }

    public Type getSeconType() {
        return second;
    }
    public void setFirst(Type first) {
        this.first = first;
    }
    public void setSecond(Type second) {
        this.second = second;
    }
}
