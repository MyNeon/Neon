package example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class general {

	public static void main(String[] args) {
		try {
			State st;
			if (args.length == 3) {
				int countStrings = Integer.parseInt(args[2]), 
						cur = Integer.parseInt(args[1]);
				String source = GetAllStates("states.json");
				while (cur != countStrings + 1) {
					st = new State(source, cur);
					st.Show();
					cur++;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String GetAllStates(String fileName) throws IOException {
		RandomAccessFile name = new RandomAccessFile(fileName, "r");
		String res = "";
		int b = name.read();
		while (b != -1) {
			res += (char) b;
			b = name.read();
		}
		name.close();
		return res;
	}
}
