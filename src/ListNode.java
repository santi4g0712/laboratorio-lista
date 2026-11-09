public class ListNode {
    public Object object;
    Object dato;
    ListNode siguiente;

    public ListNode(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "dato=" + dato +
                ", siguiente=" + siguiente +
                '}';
    }
}
