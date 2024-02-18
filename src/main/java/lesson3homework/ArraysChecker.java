package lesson3homework;

public class ArraysChecker {
    public <T1, T2> boolean compareArrays(T1[] a1, T2[] a2) {
        if (a1.length != a2.length) {
            return false;
        } else {
            for (int i = 0; i < a1.length; i++) {
                if(!a1[i].equals(a2[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
