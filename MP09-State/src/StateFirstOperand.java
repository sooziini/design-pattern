public class StateFirstOperand implements State {
    CalcV1 cv;

    StateFirstOperand(CalcV1 cv) {
        this.cv = cv;
    }

    @Override
    public void processOperator(char ch) {
        cv.setOperator(ch);
        cv.setState(cv.getStateOperator());
    }
}
