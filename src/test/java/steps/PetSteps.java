package steps;

import api.PetstoreClient;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PetSteps {
    @Step("Генерация уникального petId")
    public int generatePetId() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    @Step("Создание животного: id={petId}, name={name}, status={status}")
    public Response createPet(PetstoreClient animal, int petId, String name, String status) {
        Response response = animal.createPet(petId, name, status);
        assertEquals(200, response.getStatusCode(), "Ошибка при создании питомца");
        return response;
    }

    @Step("Ожидание появления животного с id={petId}")
    public void waitForPetAvailable(PetstoreClient animal, int petId, String name, String status) {
        await()
                .atMost(20, SECONDS)
                .pollDelay(3, SECONDS)
                .pollInterval(2, SECONDS)
                .untilAsserted(() -> {
                    Response response = animal.getPet(petId);
                    assertEquals(200, response.getStatusCode());
                    assertEquals(name, response.jsonPath().getString("name"));
                    assertEquals(status, response.jsonPath().getString("status"));
                    assertNotNull(response.jsonPath().getString("tags"));
                });
    }

    @Step("Удаление животного с id={petId}")
    public void deletePet(PetstoreClient animal, int petId) {
        await()
                .atMost(20, SECONDS)
                .pollInterval(2, SECONDS)
                .untilAsserted(() -> {
                    Response response = animal.deletePet(petId);
                    assertEquals(200, response.getStatusCode(), "Ошибка при удалении питомца");
                });
    }

    @Step("Проверка, что животное с id={petId} удалено")
    public void assertPetDeleted(PetstoreClient animal, int petId) {
        Response response = animal.getPet(petId);
        assertEquals(404, response.getStatusCode(), "Ожидался статус 404 для удалённого питомца");
    }

}
