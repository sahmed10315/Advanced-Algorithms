
import java.io.IOException;
import java.io.RandomAccessFile;

public class TailUnix {
	public static String tail(String fileName, int N) throws IOException {
		RandomAccessFile filePtr = new RandomAccessFile(fileName, "r");

		filePtr.seek(filePtr.length() - 1);
		long fileSize = filePtr.length(), newLineCount = 0;
		StringBuilder lastNLines = new StringBuilder();
		// Reads file in reverse looking for '\n'.
		for (long i = fileSize - 1; i != -1; i--) {
			filePtr.seek(i);
			int readByte = filePtr.readByte();
			char c = (char) readByte;
			if (c == '\n') {
				++newLineCount;
				if (newLineCount > N) {
					break;
				}
			}
			lastNLines.append(c);
		}

		filePtr.close();

		lastNLines.reverse();
		return lastNLines.toString();
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Usage: file name and tail count");

		int tailCount = 10;
		String fileName;
		if (args.length == 1) {
			fileName = args[0];
		} else if (args.length == 2) {
			fileName = args[0];
			tailCount = Integer.parseInt(args[1]);
		} else {
			return;
		}

		String output = tail(fileName, tailCount);
		System.out.println(output);
	}
}
