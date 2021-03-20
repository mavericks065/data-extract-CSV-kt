package au.com.nig.pks

import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.nio.file.Path
import java.nio.file.Paths
import java.time.LocalDate

object PatientTest : Spek({
    describe("When receiving an id and a list of CSV records") {
        it("should transform it into a patient with all its details") {
            // Given
            val expectedDetails = listOf(
                PatientResults("Blood pressure", "160", LocalDate.of(2019, 12, 9)),
                PatientResults("Glucose", "11.1", LocalDate.of(2019, 12, 9)),
                PatientResults("Diabetes", "TRUE", LocalDate.of(2019, 12, 9)),
                PatientResults("WCC", "120", LocalDate.of(2019, 12, 9))
            )
            val expectedPatient = Patient(1L, 23L, "F", expectedDetails)

            val key = "1"
            val currentRelativePath: Path = Paths.get("")
            val s = currentRelativePath.toAbsolutePath().toString()
            val filePath = "$s/src/test/resources/short_sample.csv"
            val records = IO.readFile(filePath)

            // When
            val result = Patient.transformToPatient(key, records)

            // Then
            assertEquals(expectedPatient, result)
        }
    }
})
