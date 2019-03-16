import React, {Component} from 'react';
import axios from 'axios';

class AddUser extends Component {
    constructor(props) {
        super(props);

        this.state = {
            firstName: '',
            lastName: ''
        }
    }

    firstNameChangeHandler = (name) => {
        this.setState({firstName: name})
    };

    lastNameChangeHandler = (name) => {
        this.setState({lastName: name})
    };

    addUserHandler = () => {
        let user = {firstName: this.state.firstName, lastName: this.state.lastName};
        const ADD_USER_URL = "/users/add";
        axios.post(ADD_USER_URL, user)
            .then(this.props.history.push("/"));
    };

    render() {
        return(
            <div className="userForm">
                <input type="text" placeholder="firstName" onChange={e => this.firstNameChangeHandler(e.target.value)}/>
                <input type="text" placeholder="lastName" onChange={e => this.lastNameChangeHandler(e.target.value)}/>
                <button type="submit" onClick={this.addUserHandler}>Add user</button>
            </div>
        );
    }



}

export default AddUser;