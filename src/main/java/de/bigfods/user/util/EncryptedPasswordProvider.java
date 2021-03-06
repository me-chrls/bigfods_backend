package de.bigfods.user.util;

import io.quarkus.security.jpa.PasswordProvider;
import javax.xml.bind.DatatypeConverter;
import org.wildfly.security.password.Password;
import org.wildfly.security.password.interfaces.SimpleDigestPassword;

public class EncryptedPasswordProvider implements PasswordProvider {

  @Override
  public Password getPassword(String pass) {
    byte[] digest = DatatypeConverter.parseHexBinary(pass);
    return SimpleDigestPassword.createRaw(SimpleDigestPassword.ALGORITHM_SIMPLE_DIGEST_SHA_256, digest);
  }
}
