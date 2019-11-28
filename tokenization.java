import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
public class tokenization{
    static String text;
    static String[] wordsArray;
    static String stopWords;

    public static void main(String args[]) throws IOException {
        //reading text
        File file = new File("/home/irina/IdeaProjects/textMining/src/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            text = sb.toString();
        } finally {
            br.close();
        }

        //reading stopwords
        File file2 = new File("/home/irina/IdeaProjects/textMining/src/stopwords.txt");
        BufferedReader br2 = new BufferedReader(new FileReader(file2));
        try {
            StringBuilder sb2 = new StringBuilder();
            String line2 = br2.readLine();

            while (line2 != null) {
                sb2.append(line2);
                sb2.append(System.lineSeparator());
                line2 = br2.readLine();
            }
            stopWords = sb2.toString();
        } finally {
            br2.close();
        }

        //splitting the text
//        StringTokenizer st = new StringTokenizer(text," ");
//        while (st.hasMoreTokens()) {
//            for(int i = 0; i< st.countTokens(); i++) wordsArray[i] = st.nextToken();
//            //System.out.println(st.nextToken());
//        }
        String[] allWords = text.toLowerCase().split(" ");
        StringBuilder builder = new StringBuilder();
        for ( String word : allWords){
            if(!stopWords.contains(word)){
                builder.append(word);
                builder.append(' ');
            }
        }
        String result = builder.toString().trim();

        System.out.println(result);
        //System.out.println(wordsArray);
        // printing next token
        //System.out.println("Next token is : " + st.nextToken(","));
    }


}