package scs1_group1.menu;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import scs1_group1.container.Container;
import scs1_group1.container.data.AppointmentContainer;
import scs1_group1.container.data.AppointmentOutcomeRecordContainer;
import scs1_group1.container.data.MedicineContainer;
import scs1_group1.container.data.ReplenishmentRequestContainer;
import scs1_group1.container.user.AdministratorContainer;
import scs1_group1.container.user.DoctorContainer;
import scs1_group1.container.user.PatientContainer;
import scs1_group1.container.user.PharmacistContainer;
import scs1_group1.container.user.UserContainer;

/**
 * The StartMenu class represents the main entry point for users accessing the hospital management system.
 * It provides options to log in as different types of users or to quit the application.
 */
public class StartMenu extends Menu {
    HashMap<String,Container> containers;

    /**
     * Constructs a StartMenu instance with the specified containers.
     *
     * @param containers The HashMap of containers representing various user and data storage containers.
     */
    public StartMenu(HashMap<String,Container> containers) {
        this.containers=containers;
    }
    @Override
public void run() {
    String HMS_LOGO =
        "                                                                          \n" +
        "HHHHHHHHH     HHHHHHHHHMMMMMMMM               MMMMMMMM   SSSSSSSSSSSSSSS \n" +
        "H:::::::H     H:::::::HM:::::::M             M:::::::M SS:::::::::::::::S\n" +
        "H:::::::H     H:::::::HM::::::::M           M::::::::MS:::::SSSSSS::::::S\n" +
        "HH::::::H     H::::::HHM:::::::::M         M:::::::::MS:::::S     SSSSSSS\n" +
        "  H:::::H     H:::::H  M::::::::::M       M::::::::::MS:::::S            \n" +
        "  H:::::H     H:::::H  M:::::::::::M     M:::::::::::MS:::::S            \n" +
        "  H::::::HHHHH::::::H  M:::::::M::::M   M::::M:::::::M S::::SSSS         \n" +
        "  H:::::::::::::::::H  M::::::M M::::M M::::M M::::::M  SS::::::SSSSS    \n" +
        "  H:::::::::::::::::H  M::::::M  M::::M::::M  M::::::M    SSS::::::::SS  \n" +
        "  H::::::HHHHH::::::H  M::::::M   M:::::::M   M::::::M       SSSSSS::::S \n" +
        "  H:::::H     H:::::H  M::::::M    M:::::M    M::::::M            S:::::S\n" +
        "  H:::::H     H:::::H  M::::::M     MMMMM     M::::::M            S:::::S\n" +
        "HH::::::H     H::::::HHM::::::M               M::::::MSSSSSSS     S:::::S\n" +
        "H:::::::H     H:::::::HM::::::M               M::::::MS::::::SSSSSS:::::S\n" +
        "H:::::::H     H:::::::HM::::::M               M::::::MS:::::::::::::::SS \n" +
        "HHHHHHHHH     HHHHHHHHHMMMMMMMM               MMMMMMMM SSSSSSSSSSSSSSS   \n" +
        "                                                                          \n";

        String GOODBYE_LOGO =
        "  ███████████████████████████████████████████████████████████████████████████████████████   \n" +
        "  ██                                                                                   ██   \n" +
        "  ██  ██████  ██████  ██████    ██      ██████  ██████  ██████  ██  ██  ██████    ██   ██   \n" +
        "  ██  ██      ██      ██        ██      ██      ██  ██  ██  ██  ██  ██  ██  ██    ██   ██   \n" +
        "  ██  ██████  ██      ██████    ██      ██  ██  ██████  ██  ██  ██  ██  ██████    ██   ██   \n" +
        "  ██      ██  ██          ██    ██      ██  ██  ██  ██  ██  ██  ██  ██  ██        ██   ██   \n" +
        "  ██  ██████  ██████  ██████    ██      ██████  ██  ██  ██████  ██████  ██        ██   ██   \n" +
        "  ██                                                                                   ██   \n" +
        "  ███████████████████████████████████████████████████████████████████████████████████████   \n" +
        "                                                                                            \n" +
        "                ██████████████████                                                          \n" +
        "            ████                  ████                                                     \n" +
        "          ██                          ██                                                   \n" +
        "          ██                          ██                                                   \n" +
        "        ████                          ████                                                 \n" +
        "    ██  ██  ████                        ██                                                 \n" +
        "    ████████████████          ██████    ██                                                 \n" +
        "  ████████████████████        ██████    ██                                                 \n" +
        "      ██████  ██████    ██    ██████    ██                                                 \n" +
        "        ████  ██      ██████          ██                                                   \n" +
        "        ████  ██                  ██  ████        ████████                      ██  ██     \n" +
        "        ██    ██████████████████████    ██        ██                            ██  ██     \n" +
        "        ██      ██  ██  ██  ██  ██      ██        ██  ████  ██████  ██████  ██████  ██████  ██  ██  ██████  \n" +
        "        ██████    ██████████████    ██████        ██    ██  ██  ██  ██  ██  ██  ██  ██  ██  ██  ██  ██  ██  \n" +
        "      ████████████      ██  ██  ████████████      ████████  ██████  ██████  ██████  ██████  ██████  ██████  \n" +
        "    ████████████████████████████████████████                                                    ██  ██      \n" +
        "      ██████████████████████████████████  ██      ████████████████████████████████████████  ██████  ██████    ██  ██  ██  \n" +
        "    ████  ██  ████████████████████    ██  ████                                               \n" +
        "    ██      ████████    ██    ██    ██      ████                                           \n" +
        "  ██    ████  ██████████      ██████  ████  ████                                           \n" +
        "  ██        ██    ████████  ████    ██        ████                                         \n" +
        "  ██          ██  ██    ████  ██  ██          ██                                           \n" +
        "    ██      ██    ████████████████  ██      ██                                             \n" +
        "      ████  ██    ██████████████    ██  ████                                               \n" +
        "        ██████    ██████████████    ██████                                                 \n" +
        "        ██████████████████████████████████                                                 \n" +
        "      ██████████████████████████████████████                                               \n" +
        "      ██████████████████  ██████████████████                                               \n" +
        "        ██████████████      ██████████████                                                 \n" +
        "    ██████          ██      ██          ██████                                             \n" +
        "    ██            ████      ████            ██                                             \n" +
        "      ████████████              ████████████                                             \n";


    Scanner sc = new Scanner(System.in);
    
    int choice;
    do {
        System.out.println(HMS_LOGO);
        System.out.println("----------------------------------------");
        System.out.println("Hospital Start Menu");
        System.out.println("0. Quit");
        System.out.println("1. Log in");
        System.out.print("Enter your choice: ");
        
        // Use try-catch to handle invalid input
        try {
            choice = sc.nextInt();
            
            switch (choice) {
                case 0:
                    System.out.println("Quitting...");
                    break;
                case 1:
                    System.out.print("Enter hospital ID: ");
                    String hospitalId = sc.next();
                    System.out.print("Enter password: ");
                    String password = sc.next();
                    Menu userMenu = createUserMenu(hospitalId, password);
                    if (userMenu != null) {
                        userMenu.run();
                    } else {
                        System.out.println("Wrong hospital ID or wrong password");
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid answer! Please enter a number.");
            sc.nextLine(); // Clear the invalid input from the scanner buffer
            choice = -1; // Set choice to a non-exiting value to continue the loop
        }
        System.out.println(GOODBYE_LOGO);
    } while (choice != 0);
    
}

    /**
     * Creates and returns a user-specific menu based on the given hospital ID and password.
     *
     * @param hospitalId The hospital ID of the user attempting to log in.
     * @param password   The password of the user.
     * @return A Menu object for the logged-in user, or null if the login fails.
     */
    public Menu createUserMenu(String hospitalId,String password) {
        PatientContainer patientContainer = (PatientContainer)(containers.get("Patient"));
        DoctorContainer doctorContainer = (DoctorContainer)(containers.get("Doctor"));
        PharmacistContainer pharmacistContainer = (PharmacistContainer)(containers.get("Pharmacist"));
        AdministratorContainer administratorContainer = (AdministratorContainer)(containers.get("Administrator"));
        AppointmentContainer appointmentContainer = (AppointmentContainer)(containers.get("Appointment"));
        AppointmentOutcomeRecordContainer appointmentOutcomeRecordContainer = (AppointmentOutcomeRecordContainer)(containers.get("AppointmentOutcomeRecord"));
        MedicineContainer medicineContainer = (MedicineContainer)(containers.get("Medicine"));
        ReplenishmentRequestContainer replenishmentRequestContainer = (ReplenishmentRequestContainer)(containers.get("ReplenishmentRequest"));

        /*//put some sample appointments for testing
        appointmentContainer.addAppointment("2021-10-01 10:00", "P1001", "D001");
        appointmentContainer.addAppointment("2021-10-01 11:00", "P1002", "D002");
        appointmentContainer.addAppointment("2021-10-01 14:00", "P1003", "d001");*/

        if (patientContainer.containsUser(hospitalId)&&patientContainer.getUserTypeByHospitalId(hospitalId).equals("Patient")){ 
            String correctPassword=patientContainer.getUserByHospitalId(hospitalId).getPassword();
            if (password.equals(correctPassword)) {
                if (password.equals("password")) {
                    promptPasswordChange(patientContainer, hospitalId);  // Prompt to change default password
                }
                return new PatientMenu(
                    hospitalId,
                    patientContainer,
                    doctorContainer,
                    appointmentContainer,
                    appointmentOutcomeRecordContainer
                );
            } else return null;
        } else if (doctorContainer.containsUser(hospitalId)&&doctorContainer.getUserTypeByHospitalId(hospitalId).equals("Doctor")){
            String correctPassword=doctorContainer.getUserByHospitalId(hospitalId).getPassword();
            if (password.equals(correctPassword)) {
                if (password.equals("password")) {
                    promptPasswordChange(doctorContainer, hospitalId);  // Prompt to change default password
                }
                return new DoctorMenu(
                    hospitalId,
                    doctorContainer,
                    patientContainer,
                    appointmentContainer,
                    appointmentOutcomeRecordContainer,
                    medicineContainer
                );
            } else return null;
        } else if (pharmacistContainer.containsUser(hospitalId)&&pharmacistContainer.getUserTypeByHospitalId(hospitalId).equals("Pharmacist")){
            String correctPassword=pharmacistContainer.getUserByHospitalId(hospitalId).getPassword();
            if (password.equals(correctPassword)) {
                if (password.equals("password")) {
                    promptPasswordChange(pharmacistContainer, hospitalId);  // Prompt to change default password
                }
                return new PharmacistMenu(
                    hospitalId,
                    appointmentOutcomeRecordContainer,
                    medicineContainer,
                    replenishmentRequestContainer
                );
            } else return null;
        } else if (administratorContainer.containsUser(hospitalId)&&administratorContainer.getUserTypeByHospitalId(hospitalId).equals("Administrator")){
            String correctPassword=administratorContainer.getUserByHospitalId(hospitalId).getPassword();
            if (password.equals(correctPassword)) {
                if (password.equals("password")) {
                    promptPasswordChange(administratorContainer, hospitalId);  // Prompt to change default password
                }
                return new AdministratorMenu(
                    hospitalId,
                    administratorContainer,
                    patientContainer,
                    doctorContainer,
                    pharmacistContainer,
                    medicineContainer,
                    replenishmentRequestContainer,
                    appointmentContainer
                );
            } else return null;
        }
        return null;
    }  
    

    /**
     * Prompts the user to change their default password.
     *
     * @param userContainer The container storing user information.
     * @param hospitalId    The hospital ID of the user.
     */
    private void promptPasswordChange(UserContainer userContainer, String hospitalId) {
        Scanner sc = new Scanner(System.in);
        System.out.println("You are using the default password. Please change it for security.");
        /*String newPassword;
    
        while (true) {
            System.out.print("Enter new password: ");
            newPassword = sc.nextLine();
    
            // Check if the new password meets complexity requirements
            if (!isPasswordComplex(newPassword)) {
                System.out.println("Password must be 6-20 characters and contain at least one digit, one lowercase, and one uppercase letter.");
                continue;
            }
    
            System.out.print("Confirm new password: ");
            String confirmPassword = sc.nextLine();
    
            if (newPassword.equals(confirmPassword)) {
                userContainer.getUserByHospitalId(hospitalId).setPassword(newPassword);
                System.out.println("Password changed successfully.");
                break;
            } else {
                System.out.println("Passwords do not match. Please try again.");
            }
        }*/
    }
    
    
    /**
     * Checks if the given password meets complexity requirements.
     *
     * @param password The password to be checked.
     * @return true if the password meets the complexity requirements, otherwise false.
     */
    private boolean isPasswordComplex(String password) {
        if (password.length() < 6 || password.length() > 20) {
            return false;
        }
        boolean hasUpper = false, hasLower = false, hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
        }
        return hasUpper && hasLower && hasDigit;
    }
    
}
