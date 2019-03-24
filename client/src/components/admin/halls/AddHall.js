import React, {Component} from 'react';
import axios from 'axios';

import AdminMenu from "../AdminMenu";
import '../../../style/DataForm.css'

class AddHall extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: '',
            name: '',
            height: '',
            width: ''
        }
    }

    nameChangeHandler = (name) => {
        this.setState({name: name})
    };

    heightChangeHandler = (name) => {
        this.setState({height: name})
    };

    widthChangeHandler = (name) => {
        this.setState({width: name})
    };

    addUserHandler = () => {
        let hall = {
            name: this.state.name,
            height: this.state.height,
            width: this.state.width,
            places: []
        };
        const ADD_USER_URL = "http://localhost:8080/halls/add";

        axios.post(ADD_USER_URL, hall)
            .then(response => {this.props.history.push("/hall_card?id=" + response.data.id)});
    };

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>
                <div className="filmForm" id="content">
                    <p><input type="text" placeholder="name"
                              onChange={e => this.nameChangeHandler(e.target.value)}/></p>
                    <p><input type="number" min={1} placeholder="width"
                              onChange={e => this.widthChangeHandler(e.target.value)}/></p>
                    <p><input type="number" placeholder="number rows" min={1}
                              onChange={e => this.heightChangeHandler(e.target.value)}/></p>
                    <p>
                        <button type="submit" onClick={this.addUserHandler}>Add user</button>
                    </p>
                </div>
            </div>
        );
    }
}

export default AddHall;