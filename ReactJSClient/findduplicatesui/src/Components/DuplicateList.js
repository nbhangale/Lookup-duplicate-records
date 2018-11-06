import React, { Component } from 'react';
import {connect} from 'react-redux';

class DuplicateList extends Component {

    displayList = (list) => {
        var count = 0;
        var foo = this.props.dublicateList[0];
        for (var k in foo) {
            if (foo.hasOwnProperty(k)) {
            ++count;
            }
        }
        let listTable =  list.map(listItem => {

            let row = [];
            let column = [];
            let j = 0;
            for (let i in listItem) {
             //   row.push(<tr>{listItem[i]}</tr>)
               if(j < count)
               {
                   ++j
                   column.push(<td>{listItem[i]}</td>)
                   if(j === count)
                   {
                        j = 0;
                        row.push(<tr>{column}</tr>)
                        column = [];
                    }
                   continue;
               }
               
               
            }
            return row;
        })

        return listTable
    }
    
    render() {
        
        let { dublicateList } = this.props

		return (
            <div>
                {dublicateList.length > 0? <span>
                    <table>
                    {this.displayList(dublicateList)}
                    </table>
                </span>: null 
                }
                
            </div>
            );
        }
    }

    let mapStateToProps = (state) => {
        return {
           dublicateList: state.listReducer.payload
        } 
      }
      
export default connect(mapStateToProps, null)(DuplicateList);