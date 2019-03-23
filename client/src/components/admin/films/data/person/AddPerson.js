import React, {Component} from 'react';
import axios from 'axios';

class AddPerson extends Component {
    constructor(props) {
        super(props);

        this.state = {
            firstName: '',
            lastName: '',
            roleId: '3'
        }
    }

    firstNameChangeHandler = (name) => {
        this.setState({firstName: name})
    };

    lastNameChangeHandler = (name) => {
        this.setState({lastName: name})
    };

    roleChangeHandler = (name) => {
        console.log(name);
        this.setState({roleId: name})
    };

    addPersonHandler = () => {
        let person = {
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            roleId: this.state.roleId
        };
        const ADD_PERSON_URL = "http://localhost:8080/persons/add";
        if (this.state.firstName.match(/(\w ?)+/) && this.state.lastName.match(/(\w ?)+/)) {
            axios.post(ADD_PERSON_URL, person)
                .then("3" === this.state.roleId
                ? this.props.history.push("/director_list")
                : this.props.history.push("/actor_list"));
        }
    };

    render() {
        return (
            <div className="wrapper">
                <div className="personForm" id="content">
                    <p><input type="text" placeholder="First name"
                              onChange={e => this.firstNameChangeHandler(e.target.value)}/></p>
                    <p><input type="text" placeholder="Last name"
                              onChange={e => this.lastNameChangeHandler(e.target.value)}/></p>

                    <p><select placeholder="roleId" onChange={e => this.roleChangeHandler(e.target.value)}>
                        <option value="3">Director</option>
                        <option value="4">Actor</option>
                    </select></p>

                    <p>
                        <button type="submit" onClick={this.addPersonHandler}>Add person</button>
                    </p>
                </div>
            </div>
        );
    }
}

export default AddPerson;