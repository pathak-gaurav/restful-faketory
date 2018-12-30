package com.gaurav.api;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class RestTemplatesExample {

    public static final String API_ROOT = "https://api.predic8.de:443/shop/";

    @Test
    public void getCategories() throws Exception {
        String apiUrl = API_ROOT + "/categories/";
        RestTemplate restTemplate = new RestTemplate();
        JsonNode jsonNode = restTemplate.getForObject(apiUrl, JsonNode.class);
        System.out.println("Response");
        System.out.println(jsonNode.toString());
    }

    @Test
    public void getCustomers() throws Exception {
        String apiUrl = API_ROOT + "/customers/";
        RestTemplate restTemplate = new RestTemplate();
        JsonNode forObject = restTemplate.getForObject(apiUrl, JsonNode.class);
        System.out.println("Response");
        System.out.println(forObject.toString());
    }

    @Test
    public void createCustomer() throws Exception {
        String apiUrl = API_ROOT + "/customers/";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> map = new HashMap<>();
        map.put("firstname", "Zack");
        map.put("lastname", "Anderson");
        JsonNode jsonNode = restTemplate.postForObject(apiUrl, map, JsonNode.class);
        System.out.println("Response");
        System.out.println(jsonNode.toString());
    }

    @Test
    public void updateCustomer() throws Exception {
        String apiUrl = API_ROOT + "/customers/";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> map = new HashMap<>();
        map.put("firstname", "Zack");
        map.put("lastname", "Anderson");
        JsonNode jsonNode = restTemplate.postForObject(apiUrl, map, JsonNode.class);
        System.out.println("Response");
        System.out.println(jsonNode.toString());

        String customerUrl = jsonNode.get("customer_url").textValue();
        String id = customerUrl.split("/")[3];
        System.out.println("Customer Id -" + id);
        map.put("firstname", "Zack1");
        map.put("lastname", "Anderson1");
        restTemplate.put(apiUrl + id, map);
        JsonNode object = restTemplate.getForObject(apiUrl + id, JsonNode.class);
        System.out.println(object.toString());
    }
}
