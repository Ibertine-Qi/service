package com.example.goodscommons.vo;

public class ResultVo {
    private Integer code;
    private String msg;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public ResultVo(){}

    /*
    * 成功
    * */
    public static ResultVo ok(Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(200);
        resultVo.setMsg("ok");
        resultVo.setData(data);
        return resultVo;
    }
    public static ResultVo ok(){
        return ResultVo.ok(null);
    }
    /*失败*/
    public static ResultVo error(){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(500);
        resultVo.setMsg("error");
        return resultVo;
    }
    public static ResultVo error(String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(500);
        resultVo.setData(msg);
        return resultVo;
    }
}
