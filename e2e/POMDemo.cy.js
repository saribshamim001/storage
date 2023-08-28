import { beforeEach } from 'mocha'
import { LoginPage } from './POM/Login_Page'
const obj = new LoginPage()


describe( 'Login Test Suite' , function(){

  beforeEach(function(){
    cy.visit('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
  })

  it('TC 1', function() {
    
    obj.enterUsername('Admin')
    obj.enterPassword('admin123')
    obj.clickLoginBtn()
    
  })
  
  
  it('TC 2', function() {
    
    obj.enterUsername('Admin')
    obj.enterPassword('admin123')
    obj.clickLoginBtn()
    
  })

}
)
