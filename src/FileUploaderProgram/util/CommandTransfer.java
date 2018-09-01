package FileUploaderProgram.util;

import java.io.Serializable;

//表示客户端和服务器之间传输的指令数据
public class CommandTransfer implements Serializable {
    private static final long serialVersionUID = -2501456330966162727L;

    private String cmd;//当前操作的指令
    private Object data;//发送的数据
    private boolean flag;//操作是否成功
    private String result;//返回的结果

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
