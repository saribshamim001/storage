
    it('Google Test', () => {
      cy.visit('https://google.com')
      cy.get('.SDkEP',{timeout:5000}).type('Imran Khan is love !{esc}')
      // cy.contains('Google Search').should('contain','Google').should('be.enabled')

      cy.contains('Google Search').should('contain','Google').and('be.enabled')
      
      
      cy.wait(2000)

      cy.contains('Google Search').click()
    })
  