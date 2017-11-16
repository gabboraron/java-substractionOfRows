import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class substractionOfRowsOutToFile{
	public static void main(String[] args){
		if(args.length > 2){
			System.out.println("Too much filenames!");
		} else if(args.length<2){
			System.out.println("Too few filenames!");
		} else {
			try{
				substractionWithBufferReaderToFile(args[0], args[1]);
			} catch (IOException e){
				System.err.println("IO ERROR");
				e.printStackTrace();
			}
		}
	}
	
	public static void substractionWithBufferReaderToFile(String inFileName, String outFileName)
	throws IOException{
		File inFile = new File(inFileName);
		File outFile = new File(outFileName);
		try(
		BufferedReader br = new BufferedReader(new FileReader(inFile));
		PrintWriter pw = new PrintWriter(outFile);){
			String line;
			for(line = br.readLine(); line!=null; line=br.readLine() ){
				String line1 = line;
				line = br.readLine();
				if(line != null){
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
					pw.println(Arrays.toString(tmp));
				}
			}
		}
	}
}