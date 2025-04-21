package views;
import java.util.Scanner;

public class ShowConsole {
    private Scanner scanner;

    public ShowConsole() {
        this.scanner = new Scanner(System.in);
    }

    public void showBanner() {System.out.println("*** Metodo de Busqueda Binaria ***");}

    public void showMessage(String message) {System.out.println(message);}

    public int inputInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
    
    public String inputString(String message) {
        System.out.print(message);
        return scanner.next();
    }
}
