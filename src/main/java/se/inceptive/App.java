package se.inceptive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) {
        // inlämning 5 CounterString program / done
        System.out.println("Den magiska strängen! ");
        boolean loop = true;
        int Strcount = 0, length;
        String getline = "";
        ArrayList<String> gotit = new ArrayList<String>();
        do { // försök ta in rätt input

            System.out.print("Ge mig ditt önskade nummer: ");
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            try {
                getline = input.readLine();
                Strcount = Integer.parseInt(getline);
                loop = false;

            } catch (Exception e) {
                System.out.println("Vad du gav är konstig, försök igen med ett nummer");
            }
        } while (loop);
        if (Strcount<=-1)
        {
            System.out.println("Det gärller ett hel tal större än 1.");
        }
        else if (Strcount < 2 && Strcount > -1) {
            System.out.println(getline);
        } else {

            getline = getline + "*";
            gotit.add(getline);
            length = getLongestLineLength(gotit); // att räkna att placera *

            while (length < Strcount) {
                getline = getline + String.valueOf(Strcount - length) + "*";
                gotit.clear();
                gotit.add(getline);
                length = getLongestLineLength(gotit);
                if (length > Strcount) {
                    getline = getline.substring(0, Strcount);
                    gotit.clear();
                    gotit.add(getline);
                }
            }
            gotit = split(getline, "*");


            if (Strcount % 2 != 0) {
                getline = "*";
                for (int rev = gotit.size() - 1; rev > 0; rev--) {
                    getline = getline + gotit.get(rev) + "*";
                }

            } else {
                getline = "";
                for (int rev = gotit.size() - 1; rev > 0; rev--) {
                    getline = getline + gotit.get(rev) + "*";
                }
            }
            getline = getline + gotit.get(0);
            System.out.println(getline);

        }//slut else



    }

    // Inlämning 1 RepeatChar / done
    public static String repeatChar(char b, int nr) {
        String total = "";
        while (nr > 0) {
            total = total + b;
            nr--;
        }
        return total;
    }

    // Inlämning 2 getLongestLineLengh / done
    public static int getLongestLineLength(ArrayList<String> input) {
        int count = 0;
        for (String item : input) {
            if (count <= item.length()) {
                count = item.length();
            } else {
                return count;
            }
        }
        return count;

    }

    // Inlämning 3 indexMenu / done
    public static String indexMenu(ArrayList<String> input) {
        String slut = "";
        int nr = 1;
        for (String item : input) {
            StringBuilder add = new StringBuilder(nr + ". ");
            add.append(item + "\n");
            slut = slut + add;
            nr++;
        }
        return slut;

    }

    // Inlämning 4 split / done
    public static ArrayList<String> split(String str1, String rad) {
        ArrayList<String> nylist = new ArrayList<String>();
        StringTokenizer splited = new StringTokenizer(str1, rad);
        while (splited.hasMoreTokens()) {
            nylist.add(splited.nextToken());
        }
        return nylist;


    }
}
