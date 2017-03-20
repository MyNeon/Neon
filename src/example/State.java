package example;
import java.util.Iterator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class State {
	String Name;
	ArrayList<Point> Points;
	public State(String sourceString, int numberString) throws IOException {
		JSONObject json = new JSONObject(sourceString);
		Set<String> setKeys = json.keySet();
		Iterator<String> iter = setKeys.iterator();
		int index = 0;
		while (iter.hasNext()) {
			if (index == numberString - 1) {
				this.Name = iter.next();
				break;
			}
			else {
				iter.next();
				index++;
			}
		}
		this.Points = new ArrayList<Point>();
		GetPoint(json.getJSONArray(Name));
	}
	@Override
	public String toString() {
		return "State [Name=" + Name + ", Points=" + Points + "]";
	}
	public void Show() {
		System.out.println(this.Name);
		Iterator<Point> iter = Points.iterator();
		while (iter.hasNext())
			iter.next().GetPoint();
	}
	private void GetPoint(JSONArray arr) throws JSONException {
		int index = 0;
		while (index != arr.length()) {
			if (arr.get(0) instanceof Double) {
				this.Points.add(new Point(arr.getDouble(0), arr.getDouble(1)));
				return;
			} else {
				GetPoint(arr.getJSONArray(index));
				index++;
			}
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Points == null) ? 0 : Points.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof State)) {
			return false;
		}
		State other = (State) obj;
		if (Name == null) {
			if (other.Name != null) {
				return false;
			}
		} else if (!Name.equals(other.Name)) {
			return false;
		}
		if (Points == null) {
			if (other.Points != null) {
				return false;
			}
		} else if (!Points.equals(other.Points)) {
			return false;
		}
		return true;
	}
}
