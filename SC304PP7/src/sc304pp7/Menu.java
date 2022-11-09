package sc304pp7;

import javax.swing.JOptionPane;


public class Menu {
    ListaDC l = new ListaDC();
    int op = 0;
    int id = 0;
    
    public void menu() {
        op = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese una opcion\n"
                + "\n1. Agregar persona"
                + "\n2. Mostrar"
                + "\n3. Verificar existencia"
                + "\n4. Modificar nombre"
                + "\n5. Eliminar persona"
                + "\n6. Extraer persona"
                + "\n7. Salir"));
        
        switch(op) {
            case 1 -> {
                l.agregar();
                menu();
                break;
            }
            
            
            case 2 -> {
                l.mostrarElementos();
                menu();
                break;
            }
            
            case 3 -> {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un id para verificar"));
                JOptionPane.showMessageDialog(null, "Resultado de la busqueda: " + l.existe(id));
                menu();
                break;
            }
            
            case 4 -> {
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
            
            case 5 -> {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un id para eliminar"));
                l.elimina(id);
                menu();
                break;
            }
            
            case 6 -> {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un id para extraer"));
                JOptionPane.showMessageDialog(null, "Extraido: " + l.extrae(id).getNombre());
                menu();
                break;
            }
            
            case 7 -> {
                System.exit(0);
            }
        }
    }
    
}
