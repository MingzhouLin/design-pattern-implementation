package csvGenerator;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

@Data
public class Employee {
    public String Name;
    public String Age;
    public String Company;
    public String Salary;

    public Employee(String name, String age,
                    String company, String salary) {
        super();
        Name = name;
        Age = age;
        Company = company;
        Salary = salary;
    }

    @Override
    public String toString() {
        List<String> list = new LinkedList<>();
        for (Field field :
                this.getClass().getDeclaredFields()) {
            list.add(field.getName());
        }
        return String.join(",", list);
    }
}
