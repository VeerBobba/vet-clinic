package serenitylabs.tutorials.vetclinic.domain;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import org.junit.Assert;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


public class WhenCalculatingTotalPrices {

    @Test
    public void total_consultation_price_should_include_20_percent_tax() throws Exception {
        // GIVEN
        int netPrice = 100;

        // WHEN
        int totalPrice = TotalConsultationPrice.includingTax().forANetPriceOf(netPrice);

        // THEN
        assertThat(totalPrice,greaterThan(100));
    }

    @Test
    public void a_dog_should_be_printed_in_a_readable_form(){

        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        assertThat(fido.toStringConvert(),is(equalTo("Fido the black labrador")));
        assertThat(fido.toStringConvert(),startsWith("Fido"));
        assertThat(fido.toStringConvert(), containsString("black"));

    }

    @Test
    public void a_dog_should_have_many_colors(){
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black","White");

        assertThat(fido.getColour(),contains("Black","White"));

        assertThat(fido.getColour(),not(hasItem("red")));

    }
}
