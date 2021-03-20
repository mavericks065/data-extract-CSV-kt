package au.com.nig.pks

class ReportingEngine {
    companion object {
        fun computePatientsOnGender(patients: List<Patient>, gender: String): Int =
            patients.filter { it.gender.equals(gender) }.size

        fun computeAverageAgeOfGender(patients: List<Patient>, gender: String): Double =
            patients.filter { it.gender.equals(gender) }
                .mapNotNull { it.age }
                .average()
    }
}
