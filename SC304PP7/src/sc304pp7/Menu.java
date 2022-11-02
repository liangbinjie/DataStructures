package sc304pp7;

import javax.swing.JOptionPane;


public class Menu {
    ListaDC l = new ListaDC();
    int op = 0;
    
    public void menu() {
        op = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese una opcion\n"
                + "\n1. Agregar persona"
                + "\n2. Extraer"
                + "\n3. Mostrar"
                + "\n4. Salir"));
        
        switch(op) {
            case 1 -> {
                l.agregar();
                menu();
                break;
            }
            
            case 2 -> {
                l.extraer();
                menu();
                break;
            }
            
            case 3 -> {
                l.mostrarElementos();
                menu();
                break;
            }
            
            case 4 -> {
                System.exit(0);
            }
        }
    }
    
}
