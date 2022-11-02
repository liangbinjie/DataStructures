package sc304pp7;

import javax.swing.JOptionPane;

public class ListaDC {
    private Nodo inicio, fin;
    
    public ListaDC() {
        this.inicio = null;
        this.fin = null;
    }
    
    public boolean vacia() {
        return (inicio==null);
    }
    
    public void agregar() {
        Persona p = new Persona();
        
        p.setId(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id de la persona")));
        p.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre de la persona"));
        
        Nodo nuevo = new Nodo();
        nuevo.setDato(p);
        
        if (vacia()) {
            inicio = nuevo;
            fin = nuevo;
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else if (p.getId() < inicio.getDato().getId()) { // si el id de la persona es menor que el inicio
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else if (p.getId() > inicio.getDato().getId()) { // si el id de la persona es mayor que el inicio
            fin.setSiguiente(nuevo);
            fin = fin.getSiguiente();
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else {
            Nodo aux = inicio;
            while (aux.getSiguiente().getDato().getId() < p.getId()) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            nuevo.setAnterior(aux);
            aux.setSiguiente(nuevo);
            nuevo.getSiguiente().setAnterior(nuevo);
        }
    }
    
    public void extraer() {
        if (!vacia()) {
            inicio = inicio.getSiguiente();
            fin.setSiguiente(inicio);
            JOptionPane.showMessageDialog(null, "Elemento extraido");
        } else {
            JOptionPane.showMessageDialog(null, "Lista vacia");
        }
    }
    
    public void mostrarElementos() {
        String s = "";
        Nodo aux = inicio;
        s += "Nombre: " + aux.getDato().getNombre() + " | ID: " + aux.getDato().getId() + "<=>";
        aux = aux.getSiguiente();
        while (aux!=inicio) {
            s += "Nombre: " + aux.getDato().getNombre() + " | ID: " + aux.getDato().getId() + "<=>";
            aux = aux.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, "La lista contiene: \n" + s);
    }
}
