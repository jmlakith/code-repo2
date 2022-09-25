package hackeranktest;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'contacts' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_STRING_ARRAY queries as parameter.
     */

    public static List<Integer> contacts(List<List<String>> queries) {

        List<Integer> output = new ArrayList<>();
        Map<String,Integer> nameMap = new HashMap<>();

        for(List<String> query : queries){
            if(query.get(0).equals("add")){
                // Trie.insert(query.get(1));
                String [] nameStr = query.get(1).split("");
                StringBuilder stringBuilder = new StringBuilder();
                for(String letter : nameStr){
                    String merge = stringBuilder.append(letter).toString();
                    if(nameMap.containsKey(merge)){
                        nameMap.put(merge, nameMap.get(merge)+1);
                        // nameMap.get(merge).add(query.get(1));
                    }else{
                        // List<String> newList = new ArrayList<>();
                        // newList.add(query.get(1));
                        nameMap.put(merge, 1);
                    }
                }
            }else if (query.get(0).equals("find")){
                //if(Trie.search(query.get(1))){
                if(nameMap.containsKey(query.get(1))){
                    output.add(nameMap.get(query.get(1)));
                }else{
                    output.add(0);
                }
                // output.add(Trie.count);
                // Trie.count = 0;
                // }
            }
        }

        return output;
    }

}

public class StringSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        IntStream.range(0, queriesRows).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.contacts(queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
