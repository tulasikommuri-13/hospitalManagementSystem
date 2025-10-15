import java.util.*;

class Patient {
    String name;
    int age;
    String contact;
    String problem;

    Patient(String name, int age, String contact, String problem)
    {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.problem = problem;
    }
}

class Doctor {
    String name;
    String specialization;
    String appointmentDateTime; // Fixed availability

    Doctor(String name, String specialization, String dateTime)
    {
        this.name = name;
        this.specialization = specialization;
        this.appointmentDateTime = dateTime;
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Fixed doctors with availability
        Doctor cardio = new Doctor("Dr. Rao", "Cardiologist", "20 Aug 2025 10:00 AM");
        Doctor genphy = new Doctor("Dr. Meera", "General Physician", "20 Aug 2025 02:00 PM");
        Doctor ortho = new Doctor("Dr. Arun", "Orthopedic", "21 Aug 2025 04:00 PM");

        // Patient details input
        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Contact: ");
        String contact = sc.nextLine();

        System.out.print("Enter Health Problem: ");
        String problem = sc.nextLine();

        Patient p = new Patient(name, age, contact, problem);

        // Doctor assignment based on problem keywords
        Doctor assignedDoctor = null;
        String lowerProblem = problem.toLowerCase();

        if (lowerProblem.contains("heart") || lowerProblem.contains("chest")) {
            assignedDoctor = cardio;
        } else if (lowerProblem.contains("fever") || lowerProblem.contains("cold")) {
            assignedDoctor = genphy;
        } else if (lowerProblem.contains("bone") || lowerProblem.contains("fracture")) {
            assignedDoctor = ortho;
        }

        // Display results
        if (assignedDoctor != null) {
            System.out.println("\n✅ Appointment Scheduled!");
            System.out.println("Patient: " + p.name);
            System.out.println("Doctor: " + assignedDoctor.name + " (" + assignedDoctor.specialization + ")");
            System.out.println("Date & Time: " + assignedDoctor.appointmentDateTime);
        } else {
            System.out.println("\n❌ No doctor available for this health problem.");
        }

        sc.close();
    }
}
