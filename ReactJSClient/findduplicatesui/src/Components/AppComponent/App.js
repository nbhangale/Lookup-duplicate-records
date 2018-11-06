import React, { Component } from 'react';
import {connect} from 'react-redux';

import './App.css';
import Util from '../../Service/lookup';
import DuplicateList from '../DuplicateListComponent/DuplicateList';

class App extends Component {

  // Get the list on click event
  handleFileChange = (event) => {
    console.log(event.target.files);
    this.props.onFileChange(event.target.files[0]);
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
         <h1>Get duplicate and non-duplicate employee data</h1>
          <p>
            Click to upload the data.
          </p>
          <button>
            <input type="file" name="uploadedFile" onChange={e => this.handleFileChange(e)} />
          </button>
          <div className="Links">
              <DuplicateList />
          </div>
        </header>
      </div>
    );
  }
}

let mapDispatchToProps = (dispatch) => {
  return {
    onFileChange : (file) => {
      Util.getDuplicateData(file).then(res => {
        console.log(res);
        dispatch({type: 'DUBLICATE_LIST', payload: res.employeeList});
      }).catch(err => {
        console.log(err);
      })
    }
  } 
}

export default connect(null, mapDispatchToProps)(App);
