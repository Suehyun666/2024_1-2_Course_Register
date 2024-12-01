package constants;
import java.util.Locale;
import java.util.ResourceBundle;

public class CourseRegistration {
    public static void main(String[] args) {
        Locale locale = new Locale("ko", "KR"); // 한국어 설정
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        System.out.println(bundle.getString("course_added"));
    }
}