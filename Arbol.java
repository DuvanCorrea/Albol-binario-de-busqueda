package trabajoa.p_punto3;

import java.util.ArrayList;

public class Arbol {

    private Nodo raiz;
    private int altura;

    public Arbol() {
        this.raiz = null;
        this.altura = 0;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void agregarNodo(Nodo nodo) {
        int alt = 0;
        if (raiz == null) {
            raiz = nodo;
            altura = 1;
        } else {
            alt += 1;
            agregarNodoAux(nodo, raiz, alt);
        }
    }

    public void agregarNodoAux(Nodo nodo, Nodo nPadre, int alt) {
        alt++;
        if (nodo.getCedula() > nPadre.getCedula()) {
            if (nPadre.getLD() == null) {
                nPadre.setLD(nodo);
                if (alt > altura) {
                    altura = alt;
                }
            } else {
                agregarNodoAux(nodo, nPadre.getLD(), alt);
            }
        } else {
            if (nPadre.getLi() == null) {
                nPadre.setLi(nodo);
                if (alt > altura) {
                    altura = alt;
                }
            } else {
                agregarNodoAux(nodo, nPadre.getLi(), alt);
            }
        }
    }

    public ArrayList<Nodo> mostrarHojas() {

        ArrayList<Nodo> lista = new ArrayList<>();

        if (raiz != null) {
            mostrarHojasAux(lista, raiz);
        }

        for (Nodo nodo : lista) {
            System.out.println("Nombre: " + nodo.getNombre());
        }

        return lista;
    }

    public void mostrarHojasAux(ArrayList<Nodo> lista, Nodo nodoActual) {

        if ((nodoActual.getLD() == null) && (nodoActual.getLi() == null)) {
            lista.add(nodoActual);
        }
        if (nodoActual.getLi() != null) {
            mostrarHojasAux(lista, nodoActual.getLi());
        }
        if (nodoActual.getLD() != null) {
            mostrarHojasAux(lista, nodoActual.getLD());
        }
    }

    public Nodo buscarPadre(int cc) {
        Nodo aux = new Nodo("", "", cc, null, null);
        Nodo aux2 = buscarPadreAux(aux, raiz);

        return aux2;
    }

    public Nodo buscarPadreAux(Nodo nodo, Nodo nodoActual) {

        Nodo n = null;

        if (nodoActual.getLi() != null) {
            if (nodoActual.getLi().getCedula() == nodo.getCedula()) {
                return nodoActual;
            } else {
                n = buscarPadreAux(nodo, nodoActual.getLi());
            }
        }

        if (nodoActual.getLD() != null) {
            //System.out.println(nodoActual.getLD().getCedula() + " " + nodoActual.getLD().getCedula());
            if (nodoActual.getLD().getCedula() == nodo.getCedula()) {
                return nodoActual;
            } else {
                n = buscarPadreAux(nodo, nodoActual.getLD());
            }
        }

        return n;
    }

    public Nodo buscarHijo(int cc) {
        Nodo aux = new Nodo("", "", cc, null, null);
        Nodo aux2 = buscarPadreAux(aux, raiz);

        return aux;
    }

    public Nodo buscarHijoAux(Nodo nodo, Nodo nodoActual) {

        if (nodo.getCedula() == nodoActual.getCedula()) {
            if (nodoActual.getLD() != null) {
                return nodoActual.getLD();
            } else if (nodoActual.getLi() != null) {
                return nodoActual.getLi();
            } else {
                return null;
            }
        }
        if (nodoActual.getLD() != null) {
            buscarHijoAux(nodo, nodoActual.getLD());
        }
        if (nodoActual.getLi() != null) {
            buscarHijoAux(nodo, nodoActual.getLi());
        }

        return null;
    }

    public Nodo buscar(int cc, Nodo nActual) {
        Nodo n = null;
        if (nActual.getCedula() == cc) {
            n = nActual;
            return n;
        } else {
            if (nActual.getLi() != null) {
                n = buscar(cc, nActual.getLi());
            }
            if (nActual.getLD() != null) {
                n = buscar(cc, nActual.getLD());
            }
        }
        return n;
    }

    public void eliminarNodo(int cc) {

        Nodo aux = buscar(cc, raiz);
        Nodo padre;

        if (aux != null) {
            if (aux.getLi() == null && aux.getLD() == null) {
                System.out.println(aux.getCedula() + " eliminado...");
                aux = null;
            } else if (aux.getLi() != null && aux.getLD() != null) {
                padre = buscarPadre(cc);
                if (padre == null) {
                    setRaiz(raiz.getLD());
                } else {
                    if (padre.getLi() != null) {
                        if (padre.getLi().getCedula() == cc) {
                            padre.setLi(aux.getLi());
                        } else {
                            padre.setLD(aux.getLD());
                        }
                    } else if (padre.getLD() != null) {
                        if (padre.getLD().getCedula() == cc) {
                            padre.setLD(aux.getLD());
                        } else {
                            padre.setLi(aux.getLi());
                        }
                    }
                }
            } else if (aux.getLi() != null) {
                padre = buscarPadre(cc);
                if (padre == null) {
                    setRaiz(raiz.getLi());
                } else {
                    if (padre.getLi() != null) {
                        if (padre.getLi().getCedula() == cc) {
                            padre.setLi(aux.getLi());
                        }
                    } else {
                        if (padre.getLD() != null) {
                            if (padre.getLD().getCedula() == cc) {
                                padre.setLi(aux.getLi());
                            }
                        }
                    }
                }
            } else {
                padre = buscarPadre(cc);
                if (padre == null) {
                    setRaiz(raiz.getLD());
                } else {
                    if (padre.getLi() != null) {
                        if (padre.getLi().getCedula() == cc) {
                            padre.setLi(aux.getLD());
                        }
                    } else {
                        if (padre.getLD() != null) {
                            if (padre.getLD().getCedula() == cc) {
                                padre.setLi(aux.getLD());
                            }
                        }
                    }
                }
            }
        }
    }

    //Pueba
}
