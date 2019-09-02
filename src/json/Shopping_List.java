package json;

import java.util.List;

public class Shopping_List {
	
	private List<String> items;
	private List<ItemInfo> information;

	public List<ItemInfo> getInformation() {
		return information;
	}

	public void setInformation(List<ItemInfo> information) {
		this.information = information;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}
}
