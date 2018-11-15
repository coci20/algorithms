/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    Map<Integer, Employee> eMap = new HashMap<Integer, Employee>();
    public int setImportance(List<Employee> employees, Employee e) {
        int val = e.importance;
        for (int i = 0; i < e.subordinates.size(); i++) {
            //get next sub id
            Employee nextEmployee = eMap.get(e.subordinates.get(i));
            val += setImportance(employees, nextEmployee);
        }
        e.importance = val;
        return val;
    }
    public int getImportance(List<Employee> employees, int id) {
        int val = 0;
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            eMap.put(e.id, e);
        }
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            if (e.id == id) {
                val = setImportance(employees, e);
            }
        }
        return val;
    }
}
