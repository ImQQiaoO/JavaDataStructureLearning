package DataStructure.SymbolTable;

public class Test {
    public static void main(String[] args) {
        SymbolTable<String, Integer> st = new SymbolTable<>();
        System.out.println("SymbolTable---------------");
        System.out.println(st.put("a", 1));
        System.out.println(st.put("b", 2));
        System.out.println(st.put("c", 3));
        System.out.println(st.put("c", 4));
        System.out.println("------------------");
        System.out.println(st.get("a"));
        System.out.println(st.get("b"));
        System.out.println(st.get("c"));
        System.out.println(st.get("d"));
        System.out.println("Value of c is : " + st.delete("c"));
        for (String s : st) {
            System.out.println(s + " : " + st.get(s));
        }

        System.out.println("OrderSymbolTable---------------");
        OrderSymbolTable<String, Integer> ost = new OrderSymbolTable<>();
        System.out.println(ost.put("c", 4));
        System.out.println(ost.put("a", 1));
        System.out.println(ost.put("e", 0));
        System.out.println(ost.put("b", 2));
        System.out.println(ost.put("d", 5));
        System.out.println(ost.put("c", 3));
        System.out.println(ost.put("f", 6));
        System.out.println("size:" + ost.size());
        ost.delete("a");
        System.out.println("size:" + ost.size());
        for (String s : ost) {
            System.out.println(s + " : " + ost.get(s));
        }
    }
}
