package test;

import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.ResourceBundle;

public class Testfx implements Initializable {
    public ImageView image_1;
    private String encodedString;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setImage_1(){

    }

    public void Comprass() throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(new File("D:\\"+File.separator+"1"));
        encodedString = Base64.getEncoder().encodeToString(fileContent);
    }

    public void decomprase(){
        /*byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        FileUtils.writeByteArrayToFile(new File(outputFileName), decodedBytes);

        ByteArrayInputStream input_stream= new ByteArrayInputStream(decodedBytes);
        BufferedImage final_buffered_image = ImageIO.read(input_stream);
        ImageIO.write(final_buffered_image , "jpg", new File("final_file.jpg") );*/
    }


}
