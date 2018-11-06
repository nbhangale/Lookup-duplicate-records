import {combineReducers} from 'redux';

let listReducer = (state = {}, action) => {
    switch(action.type) {
        case 'DUBLICATE_LIST':
        return {
            ...state, payload: action.payload
        };
        default:
        return state;
    }
}

export default combineReducers({
    listReducer
});