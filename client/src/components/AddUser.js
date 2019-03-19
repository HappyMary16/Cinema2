import React, {Component} from 'react';
import axios from 'axios';

class AddUser extends Component {
    constructor(props) {
        super(props);

        this.state = {
            firstName: '',
            lastName: '',
            login: '',
            password: '',
            phone: '',
            email: '',
            roleId: ''
        }
    }

    firstNameChangeHandler = (name) => {
        this.setState({firstName: name})
    };

    lastNameChangeHandler = (name) => {
        this.setState({lastName: name})
    };

    loginChangeHandler = (name) => {
        this.setState({login: name})
    };

    passwordChangeHandler = (name) => {
        this.setState({password: name})
    };

    phoneChangeHandler = (name) => {
        this.setState({phone: name})
    };

    emailChangeHandler = (name) => {
        this.setState({email: name})
    };

    roleChangeHandler = (name) => {
        this.setState({roleId: name})
    };

    addUserHandler = () => {
        let user = {firstName: this.state.firstName,
            lastName: this.state.lastName,
            login: this.state.login,
            password: this.state.password,
            phone: this.state.phone,
            email: this.state.email,
            roleId: this.state.roleId};
        const ADD_USER_URL = "http://localhost:8080/users/add";
        axios.post(ADD_USER_URL, user)
            .then(this.props.history.push("/"));
    };

    render() {
        return(
            <div className="userForm">
                <input type="text" placeholder="firstName" onChange={e => this.firstNameChangeHandler(e.target.value)}/>
                <input type="text" placeholder="lastName" onChange={e => this.lastNameChangeHandler(e.target.value)}/>
                <input type="text" placeholder="login" onChange={e => this.loginChangeHandler(e.target.value)}/>
                <input type="text" placeholder="password" onChange={e => this.passwordChangeHandler(e.target.value)}/>
                <input type="text" placeholder="phone" onChange={e => this.phoneChangeHandler(e.target.value)}/>
                <input type="text" placeholder="email" onChange={e => this.emailChangeHandler(e.target.value)}/>
                <input type="text" placeholder="roleId" onChange={e => this.roleChangeHandler(e.target.value)}/>
                <button type="submit" onClick={this.addUserHandler}>Add user</button>
            </div>
        );
    }
}

export default AddUser;