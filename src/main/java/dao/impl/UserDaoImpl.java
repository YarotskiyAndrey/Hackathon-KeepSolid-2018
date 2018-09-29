package dao.impl;

import dao.UserDao;
import model.UserEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        userDao.getAllUserList();
    }

    @Override
    public List<UserEntity> getAllUserList() {
        List<JSONObject> jsonObjectList = getAllUserJSON();


        return null;
    }

    private List<JSONObject> getAllUserJSON() {
        List<JSONObject> jsonObjectList = new ArrayList<>();

        /*JSONParser parser = new JSONParser();
        try {

            InputStream is = new FileInputStream(new File("src\\main\\resources\\database\\user.json"));

            JsonReader reader = Json.createReader(is);

            // Get the JsonObject structure from JsonReader.
            JsonObject obj = reader.readObject();
            reader.close();


            ObjectInputStream input = new ObjectInputStream("src\\main\\resources\\database\\");

            Object obj = parser.parse(new FileReader(
                    //"/main/resources/database/user.json"));
                    "src\\main\\resources\\database\\user.json"));

            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            //JSONArray companyList = (JSONArray) jsonObject.get("Company List");

            System.out.println("Name: " + name);
//            Iterator<String> iterator = companyList.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }*/

        return jsonObjectList;
    }
}
