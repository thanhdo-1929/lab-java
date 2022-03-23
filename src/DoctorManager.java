
import java.util.ArrayList;

public class DoctorManager {

    private ArrayList<Doctor> doctorList = new ArrayList<Doctor>();

    /**
     * Get List doctor
     *
     * @return doctorList
     */
    public ArrayList<Doctor> getDoctorlist() {
        return doctorList;
    }

    /**
     * function add list Doctor
     *
     * @param newDoctor
     * @return true|| false
     */
    public boolean addDoctor(Doctor newDoctor) {
        //check newDoctor null or not
        if (newDoctor != null) {
            doctorList.add(newDoctor);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Delete a doctor with index input
     *
     * @param index
     * @return true|| false
     */
    public boolean deleteIndexDoctor(int index) {
        //check index
        if (index >= 0) {
            doctorList.remove(index);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Search a doctor with code input
     *
     * @param searchText
     */
    public ArrayList<Doctor> searchDoctor(String searchText) {
        ArrayList<Doctor> listResultSearch = new ArrayList<>();
        //loop from the first to the last of element in array
        for (Doctor doctor : doctorList) {
            //check code doctor if exizt
            if (doctor.getCode().toLowerCase().contains(searchText.toLowerCase())) {
                listResultSearch.add(doctor);
            }
        }
        //loop from the first to the last of element in array
        if (listResultSearch.size() > 0) {
            return listResultSearch;
        } else {
            return null;
        }
    }

    /**
     * Function update doctor's information
     *
     * @param newDoctor
     */
    public boolean updateDoctor(int index, Doctor updatedDoctor) {
        //check new Doctor null or not
        if (index > 0) {
            Doctor oldDoctor = doctorList.get(index);
            doctorList.set(index, updatedDoctor);
            return true;
        } else {
            return false;
        }

    }
}
