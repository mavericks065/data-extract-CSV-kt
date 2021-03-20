package au.com.nig.pks

import org.apache.commons.csv.CSVRecord
import java.time.LocalDate

data class Patient(val id: Long, val testResults: List<TestResult>) {

    companion object {
        fun transformToPatient(key: String, records: List<CSVRecord>): Patient = TODO()
    }
}

data class TestResult(val test: String, val value: String, val date: LocalDate)
