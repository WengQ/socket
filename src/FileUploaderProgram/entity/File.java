package FileUploaderProgram.entity;

import java.io.Serializable;

public class File implements Serializable {

    private static final long serialVersionUID = 2822667108565350305L;
    //文件的编号，名称，内容
    private int fid;
    private String fname;
    private byte[] fcontent;

    public File() {
    }

    public File(String fname, byte[] fcontent) {
        super();
        this.fname = fname;
        this.fcontent = fcontent;
    }
}
