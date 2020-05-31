package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.exparity.hamcrest.date.LocalDateTimeMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;



public class WhenWeBookAnAppointment {

    private static final LocalDateTime TODAY_AT_2_PM = LocalDateTime.now().withHour(14).withMinute(0);

    @Test
    public void an_appointment_has_a_patient_name_an_owner_and_a_date() {
        Appointment appointment = Appointment.forPetCalled("Fido").ownedBy("Fred").at(TODAY_AT_2_PM);

        assertThat(appointment.getPetName(),equalTo("Fido"));
        assertThat(appointment.getOwner(),equalTo("Fred"));
        assertThat(appointment.getAppointmentTime(),equalTo(TODAY_AT_2_PM));
    }

    @Test
    public void an_appointment_can_have_an_optional_reason() {
        Appointment appointment = Appointment.forPetCalled("Fido").ownedBy("Fred").because("He is sick").at(TODAY_AT_2_PM);

        assertThat(appointment.getReason().isPresent(),equalTo(true));
        assertThat(appointment.getReason().get(), equalTo("He is sick"));
    }

    @Test

    public void an_appointment_should_be_after_current_time(){
        Appointment appointment = Appointment.forPetCalled("Fido").ownedBy("Fred").because("He is sick").at(TODAY_AT_2_PM);

        assertThat(TODAY_AT_2_PM,isSunday());
    }

}
