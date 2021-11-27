public class StateSecondOperand implements State {
    CalcV1 cv;

    StateSecondOperand(CalcV1 cv) {
        this.cv = cv;
    }

    @Override
    public void processOperator(char ch) {
        if (ch == '=') {
            cv.printOutResult();
            cv.setState(cv.getStateStart());
        }
    }
}
