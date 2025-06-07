package api;


import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import steps.PetSteps;

public class PetstoreClientTest {

    PetstoreClient animal = new PetstoreClient();
    PetSteps steps = new PetSteps();

    @Epic("Кошки-собаки")
    @Feature("здесь фича. можно id из jira")
    @Story("здесь стори")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("e2e"), @Tag("ui"), @Tag("regression")})
    @Test
    void testCreateAndReadNewAnimal() {
        int petId = steps.generatePetId();
        String name = "Doggo";
        String status = "homeless";

        steps.createPet(animal, petId, name, status);
        steps.waitForPetAvailable(animal, petId, name, status);
        steps.deletePet(animal, petId);
        steps.assertPetDeleted(animal, petId);
    }

}