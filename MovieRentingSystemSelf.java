class MovieRentingSystem {
    HashMap<Integer, TreeSet<int[]>> map;
    TreeSet<int[]> rented;
    HashMap<String, Integer> priceMap;
    public MovieRentingSystem(int n, int[][] entries) {
        map = new HashMap<>();
        priceMap = new HashMap<>();
        rented = new TreeSet<>((a, b) -> {
            if (a[2] == b[2] && a[0] == b[0]) return a[1] - b[1];
            if (a[2] == b[2]) return a[0] - b[0];
            return a[2] - b[2];
        });
        for (int[] entry : entries) {
            int shop = entry[0];
            int movie = entry[1];
            int price = entry[2];

            if (!map.containsKey(movie)) {
                map.put(movie, new TreeSet<>((a, b) -> {
                    if (a[1] == b[1]) return a[0] - b[0];
                    return a[1] - b[1];
                }));
            }
            map.get(movie).add(new int[] {shop, price});
            String key = shop + "*" + movie;
            priceMap.putIfAbsent(key, price);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>();
        if (map.containsKey(movie)) {
            int count = 0;
            for (int[] arr : map.get(movie)) {
                if (count == 5) break;
                ans.add(arr[0]);
                count++;
            }
        }
        return ans;
    }
    
    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "*" + movie);
        map.get(movie).remove(new int[] {shop, price});
        rented.add(new int[] {shop, movie, price});
    }
    
    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "*" + movie);
        map.get(movie).add(new int[] {shop, price});
        rented.remove(new int[] {shop, movie, price});
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        for (int[] arr : rented) {
            if (count == 5) break;
            result.add(Arrays.asList(arr[0], arr[1]));
            count++;
        }
        return result;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */
