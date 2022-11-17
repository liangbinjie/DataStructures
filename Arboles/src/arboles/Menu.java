package arboles;

import javax.swing.JOptionPane;


public class Menu {
    Arbol a = new Arbol();
    
    public void menu() {
        int op = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu Principal\n"
                + "1. Agregar Nodo\n"
                + "2. Mostrar nodo\n"
                + "3. Preorden\n"
                + "4. InOrden\n"
                + "5. PostOrden\n"
                + "6. Salir"));
        
        switch(op) {
            case 1:
                a.crearRaiz();
                menu();
                break;
                
            case 2:
                a.mostrarRaiz();
                menu();
                break;
            
            case 3:
                a.preorden();
                menu();
                break;
            case 4:
                a.inorden();
                menu();
                break;
                
            case 5:
                a.postorden();
                menu();
                break;
                
            case 6:
                System.exit(0);
                
            default:
                JOptionPane.showMessageDialog(null, "Error");
                menu();
                
        }
    }
}
