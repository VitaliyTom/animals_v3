package tags;

import org.apache.commons.codec.binary.Base64;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class SoundToBase64 extends TagSupport {

    private byte[] soundByte;

    public void setSoundByte(byte[] soundByte) {
        this.soundByte = soundByte;
    }

    @Override
    public int doStartTag() {

        if (soundByte != null && soundByte.length > 0) {
            String base64Encoded = Base64.encodeBase64String(soundByte);

            try {
                pageContext.getOut().print("data:audio/mp3;base64," + base64Encoded);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return EVAL_BODY_INCLUDE;
    }
}
