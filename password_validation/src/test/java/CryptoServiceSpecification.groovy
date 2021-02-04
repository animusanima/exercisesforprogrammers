import crypto.CryptoService
import spock.lang.Shared
import spock.lang.Specification


class CryptoServiceSpecification extends Specification {
    static def minimumKeySize = 112

    @Shared service

    def setupSpec() {
        service = new CryptoService(minimumKeySize)
        service.init()
    }

    def "should encrypt plain text to passphrase" () {
        when:
        byte[] encrypted = service.encrypt("plain text")
        byte[] plainByte = "plain text".bytes

        then:
        encrypted != plainByte
        new String(plainByte) == "plain text"
    }

    def "should decrypt passphrase to plain text" () {
        when:
        byte[] encrypted = service.encrypt("plain text")
        byte[] decrypted = service.decrypt(encrypted)

        then:
        encrypted != decrypted
        new String(decrypted) == "plain text"
    }

}