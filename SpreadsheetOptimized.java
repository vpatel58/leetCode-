class Spreadsheet {
    HashMap<String, Integer> map;

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
    }
    
    public void setCell(String cell, int value) {
        map.put(cell, value);       
    }
    
    public void resetCell(String cell) {
        map.put(cell, 0);
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
            a = map.getOrDefault(x, 0);
        }
        if (isInteger(y)) {
            b = Integer.parseInt(y);
        } else {
            b = map.getOrDefault(y, 0);
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
