package api;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.PetSteps;

public class CreationTest {
    PetstoreClient animal = new PetstoreClient();
    PetSteps steps = new PetSteps();

    @Test
    @Tag("smoke") //тут может быть и название модуля или микросервиса в твоём проекте
    void create() {
        int petId = steps.generatePetId();
        String name = "Doggo";
        String status = "homeless";

        steps.createPet(animal, petId, name, status);
    }

}
