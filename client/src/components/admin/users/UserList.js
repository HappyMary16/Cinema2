import React, {Component} from 'react';
import axios from 'axios';

import AdminMenu from "../AdminMenu";
import '../../../style/DataList.css'
import '../../../style/DataForm.css'

class UserList extends Component {
    constructor(props) {
        super(props);

        this.state = {
            users: []
        }
    }

    componentWillMount() {
        const GET_ALL_URL = "http://localhost:8080/users/all_users";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({users: response.data});
            })
    }

    componentWillReceiveProps(nextProps) {
        const GET_ALL_URL = "http://localhost:8080/users/all_users";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({users: response.data});
            })
    }

    onClickHandler = () => {
        this.props.history.push("/add_user")
    };

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>
                <div className="allUsers" id="content">
                    <h1>Users</h1>
                    <table>
                        <tr>
                            <th className="title">№</th>
                            <th className="title">First name</th>
                            <th className="title">Last name</th>
                            <th className="title">Login</th>
                            <th className="title">Phone</th>
                            <th className="title">Email</th>
                        </tr>
                        {this.state.users.map(function (d, idx) {
                            return (
                                <tr key={idx}>
                                    <a href={"user_card?id=" + d.id}>
                                        <td>{idx + 1}</td>
                                    </a>
                                    <td>{d.firstName}</td>
                                    <td>{d.lastName}</td>
                                    <td>{d.login}</td>
                                    <td>{d.phone}</td>
                                    <td>{d.email}</td>
                                </tr>
                            )
                        })}
                    </table>

                    <p>
                        <button onClick={this.onClickHandler}>Add user</button>
                    </p>
                </div>
            </div>
        );
    }
}

export default UserList;