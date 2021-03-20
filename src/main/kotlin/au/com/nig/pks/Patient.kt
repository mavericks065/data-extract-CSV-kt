package au.com.nig.pks

import org.apache.commons.csv.CSVRecord
import java.time.LocalDate

data class Patient(val id: Long, val age: Long?, val gender: String?, val patientDetails: List<PatientResults>) {

    companion object {
        fun transformToPatient(key: String, records: List<CSVRecord>): Patient {
            val age = records.find { it[2].equals("Age") }?.let { it.get(3)?.toLong() }
            val gender = records.find { it[2].equals("Gender") }?.get(3)

            val filteredRecords = records.filter { !it[2].equals("Age") && !it[2].equals("Gender") }
            val patientDetails = filteredRecords.map {
                PatientResults(
                    detail = it[2],
                    value = it[3],
                    date = LocalDate.parse(it[0])
                )
            }
            return Patient(
                id = key.toLong(), age = age, gender = gender, patientDetails = patientDetails
            )
        }
    }
}

data class PatientResults(val detail: String, val value: String, val date: LocalDate)
