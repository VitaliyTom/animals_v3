package tags;

import org.apache.commons.codec.binary.Base64;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class SoundToBase64 extends TagSupport {

    private byte[] soundByteTag;

    public byte[] getSoundByteTag() {
        return soundByteTag;
    }

    public void setSoundByteTag(byte[] soundByteTag) {
        this.soundByteTag = soundByteTag;
    }

    @Override
    public int doStartTag() {

        if (soundByteTag != null && soundByteTag.length > 0) {
            String base64Encoded = Base64.encodeBase64String(soundByteTag);

            try {
                pageContext.getOut().print("data:audio/mp3;base64," + base64Encoded);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return EVAL_BODY_INCLUDE;
    }



}
