import React, {Component} from 'react';
import '../App.css';

class TodoListPage extends Component {

  render() {

    const { todo } = this.props;

    return (
      <div>
        <div className='listaTodoEDone'>
          <div>
            <h1>Todo</h1>
            <ul>
              {(todo.length > 0) && (
                todo.filter((t) => t.complete === false).map((t) => (
                  <li key={t.id}>
                    <input type='checkbox' value={t.id} onClick={this.props.completeTodo}/> {t.name}
                  </li>
                ))
              )}
            </ul>
          </div>
          <div>
            <h1>Done</h1>
            <ul className='done'>
              {(todo.length > 0) && (
                  todo.filter((t) => t.complete === true).map((t) => (
                    <li key={t.id}>
                      <input type='checkbox' value={t.id} onClick={this.props.completeTodo} defaultChecked={t.complete}/>
                      {t.name}</li>
                  ))
                )
              }
            </ul>
          </div>
        </div>
      </div>
    )
  }
}

export default TodoListPage;