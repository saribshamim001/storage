/// <reference types="cypress"/>

before(function(){
    cy.fixture('example.json').as('myData')
})

it('Reading from a file from fixture', function(){
    cy.fixture('example.json').then((data) => {
        cy.log('data.name')
        cy.log('data.email')
    })

    cy.log(this.myData.name)
})

it('Reading from readFile method',function(){
  
    cy.readFile('./cypress/fixtures/example.json').then((ReadData) => {
        cy.log('This is from readFile method !')
        cy.log('data.name')
        cy.log('data.email')
    })

})

it('Writing to a file',function(){
        cy.writeFile('/home/saribshamim/theText.txt','\nI love my life 5!!!',{flag:'a+'})
        cy.writeFile('/home/saribshamim/theText.txt','\nI love my life 6 !!!',{flag:'a+'})
        cy.writeFile('/home/saribshamim/theText.txt','\nI love my life 7 !!!',{flag:'a+'})
})