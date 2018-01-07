import React, { Component } from 'react';
import { Form, Text } from 'react-form';
import { withRouter } from 'react-router-dom';

class AdicionarAtividadePage extends Component {

  onSubmitForm = (values) => {
    const { todo } = values;
    this.props.addAtividade(todo);
    this.props.history.push('/')
  };

  render() {
    return (
      <div>
        <Form onSubmit={this.onSubmitForm}>
          {formApi => (
            <form onSubmit={formApi.submitForm} id="form2">
              <p className="App-intro">
                <label htmlFor="todo">Atividade: </label>
                <Text field="todo" id='todo'/>
                &nbsp;
                <button type='submit'>Adicionar</button>
              </p>
            </form>
          )}
        </Form>

        <button onClick={() => this.props.history.push('/')}>Voltar</button>
      </div>
    )
  }

}

export default withRouter(AdicionarAtividadePage);