package arboles;

import javax.swing.JOptionPane;

public class Arbol {
    private Nodo raiz;
    
    public Arbol() {
        this.raiz = null;
    }
    
    public boolean vacio() {
        return (raiz == null);
    }
    
    public void crearNodo(Nodo raiz, Nodo nuevo) {
        if (nuevo.getElemento().getNumero() <= raiz.getElemento().getNumero()) {
            if (raiz.getHijoIzq() == null) {
                raiz.setHijoIzq(nuevo);
            } else {
                crearNodo(raiz.getHijoIzq(), nuevo);
            }
        } else {
            if (raiz.getHijoDer() == null) {
                raiz.setHijoDer(nuevo);
            } else {
                crearNodo(raiz.getHijoDer(), nuevo);
            }
        }
    }
    
    public void crearRaiz() {
        Dato d = new Dato();
        d.setNumero(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un numero")));
        
        Nodo nuevo = new Nodo();
        nuevo.setElemento(d);
        
        if (vacio()) {
            raiz = nuevo;
        } else {
            crearNodo(raiz, nuevo);
        }
    }
    
    public void mostrarNodo(Nodo n) {
        if (n!=null) {
            mostrarNodo(n.getHijoIzq());
            System.out.println(n.getElemento().getNumero()+" ");
            mostrarNodo(n.getHijoDer());
        }
    }
    
    public void mostrarRaiz() {
        if (!vacio()) {
            mostrarNodo(raiz);
        } else {
            System.out.println("No se puede mostrar, arbol vacio");
        }
    }
    
    private void preorden(Nodo n) {
        if (n!=null) {
            System.out.println(n.getElemento().getNumero() + " ");
            mostrarNodo(n.getHijoIzq());
            mostrarNodo(n.getHijoDer());
        }
    }
    
    public void preorden() {
        this.preorden(this.raiz);
    }
    
    private void inorden(Nodo n) {
        if (n != null) {
            mostrarNodo(n.getHijoIzq());
            System.out.println(n.getElemento().getNumero() + " ");
            mostrarNodo(n.getHijoDer());
        }
    }
    
    public void inorden() {
        this.inorden(this.raiz);
    }
    
    private void postorden(Nodo n) {
        if (n!=null) {
            mostrarNodo(n.getHijoIzq());
            mostrarNodo(n.getHijoDer());
            System.out.println(n.getElemento().getNumero() + " ");
        }
    }
    
    public void postorden() {
        this.postorden(this.raiz);
    }
}
