import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
};

public class EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {
        // find the first employee
        return getTotalImportanceDfsHelper(employees, getEmployeeById(employees, id), 0);
    }

    // Lets just do a DFS and calculate the total importance
    public int getTotalImportanceDfsHelper(List<Employee> emps, Employee current, int total) {
        if (current.subordinates == null) {
            return total;
        }
        total = total + current.importance;
        // We do for all the subordinates of a current
        for (int id : current.subordinates) {
            Employee curr = getEmployeeById(emps, id);
            total = getTotalImportanceDfsHelper(emps, curr, total);
        }

        return total;
    }

    public Employee getEmployeeById(List<Employee> employees, int id) {
        Employee emp = null;
        for (Employee currEmp : employees) {
            if (currEmp.id == id) {
                emp = currEmp;
                break;
            }
        }
        return emp;
    }

    public static void main(String[] args) {
        EmployeeImportance obj = new EmployeeImportance();
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee(1, 5, new ArrayList<>(Arrays.asList(2, 3)));
        Employee e2 = new Employee(2, 3, new ArrayList<>());
        Employee e3 = new Employee(3, 3, new ArrayList<>());
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        int id = 1;
        System.out.println(obj.getImportance(employees, id));
    }

}
