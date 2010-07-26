/*
 * Copyright 2009 Prime Technology.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.examples.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.examples.domain.Player;

public class AutoCompleteBean {

	private String txt1;
	
	private String txt2;
	
	private String txt3;
	
	private String txt4;
	
	private String txt5;

	private Player selectedPlayer;
	
	private List<Player> players;
	
	public AutoCompleteBean() {
		players = new ArrayList<Player>();
		
		players.add(new Player("Messi", 10));
		players.add(new Player("Ibrahimovic", 9));
		players.add(new Player("Henry", 14));
		players.add(new Player("Iniesta", 8));
		players.add(new Player("Xavi", 6));
		players.add(new Player("Puyol", 5));
	}

	public Player getSelectedPlayer() {
		return selectedPlayer;
	}
	public void setSelectedPlayer(Player selectedPlayer) {
		this.selectedPlayer = selectedPlayer;
	}

	
	public List<String> complete(String query) {
		List<String> results = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			results.add(query + i);
		}
		
		return results;
	}
	
	public List<Player> completePlayer(String query) {
		List<Player> suggestions = new ArrayList<Player>();
		
		for(Player p : players) {
			if(p.getName().startsWith(query))
				suggestions.add(p);
		}
		
		return suggestions;
	}
	
	public void handleSelect(SelectEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected:" + event.getObject().toString(), null);
		
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	public String getTxt2() {
		return txt2;
	}

	public void setTxt2(String txt2) {
		this.txt2 = txt2;
	}

	public String getTxt3() {
		return txt3;
	}

	public void setTxt3(String txt3) {
		this.txt3 = txt3;
	}
	
	public String getTxt4() {
		return txt4;
	}

	public void setTxt4(String txt4) {
		this.txt4 = txt4;
	}

	public String getTxt5() {
		return txt5;
	}

	public void setTxt5(String txt5) {
		this.txt5 = txt5;
	}
}