package org.simpleapplications.checkanswers.service.exception;

public class NoQuestionsFound extends RuntimeException {

    private static final long serialVersionUID = 4930194295900139323L;

    public NoQuestionsFound() {}

    public NoQuestionsFound(String arg0) {
        super(arg0);
    }

    public NoQuestionsFound(Throwable arg0) {
        super(arg0);
    }

    public NoQuestionsFound(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public NoQuestionsFound(String arg0, Throwable arg1, boolean arg2,
            boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

}
