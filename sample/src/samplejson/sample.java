package samplejson;

import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

// create multiple json files based on key, start and end values

public class sample {

	public static void main(String[] args) throws IOException {

		int start = 10;
		int end = 15;
		String[] testarray = new String[end + 1];
		String key = "TPFPDB";
		for (int k = start; k <= end; k++) {

			testarray[k] = key + k;
			System.out.println(testarray[k]);
			String filename = testarray[k] + ".json";
			System.out.println(filename);
			FileWriter file = new FileWriter(
					"C:\\Users\\Redirection\\redds24\\Desktop\\WP-Extension\\Lahari\\JSON\\" + filename);

			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();

			for (int i = 1; i <= 20; i++) {

				JSONObject obj = new JSONObject();
				obj.put("testKey", testarray[k] + "-" + i);
				obj.put("start", "2014-08-30T11:47:35+01:00");
				obj.put("finish", "2014-08-30T11:50:56+01:00");
				obj.put("comment", "Successful execution");
				obj.put("status", "PASS");
				jsonArray.put(obj);

			}

			jsonObject.put("tests", jsonArray);
			file.write(jsonObject.toString());
			file.close();

		}
	}
}
