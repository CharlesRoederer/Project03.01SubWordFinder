import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SubWordFinder implements WordFinder    {
    private ArrayList<ArrayList<String>> dictionary;
    private String alpha = "abcdefghijklmnopqrstuvwxyz";

    public SubWordFinder()  {
        dictionary = new ArrayList<>();
        for(int i = 0; i < 26; i++)
            dictionary.add(new ArrayList<String>());
        populateDictionary();
    }

    @Override
    public void populateDictionary() {
        String file1="";
        for(int j=0; j<3;j++) {
            try {
                Scanner in = new Scanner(new File("all_subwords.txt"));
                while (in.hasNext()) {
                    String word = in.nextLine();
                    int index = alpha.indexOf(word.substring(0, 1));
                    dictionary.get(index).add(word);
                }
                in.close();
                for (int i = 0; i < dictionary.size(); i++)
                    Collections.sort(dictionary.get(i));


            } catch (Exception e) {
                System.out.println("Error here: " + e);
            }
        }
    }

    @Override
    public ArrayList<SubWord> getSubWords() {
        return null;
    }

    @Override
    public boolean inDictionary(String word) {
        return Collections.binarySearch(dictionary.get(alpha.indexOf(word.substring(0,1))), word) >= 0;
    }

    class BinarySearch
    {
        // Returns index of x if it is present in arr[l..
        // r], else return -1
        int binarySearch(ArrayList<String> arr, String l, String r, String x)
        {
            if (r.compareToIgnoreCase(l) >=0)
            {
                int mid = l + (r.replace(l, )) / 2;

                // If the element is present at the
                // middle itself
                if (arr.get(mid).equals(x))
                    return mid;

                // If element is smaller than mid, then
                // it can only be present in left subarray
                if (arr.get(mid).compareToIgnoreCase(x) > 0)
                    return binarySearch(arr, l, mid - 1, x);

                // Else the element can only be present
                // in right subarray
                return binarySearch(arr, mid + 1, r, x);
            }

            // We reach here when element is not present
            // in array
            return -1;
        }
    /**
     * Populates the dictionary from the text file contents
     * The dictionary object should contain 26 buckets, each
     * bucket filled with an ArrayList<String>
     * The String objects in the buckets are sorted A-Z because
     * of the nature of the text file words.txt
     */
    //@Override
    public void populateDictionary() {
        try{
            Scanner in =new Scanner(new File("SCRABBLE_WORDS (1).txt"));
            while(in.hasNext()){
                String word=in.nextLine();
                int index=alpha.indexOf(word.substring(0,1));
                dictionary.get(index).add(word);
            }
            in.close();
            for (int i=0; i<dictionary.size(); i++)
                Collections.sort(dictionary.get(i));


        }
        catch(Exception e) {
            System.out.println("Error here: "+ e);
        }
    }


    /**
     * Retrieve all SubWord objects from the dictionary.
     * A SubWord is defined as a word that can be split into two
     * words that are also found in the dictionary.  The words
     * MUST be split evenly, e.g. no unused characters.
     * For example, "baseball" is a SubWord because it contains
     * "base" and "ball" (no unused characters)
     * To do this, you must look through every word in the dictionary
     * to see if it is a SubWord object
     *
     * @return An ArrayList containing the SubWord objects
     * pulled from the file words.txt
     */


    /**
     * Look through the entire dictionary object to see if
     * word exists in dictionary
     *
     * @param word The item to be searched for in dictionary
     * @return true if word is in dictionary, false otherwise
     * NOTE: EFFICIENCY O(log N) vs O(N) IS A BIG DEAL HERE!!!
     * You MAY NOT use Collections.binarySearch() here; you must use
     * YOUR OWN DEFINITION of a binary search in order to receive
     * the credit as specified on the grading rubric.
     */


    }
}