package DataProvider;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.openqa.selenium.json.Json;
import org.testng.annotations.DataProvider;
import pojo.loginData;
import java.util.List;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class userDataProvider {
    @DataProvider(name = "getUsersDataFromJson")
    public Object[] getUsersDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/java/DataFiles/userCredentialsData.json"));
        JsonElement userDataSet = jsonData.getAsJsonObject().get("dataset");
        List<loginData> usersData = new Gson().fromJson(userDataSet, new TypeToken<List<loginData>>(){}.getType());
        Object[][] returnValue =  new Object[usersData.size()][1];
        int index = 0;
        for (Object[] each: returnValue){
            each[0] = usersData.get(index++);
        }
        return returnValue;
    }
}
