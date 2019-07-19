package csvGenerator;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvGenerator {
    public static void main(String[] args)
    {

        // name of generated csv
        final String CSV_LOCATION = "Employees.csv ";

        try {

            // Creating writer class to generate
            // csv file
            FileWriter writer = new
                    FileWriter(CSV_LOCATION);

            // create a list of employee
            List<Object> EmployeeList = new
                    ArrayList<>();
            Employee emp1 = new Employee
                    ("Mahafuj", "24", "HTc", "75000");
            Employee emp2 = new Employee

                    ("Aman", "24", "microsoft", "79000");
            Employee emp3 = new Employee
                    ("Suvradip", "26", "tcs", "39000");
            Employee emp4 = new Employee
                    ("Riya", "22", "NgGear", "15000");
            Employee emp5 = new Employee
                    ("Prakash", "29", "Sath", "51000");
            EmployeeList.add(emp1);
            EmployeeList.add(emp2);
            EmployeeList.add(emp3);
            EmployeeList.add(emp4);
            EmployeeList.add(emp5);
            List<Object> list = Arrays.asList("1,2", "3", "4");

            // Createing StatefulBeanToCsv object
            StatefulBeanToCsv beanWriter=
                    new StatefulBeanToCsvBuilder(writer).build();

            // Write list to StatefulBeanToCsv object
            beanWriter.write(list);

            // closing the writer object
            writer.close();

            CSVWriter csvWriter = new CSVWriter(new FileWriter("yourfile.csv"), '\t');
            // feed in your array (or convert your data to an array)
            String[] entries = "first#second#third".split("#");
            csvWriter.writeNext(entries);
            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
