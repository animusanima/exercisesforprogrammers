import repositories.CredentialRepository
import spock.lang.Shared
import spock.lang.Specification

class CredentialRepositorySpecification extends Specification {

    @Shared CredentialRepository repository

    def setupSpec() {
        repository = new CredentialRepository()
    }

    def "should throw illegal argument exception if username is null" () {
        when:
        repository.credentialValid(null, "valid_password")

        then:
        IllegalArgumentException ex = thrown()
        ex.getMessage() == "Username or password need to be provided."
    }

    def "should throw illegal argument exception if username is empty" () {
        when:
        repository.credentialValid("", "valid_password")

        then:
        IllegalArgumentException ex = thrown()
        ex.getMessage() == "Username or password need to be provided."
    }

    def "should throw illegal argument exception if password is null" () {
        when:
        repository.credentialValid("valid_user", null)

        then:
        IllegalArgumentException ex = thrown()
        ex.getMessage() == "Username or password need to be provided."
    }

    def "should throw illegal argument exception if password is empty" () {
        when:
        repository.credentialValid("valid_user", "")

        then:
        IllegalArgumentException ex = thrown()
        ex.getMessage() == "Username or password need to be provided."
    }

    def "should throw illegal argument exception when adding invalid credentials" () {
        when:
        repository.addCredential(null, null)

        then:
        IllegalArgumentException ex = thrown()
        ex.getMessage() == "Username or password need to be provided."
    }

}