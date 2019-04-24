import java.util.Scanner;

public class main {

    public static void main(String[] args)
    {
        //Hoşgeldin ekranını göster.
        welcome();

        while(true)
        {
            Question q = new Question(ask());
            if (q.get_validity()){
                Answer a = new Answer(q, q.get_regex_no());
            }
            if (cont().equalsIgnoreCase("Q")){
                break;
            }
        }
    }

    public static void welcome()
    {
        System.out.println("Oscar Sorgulama Sistemi'ne hoşgeldiniz.");
    }

    public static String ask()
    {
        System.out.println("Sorunuzu yazın:");

        Scanner read = new Scanner(System.in);
        String question = read.nextLine();

        return question;
    }

    private static String cont()
    {
        System.out.println("Tekrar sormak için herhangi bir tuşa, Çıkmak için Q'ya basınız ! ");
        Scanner input = new Scanner(System.in);
        String stop = input.nextLine();
        return stop;
    }
}
