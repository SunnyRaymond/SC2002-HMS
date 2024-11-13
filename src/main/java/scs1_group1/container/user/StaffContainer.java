package scs1_group1.container.user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import scs1_group1.user.Administrator;
import scs1_group1.user.Doctor;
import scs1_group1.user.Pharmacist;
import scs1_group1.user.Staff;

public class StaffContainer extends UserContainer {

    public StaffContainer(String filePath, String userType) {
        super();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true; // Flag to skip the header line

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip the first line (header)
                    continue;
                }

                String[] fields = line.split(",");
                String staffId = fields[0].trim();       // "Staff ID"
                String password = fields[1].trim();      // "Password"
                String name = fields[2].trim();          // "Name"
                String rowUserType = fields[3].trim();   // "Role"
                String gender = fields[4].trim();        // "Gender"
                int age = Integer.parseInt(fields[5].trim()); // "Age"
                
                // Create and add the correct subclass based on role type
                if (rowUserType.equalsIgnoreCase("Doctor")) {
                    putUser(new Doctor(staffId, password, name, gender, rowUserType, "", age));
                } else if (rowUserType.equalsIgnoreCase("Pharmacist")) {
                    putUser(new Pharmacist(staffId, password, name, gender, rowUserType, "", age));
                } else if (rowUserType.equalsIgnoreCase("Administrator")) {
                    putUser(new Administrator(staffId, password, name, gender, rowUserType, "", age));
                } else {
                    System.out.println("Skipping unrecognized role: " + rowUserType);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStaff(String staffId, String password, String name, String gender, String userType, String email, int age) {
        if (userType.equalsIgnoreCase("Doctor")) {
            putUser(new Doctor(staffId, password, name, gender, userType, email, age));
        } else if (userType.equalsIgnoreCase("Pharmacist")) {
            putUser(new Pharmacist(staffId, password, name, gender, userType, email, age));
        } else if (userType.equalsIgnoreCase("Administrator")) {
            putUser(new Administrator(staffId, password, name, gender, userType, email, age));
        } else {
        }
    }

    // Export all staff (Doctors, Pharmacists, Administrators) to a single CSV file
    public void exportStaffToCSV(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Write header
            writer.write("Staff ID,Password,Name,Role,Gender,Age\n");

            // Export Doctors
            List<Staff> doctors = getAllUsersByUserType("Doctor").values().stream()
                .map(user -> (Staff) user)
                .collect(Collectors.toList());
            for (Staff doctor : doctors) {
                writeStaffToCSV(writer, doctor, "Doctor");
            }

            // Export Pharmacists
            List<Staff> pharmacists = getAllUsersByUserType("Pharmacist").values().stream()
                .map(user -> (Staff) user)
                .collect(Collectors.toList());
            for (Staff pharmacist : pharmacists) {
                writeStaffToCSV(writer, pharmacist, "Pharmacist");
            }

            // Export Administrators
            List<Staff> administrators = getAllUsersByUserType("Administrator").values().stream()
                .map(user -> (Staff) user)
                .collect(Collectors.toList());
            for (Staff admin : administrators) {
                writeStaffToCSV(writer, admin, "Administrator");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to write individual staff entries to CSV
    private void writeStaffToCSV(FileWriter writer, Staff staff, String role) throws IOException {
        writer.write(
            String.format(
                "%s,%s,%s,%s,%s,%d\n",
                staff.getHospitalId(),
                staff.getPassword(),
                staff.getName(),
                role,
                staff.getGender(),
                staff.getAge()
            )
        );
    }

}