import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
public class VowelsMatcher {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String vowel;
        String sentence;
        int count = 0;      
        List<Integer> countList = new ArrayList<>();
        
        while ((vowel = br.readLine()) != null) {
            if (vowel.length() == 0) {
                break;}
            
            sentence = br.readLine();
        
            Set<Character> setVogais = new HashSet<>();
            for (char ch : vowel.toCharArray()) {
            	setVogais.add(ch);
            }
        
            for (char ch : sentence.replaceAll("\\s", "").toCharArray()) {
            	if(setVogais.contains(ch)) count ++;
            }
            
        countList.add(count);
        count = 0;
        
        
        }
        countList.forEach(System.out::println);
    }
}