import React, {Component} from 'react';
import axios from 'axios';

import AdminMenu from "../AdminMenu";
import '../../../style/DataList.css'
import '../../../style/DataForm.css'

class UserCard extends Component {
    constructor(props) {
        super(props);

        this.state = {
            user : {},
            id: new URLSearchParams(this.props.location.search).get("id")
        }
    }

    componentWillMount() {
        const GET_ALL_URL = "http://localhost:8080/users/" + this.state.id;
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({user: response.data});
            })
    }

    componentWillReceiveProps(nextProps) {
        const GET_ALL_URL = "http://localhost:8080/users/" + this.state.id;
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({user: response.data});
            })
    }

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>

                <div className="allUsers" id="content">
                    <p><label htmlFor="firstNameField">Имя:</label><input type="text" name="firstName"
                                                                          id="firstNameField"
                                                                          value={this.state.user.firstName} readOnly/>
                    </p>
                    <p><label htmlFor="lastNameField">Фамилия:</label><input type="text" name="lastName"
                                                                             id="lastNameField"
                                                                             value={this.state.user.lastName}
                                                                             readOnly/></p>
                    <p><label htmlFor="phoneField">Телефон:</label><input type="tel" name="phone" id="phoneField"
                                                                          value={this.state.user.phone} readOnly/></p>
                    <p><label htmlFor="loginField">Login:</label><input type="login" name="login" id="loginField"
                                                                        value={this.state.user.login} readOnly/></p>
                    <p><label htmlFor="emailField">Email:</label><input type="email" name="email" id="emailField"
                                                                        value={this.state.user.email} readOnly/></p>
                    <p><label htmlFor="passwordField">Пароль:</label><input type="password" name="password"
                                                                            id="passwordField"
                                                                            value={this.state.user.password} readOnly/>
                    </p>
                    <p>
                        <a href={"/user_update?id=" + this.state.id}>Update</a>
                    </p>
                </div>
            </div>
        );
    }
}

export default UserCard;