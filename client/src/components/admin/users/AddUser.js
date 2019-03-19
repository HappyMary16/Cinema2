import React, {Component} from 'react';
import axios from 'axios';

import AdminMenu from "../AdminMenu";
import '../../../style/DataForm.css'

class AddUser extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: '',
            firstName: '',
            lastName: '',
            login: '',
            password: '',
            phone: '',
            email: '',
            roleId: '1'
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
        console.log(name);
        this.setState({roleId: name})
    };

    addUserHandler = () => {
        let user = {
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            login: this.state.login,
            password: this.state.password,
            phone: this.state.phone,
            email: this.state.email,
            roleId: this.state.roleId
        };
        const ADD_USER_URL = "http://localhost:8080/users/add";
        console.log(this.state.roleId);
        axios.post(ADD_USER_URL, user)
            .then("1" === this.state.roleId
                ? this.props.history.push("/admin_list")
                : this.props.history.push("/user_list"));
    };

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>
            <div className="userForm" id="content">
                <p><input type="text" placeholder="firstName"
                          onChange={e => this.firstNameChangeHandler(e.target.value)}/></p>
                <p><input type="text" placeholder="lastName"
                          onChange={e => this.lastNameChangeHandler(e.target.value)}/></p>
                <p><input type="text" placeholder="login" onChange={e => this.loginChangeHandler(e.target.value)}/></p>
                <p><input type="text" placeholder="password"
                          onChange={e => this.passwordChangeHandler(e.target.value)}/></p>
                <p><input type="text" placeholder="phone" onChange={e => this.phoneChangeHandler(e.target.value)}/></p>
                <p><input type="text" placeholder="email" onChange={e => this.emailChangeHandler(e.target.value)}/></p>
                <p><select placeholder="roleId" onChange={e => this.roleChangeHandler(e.target.value)}>
                    <option value="1">Admin</option>
                    <option value="2">User</option>
                </select></p>
                <p>
                    <button type="submit" onClick={this.addUserHandler}>Add user</button>
                </p>
            </div>
            </div>
        );
    }
}

export default AddUser;