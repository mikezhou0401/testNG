package interFace;

public class TestException extends Exception {
    String message="触发器不能为空";
    public TestException(String message){
            super(message);

    }
}
