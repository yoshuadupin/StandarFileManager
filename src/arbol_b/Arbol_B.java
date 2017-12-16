package arbol_b;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Diego
 */
public class Arbol_B {

    int llaveSube = 0;
    Pagina nodoBusqueda;
    int orden;
    ArrayList<Pagina> arbol;
    Pagina raiz = null;

    /**
     * @param args the command line arguments
     */
    public Arbol_B(int orden) {
        this.orden = orden;
        arbol = new ArrayList<>();
        // TODO code application logic here
    }

    public boolean insertar(int llave) {
        //Si el arbol esta vacio lo crea una pagina y le agrega la llave
        if (raiz == null) {
            raiz = new Pagina();
            raiz.agregar_llave(llave);
        } else {
            //Busca la pagina adecuada
            Pagina nodo = busqueda_Binaria(llave, raiz);
            if (nodo.getLlaves().size() + 1 == orden) {
                //Si lo que voy agregar excede el limite
                nodo.agregar_llave(llave);
                recursionDivision(nodo);
                // imprimirArbolB(raiz, 0);
            } else {
                //Si hay espacio introduce la llave
                nodo.agregar_llave(llave);
                //imprimirArbolB(raiz, 0);
            }
        }
        return false;

    }

    public boolean eliminar(int llave) {
        //Arbol essta vacio
        if (raiz == null) {
            return false;
        } else {
            Pagina nodo = busquedaNodo(llave, raiz);
            System.out.println("LLave Seleccionada");
            System.out.println(nodo.getLlaves());
            if (nodo.esHoja()) {
                if (nodo.getLlaves().size() - 1 >= orden / 2) {
                    nodo.getLlaves().remove(new Integer(llave));
                    return true;
                } else {
                    nodo.getLlaves().remove(new Integer(llave));
                    balanceoArbol(nodo);
                }
            } else {
                int indice = nodo.getLlaves().indexOf(new Integer(llave));
                int llaveSube = llaveMayor(nodo.getHijos().get(indice));
                nodo.getLlaves().remove(new Integer(llave));
                nodo.agregar_llave(llaveSube);
                Pagina nodoAux = busquedaNodo(llaveSube, nodo.getHijos().get(indice));
                if (nodoAux.getLlaves().size() - 1 >= orden / 2) {
                    nodoAux.getLlaves().remove(new Integer(llaveSube));
                    return true;
                } else {
                    nodoAux.getLlaves().remove(new Integer(llaveSube));
                    balanceoArbol(nodoAux);
                }
                
            }
        }

        return false;
    }

    public Integer llaveMayor(Pagina nodo) {
        if (nodo.esHoja()) {
            return nodo.getLlaves().get(nodo.getLlaves().size() - 1);
        } else {
            return llaveMayor(nodo.getHijos().get(nodo.getHijos().size() - 1));
        }

    }

    public Pagina combinar_Pagina(Pagina pagIzq, Pagina pagDer) {
        Pagina nodo = new Pagina();
        //Combina las llaves
        LinkedList<Integer> llaves = new LinkedList<>();
        llaves.addAll(pagIzq.getLlaves());
        llaves.addAll(pagDer.getLlaves());
        nodo.setLlaves(llaves);
        //Toma el indice de donde esta la llave que se va bajar que es la relacionada
        //Con la pag Izq
        //La saca y la baja
        int indicePadre = pagIzq.getPadre().getHijos().indexOf(pagIzq);
        int llaveBajar = pagIzq.getPadre().getLlaves().get(indicePadre);
        System.out.println("LLAVE QUE BAJA" + llaveBajar);
        nodo.agregar_llave(llaveBajar);
        System.out.println("LLaves COMBINANADAS" + nodo.getLlaves());
        pagIzq.getPadre().getLlaves().remove(new Integer(llaveBajar));

        //Si es nodo hoja no hay que combinar los hijos
        System.out.println("Es hoja" + nodo.esHoja());
        System.out.println("Combina");
        LinkedList<Pagina> hijos = new LinkedList<>();
        hijos.addAll(pagIzq.getHijos());
        hijos.addAll(pagDer.getHijos());
        nodo.setHijos(hijos);

        //Setea el padre de este
//        if (!pagDer.getPadre().esRaiz()) {
//            nodo.setPadre(pagDer.getPadre());
//        }
        nodo.setPadre(pagDer.getPadre());

        for (int i = 0; i < nodo.getHijos().size(); i++) {

            nodo.getHijos().get(i).setPadre(nodo);
        }

        return nodo;
    }

