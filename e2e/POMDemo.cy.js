

import { LoginPage } from './POM/Login_Page';

const obj = new LoginPage();

it('Pom', function() {
  cy.visit('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login');

  obj.enterUsername('Admin');
  obj.enterPassword('admin123');
  obj.clickLoginBtn();
});
