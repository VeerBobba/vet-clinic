package serenitylabs.tutorials.vetclinic.domain;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.List;

public class WhenCollectingAnimals {

    @Test
    public void a_list_of_animals_can_contain_cats_and_dogs(){
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");
        Cat felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("Gray");
        List<Animal> animals = new ArrayList<>();

        animals.add(fido);
        animals.add(felix);

        assertThat(animals, hasItems(felix,fido));

    }

    @Test
    public void a_dog_complains_by_growling(){
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        assertThat(fido.complaint(), is(equalTo("Bark...")));

    }

    @Test
    public void a_cat_complains_by_meowing(){
        Cat felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("Gray");

        assertThat(felix.complaint(),is(equalTo("Meow...")));
    }

}
