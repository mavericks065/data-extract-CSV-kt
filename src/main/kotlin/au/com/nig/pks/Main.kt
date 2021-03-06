package au.com.nig.pks

import java.nio.file.Path
import java.nio.file.Paths
import java.util.logging.Level


val logger = java.util.logging.Logger.getLogger("main")

fun main(args: Array<String>) {
    val filePath = if (args.isNotEmpty())
        args[0]
    else {
        val currentRelativePath: Path = Paths.get("")
        val s = currentRelativePath.toAbsolutePath().toString()
        "$s/src/test/resources/sample.csv"
    }

    val patients = IO.readFile(filePath)
        .groupBy { it.get("PatientId") }
//        .map {
//                Here could be data cleansing --> CSV record making sure we have either
//                gae or well formatted data etc
//        }
        .map { (key, records) -> Patient.transformToPatient(key, records) }

    val nbOfFemalePatients = ReportingEngine.computePatientsOnGender(patients, "F")
    val nbOfMalePatients = ReportingEngine.computePatientsOnGender(patients, "M")

    val avgAgeOfFemalePatients = ReportingEngine.computeAverageAgeOfGender(patients, "F")
    val avgAgeOfMalePatients = ReportingEngine.computeAverageAgeOfGender(patients, "M")

    logger.log(Level.INFO, "number of FEMALE patients $nbOfFemalePatients")
    logger.log(Level.INFO, "number of MALE patients $nbOfMalePatients")
    logger.log(Level.INFO, "average age of FEMALE patients $avgAgeOfFemalePatients")
    logger.log(Level.INFO, "average age of MALE patients $avgAgeOfMalePatients")
}
