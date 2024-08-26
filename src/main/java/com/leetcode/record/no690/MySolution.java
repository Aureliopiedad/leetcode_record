package com.leetcode.record.no690;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class MySolution {
    /*
    你有一个保存员工信息的数据结构，它包含了员工唯一的 id ，重要度和直系下属的 id 。

    给定一个员工数组 employees，其中：

    employees[i].id 是第 i 个员工的 ID。
    employees[i].importance 是第 i 个员工的重要度。
    employees[i].subordinates 是第 i 名员工的直接下属的 ID 列表。
    给定一个整数 id 表示一个员工的 ID，返回这个员工和他所有下属的重要度的 总和。
     */

    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    /**
     * 这个是时间换空间的做法
     *
     * @param employees
     * @param id
     * @return
     */
    private int getImportance(List<Employee> employees, int id) {
        int result = 0;
        // 首先第一步应该是找到参数employees中对应id的员工
        for (Employee employee : employees) {
            if (employee.id == id) {
                result += employee.importance;
                // 找到这个员工下的员工
                for (Integer subordinate : employee.subordinates) {
                    result += getImportance(employees, subordinate);
                }
            }
        }

        return result;
    }

    /**
     * 空间换时间
     *
     * @param employees
     * @param id
     * @return
     */
    private int getImportanceOther(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeIdAndModel = new HashMap<>(employees.size());
        employees.forEach(employee -> employeeIdAndModel.put(employee.id, employee));

        return dfs(employeeIdAndModel, id);
    }

    private int dfs(Map<Integer, Employee> employeeIdAndModel, int id) {
        Employee employee = employeeIdAndModel.get(id);
        int result = employee.importance;

        for (Integer subordinate : employee.subordinates) {
            result += dfs(employeeIdAndModel, subordinate);
        }

        return result;
    }

    public static void main(String[] args) {
        /*
        输入：employees = [[1,2,[5]],[5,-3,[]]], id = 5
        输出：-3
        解释：员工 5 的重要度为 -3 并且没有直接下属。
        因此，员工 5 的总重要度为 -3。
         */
        Employee employee1 = new Employee();
        employee1.id = 1;
        employee1.importance = 2;
        employee1.subordinates = Collections.singletonList(5);

        Employee employee2 = new Employee();
        employee2.id = 5;
        employee2.importance = -3;
        employee2.subordinates = Collections.emptyList();

        log.info(String.valueOf(new MySolution().getImportance(Arrays.asList(employee1, employee2), 5)));
        log.info(String.valueOf(new MySolution().getImportanceOther(Arrays.asList(employee1, employee2), 5)));

        /*
        输入：employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
        输出：11
        解释：
        员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
         */
        Employee employee3 = new Employee();
        employee3.id = 1;
        employee3.importance = 5;
        employee3.subordinates = Arrays.asList(2, 3);

        Employee employee4 = new Employee();
        employee4.id = 2;
        employee4.importance = 3;
        employee4.subordinates = Collections.emptyList();

        Employee employee5 = new Employee();
        employee5.id = 3;
        employee5.importance = 3;
        employee5.subordinates = Collections.emptyList();

        log.info(String.valueOf(new MySolution().getImportance(Arrays.asList(employee3, employee4, employee5), 1)));
        log.info(String.valueOf(new MySolution().getImportanceOther(Arrays.asList(employee3, employee4, employee5), 1)));
    }
}
