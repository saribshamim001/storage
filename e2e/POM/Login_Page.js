export class LoginPage {

    enterUsername(username){
        cy.get(':nth-child(2) > .oxd-input-group > :nth-child(2) > .oxd-input').type(username)
    }

    enterPassword(pwd){
        cy.get(':nth-child(3) > .oxd-input-group > :nth-child(2) > .oxd-input').type(pwd)
    }

    clickLoginBtn(){
        cy.get('.oxd-button').click()
    }
}