package medicalCenter;

import medicalCenter.model.Doctor;
import medicalCenter.model.Patient;
import medicalCenter.model.Profession;
import medicalCenter.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.function.Predicate;

public class MedicalCenter implements MedicalCenterCom {
    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            MedicalCenterCom.printCommands();
            String command = prompt("Enter command: ");
            switch (command) {
                case EXIT -> isRun = shutdown();
                case ADD_DOCTOR -> addDoctor();
                case SEARCH_DOCTOR_BY_PROFESSION -> personStorage.searchDoctorByProfession(chooseProfession());
                case DELETE_DOCTOR_BY_ID -> personStorage.deleteDoctorById(getExistingDoctorId());
                case CHANGE_DOCTOR_BY_ID -> changeDoctorById(personStorage.getDoctorById(getExistingDoctorId()));
                case ADD_PATIENT -> addPatient();
                case PRINT_ALL_PATIENTS_BY_DOCTOR ->
                        personStorage.getPatientByDoctor(personStorage.getDoctorById(getExistingDoctorId()));
                case PRINT_ALL_PATIENTS -> personStorage.printPatients();
                default -> System.out.println("Unknown command. Try again.");
            }
        }
    }

    private static void addDoctor() {
        Doctor doctor = new Doctor(
                getUniqueInput("Enter DOCTOR_ID: ", id -> personStorage.checkId(id, true), "ID already exists. Try again: "),
                prompt("Enter DOCTOR_NAME: "),
                prompt("Enter DOCTOR_SURNAME: "),
                getUniqueInput("Enter DOCTOR_PHONE: ", personStorage::checkPhone, "Phone already exists. Try again: "),
                getUniqueInput("Enter DOCTOR_EMAIL: ", personStorage::checkEmail, "Email already exists. Try again: "),
                chooseProfession()
        );
        personStorage.add(doctor);
        System.out.println("Doctor added!");
    }

    private static void changeDoctorById(Doctor doctor) {
        if (doctor != null) {
            doctor.setName(prompt("Enter new DOCTOR_NAME: "));
            doctor.setSurname(prompt("Enter new DOCTOR_SURNAME: "));
            doctor.setPhone(getUniqueInput("Enter new DOCTOR_PHONE: ", personStorage::checkPhone, "Phone already exists. Try again: "));
            doctor.setEmail(getUniqueInput("Enter new DOCTOR_EMAIL: ", personStorage::checkEmail, "Email already exists. Try again: "));
            doctor.setProfession(chooseProfession());
            System.out.println("Doctor info updated!");
        } else {
            System.out.println("No doctor found with that ID.");
        }
    }

    private static void addPatient() {
        Patient patient = new Patient(
                getUniqueInput("Enter PATIENT_ID: ", id -> personStorage.checkId(id, true), "ID already exists. Try again: "),
                prompt("Enter PATIENT_NAME: "),
                prompt("Enter PATIENT_SURNAME: "),
                getUniqueInput("Enter PATIENT_PHONE: ", personStorage::checkPhone, "Phone already exists. Try again: "),
                personStorage.getDoctorById(getExistingDoctorId()),
                readPatientDate()
        );
        personStorage.add(patient);
        System.out.println("Patient added!");
    }

    private static Date readPatientDate() {
        while (true) {
            String input = prompt("Enter PATIENT_REGISTER_TIME (format: MM-dd HH:mm): ");
            try {
                return DateUtil.fromStringToDate(input);
            } catch (ParseException e) {
                System.out.println("Invalid date format: " + e.getMessage());
            }
        }
    }

    private static Profession chooseProfession() {
        MedicalCenterCom.printProfession();
        while (true) {
            String input = prompt("Enter profession: ").toUpperCase();
            try {
                return Profession.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid profession. Try again.");
            }
        }
    }

    private static boolean shutdown() {
        System.out.println("Medical center is now closed.");
        return false;
    }

    private static String prompt(String message) {
        System.out.print(message);
        String input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.print("Nothing entered. Try again: ");
            input = scanner.nextLine().trim();
        }
        return input;
    }

    private static String getUniqueInput(String message, Predicate<String> existsCheck, String errorMessage) {
        String input = prompt(message);
        while (existsCheck.test(input)) {
            input = prompt(errorMessage);
        }
        return input;
    }

    private static String getExistingDoctorId() {
        String id = prompt("Enter DOCTOR_ID: ");
        while (personStorage.checkId(id, false)) {
            id = prompt("No such ID. Try again: ");
        }
        return id;
    }
}