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
            val key = "1"
            val currentRelativePath: Path = Paths.get("")
            val s = currentRelativePath.toAbsolutePath().toString()
            val filePath = "$s/src/test/resources/short_sample.csv"
            val records = IO.readFile(filePath)

            val expectedDetails = listOf(
                PatientDetails("Age", "23", LocalDate.of(2019, 12, 9)),
                PatientDetails("Blood pressure", "160", LocalDate.of(2019, 12, 9)),
                PatientDetails("Gender", "F", LocalDate.of(2019, 12, 9)),
                PatientDetails("Glucose", "11.1", LocalDate.of(2019, 12, 9)),
                PatientDetails("Diabetes", "TRUE", LocalDate.of(2019, 12, 9)),
                PatientDetails("WCC", "WCC", LocalDate.of(2019, 12, 9))
            )

            // When
            val result = Patient.transformToPatient(key, records)

            // Then
            assertEquals(Patient(1L, expectedDetails), result)
        }
    }
})
