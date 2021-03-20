package au.com.nig.pks

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVRecord
import java.nio.file.Paths

object IO {
    fun readFile(filePath: String): List<CSVRecord> {
        val bufReader = Paths.get(filePath).toFile().bufferedReader()
        val parser = CSVParser(
            bufReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim()
        )
        return parser.records
    }
}
