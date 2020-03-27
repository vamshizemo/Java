public class Test {
    public void findAbc(String input){
        int index = input.indexOf("abc");
        while (true){
            if (index == -1 || index >= input.length() - 3){
                break;
            }
            String found = input.substring(index+1, index+4);
            System.out.println(found+index);
            index = input.indexOf("abc",index+3);
            System.out.println(index);
        }
    }

    public void test(){
        findAbc("abcabcabcabca");
        //findAbc("abcdabc");
        //findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
    }
    public static void main(String[] args) {
        HelloWorld object = new HelloWorld();
        //object.runHello();
        Test test= new Test();
        test.test();
    }
}
