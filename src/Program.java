public class Program {
    public static void main(String[] args){
        System.out.println("Hello world");
        System.out.println("Hello CI");

        // 1. Variables
        int a = 5;
        int b = 6;
        int c = a + b;
//        System.out.println("a= " + a + ", b= " + b + ", c= " + c);
//        String output = String.format("a = %d, b = %d, c = %d", a, b, c);
//        System.out.println(output);

        System.out.println(String.format("a = %d, b = %d, c = %d", a, b, c));

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(b/a);

        // File path
        // String formatting
        String s1 = "Toi la ai";
        String s2 = "Day la dau";
        System.out.println(s1);
        System.out.println(s2);

        System.out.println(s1 + ", " + s2); //concatenate

        System.out.print(s1);
        System.out.print(", ");
        System.out.println(s2);

    }
}
