describe('Example e2e test for calculator', () => {
  beforeEach(() => {
    cy.visit('http://localhost:8081')
  });

  it('displays a header, two input fields, one operator select and a button', () => {
    cy.get('#header').should('exist');
    cy.get('#first').should('exist');
    cy.get('#second').should('exist');
    cy.get('#operator').should('exist');
    cy.get('#calculate').should('exist');
  });

  it('can add 1 + 2 correctly', () => {
    cy.get('#first').type('1');
    cy.get('#second').type('2');
    cy.get('#calculate').click();
    cy.get('#result').contains('3');
  });

  it('can multiply 3 * 4 correctly', () => {
    cy.get('#first').type('3');
    cy.get('#operator').select('*');
    cy.get('#second').type('4');
    cy.get('#calculate').click();
    cy.get('#result').contains('12');
  });
})
