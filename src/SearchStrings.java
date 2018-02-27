import java.util.ArrayList;
import java.util.Arrays;

public class SearchStrings {

    static int countType1 = 0;
    static int countType2 = 0;
    static int countType3 = 0;
    char[] c = {'A', 'G', 'C', 'T'};
    public int type1(String s, String l){
        if(l.length() >= s.length()){
            if(l.contains(s)){
                type1(s,l.substring(s.length()-1));
                countType1++;
            }else return countType1;
        }
        return countType1;
    }

    public int type2(String s, String l, ArrayList<Character> sToList){

        //Create an Array out of the first string parameter
        for(int i = 0; i < sToList.size(); i++){
            char temp = sToList.get(i);
            String smallerString = deleteOneChar(sToList,i);
            countType2 = goThroughString(smallerString,l, countType2);
            sToList.add(i, temp);
        }
        return countType2;
    }
    public String deleteOneChar(ArrayList sToList, int index){
            sToList.remove(index);
            String str = sToList.toString();
            str = str.replaceAll(", " , " ").replaceAll(" ", "").replaceAll("\\[" , "").replaceAll("\\]","" );
            return str;
    }

    public int goThroughString(String s, String l, int countType){

        //check if string l starts with l
        if(l.length() >= s.length()) {
            if (l.startsWith(s)) {
                countType++;
                System.out.println("L starts with s-string: " + s + " l-String: " + l);
                goThroughString(s, l.substring(s.length()), countType);
            } else {
                goThroughString(s, l.substring(1), countType);
            }
        }
       return countType;
    }

    public int type3(String s, String l, ArrayList<Character> sToList){
        for(int i = 0; i < sToList.size(); i++){
            for(int j = 0; j < c.length; j++){
                String biggerString = addOneChar(sToList, i, c[j]);
                countType3 = goThroughString(biggerString, l, countType3);
            }
        }
        return countType3;
    }
    public String addOneChar(ArrayList sToList, int index, char temp){
        sToList.add(index, temp);
        String str = sToList.toString();
        str = str.replaceAll(", " , " ").replaceAll(" ", "").replaceAll("\\[" , "").replaceAll("\\]","" );
        return str;
    }
    public ArrayList<Character> convertString(String s){
        char[] sToArray = s.toCharArray();
        System.out.println(sToArray);
        //Create an ArrayList out of the Array of characters
        ArrayList<Character> sToList = new ArrayList<Character>();
        for(int i = 0; i < sToArray.length;i++){
            sToList.add(sToArray[i]);
        }
        return sToList;
    }

    public static void main(String[] args){

        SearchStrings program = new SearchStrings();
        String s1 = "AGCT";
        String s2 = "AGCTAGCT";
        System.out.print(program.type1(s1, s2)+" ");
        System.out.print(program.type2(s1, s2, program.convertString(s1))+" ");
        //System.out.println(program.type3(s1, s2, program.convertString(s1))+" ");


    }


}
