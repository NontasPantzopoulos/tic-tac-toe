package main.tictactoe.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import main.tictactoe.model.PlayerRoster;
import main.tictactoe.utils.GeneralUtils;

/**
 * This class is the responsible class for reading/writing (serializing/deserializing) the
 * PlayerRoster class, which holds all the game data and players.
 * It consists of static methods in order to be accessed by all classes independently.
 */
public class FileHandler {
	//The user's profile path from the OS
	private static final String userPath = System.getProperty("user.home") + File.separator + "tictactoe.ser";
	
	/** 
	 * Reads the file tictactoe.ser from the user's profile
	 * If it is not found writes an error to console.
	 * @return PlayerRoster instance
	 */
	public static PlayerRoster readPlayerRoster() {
		try {
			FileInputStream fileIn = new FileInputStream(userPath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			PlayerRoster playerRoster = (PlayerRoster) objectIn.readObject();
			objectIn.close();
			fileIn.close();
			return playerRoster;
		} catch (Exception e) {
			GeneralUtils.log("FileHandler", "Game file not found at users profile");
		}
		return null;
	}
	
	/**
	 * Writes an instance of PlayerRoster class to a file in user's profile.
	 * @param playerRoster
	 */
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

	public static String getUserpath() {
		return userPath;
	}

}
