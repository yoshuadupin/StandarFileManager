package arbol_b;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Arbol_B {

    int llaveSube = 0;
    Pagina nodoBusqueda;
    int orden;
    ArrayList<Pagina> arbol;
    Pagina raiz = null;

    public Arbol_B(int orden) {
        this.orden = orden;
        arbol = new ArrayList<>();
    }

    public boolean insertar(int llave, long rrn) {
        //Si el arbol esta vacio lo crea una pagina y le agrega la llave
        if (raiz == null) {
            raiz = new Pagina();
            raiz.agregar_llave(llave);
            raiz.getRrn().add(rrn);
        } else {
            //Busca la pagina adecuada
            Pagina nodo = busqueda_Binaria(llave, raiz);
            if (nodo.getLlaves().size() + 1 == orden) {
                //Si lo que voy agregar excede el limite

                nodo.agregar_llave(llave);
                int indiceRRN = nodo.getLlaves().indexOf(new Integer(llave));
                //Agrega RRN
                if (nodo.getRrn().size() - 1 < indiceRRN || nodo.getRrn().isEmpty()) {
                    nodo.getRrn().add((long) rrn);
                } else {
                    nodo.getRrn().add(indiceRRN, (long) rrn);
                }
                recursionDivision(nodo);
                // imprimirArbolB(raiz, 0);
            } else {
                //Si hay espacio introduce la llave
                nodo.agregar_llave(llave);
                //AGrega RRn
                int indiceRRN = nodo.getLlaves().indexOf(new Integer(llave));
                if (nodo.getRrn().size() - 1 < indiceRRN || nodo.getRrn().isEmpty()) {
                    nodo.getRrn().add((long) rrn);
                } else {
                    nodo.getRrn().add(indiceRRN, (long) rrn);
                }
                //imprimirArbolB(raiz, 0);
            }
        }
        return false;

    }

    public Pagina getRaiz() {
        return raiz;
    }

    public void setRaiz(Pagina raiz) {
        this.raiz = raiz;
    }

    public boolean eliminar(int llave) {
        //Arbol essta vacio
        System.out.println("Borra hoja");
        if (raiz == null) {
            return false;
        } else {
            Pagina nodo = busquedaNodo(llave, raiz);
            if (nodo.esHoja()) {
                //System.out.println("Es hoja");
                if (nodo.getLlaves().size() - 1 >= orden / 2) {
                    System.out.println("Borra normal");
                    int indRRN = nodo.getLlaves().indexOf(new Integer(llave));
                    System.out.println(indRRN);
                    long rrn = nodo.getRrn().get(indRRN);
                    System.out.println(rrn);
                    nodo.getRrn().remove(rrn);
                    nodo.getLlaves().remove(new Integer(llave));

                    return true;
                } else {
                    System.out.println("BALANCEO");
                    int indRRN = nodo.getLlaves().indexOf(new Integer(llave));
                    System.out.println(indRRN);
                    long rrn = nodo.getRrn().get(indRRN);
                    System.out.println(rrn);
                    nodo.getRrn().remove(rrn);
                    nodo.getLlaves().remove(new Integer(llave));
                    balanceoArbol(nodo);
                }
            } else {
                int indice = nodo.getLlaves().indexOf(new Integer(llave));
                int llaveSube = llaveMayor(nodo.getHijos().get(indice));
                Pagina nodoSube = rrnMayor(nodo.getHijos().get(indice));
                System.out.println(nodoSube.getLlaves());
                System.out.println(nodoSube.getRrn());
                long rrnSube = nodoSube.getRrn().get(nodoSube.getRrn().size() - 1);
                int indRRN = nodo.getLlaves().indexOf(new Integer(llave));
                long rrn = nodo.getRrn().get(indRRN);
                System.out.println("RRN: que sube" + rrn);
                System.out.println("LLAVE QUE SUBE" + llaveSube);
                nodo.getRrn().remove(rrn);
                nodo.getLlaves().remove(new Integer(llave));

                nodo.agregar_llave(llaveSube);
                int indiceRRN = nodo.getLlaves().indexOf(new Integer(llaveSube));
                //Agrega RRN
                if (nodo.getRrn().size() - 1 < indiceRRN || nodo.getRrn().isEmpty()) {
                    nodo.getRrn().add((long) rrnSube);
                } else {
                    nodo.getRrn().add(indiceRRN, (long) rrnSube);
                }
                System.out.println(nodo.getRrn());
                System.out.println(nodo.getLlaves());
                Pagina nodoAux = busquedaNodo(llaveSube, nodo.getHijos().get(indice));
                if (nodoAux.getLlaves().size() - 1 >= orden / 2) {

                    indRRN = nodoAux.getLlaves().indexOf(new Integer(llaveSube));
                    rrn = nodoAux.getRrn().get(indRRN);
                    nodoAux.getRrn().remove(rrn);
                    nodoAux.getLlaves().remove(new Integer(llaveSube));

                    return true;
                } else {

                    indRRN = nodoAux.getLlaves().indexOf(new Integer(llaveSube));
                    rrn = nodoAux.getRrn().get(indRRN);
                    nodoAux.getRrn().remove(rrn);
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

    public Pagina rrnMayor(Pagina nodo) {
        System.out.println("SE METIO");
        if (nodo.esHoja()) {
            return nodo;
        } else {
            return rrnMayor(nodo.getHijos().get(nodo.getHijos().size() - 1));
        }
    }

    public Pagina combinar_Pagina(Pagina pagIzq, Pagina pagDer) {
        Pagina nodo = new Pagina();
        //Combina las llaves y RRN

        LinkedList<Integer> llaves = new LinkedList<>();
        llaves.addAll(pagIzq.getLlaves());
        llaves.addAll(pagDer.getLlaves());
        nodo.setLlaves(llaves);
        LinkedList<Long> rrn = new LinkedList<>();
        rrn.addAll(pagIzq.getRrn());
        rrn.addAll(pagDer.getRrn());
        nodo.setRrn(rrn);

//Toma el indice de donde esta la llave que se va bajar que es la relacionada
        //Con la pag Izq
        //La saca y la baja
        int indicePadre = pagIzq.getPadre().getHijos().indexOf(pagIzq);
        int llaveBajar = pagIzq.getPadre().getLlaves().get(indicePadre);
        //Baja RRN
        System.out.println("LLAVE PADRE DE DONDEBAJA ");
        System.out.println(pagIzq.getPadre().getLlaves());
        long rrnBajar = pagIzq.getPadre().getRrn().get(indicePadre);

        nodo.agregar_llave(llaveBajar);
        int indiceRRN = nodo.getLlaves().indexOf(new Integer(llaveBajar));
        if (nodo.getRrn().size() - 1 < indiceRRN || nodo.getRrn().isEmpty()) {
            nodo.getRrn().add((long) rrnBajar);
        } else {
            nodo.getRrn().add(indiceRRN, (long) rrnBajar);
        }
        //System.out.println("LLaves COMBINANADAS" + nodo.getLlaves());
        pagIzq.getPadre().getLlaves().remove(new Integer(llaveBajar));
        pagIzq.getPadre().getRrn().remove((Long) rrnBajar);

        //Si es nodo hoja no hay que combinar los hijos
        //System.out.println("Es hoja" + nodo.esHoja());
        //System.out.println("Combina");
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
            //System.out.println("RAIZ" + raiz.getLlaves());
            //Si el nodo en la recursion no es valido vuelve hacer el balanceo
        } else if (nodo.getLlaves().size() < (orden - 1) / 2) {
            //Cuando es el primero no puede evaluar ambos solo uno
            if (index == 0) {
                // System.out.println("ESTA EN EL PRIMERO");
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

        //Divide los rrn
        LinkedList<Long> mitadDerRRN = new LinkedList<>(nodo.getRrn().subList(mitad + 1, nodo.getLlaves().size()));
        LinkedList<Long> mitadIzqRRN = new LinkedList<>(nodo.getRrn().subList(0, mitad));
        pagDer.setRrn(mitadDerRRN);
        pagIzq.setRrn(mitadIzqRRN);
        System.out.println(pagDer.getRrn());
        System.out.println(pagIzq.getRrn());
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
        long rrnSube = nodo.getRrn().get(mitad);
        llaveSube = nodo.getLlaves().get(mitad);
        if (nodo.esRaiz()) {
//            System.out.println("ENTRO PARA HACER BIEN EL SPLIT");
//            System.out.println("NODO  AL QUE SUBE");
//            System.out.println(nodo.getLlaves());

            Pagina raiz = new Pagina();
            //Inserta LLave
            raiz.agregar_llave(llaveSube);
            int indiceRRN = nodo.getLlaves().indexOf(new Integer(llaveSube));
            //Agregar RRN
            if (raiz.getRrn().size() - 1 <= indiceRRN || raiz.getRrn().isEmpty()) {
                raiz.getRrn().add((long) rrnSube);
            } else {
                raiz.getRrn().add(indiceRRN, (long) rrnSube);
            }
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
            //Agregar RRRN
            if (nodo.getPadre().getRrn().size() - 1 <= indice || nodo.getPadre().getRrn().isEmpty()) {
                nodo.getPadre().getRrn().add((long) rrnSube);
            } else {
                nodo.getPadre().getRrn().add(indice, (long) rrnSube);
            }//  if (!nodo.esHoja()) {
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

    public void imprimirArbolRRN(Pagina nodo, int nivel) {
        if (!nodo.esHoja()) {

            for (int i = 0; i < nivel; i++) {
                System.out.print("--");
            }
            System.out.println(nodo.getRrn().toString());
            nivel++;
            for (int i = 0; i < nodo.getHijos().size(); i++) {
                imprimirArbolRRN(nodo.getHijos().get(i), nivel);
            }
        } else {

            for (int i = 0; i < nivel; i++) {
                System.out.print("--");
            }
            System.out.println(nodo.getRrn().toString());
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Arbol_B prueba = new Arbol_B(4);
        int cont = 10;
        
        for (int i = 1; i <= 11; i++) {
            //System.out.println(i);
            prueba.insertar(i, i);
        }
        
        Scanner in = new Scanner(System.in);
        prueba.imprimirArbolB(prueba.raiz, 0);
        prueba.imprimirArbolRRN(prueba.raiz, 0);
        //System.out.println(prueba.raiz.getHijos().get(1).getRrn());
        //prueba.imprimirArbolB(prueba.raiz, 0);
        int aux;
        System.out.println("LLAVES" + prueba.raiz.getLlaves() + "RRN" + prueba.raiz.getRrn());
        System.out.println("LLAVES" + prueba.raiz.getHijos().get(0).getLlaves() + "RRN" + prueba.raiz.getHijos().get(0).getRrn());
        System.out.println("LLAVES" + prueba.raiz.getHijos().get(1).getLlaves() + "RRN" + prueba.raiz.getHijos().get(1).getRrn());
        System.out.println("LLAVES" + prueba.raiz.getHijos().get(1).getHijos().get(0).getLlaves() + "RRN" + prueba.raiz.getHijos().get(1).getHijos().get(0).getRrn());
        do {
            aux = in.nextInt();
            prueba.eliminar(aux);
            prueba.imprimirArbolB(prueba.raiz, 0);
            prueba.imprimirArbolRRN(prueba.raiz, 0);

            //System.out.println("RAIZ" + prueba.raiz.getLlaves());
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
