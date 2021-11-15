package swya.firmas.controlador;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

@WebServlet(name = "Firmar", value = "/Firmar")
@MultipartConfig
public class Firmar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition",
                "attachment;filename=downloadfilename.csv");

        Part dataPart = request.getPart("dataFile");
        Part keyPart = request.getPart("key");
        InputStream dataFile = dataPart.getInputStream();
        InputStream privateKey = keyPart.getInputStream();

        byte[] bytesFile = new byte[dataFile.available()];
        dataFile.read(bytesFile);
        dataFile.close();

        byte[] bytesKey = new byte[privateKey.available()];
        privateKey.read(bytesKey);
        privateKey.close();

        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
            KeySpec keyspec = new PKCS8EncodedKeySpec(bytesKey);
            SignDocument signDocument = new SignDocument();
            signDocument.signDoc(bytesFile,keyFactory.generatePrivate(keyspec));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
