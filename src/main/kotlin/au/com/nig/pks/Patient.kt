package au.com.nig.pks

import org.apache.commons.csv.CSVRecord
import java.time.LocalDate

data class Patient(val id: Long, val patientDetails: List<PatientDetails>) {

    companion object {
        fun transformToPatient(key: String, records: List<CSVRecord>): Patient = TODO()
    }
}

data class PatientDetails(val detail: String, val value: String, val date: LocalDate)
