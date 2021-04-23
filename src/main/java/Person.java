import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Person {
    private long id;
    private String name;
    private String gender;
    private Date birthDate;
    private Subdivision subdivision;
    private int salary;

    public Person(String[] strings, List<Subdivision> subdivisionList) {
        id = Long.parseLong(strings[0]);
        name = strings[1];
        gender = strings[2];
        try {
            birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(strings[3]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String subdivisionName = strings[4];
        subdivision = null;
        for (var subdivisionElement : subdivisionList) {
            if (subdivisionElement.getName().equals(subdivisionName)) {
                subdivision = subdivisionElement;
                break;
            }
        }
        if (subdivision == null) {
            subdivision = new Subdivision(id, subdivisionName);
            subdivisionList.add(subdivision);
        }
        salary = Integer.parseInt(strings[5]);

    }

}
