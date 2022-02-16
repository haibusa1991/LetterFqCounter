
import java.util.Set;
import java.util.TreeSet;

public class Config {
    public static final String INPUT_FILE_NAME = "text.txt";
    public static final String OUTPUT_FILE_NAME = "output.txt";


    public static final Set<Character> validLetters = new TreeSet<>() {{
        add('а');
        add('б');
        add('в');
        add('г');
        add('д');
        add('е');
        add('ж');
        add('з');
        add('и');
        add('й');
        add('к');
        add('л');
        add('м');
        add('н');
        add('о');
        add('п');
        add('р');
        add('с');
        add('т');
        add('у');
        add('ф');
        add('х');
        add('ч');
        add('ц');
        add('ш');
        add('щ');
        add('ъ');
        add('ь');
        add('ю');
        add('я');
    }};
}
