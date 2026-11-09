import java.lang.Object;
import java.util.Iterator;

public class MiLista implements Iterable<MiLista.ListNode> {

    public static class ListNode {
        public Object object;
        public ListNode siguiente;

        public ListNode() {
            this.object = null;
            this.siguiente = null;
        }

        public ListNode(Object object) {
            this.object = object;
            this.siguiente = null;
        }

        public ListNode(Object object, ListNode siguiente) {
            this.object = object;
            this.siguiente = siguiente;
        }
    }

    public ListNode cabeza;

    public MiLista() {
        this.cabeza = null;
    }

    public boolean isEmpty() {
        return this.cabeza == null;
    }


    public int getSize() {
        if (isEmpty()) {
            return 0;
        }
        ListNode iterador = this.cabeza;
        int contador = 0;
        while (iterador != null) {
            iterador = iterador.siguiente;
            contador++;
        }
        return contador;
    }


    public void clear() {
        this.cabeza = null;
    }

    public Object getHead() {
        if (isEmpty()) {
            return null;
        }
        return this.cabeza.object;
    }

    public Object getTail() {
        if (isEmpty()) {
            return null;
        }

        ListNode tail = this.cabeza;
        while (tail.siguiente != null) {
            tail = tail.siguiente;
        }

        return tail.object;
    }

    public Object get(ListNode node) {
        try {
            if (node == null || this.cabeza == null) {
                return null;
            }

            ListNode iterador = this.cabeza;

            while (iterador != null) {
                if (iterador == node) {
                    return iterador.object;
                }
                iterador = iterador.siguiente;
            }

            return null;

        } catch (Exception e) {
            System.out.println("Ocurrió un error al obtener el nodo");
            return null;
        }
    }

    public Object search(Object object) {
        try {
            if (object == null || this.cabeza == null) {
                return null;
            }

            ListNode iterador = this.cabeza;

            while (iterador != null) {
                if (iterador.object != null && iterador.object.equals(object)) {
                    return iterador.object;
                }
                iterador = iterador.siguiente;
            }

            return null;

        } catch (Exception e) {
            System.out.println("Ocurrió un error al buscar el elemento");
            return null;
        }
    }

    public boolean add(Object object) {
        try {
            if (this.cabeza == null) {
                ListNode nuevaCabeza = new ListNode(object);
                this.cabeza = nuevaCabeza;
            } else {
                ListNode nuevaCola = new ListNode(object);
                ListNode iterador = this.cabeza;

                while (iterador.siguiente != null) {
                    iterador = iterador.siguiente;
                }

                iterador.siguiente = nuevaCola;
            }

            return true;

        } catch (Exception e) {
            System.out.println("Ocurrió un error al agregar el elemento");
            return false;
        }
    }

    public boolean insert(ListNode node, Object object) {
        try {
            if (node == null || this.cabeza == null) {
                return false;
            }

            ListNode iterador = this.cabeza;

            while (iterador != null) {
                if (iterador == node) {
                    ListNode nuevoNodo = new ListNode(object);
                    nuevoNodo.siguiente = iterador.siguiente;
                    iterador.siguiente = nuevoNodo;
                    return true;
                }
                iterador = iterador.siguiente;
            }

            return false;

        } catch (Exception e) {
            System.out.println("Ocurrió un error al insertar el elemento");
            return false;
        }
    }

    public boolean insert(Object ob, Object object) {
        try {
            if (ob == null || object == null || this.cabeza == null) {
                return false;
            }

            ListNode iterador = this.cabeza;

            while (iterador != null) {
                if (iterador.object != null && iterador.object.equals(ob)) {
                    ListNode nuevoNodo = new ListNode(object);
                    nuevoNodo.siguiente = iterador.siguiente;
                    iterador.siguiente = nuevoNodo;
                    return true;
                }
                iterador = iterador.siguiente;
            }

            return false;

        } catch (Exception e) {
            System.out.println("Ocurrió un error al insertar por objeto de referencia");
            return false;
        }
    }

