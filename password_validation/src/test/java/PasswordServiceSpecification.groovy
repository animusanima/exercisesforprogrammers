import repositories.DemoDataCredentialRepository
import services.LoginService
import spock.lang.Shared
import spock.lang.Specification
import validation.PasswordValidator


class PasswordServiceSpecification extends Specification {

    @Shared service

    def setupSpec() {
        service = new LoginService()
    }

    def "should compare password for given user to a known password" () {
        given:
        def validator = new PasswordValidator(new DemoDataCredentialRepository())
        service = new LoginService(validator)

        when:
        def loginSuccessful = service.login("John", "Wick")

        then:
        loginSuccessful === true
    }

    def "should deny login when credentials are invalid" () {
        given:
        service = new LoginService()

        when:
        def loginSuccessful = service.login("unknown_user", "invalid_password")

        then:
        loginSuccessful === false
    }
}