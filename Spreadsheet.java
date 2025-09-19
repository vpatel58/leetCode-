class Spreadsheet {
    HashMap<Integer, HashMap<Character, Integer>> map;

    public boolean isInteger(String str) {
        if (str == null || str.isEmpty()) return false;
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        } 
        return true;
    }

    public Spreadsheet(int rows) {
        map = new HashMap<>();
        for (int i = 1; i <= rows; i++) {
            map.put(i, new HashMap<>());
        }
        for (int i = 1; i <= rows; i++) {
            HashMap<Character, Integer> hmap = map.get(i);
            for (char ch = 'A'; ch <= 'z'; ch++) {
                hmap.put(ch, 0);
            }
        }
    }
    
    public void setCell(String cell, int value) {
        int row = Integer.parseInt(cell.substring(1));
        HashMap<Character, Integer> hmap = map.get(row);
        hmap.put(cell.charAt(0), value);       
    }
    
    public void resetCell(String cell) {
        int row = Integer.parseInt(cell.substring(1));
        HashMap<Character, Integer> hmap = map.get(row);
        hmap.put(cell.charAt(0), 0);
    }
    
    public int getValue(String formula) {
        String x = "";
        String y = "";
        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '+') {
                x = formula.substring(1, i);
                y = formula.substring(i + 1);
            }
        }
        int a = 0;
        int b = 0;
        if (isInteger(x)) {
            a = Integer.parseInt(x);
        } else {
            int row = Integer.parseInt(x.substring(1));
            HashMap<Character, Integer> hmap = map.get(row);
            a = hmap.get(x.charAt(0));
        }
        if (isInteger(y)) {
            b = Integer.parseInt(y);
        } else {
            int row = Integer.parseInt(y.substring(1));
            HashMap<Character, Integer> hmap = map.get(row);
            b = hmap.get(y.charAt(0));
        }
        return a + b;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
