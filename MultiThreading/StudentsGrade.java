import java.util.InputMismatchException;

public class StudentsGrade {

    public static void calculateGrade(Integer marks)
    {
        if(marks<0)
        {
            throw new IllegalArgumentException("marks cannot be negative");
        }
        try {
            
        } catch(InputMismatchException e){e.printStackTrace();}

    }
    public static void main(String[] args) {
        
        calculateGrade(null);

    }
}
