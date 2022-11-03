package sc304pp7;

import javax.swing.JOptionPane;


public class Menu {
    ListaDC l = new ListaDC();
    int op = 0;
    int id = 0;
    
    public void menu() {
        op = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese una opcion\n"
                + "\n1. Agregar persona"
                + "\n2. Extraer"
                + "\n3. Mostrar"
                + "\n4. Verificar existencia"
                + "\n5. Modificar nombre"
                + "\n6. Eliminar persona"
                + "\n7. Extraer persona"
                + "\n8. Salir"));
        
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
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un id para verificar"));
                JOptionPane.showMessageDialog(null, "Resultado de la busqueda: " + l.existe(id));
                menu();
                break;
            }
            
            case 5 -> {
                Persona p = new Persona();
                p.setId(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un id para verificar")));
                if (l.existe(p.getId())) {
                    p.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre de la persona"));
                    l.modifica(p);
                } else {
                    JOptionPane.showMessageDialog(null, "La persona no existe");
                }
                menu();
                break;
            }
            
            case 6 -> {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un id para verificar"));
                l.elimina(id);
                menu();
                break;
            }
            
            case 7 -> {
                // extraer
            }
            
            case 8 -> {
                System.exit(0);
            }
        }
    }
    
}
