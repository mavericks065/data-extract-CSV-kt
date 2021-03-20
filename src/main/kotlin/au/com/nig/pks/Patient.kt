package au.com.nig.pks

import org.apache.commons.csv.CSVRecord
import java.time.LocalDate

data class Patient(val id: Long, val patientDetails: List<PatientDetails>) {

    companion object {
        fun transformToPatient(key: String, records: List<CSVRecord>): Patient {
            val patientDetails = records.map {
                PatientDetails(
                    detail = it[2],
                    value = it[3],
                    date = LocalDate.parse(it[0])
                )
            }
            return Patient(key.toLong(), patientDetails)
        }
    }
}

data class PatientDetails(val detail: String, val value: String, val date: LocalDate)
