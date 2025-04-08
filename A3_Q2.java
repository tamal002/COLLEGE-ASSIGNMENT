import java.util.*;
import java.io.*;

class A3_Q2 {
	public static void main(String[] args) throws java.lang.Exception {

		TreeMap<String, Integer> tmap = new TreeMap<>(Collections.reverseOrder());

		Scanner input1 = new Scanner(System.in);
		System.out.print("File_path: ");
		String file_path = input1.next();
		File file = new File(file_path);
		ArrayList<String> words = new ArrayList<>();
		if (file.exists()) {
			Scanner input2 = new Scanner(file);

			while (input2.hasNext()) {
				String word = input2.next().toLowerCase().replaceAll("[^a-z]", "");
				if(!word.isEmpty()) words.add(word);
			}
			input2.close();
		} else {
			System.out.println("File does not exist.");
			input1.close();
			return;
		}

		
		for (String s : words) {
			tmap.put(s, tmap.getOrDefault(s, 0) + 1);
		}

		System.out.println(tmap);

		String greatest = tmap.firstKey();
		String least = tmap.lastKey();

		System.out.println("Greatest key : " + greatest + " --> value: " + tmap.get(greatest));
		System.out.println("least key : " + least + " --> value: " + tmap.get(least));
		input1.close();



	}
}