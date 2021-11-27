public interface State {
    public default void processNumber(int num) {
        System.out.println("+,-,*,/,= 기호 중 한 개를 입력해 주세요");
    }
    public default void processOperator(char ch) {
        System.out.println("정수를 입력해 주세요");
    }
}