    public void balanceoArbol(Pagina nodo) {
        int index = 0;
        if (!nodo.esRaiz()) {
            index = nodo.getPadre().getHijos().indexOf(nodo);
        }

        if (nodo.esRaiz()) {
            System.out.println("LLego a la raiz");
            if (nodo.getLlaves().size() == 0) {
                raiz = nodo.getHijos().get(0);
                nodo.getHijos().get(0).setPadre(nodo);
                raiz.setPadre(null);
            }
            System.out.println("RAIZ" + raiz.getLlaves());
            //Si el nodo en la recursion no es valido vuelve hacer el balanceo
        } else if (nodo.getLlaves().size() < (orden - 1) / 2) {
            //Cuando es el primero no puede evaluar ambos solo uno
            if (index == 0) {
                System.out.println("ESTA EN EL PRIMERO");
                Pagina nodoComb = combinar_Pagina(nodo.getPadre().getHijos().get(index), nodo.getPadre().getHijos().get(index + 1));
                //Agrega el nodo y borra las otras dos referencias
                nodo.getPadre().getHijos().add(index, nodoComb);
                nodo.getPadre().getHijos().remove(nodo.getPadre().getHijos().get(index + 1));
                nodo.getPadre().getHijos().remove(nodo.getPadre().getHijos().get(index + 1));
                //Revisar si se debe hacer algo mas
                if (nodo.getPadre().getHijos().get(index).getLlaves().size() < orden) {
                    balanceoArbol(nodo.getPadre());
                } else {
                    dividirNodo(nodo.getPadre().getHijos().get(index));
                }
                //Si es el nodo mas a la derecha solo puede evaluar a la izquierda
            } else if (index == nodo.getPadre().getLlaves().size()) {
                System.out.println("ESTA EN EL ULTIMO");
                Pagina nodoComb = combinar_Pagina(nodo.getPadre().getHijos().get(index - 1), nodo.getPadre().getHijos().get(index));
                //Agrega el nodo y borra las otras dos referencias
                nodo.getPadre().getHijos().add(index - 1, nodoComb);
                nodo.getPadre().getHijos().remove(nodo.getPadre().getHijos().get(index));
                nodo.getPadre().getHijos().remove(nodo.getPadre().getHijos().get(index));
                //Revisar si se debe hacer algo mas
                if (nodo.getPadre().getHijos().get(index - 1).getLlaves().size() < orden) {
                    balanceoArbol(nodo.getPadre());
                } else {
                    dividirNodo(nodo.getPadre().getHijos().get(index - 1));
                }
            } else {
                System.out.println("ENTRA EN LOS DE MEDIO");
                //Elige el vecino mas populoso , si son iguales elige el de la izquierda
                if (nodo.getPadre().getHijos().get(index - 1).getLlaves().size() >= nodo.getPadre().getHijos().get(index + 1).getLlaves().size()) {
                    System.out.println("AGARRA EL DE LA IZQUIERDA");
                    //Lo combina
                    Pagina nodoComb = combinar_Pagina(nodo.getPadre().getHijos().get(index - 1), nodo.getPadre().getHijos().get(index));
                    //Agrega el nodo y borra las otras dos referencias
                    nodo.getPadre().getHijos().add(index - 1, nodoComb);
                    nodo.getPadre().getHijos().remove(nodo.getPadre().getHijos().get(index));
                    nodo.getPadre().getHijos().remove(nodo.getPadre().getHijos().get(index));
                    //Revisar si se debe hacer algo mas
                    if (nodo.getPadre().getHijos().get(index - 1).getLlaves().size() < orden) {
                        balanceoArbol(nodo.getPadre());
                    } else {
                        dividirNodo(nodo.getPadre().getHijos().get(index - 1));
                    }
                    //Balanc 
                } else {
                    System.out.println("AGARRA EL DE LA DERECHA");
                    Pagina nodoComb = combinar_Pagina(nodo.getPadre().getHijos().get(index), nodo.getPadre().getHijos().get(index + 1));
                    //Agrega el nodo y borra las otras dos referencias
                    nodo.getPadre().getHijos().add(index, nodoComb);
                    nodo.getPadre().getHijos().remove(nodo.getPadre().getHijos().get(index + 1));
                    nodo.getPadre().getHijos().remove(nodo.getPadre().getHijos().get(index + 1));
                    //Revisar si se debe hacer algo mas
                    if (nodo.getPadre().getHijos().get(index).getLlaves().size() < orden) {
                        balanceoArbol(nodo.getPadre());
                    } else {
                        dividirNodo(nodo.getPadre().getHijos().get(index));
                    }
                }

            }
        }
    }

