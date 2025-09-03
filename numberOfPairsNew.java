import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;

class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (left, right) -> {
            var cmp = Integer.compare(right[1], left[1]);
            if (cmp != 0) return cmp;
            return Integer.compare(left[0], right[0]);
        });

        var res = 0;
        for (int i = 0; i < points.length - 1; i++) {
            var pax = points[i][0];

            var skipWhilePbxGeq = Integer.MAX_VALUE;
            for (int j = i + 1; j < points.length; j++) {
                var pbx = points[j][0];

                if (pax <= pbx && pbx < skipWhilePbxGeq) {
                    res++;
                    skipWhilePbxGeq = pbx;
                }
            }
        }

        return res;
    }

    @SuppressWarnings({"DuplicatedCode", "unused"})
    static int minOf(int... is) {
        if (is.length == 0) {
            throw new IllegalArgumentException();
        }

        var res = Integer.MAX_VALUE;
        for (int i : is) {
            res = Math.min(res, i);
        }
        return res;
    }

    @SuppressWarnings({"DuplicatedCode", "unused"})
    static int maxOf(int... is) {
        if (is.length == 0) {
            throw new IllegalArgumentException();
        }

        var res = Integer.MIN_VALUE;
        for (int i : is) {
            res = Math.max(res, i);
        }
        return res;
    }

    @SuppressWarnings({"DuplicatedCode", "unused"})
    static long minOf(long... is) {
        if (is.length == 0) {
            throw new IllegalArgumentException();
        }

        var res = Long.MAX_VALUE;
        for (long i : is) {
            res = Math.min(res, i);
        }
        return res;
    }

    @SuppressWarnings({"DuplicatedCode", "unused"})
    static long maxOf(long... is) {
        if (is.length == 0) {
            throw new IllegalArgumentException();
        }

        var res = Long.MIN_VALUE;
        for (long i : is) {
            res = Math.max(res, i);
        }
        return res;
    }

    @SuppressWarnings({"DuplicatedCode", "unused"})
    static <T> ExtendedArrayList<T> fillList(int n, Supplier<T> supplier) {
        return fillList(n, ignore -> supplier.get());
    }

    @SuppressWarnings({"DuplicatedCode", "unused"})
    static <T> ExtendedArrayList<T> fillList(int n, IntFunction<T> valueAt) {
        var res = new ExtendedArrayList<T>(n);
        for (int i = 0; i < n; i++) {
            res.add(valueAt.apply(i));
        }

        return res;
    }

    @SuppressWarnings({"DuplicatedCode", "unused"})
    static <T> T[] fillArray(int n, Class<T> clazz, Supplier<T> supplier) {
        return fillArray(n, clazz, ignore -> supplier.get());
    }

    @SuppressWarnings({"DuplicatedCode", "unused"})
    static <T> T[] fillArray(int n, Class<T> clazz, IntFunction<T> valueAt) {
        @SuppressWarnings("unchecked") var res = (T[]) Array.newInstance(clazz, n);

        for (int i = 0; i < n; i++) {
            res[i] = valueAt.apply(i);
        }

        return res;
    }

    @SuppressWarnings({"DuplicatedCode", "unused", "SameParameterValue"})
    static <T> T[] fillArray(int n, T value) {
        @SuppressWarnings("unchecked") var res = (T[]) Array.newInstance(value.getClass(), n);
        Arrays.fill(res, value);
        return res;
    }

    @SuppressWarnings({"DuplicatedCode", "unused"})
    static int[] fillIntArray(int n, IntUnaryOperator valueAt) {
        var res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = valueAt.applyAsInt(i);
        }
        return res;
    }

    @SuppressWarnings({"DuplicatedCode", "unused"})
    static int[] fillIntArray(int n, int value) {
        var res = new int[n];
        Arrays.fill(res, value);
        return res;
    }

    @SuppressWarnings({"DuplicatedCode", "unused"})
    static long[] fillLongArray(int n, IntToLongFunction valueAt) {
        var res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = valueAt.applyAsLong(i);
        }
        return res;
    }

    @SuppressWarnings({"DuplicatedCode", "unused"})
    static long[] fillLongArray(int n, long value) {
        var res = new long[n];
        Arrays.fill(res, value);
        return res;
    }

    @SuppressWarnings({"DuplicatedCode", "unused"})
    static long gcd(long a, long b) {
        while (b != 0) {
            var bb = a % b;
            a = b;
            b = bb;
        }

        return a;
    }

    @SuppressWarnings({"DuplicatedCode", "unused"})
    static int gcd(int a, int b) {
        while (b != 0) {
            var bb = a % b;
            a = b;
            b = bb;
        }

        return a;
    }

    @SuppressWarnings({"DuplicatedCode", "unused", "UnusedReturnValue"})
    static class ExtendedArrayList<T> extends ArrayList<T> {
        public ExtendedArrayList(int initialCapacity) {
            super(initialCapacity);
        }

        public ExtendedArrayList() {

        }

        public ExtendedArrayList(Collection<? extends T> c) {
            super(c);
        }

        T getFromEnd(int offset) {
            return get(size() - offset - 1);
        }

        T getFst() {
            return get(0);
        }

        T getLst() {
            return getFromEnd(0);
        }

        T removeLst() {
            return remove(size() - 1);
        }
    }
}
