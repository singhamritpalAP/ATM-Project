package project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

class ReadData {
	public List<Account> readAccount(RandomAccessFile raf) {
		List<Account> account = new ArrayList<>();
		String [] data = new String[7];
		String line = "";

		try {
			while ((line = raf.readLine()) != null) {
				data = line.split(";");
				if(data[0].equals("S"))
					account.add(new SavingAccount(data[0],Integer.parseInt(data[1]), data[2], 
							data[3], data[4], 
							Double.parseDouble(data[5]), data[6]));
				else
					account.add(new CurrentAccount(data[0],Integer.parseInt(data[1]), data[2], 
							data[3], data[4], 
							Double.parseDouble(data[5]), data[6]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return account;
	}
}

