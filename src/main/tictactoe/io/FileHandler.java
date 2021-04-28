package main.tictactoe.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import main.tictactoe.model.PlayerRoster;
import main.tictactoe.utils.GeneralUtils;

public class FileHandler {
	private static final String userPath = System.getProperty("user.home") + File.separator + "tictactoe.ser";
	
	public static PlayerRoster readPlayerRoster() {
		try {
			FileInputStream fileIn = new FileInputStream(userPath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			PlayerRoster playerRoster = (PlayerRoster) objectIn.readObject();
			objectIn.close();
			fileIn.close();
			return playerRoster;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void writePlayerRoster(PlayerRoster playerRoster) {
		try {
            FileOutputStream fileOut = new FileOutputStream(userPath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(playerRoster);
            objectOut.close();
            fileOut.close();
            GeneralUtils.log("FileHandler", "Succesfully saved PlayerRoster class to disk at "+userPath);
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
	}
	

}
