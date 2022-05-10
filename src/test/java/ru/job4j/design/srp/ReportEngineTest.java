package ru.job4j.design.srp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static ru.job4j.design.srp.ReportForAccounting.BILLING_PERIOD;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }


    @Test
    public void whenGeneratedForProgrammers() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportForProgrammers(store);
        String ls = System.lineSeparator();
        StringBuilder expect = new StringBuilder()
                .append("<html>").append(ls)
                .append("<head>").append(ls)
                .append("<title>").append(ls)
                .append("Report for Programmers").append(ls)
                .append("</title>").append(ls)
                .append("</head>").append(ls)
                .append("<body>").append(ls)
                .append("<h3>").append(ls)
                .append("Name; Hired; Fired; Salary;").append(ls)
                .append("</h3>").append(ls)
                .append("<h4>").append(ls)
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";").append(ls)
                .append("</h4>").append(ls)
                .append("</body>").append(ls)
                .append("</html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedForAccounting() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportForAccounting(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() * BILLING_PERIOD).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedForHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", 100);
        Employee worker2 = new Employee("Petr", 300);
        Employee worker3 = new Employee("Andrey", 200);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportForHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        formatter.format(now.getTime());
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportXML(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>").append("\n")
                .append("<employees>").append("\n")
                .append("    ").append("<employee name=\"").append(worker.getName()).append("\" salary=\"")
                .append(worker.getSalary()).append("\">").append("\n")
                .append("        ").append("<hired>").append(formatter.format(worker.getHired().getTime())).append("</hired>").append("\n")
                .append("        ").append("<fired>").append(formatter.format(worker.getFired().getTime())).append("</fired>").append("\n")
                .append("    ").append("</employee>").append("\n")
                .append("</employees>").append("\n");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedJSON() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportJSON(store);
        var expect = String.format("[{\"name\":\"%s\",\"hired\":{\"year\":%d,\"month"
                        + "\":%d,\"dayOfMonth\":%d,\"hourOfDay\":%d,\"minute\":%d,\"second\":%d},\"fired\":"
                        + "{\"year\":%d,\"month\":%d,\"dayOfMonth\":%d,\"hourOfDay\":%d,\"minute\":%d"
                        + ",\"second\":%d},\"salary\":%s}]",
                worker.getName(), worker.getHired().get(Calendar.YEAR), worker.getHired().get(Calendar.MONTH),
                worker.getHired().get(Calendar.DATE), worker.getHired().get(Calendar.HOUR),
                worker.getHired().get(Calendar.MINUTE), worker.getHired().get(Calendar.SECOND),
                worker.getHired().get(Calendar.YEAR), worker.getHired().get(Calendar.MONTH),
                worker.getHired().get(Calendar.DATE), worker.getHired().get(Calendar.HOUR),
                worker.getHired().get(Calendar.MINUTE), worker.getHired().get(Calendar.SECOND), worker.getSalary());
        assertThat(engine.generate(em -> true), is(expect));
    }
}