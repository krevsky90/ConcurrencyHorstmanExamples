public class TestClass {
    public static void main(String[] args) {
        int someInt = 67;
        float val = (float)someInt / 100f;
        System.out.println(val);
        String s = "";
        s.intern();
    }
}
