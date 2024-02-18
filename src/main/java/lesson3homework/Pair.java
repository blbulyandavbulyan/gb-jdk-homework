package lesson3homework;

public class Pair <FIRST, SECOND> {
    private final FIRST first;
    private final SECOND second;

    public Pair(FIRST first, SECOND second) {
        this.first = first;
        this.second = second;
    }

    public FIRST getFirst() {
        return first;
    }

    public SECOND getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair{first=%s, second=%s}".formatted(first, second);
    }
}
