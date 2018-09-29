package dao.impl;

import dao.UserDao;
import model.UserEntity;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.persistence.mappings.OneToManyMapping;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.json.JsonObject;
import java.io.*;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserDaoImpl implements UserDao {
    @Override
    public List<UserEntity> getAllUserList() {
        JSONParser parser = new JSONParser();

        JSONArray jsonArray = null;

        try {
            jsonArray = (JSONArray) parser.parse(new FileReader("src\\main\\resources\\database\\user.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entityConverter(jsonArray);
    }

    private static List<UserEntity> entityConverter(JSONArray jsonArray) {
        List<UserEntity> userEntities = new ArrayList<>();
        for (Object obj : jsonArray) {
            JSONObject userJSON = (JSONObject) obj;

            UserEntity userEntity = new UserEntity();

            userEntity.setId((Integer.parseInt(userJSON.get("id").toString())));
            userEntity.setName((String) userJSON.get("name"));
            userEntity.setSurname((String) userJSON.get("surname"));

            Map<String, Integer> skillsMap = new HashMap<>();

            JSONArray JsonSkills = (JSONArray) userJSON.get("skills");

            for (Object skillObj : JsonSkills) {
                JSONObject skillJson = (JSONObject) skillObj;

                String work = skillJson.get("work").toString();
                Integer level = Integer.parseInt(skillJson.get("level").toString());

                skillsMap.put(work, level);
            }

            userEntity.setSkills(skillsMap);

            userEntity.setOnWork((Boolean) userJSON.get("onWork"));


            if (userJSON.get("taskID") != null) {
                userEntity.setTaskID(Integer.parseInt(userJSON.get("taskID").toString()));
            } else userEntity.setTaskID(null);

            if (userJSON.get("taskStartTime") != null) {
                String taskStartTime = userJSON.get("taskStartTime").toString();

                Date date = null;
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH);
                try {
                    date = formatter.parse(taskStartTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                userEntity.setTaskStartTime(date);
            } else userEntity.setTaskStartTime(null);

            userEntities.add(userEntity);
        }

        return userEntities;
    }
}
