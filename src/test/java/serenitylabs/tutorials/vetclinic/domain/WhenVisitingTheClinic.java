package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class WhenVisitingTheClinic {

    @Test
    public void cats_and_dogs_complain_to_the_assistant(){
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");
        Cat felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("Gray");

        ComplaintRegister complaintRegister = new ComplaintRegister();
        VetAssistant vetAssistant = new VetAssistant(complaintRegister);

        vetAssistant.recordComplainFrom(fido);
        vetAssistant.recordComplainFrom(felix);
        assertThat(complaintRegister.getComplaints(),hasItems("Meow...","Bark..."));

    }
    @Test
    public void the_vet_should_know_when_a_cat_vaccination_is_due(){
        NeedsVaccinations felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("Gray");

        LocalDate today = LocalDate.now();
        LocalDate nextYear = today.plusYears(1);

        felix.wasVaccinatedOn(today);
        assertThat(felix.nextVaccinationDate(),equalTo(nextYear));

    }


    @Test
    public void the_vet_should_know_when_a_dog_vaccination_is_due(){
        NeedsVaccinations fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        LocalDate today = LocalDate.now();
        LocalDate afterSixMonths = today.plusMonths(6);

        fido.wasVaccinatedOn(today);
        assertThat(fido.nextVaccinationDate(),equalTo(afterSixMonths));

    }
}
