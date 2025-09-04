class Solution {
    public int findClosest(int x, int y, int z) {
        if (x == y && y == z) return 0;
        if (x == z) return 1;
        if (y == z) return 2;
        if (x < y) {
            if (z < x && z < y) {
                return 1;
            } else if (z > x && z > y) {
                return 2;
            } else {
                if (z - x < y - z) {
                    return 1;   
                } else if (z -x > y - z) {
                    return 2;
                } else {
                    return 0;
                }
            }
        } else if (x > y) {
            if (z < x && z < y) {
                return 2;
            } else if (z > x && z > y) {
                return 1;
            } else {
                if (z - y < x - z) {
                    return 2;   
                } else if (z - y > x - z) {
                    return 1;
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }
    }
}
