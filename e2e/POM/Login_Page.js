export class LoginPage {

    usernameTextField = ':nth-child(2) > .oxd-input-group > :nth-child(2) > .oxd-input'
    passwordTextField = ':nth-child(3) > .oxd-input-group > :nth-child(2) > .oxd-input'
    loginBtn = '.oxd-button'

    enterUsername(username){
        cy.get(this.usernameTextField).type(username)
    }

    enterPassword(pwd){
        cy.get(this.passwordTextField).type(pwd)
    }

    clickLoginBtn(){
        cy.get(this.loginBtn).click()
    }
}