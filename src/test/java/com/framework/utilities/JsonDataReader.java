package com.framework.utilities;

import java.io.FileReader;
import java.io.IOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonDataReader {

	private JsonObject data;

	public JsonDataReader() {
		try {
			String filePath = ".\\src\\main\\resources\\testdata.json";
			FileReader reader = new FileReader(filePath);
			this.data = JsonParser.parseReader(reader).getAsJsonObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getString(String key) {
		return data.get(key).getAsString();
	}

	public int getInt(String key) {
		return data.get(key).getAsInt();
	}

}
