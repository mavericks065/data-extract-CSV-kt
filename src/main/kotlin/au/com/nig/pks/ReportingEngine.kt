package au.com.nig.pks

class ReportingEngine {
    companion object {
        fun computePatientsOnGender(patients: List<Patient>, gender: String): Int =
            patients.filter { it.gender.equals(gender) }.size
    }
}
