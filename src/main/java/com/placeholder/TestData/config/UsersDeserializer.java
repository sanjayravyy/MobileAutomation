package com.placeholder.TestData.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersDeserializer extends JsonDeserializer<Users> {

    @Override
    public Users deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        Users users = new Users();

        node.fields().forEachRemaining(entry -> {
            JsonNode userNode = entry.getValue();
            Account user = new Account();
            List<String> numbersList = new ArrayList<>();
            List<String> nameList = new ArrayList<>();

            userNode.fields().forEachRemaining(field -> {
                String fieldName = field.getKey();
                JsonNode fieldValue = field.getValue();
                if (fieldName.equalsIgnoreCase("name")) {
                    user.setName(fieldValue.asText());
                } else if (fieldName.equalsIgnoreCase("email")) {
                    user.setEmail(fieldValue.asText());
                } else {
                    fieldValue.elements().forEachRemaining(num -> {
                        String number = num.get("number").asText();
                        String name = num.get("name").asText();
                        numbersList.add(number);
                        nameList.add(name);
                    });
                }
            });
            user.setNumbers(numbersList);
            user.setNames(nameList);
            users.setUser(entry.getKey(), user);
        });

        return users;
    }
}
