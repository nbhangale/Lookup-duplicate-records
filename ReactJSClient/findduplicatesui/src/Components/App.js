import React, { Component } from 'react';
import {connect} from 'react-redux';

import '../Assets/css/App.css';
import Util from '../Service/util';

class App extends Component {

  handleFileChange = (event) => {
    console.log(event.target.files);
    // Util.getDuplicateData(event.target.files[0]).then(res => {
    //   console.log(res);
    // }).catch(err => {
    //   console.log(err);
    // })

    this.props.onFileChange(event.target.files[0]);
  }

  handleClick() {

  }
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h1>Get potential duplicates</h1>
          <p>
            Click to upload the data.
          </p>
          <button>
            <input type="file" name="uploadedFile" onChange={e => this.handleFileChange(e)} />
          </button>
          <div className="Links">
            <span onClick={(e) => this.handleClick(e)}>
              <a href='#' className="DuplicateList-link">
                Get Duplicate List
						</a>
            </span>
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
        dispatch(res);
      }).catch(err => {
        console.log(err);
      })
    }
  } 
}

export default connect(null, mapDispatchToProps)(App);
