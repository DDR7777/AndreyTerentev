package base;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.google.gson.Gson;
//import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
//import com.google.gson.stream.JsonReader;
import entity.MetalsAndColorsData;
//import org.openqa.selenium.json.Json;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetalsAndColorsDataProvider {
    public List<Integer> summary;
    public List<String> elements;
    public String color;
    public String metals;
    public List<String> vegetables;

    @DataProvider
    public static Object[][] metalsAndColorsDataProvider() {

//        Type type = new TypeToken<HashMap<String, MetalsAndColorsData>>() {
//        }.getType();
//
        Object[][] result = null;
        File jsonInputFile = new File("src/main/resources/JDI_ex8_metalsColorsDataSet.json");
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            JsonReader reader = Json.createReader(is);
            JsonObject object = reader.readObject();
            reader.close();
        }
        catch ( IOException e) {
            e.printStackTrace();
        }
//        JsonParser jsonParser = new JsonParser();
//        try {
//            JsonObject jsonNode = (JsonObject) jsonParser.parse(new FileReader(new File("src/main/resources/JDI_ex8_metalsColorsDataSet.json")));
//            HashMap<String, MetalsAndColorsData> data = new Gson().fromJson(jsonNode.getAsJsonObject(), type);
//            result = new Object[data.size()][1];
//
//            int i = 0;
//            for (Map.Entry<String, MetalsAndColorsData> entry : data.entrySet()) {
//                result[i][0] = entry.getValue();
//                i++;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return result;
    }
}
