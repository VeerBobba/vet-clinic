package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public interface NeedsVaccinations {
    void wasVaccinatedOn(LocalDate vaccinatedDate);

    LocalDate nextVaccinationDate();
}