    //Busca 
    public Pagina busquedaNodo(int llave, Pagina nodo) {
        //System.out.println(nodo.esHoja());
        if (nodo.getLlaves().contains(llave)) {
            return nodo;
        } else {
            for (int i = 0; i < nodo.getLlaves().size(); i++) {
                if (llave <= nodo.getLlaves().get(i)) {
                    return busquedaNodo(llave, nodo.getHijos().get(i));
                }
            }
            return busquedaNodo(llave, nodo.getHijos().get(nodo.getLlaves().size()));

        }

    }

    public boolean recursionDivision(Pagina nodo) {
        // System.out.println("Nodo en la recursion" + nodo.getLlaves());
        if (!nodo.esRaiz()) {
            //      System.out.println("Nodo padre" + nodo.getPadre().getLlaves());
        }
        if (nodo.getLlaves().size() == orden) {
//            System.out.println("ENTRA EN EL SPLIT");
            nodo = dividirNodo(nodo);
            recursionDivision(nodo);
        } else if (nodo.esRaiz()) {
            //    System.out.println("Salio de la recursion");
            return true;
        } else {
            return true;
        }
        return false;
    }

    //Recursiva Split
    public Pagina dividirNodo(Pagina nodo) {
        //System.out.println("Bucle");
        Pagina pagDer = new Pagina();
        Pagina pagIzq = new Pagina();
        //Agrega la llave para luego hacer la division
        int mitad = (nodo.getLlaves().size() - 1) / 2;

        //Divide los hijos
        if (!nodo.esHoja()) {
            System.out.println("Divide");
            LinkedList<Pagina> mitadDerHijos = new LinkedList<>(nodo.getHijos().subList(mitad + 1, nodo.getHijos().size()));
            LinkedList<Pagina> mitadIzqHijos = new LinkedList<>(nodo.getHijos().subList(0, mitad + 1));
            pagDer.setHijos(mitadDerHijos);
            pagIzq.setHijos(mitadIzqHijos);
        }
        //Divide las llaves
        LinkedList<Integer> mitadDerLlaves = new LinkedList<>(nodo.getLlaves().subList(mitad + 1, nodo.getLlaves().size()));
        LinkedList<Integer> mitadIzqLLaves = new LinkedList<>(nodo.getLlaves().subList(0, mitad));
        pagDer.setLlaves(mitadDerLlaves);
        pagIzq.setLlaves(mitadIzqLLaves);
//        System.out.println("NODO HACER SPLIT");
//        System.out.println(nodo.getLlaves());
//        System.out.println("Ver el SPLIT");
//        System.out.println("Pag DERECHA");
//        System.out.println(pagDer.getLlaves());
//        System.out.println("HIJOS");
        //ACTUALIZA LOS PADRES DE CADA NODO!!!!!!!!
//        for (int i = 0; i < pagDer.getHijos().size(); i++) {
//            System.out.println(pagDer.getHijos().get(i).getLlaves());
//        }
//        System.out.println("Pag IZQUIEDA");
//        System.out.println(pagIzq.getLlaves());
//        System.out.println("HIJOS");
//        for (int i = 0; i < pagIzq.getHijos().size(); i++) {
//            System.out.println(pagIzq.getHijos().get(i).getLlaves());
//        }
        //Sube la llave
        llaveSube = nodo.getLlaves().get(mitad);
        if (nodo.esRaiz()) {
//            System.out.println("ENTRO PARA HACER BIEN EL SPLIT");
//            System.out.println("NODO  AL QUE SUBE");
//            System.out.println(nodo.getLlaves());

            Pagina raiz = new Pagina();
            //Inserta LLave
            raiz.agregar_llave(llaveSube);
            pagDer.setPadre(raiz);
            pagIzq.setPadre(raiz);
            //int indice = raiz.getLlaves().indexOf(llaveSube);
            raiz.getHijos().add(pagIzq);
            raiz.getHijos().add(pagDer);
            if (!nodo.esHoja()) {
                for (int i = 0; i < pagDer.getHijos().size(); i++) {
                    pagDer.getHijos().get(i).setPadre(pagDer);
                }
                for (int i = 0; i < pagIzq.getHijos().size(); i++) {
                    pagIzq.getHijos().get(i).setPadre(pagIzq);
                }
            }
            this.raiz = null;
            this.raiz = raiz;

            return raiz;
        } else {
//            System.out.println("ENTRO PARA HACER BIEN EL SPLIT");
//            System.out.println("NODO  AL QUE SUBE");
//            System.out.println(nodo.getPadre().getLlaves());
            pagDer.setPadre(nodo.getPadre());
            pagIzq.setPadre(nodo.getPadre());
            //Sube la llave
            nodo.getPadre().agregar_llave(llaveSube);
            int indice = nodo.getPadre().getLlaves().indexOf(llaveSube);

            //  if (!nodo.esHoja()) {
            nodo.getPadre().getHijos().add(indice, pagIzq);
            nodo.getPadre().getHijos().add(indice + 1, pagDer);
            nodo.getPadre().getHijos().remove(indice + 2);
            // }
            if (!nodo.esHoja()) {
                for (int i = 0; i < pagDer.getHijos().size(); i++) {
                    pagDer.getHijos().get(i).setPadre(pagDer);
                }
                for (int i = 0; i < pagIzq.getHijos().size(); i++) {
                    pagIzq.getHijos().get(i).setPadre(pagIzq);
                }
            }

            return nodo.getPadre();
        }

    }

