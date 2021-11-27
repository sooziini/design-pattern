import java.util.Scanner;

public class CalcV1 {
//    private enum STATES { STATE_START, STATE_FIRST_OPERAND, STATE_SECOND_OPERAND, STATE_OPERATOR };
//    STATES state;
    Scanner scanner;
    String inputStr;
    int operand1; // 첫 번째 피 연산자값 저장
    int operand2; // 두 번째 피 연산자값 저장
    char operator; // 사칙 연산자 저장

    State state;    // 현재 state
    State stateStart;
    State stateFirstOperand;
    State stateSecondOperand;
    State StateOperator;

    public CalcV1() {
        scanner = new Scanner(System.in);  // Create a Scanner object

        stateStart = new StateStart(this);
        stateFirstOperand = new StateFirstOperand(this);
        stateSecondOperand = new StateSecondOperand(this);
        StateOperator = new StateOperator(this);
        state = stateStart;
    }

    public String getInput(String s) {
        System.out.println(s);
        return scanner.next();
    }

    public void printOutResult() {
        switch (operator) {
            case '+':
                System.out.printf("%d + %d = %d\n", operand1, operand2, operand1 + operand2);
                break;

            case '-':
                System.out.printf("%d - %d = %d\n", operand1, operand2, operand1 - operand2);
                break;

            case '*':
                System.out.printf("%d * %d = %d\n", operand1, operand2, operand1 * operand2);
                break;

            case '/':
                System.out.printf("%d / %d = %d\n", operand1, operand2, operand1 / operand2);
                break;
        }
    }

    public void setOperand(int ver, int operand) {
        if (ver==1)
            operand1 = operand;
        if (ver==2)
            operand2 = operand;
    }
    public void setOperator(char ch) { operator = ch; }
    public void setState(State st) { state = st; }

    public State getStateStart() { return stateStart; }
    public State getStateFirstOperand() { return stateFirstOperand; }
    public State getStateSecondOperand() { return stateSecondOperand; }
    public State getStateOperator() { return StateOperator; }

    /* 프로그램의 주 로직을 담당하는 함수
       사용자 입력을 기다렸다가 q 또는 Q가 입력되면 종료
       그렇지 않으면 정수가 입력되었는지 혹은 연산자가 입력되었는지에 따라 processNumber 또는 processOperator 함수를 호출
     */
    public boolean run() {
        inputStr = getInput("정수 또는 +,-,*,/,= 기호 중 한 개를 입력하세요");
        char ch = inputStr.charAt(0);
        if (ch == 'q' || ch == 'Q') { // q를 입력하면 프로그램 종료
            return false;
        }
        else if (ch >= '0' && ch <= '9') { // 정수가 입력되면
            //processNumber(inputStr);
            state.processNumber(Integer.parseInt(inputStr));
        }
        else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '=') { // 연산자 처리
            //processOperator(ch);
            state.processOperator(ch);
        }
        return true;
    }

    /* 정수가 입력되었을 때 처리 */
//    public void processNumber(String ch) {
//        if (state == STATES.STATE_START) {
//            operand1 = Integer.parseInt(ch);
//            state = STATES.STATE_FIRST_OPERAND;
//        }
//        else if (state == STATES.STATE_OPERATOR) {
//            operand2 = Integer.parseInt(ch);
//            state = STATES.STATE_SECOND_OPERAND;
//        }
//    }

    /* 사칙 연산자 혹은 = 연산자 처리 */
//    public void processOperator(char ch) {
//        if (state == STATES.STATE_FIRST_OPERAND) {
//            state = STATES.STATE_OPERATOR;
//            operator = ch;
//        }
//        else if (state == STATES.STATE_SECOND_OPERAND) {
//            if (ch == '=') {
//                printOutResult();
//                state = STATES.STATE_START;
//            }
//        }
//    }
}
