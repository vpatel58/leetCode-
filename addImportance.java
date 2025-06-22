/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer, Employee> map;
    int total = 0;
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) return 0;
        map = new HashMap<>();

        for (Employee e : employees) {
            map.put(e.id, e);
        }
        dfs(id);
        return total;
    }

    private void dfs(int id) {
        
        //logic
        Employee emp = map.get(id);
        if (emp != null) {
            total += emp.importance;
            for (int sub : emp.subordinates) {
                dfs(sub);
            }
        }
        
    }
}
