import java.util.Arrays;

import controllers.BusquedaBinaria;
import models.Person;
import views.ShowConsole;

public class App {
    public static void main(String[] args) throws Exception {
        boolean exit = false;
        Person[] peopleModel = new Person[] {};
        ShowConsole show = new ShowConsole();
        show.showBanner();
        BusquedaBinaria busqueda;
        while (!exit) {
            Person[] people = peopleModel.clone();
            show.showMessage("1) Nueva Persona");
            show.showMessage("2) Buscar Persona");
            show.showMessage("3) Salir");
            int option = show.inputInt("Seleccionar opcion => ");
            switch (option) {
                case 1:
                    show.showMessage("Ingresar Persona");
                    peopleModel = Arrays.copyOf(people, people.length+1);
                    while (true) {
                        int edad = show.inputInt("Edad: ");
                        if (edad>-1) {
                            peopleModel[peopleModel.length-1] = new Person(edad, show.inputString("Nombre: "));
                            show.showMessage("Persona Ingresada");
                            break;
                        } else show.showMessage("(Edad No Valida)");
                    }
                    break;
                case 2:
                    if (people.length>0) {
                        busqueda = new BusquedaBinaria(people);
                        busqueda.showPerson();
                    } else show.showMessage("(No hay personas registrados)");
                case 3:
                    show.showMessage("Shutting Down...");
                default:
                    show.showMessage("(Opcion No Valida)");
                    break;
            }
        }
    }
}
