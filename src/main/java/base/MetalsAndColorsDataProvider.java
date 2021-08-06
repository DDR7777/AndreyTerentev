package base;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.MetalsAndColorsData;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MetalsAndColorsDataProvider {

    @DataProvider
    public static Object[][] metalsAndColorsDataProvider() {

        Type type = TypeToken.getParameterized(HashMap.class, String.class, MetalsAndColorsData.class).getType();
        Object[][] result = null;
        try {
            HashMap<String, MetalsAndColorsData> data = new Gson().fromJson(new FileReader("src/main/resources/JDI_ex8_metalsColorsDataSet.json"), type);
            result = new Object[data.size()][1];

            int i = 0;
            for (Map.Entry<String, MetalsAndColorsData> entry : data.entrySet()) {
                result[i][0] = entry.getValue();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
