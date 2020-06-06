package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

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
}
