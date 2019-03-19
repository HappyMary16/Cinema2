import React, {Component} from 'react';
import axios from 'axios';

class UserList extends Component {
    constructor(props) {
        super(props);

        this.state = {
            users: []
        }
    }

    componentWillMount() {
        const GET_ALL_URL = "http://localhost:8080/users/all";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({users: response.data});
            })
    }

    componentWillReceiveProps(nextProps) {
        const GET_ALL_URL = "http://localhost:8080/users/all";
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
                <div className="allUsers">
                {this.state.users.map(function (d, idx) {
                    return (<li key={idx}>
                        <span>id: {d.id}</span>
                        <span>First name: {d.firstName}</span>
                        <span>Last name: {d.lastName}</span>
                        <span>Login: {d.login}</span>
                        <span>Password: {d.password}</span>
                        <span>Phone: {d.phone}</span>
                        <span>Email: {d.email}</span>
                        <span>Role: {d.roleId}</span>
                    </li>)
                })}
            </div>
                <button onClick={this.onClickHandler}>Add user</button>
            </div>
        );
    }
}

export default UserList;