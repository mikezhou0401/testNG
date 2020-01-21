public enum TestEnum {
    SUCCESS(200, "success"),
    FAIL(400, "faile");


    private int retCode;
    private String retMsg;

    TestEnum(int retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public int getRetCode() {
        return retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public static void main(String[] args) {
        System.out.println(TestEnum.SUCCESS.retCode);
        System.out.println(TestEnum.FAIL.retMsg);
    }

}
