package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class WebBase {
	@DataProvider(name = "Data Login")
	public String[][] getloginData() {
		String[][] LoginData = { { "Admin", "admin123" }, { "ess", "ess123" } };
		return LoginData;
	}

	@DataProvider(name = "DataCSVLogin")
	public String[][] getLoginCSVData() throws IOException {
		String filename = "C:\\Users\\gsm\\eclipse-workspace\\JavaTrainingSession\\FiletoRead\\LoginData.csv";
		File file = new File(filename);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		String loginData[][] = new String[3][2];
		String line;
		int i = 0;
		while ((line = br.readLine()) != null) {
			String[] data = line.split(",");
			loginData[i] = data;
			i++;
		}
		return loginData;
	}
}