    //Busca en el arbol y devuelve la posicion del nodo hijo
    public Pagina busqueda_Binaria(int llave, Pagina nodo) {
        //System.out.println(nodo.esHoja());
        if (nodo.esHoja()) {
            return nodo;
        } else {
            for (int i = 0; i < nodo.getLlaves().size(); i++) {
                // System.out.println("Entra en for");
                if (llave <= nodo.getLlaves().get(i)) {
                    //   System.out.println("Entra en llave");
                    Pagina posR = nodo.getHijos().get(i);
                    //System.out.println(posR);
                    return busqueda_Binaria(llave, posR);

                }

            }
            Pagina posR = nodo.getHijos().get(nodo.getLlaves().size());
            return busqueda_Binaria(llave, posR);

        }

    }

    public void imprimirArbolB(Pagina nodo, int nivel) {
        if (!nodo.esHoja()) {

            for (int i = 0; i < nivel; i++) {
                System.out.print("--");
            }
            System.out.println(nodo.getLlaves().toString());
            nivel++;
            for (int i = 0; i < nodo.getHijos().size(); i++) {
                imprimirArbolB(nodo.getHijos().get(i), nivel);
            }
        } else {

            for (int i = 0; i < nivel; i++) {
                System.out.print("--");
            }
            System.out.println(nodo.getLlaves().toString());
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Arbol_B prueba = new Arbol_B(4);

        for (int i = 1; i <= 10; i++) {
            //System.out.println(i);
            prueba.insertar(i);

        }
        Scanner in = new Scanner(System.in);

        prueba.imprimirArbolB(prueba.raiz, 0);
        int aux;
        do {
            aux = in.nextInt();
            prueba.eliminar(aux);
            prueba.imprimirArbolB(prueba.raiz, 0);
            System.out.println("RAIZ" + prueba.raiz.getLlaves());
        } while (aux != -1);

//        Scanner in = new Scanner(System.in);
//        int aux;
//        do {
//            aux = in.nextInt();
//            prueba.insertar(aux);
//            prueba.imprimirArbolB(prueba.raiz, 0);
//        } while (aux != -1);
//        System.out.println(prueba.raiz.getHijos().get(3).getLlaves().toString());
    }

}
