import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {

        String csvFilePath = "foreign_names.csv";
        List<Person> persons = new ArrayList<>();
        List<Subdivision> subdivisionList = new ArrayList<>();
        try (InputStream in = main.class.getClassLoader().getResourceAsStream(csvFilePath);
             CSVReader reader = in == null ? null : new CSVReaderBuilder(new InputStreamReader(in)).withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build()) {
            if (reader == null) {
                throw new FileNotFoundException(csvFilePath);
            }
            reader.readNext();
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                persons.add(new Person(nextLine, subdivisionList));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }

    }
}
