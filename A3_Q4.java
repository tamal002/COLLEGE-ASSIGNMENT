import java.util.*;


public class A3_Q4 {
    public static void main(String[] args) {
        TreeMap<String, Integer> hmap = new TreeMap<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of teams: ");
        int n = input.nextInt();

        // INITIALIZING THE HASH_MAP 
        for(int i = 0; i < n; i++){
            System.out.print("Enter the name of team" + (i+1) + " : ");
            String team = input.next();
            System.out.print("Enter the score of team" + (i+1) + " : ");
            int score = input.nextInt();
            hmap.put(team, score);
        }

        if(n == 1){
            System.out.println("Product of scores: 1");
            input.close();
            return;
        }

        ArrayList<Integer> prefix = new ArrayList<>();
        prefix.add(1);

        ArrayList<Integer> suffix = new ArrayList<>();
        suffix.add(1);

        ArrayList<Integer> ans = new ArrayList<>();
        
        for(Map.Entry<String, Integer> entry : hmap.entrySet()){
            prefix.add(prefix.get(prefix.size() - 1) * entry.getValue());
            if(prefix.size() == n) break;
        }
        
        for(Map.Entry<String, Integer> entry : hmap.descendingMap().entrySet()){
            suffix.add(suffix.get(suffix.size() - 1) * entry.getValue());
            if(suffix.size() == n) break;
        }

        int i = 0;
        int j = suffix.size() - 1;
        while(i < j){
            Collections.swap(suffix, i, j);
            i++;
            j--;
        }

        for(int it = 0; it < n; it++){
            ans.add(suffix.get(it) * prefix.get(it));
        }

        int count = 1;
        for(Integer it : ans){
            System.out.print("For team" + count + ": " + it);
            System.out.println();
            count++;

        }

        input.close();
    }
}