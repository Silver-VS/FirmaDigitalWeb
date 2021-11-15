package swya.firmas.controlador;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.*;

public class SignDocument {

    public byte[] signDoc(String string, PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        byte[] data;
        data = string.getBytes(StandardCharsets.UTF_8);
        return signDoc(data, privateKey);
    }

    public byte[] signDoc(File file, PrivateKey privateKey) throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        byte[] data;
        data = Files.readAllBytes(file.toPath());
        return signDoc(data, privateKey);
    }

    public byte[] signDoc(byte[] data, PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature firma = Signature.getInstance("MD5WithRSA");
        firma.initSign(privateKey);
        firma.update(data);
        return firma.sign();
    }
}
