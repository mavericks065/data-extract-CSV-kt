package au.com.nig.pks

fun main(args: Array<String>) {
    val patients = IO.readFile(args[0])
        .groupBy { it.get("PatientId") }
        .map { (key, records) -> Patient.transformToPatient(key, records) }


}
