import React, { Component } from 'react';

import { Route, withRouter } from 'react-router-dom';
import AdicionarAtividadePage from './pages/AdicionarAtividade.page';
import TodoListPage from './pages/todoList.page';

import logo from './logo.svg';
import './App.css';
import uuid from 'uuid/v1';

class App extends Component {

  state = {
    todo: []
  };

  componentDidMount() {
    let todoLocal = localStorage.todo;
    let storage = []

    if (todoLocal) {
      storage = JSON.parse(todoLocal)
    }
    this.setState({todo: storage.todo});
  }

  saveInLocalStorage = (todo) => {
    localStorage.todo = JSON.stringify(todo);
  };

  addAtividade = (atividade) => {
    this.setState((lastState, props) => {

      lastState.todo.push({
        id: uuid(),
        name: atividade,
        complete: false
      });
      this.saveInLocalStorage(lastState);
      return lastState;
    })
  };

  completeTodo = (event) => {

    const {checked, value} = event.target;

    this.setState((lastState, props) => {

      let todoFinded = lastState.todo.find(t => t.id === value);
      let todos = lastState.todo.filter(t => t.id !== value);

      todos.push({
        ...todoFinded,
        complete: checked
      });

      const todo = {
        todo: todos
      };

      this.saveInLocalStorage(todo);

      return todo;

    });
  };

  render() {
    const { todo } = this.state;

    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <br />

        <Route
          exact
          path='/add'
          render={ (history) => (
            <AdicionarAtividadePage
              addAtividade={this.addAtividade}
              />

          )} />

        <Route
          exact
          path='/'
          render={(history) => (
            <div>
              <button onClick={() => this.props.history.push('/add')}>Adicionar nova atividade</button>
              <TodoListPage
                todo={todo}
                completeTodo={this.completeTodo}/>
            </div>
          )}
        />



      </div>
    );
  }
}

export default withRouter(App);
