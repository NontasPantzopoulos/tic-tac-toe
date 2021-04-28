package main.tictactoe.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import main.tictactoe.utils.GeneralUtils;

public class PlayerRoster {
	private HashMap<String,Player> players;

	public PlayerRoster() {
		this.players = new HashMap<>();
	}
	
	public void addPlayer(Player p) {
		Optional<Player> tempPlayer = Optional.ofNullable(this.players.get(p.getName()));
		if(!tempPlayer.isPresent()) {
			this.players.put(p.getName(), p);
			GeneralUtils.log("PlayerRoster", "Adding new Player "+p.getName()+" to Roster.");
		}else {
			GeneralUtils.log("PlayerRoster", p.getName()+" already exists.");
		}
	}
	
	public ArrayList<String> findPlayerNames() {
		ArrayList<String> playernames = new ArrayList<>();
		//Through the HashMap
		this.players.forEach((key,value)->{
			playernames.add(key);
		});
		return playernames;
	}
	
	public Player findPlayerByName(String name) {
		return this.players.get(name);
	}
	
	public Player[] findHallOfFame(int n){
		//Array of players of size n
		Player[] players = new Player[n];
		
		//A map with all players and their scores
		Map<Player,Float> playersByScore = new HashMap<>();
		this.players.forEach((key,value)->{
			playersByScore.put(value,value.getScore());
		});
		
		//A map sorted by players' scores descending
		Map<Player,Float> sortedByScore = playersByScore.entrySet().stream()
		        .sorted(Map.Entry.<Player,Float> comparingByValue().reversed())
		        .collect(Collectors.toMap(Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
		                LinkedHashMap::new));
		
		//Log Print all players by score Descending
		GeneralUtils.log("PlayerRoster", "--Printing all players in descending order by score--");
		sortedByScore.forEach((k,v)->{
			GeneralUtils.log("PlayerRoster", "Player:"+k.getName()+" Score:"+v);
		});
		GeneralUtils.log("PlayerRoster", "----");
		
		//Iterate through the sorted list and set the top n players to the players array
		int counter=0;
		Iterator<Player> it = sortedByScore.keySet().iterator();
		while(counter<n) {
			if(it.hasNext()) {
				players[counter] = it.next();
			}
			counter++;
		}
		
		return players;
	}

}
