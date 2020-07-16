package trabajoa.p_punto3;

public class TrabajoAP_punto3 {

    public static void main(String[] args) {

        //Data de prueba
        String[] persona1 = {"123456789", "Pepe", "Medellin"};
        String[] persona2 = {"123456788", "Luis", "Sabaneta"};
        String[] persona3 = {"123456781", "Marco", "La estrella"};
        String[] persona4 = {"123456782", "Sofia", "Bello"};
        String[] persona5 = {"123456785", "Marta", "Medellin"};

        Arbol arbol = new Arbol();

        arbol.agregarNodo(new Nodo(persona1[1], persona1[2], Integer.parseInt(persona1[0]), null, null));
        arbol.agregarNodo(new Nodo(persona2[1], persona2[2], Integer.parseInt(persona2[0]), null, null));
        arbol.agregarNodo(new Nodo(persona3[1], persona3[2], Integer.parseInt(persona3[0]), null, null));
        arbol.agregarNodo(new Nodo(persona4[1], persona4[2], Integer.parseInt(persona4[0]), null, null));
        arbol.agregarNodo(new Nodo(persona5[1], persona5[2], Integer.parseInt(persona5[0]), null, null));

        //
        System.out.println("Hojas del arbol:");
        arbol.mostrarHojas();
        System.out.println("");

        Nodo aux = arbol.buscarPadre(123456789);
        if (aux != null) {
            System.out.println("cc padre: " + aux.getCedula());
        } else {
            System.out.println("cc es raiz");
        }

        arbol.eliminarNodo(123456785);
        arbol.mostrarHojas();

    }

}
