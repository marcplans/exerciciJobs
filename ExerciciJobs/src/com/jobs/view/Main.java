package com.jobs.view;

import com.jobs.application.JobsController;

public class Main {

	private static JobsController controller = new JobsController();

	public static void main(String[] args) {

		try {
			controller.createBossEmployee("Joan Pou",
				"c. Muntaner, 17. Barcelona", "635741289", 2500.0);
			controller.createEmployee("Pedro Garcia",
				"c. Balmes, 259. Barcelona", "665266714", 1500.0);
			controller.createEmployee("Laura Green",
				"c. Roger de Flor, 327. Barcelona", "625287945",
				1600.0);
			controller.createVolunteer("Victor Llorca",
				"c. Torrent de l'Olla, 27. Barcelona", "614266841");
			controller.createManagerEmployee("Maria Font",
				"c. Roure, 7. Sabadell", "659874232", 2200.0);
			controller.createEmployee("Robert Torres",
				"c. Camarassa, 3. Badalona", "654598321", 1700.0);
			controller.createEmployee("Anna Bou",
				"c. Barcelona, 98. Terrassa", "698332177", 1600.0);
			controller.createEmployee("Cristina Fuentes",
				"c. Consell de Cent, 155. Barcelona", "654879544",
				1200.0);
			controller.createVolunteer("Max Sabater",
				"c. Tarragona, 86. Barcelona", "699332157");
			controller.createVolunteer("Ramon Portales",
				"c. Marina, 175. Barcelona", "687645321");
			controller.createManagerEmployee("Alex Ramallets",
				"c. Valencia, 233. Barcelona", "654879921", 2000.0);
		} catch (Exception e) {
			System.out.println("Error!");
			System.out.println(e.getMessage());
		}

		controller.payAllEmployeers();

		System.out.println("EMPLOYEES: \n" 
			+ controller.getAllEmployees() + "\n\n");
		
		
		// Uncomment to print alternative listings
		
//		System.out.println("VOLUNTEERS: \n" 
//			+ controller.getVolunteers() + "\n\n");
//		System.out.println("PAID EMPLOYEES: \n"
//			+ controller.getPaidEmployees() + "\n\n");
//		System.out.println("BASIC PAID EMPLOYEES: \n"
//			+ controller.getBasicEmployees() + "\n\n");
//		System.out.println("MANAGERS: \n" 
//			+ controller.getManagers() + "\n\n");
//		System.out.println("BOSSES: \n" 
//			+ controller.getBosses() + "\n\n");	
	}

}
