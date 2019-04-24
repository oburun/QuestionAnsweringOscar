import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question {
    private String question_sentence;
    private boolean validity = false;
    private int answer_method = 0;
    private ArrayList<String> keywords = new ArrayList<String>();
    int regex_no;

    public Question(String question){
        this.question_sentence = question;
        this.add_keywords();
    }

    private void add_keywords()
    {
        regex_no = 0;

        while(!validity)
        {
            regex_no++;
            File regex_file = new File("src\\Regex\\Regex" + regex_no + ".txt");

            try {
                Scanner sc = new Scanner(new FileInputStream(regex_file));

                String regex;

                while (sc.hasNextLine()) {
                    Pattern question_pattern = Pattern.compile(sc.nextLine(), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
                    Matcher question_matcher = question_pattern.matcher(question_sentence);

                    if (question_matcher.find()) {
                        validity = true;

                        for (int j = 1; j < question_matcher.groupCount() + 1; j++) {
                            keywords.add(question_matcher.group(j));
                        }

                    }
                }
            }
            catch (FileNotFoundException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("Dosya bulunamadı!");
            }
            if (validity){
                break;
            }else if (regex_no == 3){
                System.out.println("GEÇERSİZ CÜMLE !");
                break;
            }
        }
    }

    public ArrayList<String> get_keywords()
    {
        return this.keywords;
    }

    public int get_method()
    {
        return this.answer_method;
    }

    public int get_regex_no() {return regex_no;}

    public boolean get_validity() {return validity;}
}
