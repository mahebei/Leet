package no001_100;

public class No069 {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        if (x < 4)
            return 1;
        long l = 0, r = x / 2 + 1, m = (l + r) / 2;
        while (l < r) {
            if (m * m <= x && (m + 1) * (m + 1) > x)
                return (int) m;
            if (m * m < x)
                l = m + 1;
            if (m * m > x)
                r = m;
            m = (l + r) / 2;
        }
        return (int) m;

    }
}