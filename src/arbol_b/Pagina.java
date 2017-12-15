/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_b;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author Diego
 */
public class Pagina {

    Pagina padre;
    LinkedList<Integer> llaves;
    LinkedList<Pagina> hijos;

    public Pagina() {
        padre = null;
        llaves = new LinkedList<>();
        hijos = new LinkedList<>();
    }

    public LinkedList<Integer> getLlaves() {
        return llaves;
    }

    public boolean esRaiz() {
        if (padre == null) {
            return true;
        }
        return false;
    }

    public LinkedList<Pagina> getHijos() {
        return hijos;
    }

    public void agregar_llave(int llave) {
       // System.out.println(llaves.size());
        llaves.add(llave);
        Collections.sort(llaves);
        
//        int size = llaves.size();
//        for (int i = 0; i < size; i++) {
//            if (llave < llaves.get(i)) {
//                llaves.add(i, llave);
//            }
//            System.out.println(i);
//            
//        }
//        llaves.addLast(llave);
    }

    public Pagina getPadre() {
        return padre;
    }

    public void setPadre(Pagina padre) {
        this.padre = padre;
    }

    public boolean esHoja() {
        if (hijos.isEmpty()) {
            return true;
        }
        return false;

    }

    public void setLlaves(LinkedList<Integer> llaves) {
        this.llaves = llaves;
    }

    public void setHijos(LinkedList<Pagina> hijos) {
        this.hijos = hijos;
    }

}
