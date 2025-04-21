package controllers;
import models.Person;
import views.ShowConsole;

public class BusquedaBinaria {
    private Person[] people;
    private ShowConsole screen;

    public BusquedaBinaria(Person[] people) {
        this.people = people;
        screen = new ShowConsole();
    }
    
    private void sortPeople() {
        for(int i = 0; (i+1) < people.length; i++) {
            for(int j = 0; (j+1+i) < people.length; j++) {
                if (people[j].getAge() > people[j+1].getAge()) {
                    Person aux = people[j];
                    people[j] = people[j+1];
                    people[j+1] = aux;
                }
            }
        }
    }

    private int findPerson(int code) {
        int lower = 0;
        int higher = people.length-1;
        while (higher >= lower) {
            printAges(lower, higher);
            int central = (higher + lower) / 2;
            if (people[central].getAge() == code) {
                System.out.println("bajo="+lower+" alto="+higher+" centro="+central+" valorCentro="+people[central].getAge()+" --> ENCONTRADO");
                return central;
            }
            if (people[central].getAge() > code) {
                System.out.println("bajo="+lower+" alto="+higher+" centro="+central+" valorCentro="+people[central].getAge()+" --> IZQUIERDA");
                higher = central-1;
            } else {
                System.out.println("bajo="+lower+" alto="+higher+" centro="+central+" valorCentro="+people[central].getAge()+" --> DERECHA");
                lower = central+1;  
            }
        }
        return -1;
    }

    private void printAges(int lower, int higher) {
        for (int i = lower; i < (higher+1); i++) {
            if (i < higher) System.out.print(people[i].getAge() + " | ");
            else System.out.println(people[i].getAge());
        }
    }

    public void showPerson() {
        sortPeople();
        int age = screen.inputInt("Ingrese la edad a buscar: ");
        int i = findPerson(age);
        if (i>-1) screen.showMessage("La persona con la edad " + age + " es " + people[i].getName());
        else screen.showMessage("(Persona No Encontrada)");
     }
}
