package interFace;

public enum Code {
    base_info("基础信息"),
    device("设备信息"),
    product("产品信息"),
    material("物料信息"),
    inspection_standard("检验标准"),
    workflow("流程表单(通用表单)"),
    object("流程表单(通用表单)"),
    ;
    String desc;
    Code(String desc){
        this.desc=desc;
    }

    public static String getString(){
        StringBuffer sb=new StringBuffer();
        for(Code code:Code.values()){
            if(sb.length()==0){
                sb.append(",");
            }
            sb.append(code.name()+":"+code.desc);
        }
        return sb.toString();
    }
}
