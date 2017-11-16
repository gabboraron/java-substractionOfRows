import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class substractionOfRows{
	public static void main(String[] args){
		if(args.length > 1){
			System.out.println("Too much filenames! The program need just one file!");
		} else {
			try{
				substractionWithoutBufferReader(args[0]);
				//substractionWithBufferReader(args[0]);
			} catch (IOException e){
				System.err.println("IO ERROR");
				e.printStackTrace();
			}
		}
	}
	
	public static void substractionWithoutBufferReader(String input)
	throws IOException{
		try (Scanner sc = new Scanner(new File(input));){
			while (sc.hasNextLine()){
				String currentLine = sc.nextLine();
				if(sc.hasNextLine()){
					String nextLine = sc.nextLine();
					
					String[] res1 = currentLine.split(",");
					String[] res2 = nextLine.split(",");
					
					System.out.println(Arrays.toString(res1));
					System.out.println(Arrays.toString(res2));
					System.out.println("-------");
					
					int[] sub = new int[res1.length];
					for(int i = 0; i<res1.length; ++i){
						sub[i] = Integer.parseInt(res1[i]) - Integer.parseInt(res2[i]);
						
					}
					
					System.out.println(Arrays.toString(sub));
					System.out.println(" ");
				}
			}
		}
	}
	
	public static void substractionWithBufferReader(String input)
	throws IOException{
		File inFile = new File(input);
		try( BufferedReader br = new BufferedReader(new FileReader(inFile));){
			String line;
			for(line = br.readLine(); line!=null; line=br.readLine()){
				String line1 = line;
				line = br.readLine();
				if(line!=null){
					String[] res1 = line1.split(",");
					String[] res2 = line.split(",");
					int[] tmp = new int[res1.length];
					for(int i=0; i<res1.length; ++i){
						tmp[i] = Integer.parseInt(res1[i]) - Integer.parseInt(res2[i]);
					}
					System.out.println(Arrays.toString(res1));
					System.out.println(Arrays.toString(res2));
					System.out.println("----");
					System.out.println(Arrays.toString(tmp));
					System.out.println(" ");
				}
			}
		}
	}
}