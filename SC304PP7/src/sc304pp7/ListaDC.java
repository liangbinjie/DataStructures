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
    
    public void mostrarElementos() {
        String s = "";
        if (!vacia()) {
            Nodo aux = inicio;
            s += "Nombre: " + aux.getDato().getNombre() + " | ID: " + aux.getDato().getId() + "\n+\n";
            aux = aux.getSiguiente();
            while (aux!=inicio) {
                s += "Nombre: " + aux.getDato().getNombre() + " | ID: " + aux.getDato().getId() + "\n+\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La lista contiene: \n\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }

    public boolean existe(int id) {
        boolean esta = false;
        Nodo aux = inicio;
        if (aux.getDato().getId() == id) {
            esta = true;
        }
        aux = aux.getSiguiente();
        while (aux!=inicio) {
            if (aux.getDato().getId() == id) {
                esta = true;
            }
            aux = aux.getSiguiente();
        }
        
        return esta;
    }
    
    public void modifica(Persona p) {
        Nodo aux = inicio;
        if (aux.getDato().getId() == p.getId()) {
            inicio.setDato(p);
        }
        aux = aux.getSiguiente();
        while (aux!=inicio && aux.getDato().getId() != p.getId()) {
            aux = aux.getSiguiente();
        }
        
        aux.setDato(p);
    }
    
    public void elimina(int id) {
        if (!vacia()) {
            if (id == inicio.getDato().getId()) { // si es igual al primer nodo
                inicio = inicio.getSiguiente();
                fin.setSiguiente(inicio);
            }
            else if (id == fin.getDato().getId()) { // si es igual al ultimo
                fin.setSiguiente(inicio);
                fin = fin.getSiguiente();
                fin.setSiguiente(inicio);
                inicio.setAnterior(fin);
            }
            else {
                Nodo anterior;
                Nodo aux;
                anterior = inicio;
                aux = inicio.getSiguiente();
                while ((aux != inicio) && (aux.getDato().getId() != id)) {
                    anterior = anterior.getSiguiente();
                    aux.getSiguiente();
                }
                
                if (aux!=inicio) {
                    anterior.setSiguiente(aux.getSiguiente());
                    fin.setSiguiente(inicio);
                    JOptionPane.showMessageDialog(null, "Elemento eliminado");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista vacia");
        }
    }
        
    public Persona extrae(int id) {
        Persona p = new Persona();
        if (!vacia()) {
            if (id == inicio.getDato().getId()) { // si es igual al primer nodo
                p.setId(id);
                p.setNombre(inicio.getDato().getNombre());
                inicio = inicio.getSiguiente();
                fin.setSiguiente(inicio);
            }
            else if (id == fin.getDato().getId()) { // si es igual al ultimo
                p.setId(id);
                p.setNombre(inicio.getDato().getNombre());
                fin.setSiguiente(inicio);
                fin = fin.getSiguiente();
                fin.setSiguiente(inicio);
                inicio.setAnterior(fin);
            }
            else {
                Nodo anterior;
                Nodo aux;
                anterior = inicio;
                aux = inicio.getSiguiente();
                while ((aux != inicio) && (aux.getDato().getId() != id)) {
                    anterior = anterior.getSiguiente();
                    aux.getSiguiente();
                }
                
                if (aux!=inicio) {
                    p.setId(id);
                    p.setNombre(inicio.getDato().getNombre());
                    anterior.setSiguiente(aux.getSiguiente());
                    fin.setSiguiente(inicio);
                    JOptionPane.showMessageDialog(null, "Elemento eliminado");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista vacia");
        }
        
        
        return p;
    }
}
