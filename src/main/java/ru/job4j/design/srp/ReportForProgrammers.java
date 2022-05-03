package ru.job4j.design.srp;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportForProgrammers implements Report {
    private Store store;

    public ReportForProgrammers(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        String ls = System.lineSeparator();
        text.append("<html>").append(ls).append("<head>").append(ls).append("<title>")
                .append(ls).append("Report for Programmers").append(ls)
                .append("</title>").append(ls).append("</head>").append(ls).append("<body>")
                .append(ls).append("<h3>").append(ls)
                .append("Name; Hired; Fired; Salary;")
                .append(ls).append("</h3>")
                .append(ls).append("<h4>").append(ls);
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(ls);
        }
        text.append("</h4>").append(ls).append("</body>")
                .append(ls).append("</html>");
        return text.toString();
    }

    public static void main(String[] args) {
        MemStore ms = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        ms.add(worker);
        ReportForProgrammers reportForProgrammers = new ReportForProgrammers(ms);
        System.out.println(reportForProgrammers.generate(e -> true));
    }
}
