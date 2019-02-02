package tags;

import org.apache.commons.codec.binary.Base64;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class ImageToBase64 extends TagSupport {

    private byte[] imageByteTag;


    public byte[] getImageByteTag() {
        return imageByteTag;
    }

    public void setImageByteTag(byte[] imageByteTag) {
        this.imageByteTag = imageByteTag;
    }


    @Override
    public int doStartTag() {

        if (imageByteTag != null && imageByteTag.length > 0) {
            String base64Encoded = Base64.encodeBase64String(imageByteTag);

            try {
                pageContext.getOut().print("data:image/png;base64," + base64Encoded);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return EVAL_BODY_INCLUDE;
    }

}