    public boolean insertHead(Object object) {
        try {
            ListNode nuevaCabeza = new ListNode(object);
            nuevaCabeza.siguiente = this.cabeza;
            this.cabeza = nuevaCabeza;
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    public boolean insertTail(Object object) {
        if (this.cabeza == null) {
            ListNode nuevaCabeza = new ListNode(object);
            this.cabeza = nuevaCabeza;
        } else {
            ListNode nuevaCola = new ListNode(object);
            ListNode iterador = this.cabeza;
            while (iterador.siguiente != null) {
                iterador = iterador.siguiente;
            }
            iterador.siguiente = nuevaCola;
        }
        return true;
    }

    public boolean set(ListNode node, Object object) {
        try {
            if (node == null || this.cabeza == null) {
                return false;
            }

            ListNode iterador = this.cabeza;

            while (iterador != null) {
                if (iterador == node) {
                    iterador.object = object;
                    return true;
                }
                iterador = iterador.siguiente;
            }

            return false;

        } catch (Exception e) {
            System.out.println("Ocurrió un error al modificar el nodo");
            return false;
        }
    }

    public boolean remove(ListNode node) {
        try {
            if (node == null || this.cabeza == null) {
                return false;
            }

            if (this.cabeza == node) {
                this.cabeza = this.cabeza.siguiente;
                return true;
            }

            ListNode iterador = this.cabeza;

            while (iterador.siguiente != null) {
                if (iterador.siguiente == node) {
                    iterador.siguiente = iterador.siguiente.siguiente;
                    return true;
                }
                iterador = iterador.siguiente;
            }

            return false;

        } catch (Exception e) {
            System.out.println("Ocurrió un error al eliminar el nodo");
            return false;
        }
    }

    public boolean contains(Object object) {
        try {
            if (object == null || this.cabeza == null) {
                return false;
            }

            ListNode iterador = this.cabeza;

            while (iterador != null) {
                if (iterador.object != null && iterador.object.equals(object)) {
                    return true;
                }
                iterador = iterador.siguiente;
            }

            return false;

        } catch (Exception e) {
            System.out.println("Ocurrió un error al verificar la existencia del elemento");
            return false;
        }
    }

    @Override
    public Iterator<ListNode> iterator() {
        try {
            return new Iterator<ListNode>() {
                private ListNode iterador = cabeza;

                @Override
                public boolean hasNext() {
                    return iterador != null;
                }

                @Override
                public ListNode next() {
                    if (!hasNext()) {
                        throw new java.util.NoSuchElementException();
                    }
                    ListNode actual = iterador;
                    iterador = iterador.siguiente;
                    return actual;
                }
            };
        } catch (Exception e) {
            System.out.println("Ocurrió un error al obtener el iterador");
            return null;
        }
    }

    public Object[] toArray() {
        try {
            int tamano = getSize();
            Object[] arreglo = new Object[tamano];
            ListNode iterador = this.cabeza;
            int i = 0;

            while (iterador != null) {
                arreglo[i] = iterador.object;
                iterador = iterador.siguiente;
                i++;
            }

            return arreglo;

        } catch (Exception e) {
            System.out.println("Ocurrió un error al convertir la lista a arreglo");
            return new Object[0];
        }
    }

    public Object[] toArray(Object[] object) {
        try {
            int tamano = getSize();

            if (object.length < tamano) {
                object = (Object[]) java.lang.reflect.Array.newInstance(object.getClass().getComponentType(), tamano);
            }

            ListNode iterador = this.cabeza;
            int i = 0;

            while (iterador != null) {
                object[i] = iterador.object;
                iterador = iterador.siguiente;
                i++;
            }

            if (object.length > tamano) {
                object[tamano] = null;
            }

            return object;

        } catch (Exception e) {
            System.out.println("Ocurrió un error al convertir a arreglo");
            return new Object[0];
        }
    }

    public Object getBeforeTo(ListNode node) {
        try {
            if (node == null || this.cabeza == null || this.cabeza == node) {
                return null;
            }

            ListNode iterador = this.cabeza;

            while (iterador.siguiente != null) {
                if (iterador.siguiente == node) {
                    return iterador.object;
                }
                iterador = iterador.siguiente;
            }

            return null;

        } catch (Exception e) {
            System.out.println("Ocurrió un error al obtener el elemento anterior");
            return null;
        }
    }

    public Object getNextTo(ListNode node) {
        try {
            if (node == null || this.cabeza == null) {
                return null;
            }

            ListNode iterador = this.cabeza;

            while (iterador != null) {
                if (iterador == node) {
                    if (iterador.siguiente != null) {
                        return iterador.siguiente.object;
                    } else {
                        return null;
                    }
                }
                iterador = iterador.siguiente;
            }

            return null;

        } catch (Exception e) {
            System.out.println("Ocurrió un error al obtener el elemento siguiente");
            return null;
        }
    }

    public MiLista subList(ListNode from, ListNode to) {
        try {
            MiLista subLista = new MiLista();

            if (from == null || to == null || this.cabeza == null) {
                return subLista;
            }

            ListNode iterador = this.cabeza;
            boolean inicioEncontrado = false;

            while (iterador != null) {
                if (iterador == from) {
                    inicioEncontrado = true;
                }

                if (inicioEncontrado) {
                    subLista.add(iterador.object);
                    if (iterador == to) {
                        break;
                    }
                }

                iterador = iterador.siguiente;
            }

            return subLista;

        } catch (Exception e) {
            System.out.println("Ocurrió un error al generar la sublista");
            return new MiLista();
        }
    }

    public MiLista sortList() {
        try {
            MiLista listaOrdenada = new MiLista();

            if (this.cabeza == null) {
                return listaOrdenada;
            }

            ListNode iteradorActual = this.cabeza;
            while (iteradorActual != null) {
                listaOrdenada.add(iteradorActual.object);
                iteradorActual = iteradorActual.siguiente;
            }

            boolean huboIntercambio;
            do {
                huboIntercambio = false;
                ListNode iterador = listaOrdenada.cabeza;

                while (iterador != null && iterador.siguiente != null) {
                    Comparable actual = (Comparable) iterador.object;
                    Comparable siguiente = (Comparable) iterador.siguiente.object;

                    if (actual != null && siguiente != null && actual.compareTo(siguiente) > 0) {
                        Object temp = iterador.object;
                        iterador.object = iterador.siguiente.object;
                        iterador.siguiente.object = temp;
                        huboIntercambio = true;
                    }
                    iterador = iterador.siguiente;
                }
            } while (huboIntercambio);

            return listaOrdenada;

        } catch (Exception e) {
            System.out.println("Ocurrió un error al ordenar la lista");
            return new MiLista();
        }
    }

    @Override
    public String toString() {
        try {
            if (this.cabeza == null) {
                return "[]";
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");

            ListNode iterador = this.cabeza;

            while (iterador != null) {
                sb.append(iterador.object);
                if (iterador.siguiente != null) {
                    sb.append(", ");
                }
                iterador = iterador.siguiente;
            }

            sb.append("]");
            return sb.toString();

        } catch (Exception e) {
            System.out.println("Ocurrió un error al convertir la lista a cadena de texto");
            return "[]";
        }
    }
}