import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Answer {
    private Question question;
    private String answer_sentence;
    ArrayList<String> searching_keywords;
    String year, category, movie, artist;
    String data[] = new String[4];
    Printer pr = new Printer();
    Locale trlocale = new Locale("tr-TR");

    public Answer(Question q, int regex_no)
    {
        this.question = q;
        this.searching_keywords = this.question.get_keywords();
        answer(regex_no);
    }

    private void answer(int regex_no)
    {
        switch (regex_no){
            case 1 :
                category_answer();
                break;
            case 2 :
                movie_answer();
                break;
            case 3 :
                artist_answer();
        }
    }

    private void category_answer(){

        //StringTokenizer token = new StringTokenizer(searching_keywords.get(0)," ");
        this.year = searching_keywords.get(0);
        this.category = searching_keywords.get(1);
        category_search(year, category);

    }

    private void movie_answer(){

        this.movie = searching_keywords.get(0);
        movie_search(movie);

    }

    private void artist_answer(){

        this.artist = searching_keywords.get(0);
        artist_search(artist);

    }

    private void category_search(String year, String category){

        File file = new File("awards.txt");
        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            while (sc.hasNextLine()){
                StringTokenizer token = new StringTokenizer(sc.nextLine(),"?");
                int i = 0;
                while (token.hasMoreTokens()){
                    data[i] = token.nextToken();
                    i++;
                }
                if (data[0].equals(year) && data[1].toLowerCase(trlocale).equalsIgnoreCase(category)){
                    pr.category_print(data);
                    break;
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("veritabanına bir şeyler olmuş !");
        }


    }

    private void movie_search(String movie){

        File file = new File("awards.txt");
        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            while (sc.hasNextLine()){
                StringTokenizer token = new StringTokenizer(sc.nextLine(),"?");
                int i = 0;
                while (token.hasMoreTokens()){
                    data[i] = token.nextToken();
                    i++;
                }
                if (data[2].toLowerCase(trlocale).equalsIgnoreCase(movie)){
                    pr.movie_print(data);
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("veritabanına bir şeyler olmuş !");
        }
    }

    private void artist_search(String artist){

        File file = new File("awards.txt");
        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            while (sc.hasNextLine()){
                StringTokenizer token = new StringTokenizer(sc.nextLine(),"?");
                int i = 0;
                while (token.hasMoreTokens()){
                    data[i] = token.nextToken();
                    i++;
                }
                if (data[3].toLowerCase(trlocale).equalsIgnoreCase(artist)){
                    pr.artist_print(data);
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("veritabanına bir şeyler olmuş !");
        }
    }
}
