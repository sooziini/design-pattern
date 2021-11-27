public class StateStart implements State {
    CalcV1 cv;

    StateStart(CalcV1 cv) {
        this.cv = cv;
    }

    @Override
    public void processNumber(int num) {
        cv.setOperand(1, num);
        cv.setState(cv.getStateFirstOperand());
    }
}
