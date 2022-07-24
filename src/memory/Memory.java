package memory;

public class Memory {
    public static void main(String[] args) {
        int[] a = {53,55,67};
        int[] b = a;
        a[0]=11;
        StringBuffer ll = new StringBuffer("Haneet");
        arr(ll);
        System.out.println(ll);
        sum(5);
        System.out.println(a[0]);
    }
    static void arr(StringBuffer a){
        a.append(" Arya");
    }
    static void sum(int a){
        a++;
    }
}
