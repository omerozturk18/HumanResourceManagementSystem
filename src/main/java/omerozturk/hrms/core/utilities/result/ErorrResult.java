package omerozturk.hrms.core.utilities.result;

public class ErorrResult extends Result{
    public ErorrResult() {
        super(false);
    }

    public ErorrResult( String message) {
        super(false, message);
    }
}
