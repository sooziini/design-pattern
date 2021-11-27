public class StateOperator implements State {
    CalcV1 cv;

    StateOperator(CalcV1 cv) {
        this.cv = cv;
    }

    @Override
    public void processNumber(int num) {
        cv.setOperand(2, num);
        cv.setState(cv.getStateSecondOperand());
    }
}
