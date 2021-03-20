package au.com.nig.pks

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.time.LocalDate

object ReportingEngineTest: Spek({
    describe("computePatientsOnGender") {
        it("should send back the number of Females") {
            // Given
            val expectedDetails = listOf(
                PatientDetails("Blood pressure", "160", LocalDate.of(2019, 12, 9)),
                PatientDetails("Glucose", "11.1", LocalDate.of(2019, 12, 9)),
                PatientDetails("Diabetes", "TRUE", LocalDate.of(2019, 12, 9)),
                PatientDetails("WCC", "120", LocalDate.of(2019, 12, 9))
            )
            val patient0 = Patient(1L, 23L, "F", expectedDetails)
            val patient1 = Patient(2L, 30L, "F", expectedDetails)

            // When
            val result = ReportingEngine.computePatientsOnGender(listOf(patient0, patient1), "F")

            // Then
            assertEquals(2, result)
        }
        it("should send back the number of Males when Asked") {
            // Given
            val expectedDetails = listOf(
                PatientDetails("Blood pressure", "160", LocalDate.of(2019, 12, 9)),
                PatientDetails("Glucose", "11.1", LocalDate.of(2019, 12, 9)),
                PatientDetails("Diabetes", "TRUE", LocalDate.of(2019, 12, 9)),
                PatientDetails("WCC", "120", LocalDate.of(2019, 12, 9))
            )
            val patient0 = Patient(1L, 23L, "F", expectedDetails)
            val patient1 = Patient(2L, 30L, "F", expectedDetails)
            val patient2 = Patient(3L, 30L, "M", expectedDetails)

            // When
            val result = ReportingEngine.computePatientsOnGender(listOf(patient0, patient1, patient2), "M")

            // Then
            assertEquals(1, result)
        }
    }

    describe("computeAverageAgeOfGender") {
        it("should return the avg age of males") {
            // Given
            val expectedDetails = listOf(
                PatientDetails("Blood pressure", "160", LocalDate.of(2019, 12, 9)),
                PatientDetails("Glucose", "11.1", LocalDate.of(2019, 12, 9)),
                PatientDetails("Diabetes", "TRUE", LocalDate.of(2019, 12, 9)),
                PatientDetails("WCC", "120", LocalDate.of(2019, 12, 9))
            )
            val patient0 = Patient(1L, 23L, "M", expectedDetails)
            val patient1 = Patient(2L, 30L, "F", expectedDetails)
            val patient2 = Patient(3L, 30L, "M", expectedDetails)

            // When
            val result = ReportingEngine.computeAverageAgeOfGender(listOf(patient0, patient1, patient2), "M")

            // Then
            assertEquals(26.5, result)
        }
        it("should return the avg age of females") {
            // Given
            val expectedDetails = listOf(
                PatientDetails("Blood pressure", "160", LocalDate.of(2019, 12, 9)),
                PatientDetails("Glucose", "11.1", LocalDate.of(2019, 12, 9)),
                PatientDetails("Diabetes", "TRUE", LocalDate.of(2019, 12, 9)),
                PatientDetails("WCC", "120", LocalDate.of(2019, 12, 9))
            )
            val patient0 = Patient(1L, 23L, "F", expectedDetails)
            val patient1 = Patient(2L, 30L, "F", expectedDetails)
            val patient2 = Patient(3L, 30L, "M", expectedDetails)

            // When
            val result = ReportingEngine.computeAverageAgeOfGender(listOf(patient0, patient1, patient2), "F")

            // Then
            assertEquals(26.5, result)
        }
    }
})
