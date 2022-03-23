
import java.util.ArrayList;

public class DoctorViewer {

    private DataInput dataInput = new DataInput();

    /**
     * Check index in array list
     *
     * @param doctorCode
     * @param listDoctor
     * @return i, -1
     */
    public int findDoctorIndex(String doctorCode, ArrayList<Doctor> doctorList) {
        //loop from the first to the last of array list 
        for (int i = 0; i < doctorList.size(); i++) {
            // if code equals code of index i in the listDoctor
            if (doctorList.get(i).getCode().equalsIgnoreCase(doctorCode)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Input information of new doctor
     *
     * @param doctorList
     * @return doctor
     */
    public Doctor inputNewDoctor(ArrayList<Doctor> doctorList) {
        System.out.println("--------- Add Doctor -----------");
        String code;
        //check index
        do {
            code = dataInput.inputStringValue("Enter Code: ", "Code Invalid", "[a-zA-Z0-9 ]+");
            //check the code exizt 
            if (this.findDoctorIndex(code, doctorList) != -1) {
                System.out.println("Doctor code " + code + " is duplicate");
            }
        } while (this.findDoctorIndex(code, doctorList) != -1);
        String name = dataInput.inputStringValue("Enter Name: ", "Name Invalid", "[a-zA-Z ]+");
        String specialization = dataInput.inputStringValue("Enter specialization: ", "Specialization Invalid", "[a-zA-Z ]+");
        int availability = dataInput.inputIntValue("Enter Availability: ", "Availability Invalid", 1, Integer.MAX_VALUE);
        Doctor doctor = new Doctor(code, name, specialization, availability);
        return doctor;
    }

    /**
     * Input information of new doctor
     *
     * @return doctor
     */
    public Doctor inputUpdateDoctor(Doctor updatedDoctor) {
        String name = dataInput.inputStringValue("Enter Name: ", "Name Invalid", "[a-zA-Z ]+");
        updatedDoctor.setName(name);
        String specialization = dataInput.inputStringValue("Enter specialization: ", "Specialization Invalid", "[a-zA-Z ]+");
        updatedDoctor.setSpecialization(specialization);
        int availability = dataInput.inputIntValue("Enter Availability: ", "Availability Invalid", 1, Integer.MAX_VALUE);
        updatedDoctor.setAvailability(availability);
        return updatedDoctor;
    }

    /**
     * Input option
     *
     * @return option
     */
    public int inputOption() {
        int option = dataInput.inputIntValue("Enter option: ", "Option[1-5],Try Again", 0, 6);
        return option;
    }

    /**
     * Input index
     *
     * @return index
     */
    public int inputIndexDoctor(ArrayList<Doctor> doctorList) {
        String code;
        do {
            code = dataInput.inputStringValue("Enter Code: ", "Code Invalid", "[a-zA-Z0-9 ]+");
            //check the code exizt 
            if (this.findDoctorIndex(code, doctorList) == -1) {
                System.out.println("Doctor code " + code + " does not exist Doctor");
            }
        } while (this.findDoctorIndex(code, doctorList) == -1);
        int index = this.findDoctorIndex(code, doctorList);
        return index;
    }

    /**
     * input search value
     *
     * @return code
     */
    public String inputSearchValue() {
        System.out.println("--------- Search ------------");
        String code;
        code = dataInput.inputStringNoRegexValue("Enter Code: ", "Code Invalid");
        //check input string
        return code.trim();
    }

    /**
     * Display the array list
     *
     * @param listDoctor
     */
    void displayDoctor(ArrayList<Doctor> listDoctor) {
        System.out.println("--------- List Doctor ------------");
        System.out.format("%20s%20s%20s%20s\n", "Code", "Name", "Specialization", "Availability");
        for (Doctor doctor : listDoctor) {
            System.out.println(doctor);
        }
    }
}
