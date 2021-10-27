/*

ABC     AD
DEF =>  BE
        CF

stringbuilder s
cols = max length of all strings
rows = number of strings
for j in 0 to 2 (cols-1)
  for i in 0 to 1 (rows-1)
    append j,i
  append \n

AD
BE
CF

*/
import java.util.ArrayList;
public class Transpose {
    public String transpose(String input) {
        if (input == null || input == "")
            return "";


        String[] rows = input.split("\n");
        int maxLen = 0;
        for (String row : rows) {
            if (row == null || row == "")
                continue;

            if (row.length() > maxLen)
                maxLen = row.length();
        }

        var grid = new ArrayList<String>();
        for (var row : rows) {
            int addlSpacesNeeded = maxLen - row.length();
            var spaceBuilder = new StringBuilder(row);
            for (int i = 0; i < addlSpacesNeeded; i++)
                spaceBuilder.append(" ");

            grid.add(spaceBuilder.toString());
        }

        StringBuilder sb = new StringBuilder();
        String prefix = "";
        for (int i = 0; i < maxLen; i++) {
            sb.append(prefix);
            prefix = "\n";
            for (int j = 0; j < grid.size(); j++) {
                String s = grid.get(j).toString();
                char c = s.charAt(i);
                sb.append(c);
            }
        }

        System.err.println(input + " transposed is " + sb.toString());
        return sb.toString();
    }

}