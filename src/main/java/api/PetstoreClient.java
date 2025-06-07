package api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PetstoreClient {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    @Step("[API] Создаём зверя с именем: {name} и статусом: {status}")
    public Response createPet(int id, String name, String status) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        String body = String.format("""
                {
                  "id": %d,
                  "category": { "id": 1, "name": "default" },
                  "name": "%s",
                  "photoUrls": [ "http://example.com/photo.jpg" ],
                  "tags": [ { "id": 1, "name": "tag1" } ],
                  "status": "%s"
                }
                """, id, name, status);
        return request.body(body).post(BASE_URL + "/pet");
    }

    @Step("[API] Получаем информацию по зверю {id}")
    public Response getPet(int id) {
        RequestSpecification request = RestAssured.given();
        return request.get(BASE_URL + "/pet/" + id);
    }

    @Step("[API] Удаляем зверя {id}")
    public Response deletePet(int id) {
        RequestSpecification request = RestAssured.given();
        return request.delete(BASE_URL + "/pet/" + id);
    }
}