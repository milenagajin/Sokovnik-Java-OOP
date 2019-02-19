package sokovnik.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLogger {

	private static MyLogger ml;

	private MyLogger() {
	}

	public static MyLogger getInstance() {

		if (ml == null)
			ml = new MyLogger();

		return ml;

	}

	public static void log(String text) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime trenutnoVreme = LocalDateTime.now();
		String formatted = trenutnoVreme.format(formatter);

		try (FileWriter fw = new FileWriter("mylogs.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(formatted + " " + text);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
