import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import umlcode.TreeMap;

public class startrer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap treemap = new TreeMap();
		String[] arr = {"c","a","b","f","e","d","g","z"};
		for(String i:arr) {
			treemap.add(i, i + "asd");
		}

		System.out.println(treemap.get("g"));
	}

}
