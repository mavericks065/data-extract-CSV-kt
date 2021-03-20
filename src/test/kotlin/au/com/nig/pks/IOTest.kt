package au.com.nig.pks

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.nio.file.Path
import java.nio.file.Paths

object IOTest : Spek({
    describe("When reading a file") {
        it("should return a list with the CSV records matching each lines of the file") {
            // Given
            val currentRelativePath: Path = Paths.get("")
            val s = currentRelativePath.toAbsolutePath().toString()
            val filePath = "$s/src/test/resources/short_sample.csv"

            // When
            val result = IO.readFile(filePath)

            // Then
            assertEquals("2019-12-09", result[0].get(0))
            assertEquals("1", result[0].get(1))
            assertEquals("Age", result[0].get(2))
            assertEquals("23", result[0].get(3))
        }
        it("should throw a ") {
            // Given
            val currentRelativePath: Path = Paths.get("")
            val s = currentRelativePath.toAbsolutePath().toString()
            val filePath = "$s/src/test/resources/short_sample11.csv"

            // When
            val result = assertThrows<IOException> {
                IO.readFile(filePath)
            }

            // Then
            assertEquals("Wrong file name", result.msg)
        }
    }
})
