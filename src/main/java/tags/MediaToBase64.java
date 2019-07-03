package tags;

import org.apache.commons.codec.binary.Base64;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class MediaToBase64 extends TagSupport {

    private byte[] mediaByte;


    public void setMediaByte(byte[] mediaByte) {
        this.mediaByte = mediaByte;
    }

//    декодер бейс64
    @Override
    public int doStartTag() {

        if (mediaByte != null && mediaByte.length > 0) {
            String base64Encoded = Base64.encodeBase64String(mediaByte);

            try {
                pageContext.getOut().print(base64Encoded);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return EVAL_BODY_INCLUDE;
    }
}
