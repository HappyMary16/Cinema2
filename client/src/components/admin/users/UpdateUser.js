import React, {Component} from 'react';
import axios from 'axios';

import AdminMenu from "../AdminMenu";
import '../../../style/DataList.css'
import '../../../style/DataForm.css'

class UpdateUser extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: new URLSearchParams(this.props.location.search).get("id"),
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

    addUserHandler = () => {
        let user = {
            id: this.state.id,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            login: this.state.login,
            password: this.state.password,
            phone: this.state.phone,
            email: this.state.email,
            roleId: this.state.roleId
        };
        const ADD_USER_URL = "http://localhost:8080/users/update";
        console.log("update");
        axios.post(ADD_USER_URL, user)
            .then(this.props.history.push("/user_card?id=" + this.state.id));
    };

    componentWillMount() {
        const GET_ALL_URL = "http://localhost:8080/users/" + this.state.id;
        console.log("id =  " + this.state.id);
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({firstName: response.data.firstName});
                this.setState({lastName: response.data.lastName});
                this.setState({login: response.data.login});
                this.setState({password: response.data.password});
                this.setState({phone: response.data.phone});
                this.setState({email: response.data.email});
                this.setState({roleId: response.data.roleId});
            })
    }

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>

                <div className="allUsers" id="content">

                    <p><label htmlFor="firstNameField">First name:</label>
                        <input type="text" name="firstName" id="firstNameField" value={this.state.firstName}
                               onChange={e => this.firstNameChangeHandler(e.target.value)}/></p>
                    <p><label htmlFor="lastNameField">Last name:</label>
                        <input type="text" name="lastName" id="lastNameField" value={this.state.lastName}
                               onChange={e => this.lastNameChangeHandler(e.target.value)}/></p>
                    <p><label htmlFor="phoneField">Phone:</label>
                        <input type="tel" name="phone" id="phoneField" value={this.state.phone}
                               onChange={e => this.phoneChangeHandler(e.target.value)}/></p>
                    <p><label htmlFor="loginField">Login:</label>
                        <input type="login" name="login" id="loginField" value={this.state.login}
                               onChange={e => this.loginChangeHandler(e.target.value)}/></p>
                    <p><label htmlFor="emailField">Email:</label>
                        <input type="email" name="email" id="emailField" value={this.state.email}
                               onChange={e => this.emailChangeHandler(e.target.value)}/></p>
                    <p><label htmlFor="passwordField">Password:</label>
                        <input type="password" name="password" id="passwordField" value={this.state.password}
                               onChange={e => this.passwordChangeHandler(e.target.value)}/></p>

                    <p>
                        <button type="submit" onClick={this.addUserHandler}>Update user</button>
                    </p>
                </div>
            </div>
        );
    }
}

export default UpdateUser;