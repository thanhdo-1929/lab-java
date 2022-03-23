
public class Main {

    private static DoctorManager doctorManager = new DoctorManager();
    private static DoctorViewer doctorViewer = new DoctorViewer();

    /**
     * Display menu
     */
    private static void showMenu() {
        System.out.println("======= Doctor =======\n"
                + "1. Add Doctor\n"
                + "2. Update Doctor\n"
                + "3. Delete Doctor\n"
                + "4. Search Doctor\n"
                + "5. Exit");
    }

    /**
     * function add
     */
    private static void addDoctor() {
        // input new doctor's information
        Doctor newDoctor = doctorViewer.inputNewDoctor(doctorManager.getDoctorlist());
        //Check add new doctor
        if (doctorManager.addDoctor(newDoctor)) {
            System.out.println("Add Successfully!");
        } else {
            System.out.println("Add Fail!");
        }
    }

    /**
     * function delete
     */
    private static void deleteDoctor() {
        System.out.println("--------- Delete Doctor -------");
        int index = doctorViewer.inputIndexDoctor(doctorManager.getDoctorlist());
        //Check add new doctor
        if (doctorManager.deleteIndexDoctor(index)) {
            System.out.println("Delete Successfully!");
        } else {
            System.out.println("Delete Fail!");
        }
    }

    /**
     * function search
     */
    private static void searchDoctor() {
        String code = doctorViewer.inputSearchValue();
        //Check add new doctor
        if (doctorManager.searchDoctor(code) != null) {
            for (Doctor doctor : doctorManager.searchDoctor(code)) {
                System.out.println(doctor);
            }
        } else {
            System.out.println("No Result!");
        }
    }

    /**
     * function update
     */
    private static void updateDoctor() {
        System.out.println("--------- Update Doctor -----------");
        // get index of old Doctor
        int index = doctorViewer.inputIndexDoctor(doctorManager.getDoctorlist());
        // input new doctor's information
        Doctor newDoctor = doctorViewer.inputUpdateDoctor(doctorManager.getDoctorlist().get(index));
        //Check add new doctor
        if (doctorManager.updateDoctor(index, newDoctor)) {
            System.out.println("Update Successfully!");
        } else {
            System.out.println("Update Successfully!");
        }
    }

    public static void main(String[] args) {
        while (true) {
            showMenu();
            doctorViewer.displayDoctor(doctorManager.getDoctorlist());
            int option = doctorViewer.inputOption();
            switch (option) {
                case 1:
                    doctorViewer.displayDoctor(doctorManager.getDoctorlist());
                    addDoctor();
                    break;
                case 2:
                    doctorViewer.displayDoctor(doctorManager.getDoctorlist());
                    updateDoctor();
                    break;
                case 3:
                    doctorViewer.displayDoctor(doctorManager.getDoctorlist());
                    deleteDoctor();
                    break;
                case 4:
                    doctorViewer.displayDoctor(doctorManager.getDoctorlist());
                    searchDoctor();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

}
